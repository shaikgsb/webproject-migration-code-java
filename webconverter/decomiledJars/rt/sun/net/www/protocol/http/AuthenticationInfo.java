package sun.net.www.protocol.http;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.AccessController;
import java.util.HashMap;
import sun.net.www.HeaderParser;
import sun.security.action.GetBooleanAction;

public abstract class AuthenticationInfo
  extends AuthCacheValue
  implements Cloneable
{
  static final long serialVersionUID = -2588378268010453259L;
  public static final char SERVER_AUTHENTICATION = 's';
  public static final char PROXY_AUTHENTICATION = 'p';
  static boolean serializeAuth = ((Boolean)AccessController.doPrivileged(new GetBooleanAction("http.auth.serializeRequests"))).booleanValue();
  protected transient PasswordAuthentication pw;
  private static HashMap<String, Thread> requests = new HashMap();
  char type;
  AuthScheme authScheme;
  String protocol;
  String host;
  int port;
  String realm;
  String path;
  String s1;
  String s2;
  
  public PasswordAuthentication credentials()
  {
    return this.pw;
  }
  
  public AuthCacheValue.Type getAuthType()
  {
    return this.type == 's' ? AuthCacheValue.Type.Server : AuthCacheValue.Type.Proxy;
  }
  
  AuthScheme getAuthScheme()
  {
    return this.authScheme;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public String getRealm()
  {
    return this.realm;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getProtocolScheme()
  {
    return this.protocol;
  }
  
  private static boolean requestIsInProgress(String paramString)
  {
    if (!serializeAuth) {
      return false;
    }
    synchronized (requests)
    {
      Thread localThread2 = Thread.currentThread();
      Thread localThread1;
      if ((localThread1 = (Thread)requests.get(paramString)) == null)
      {
        requests.put(paramString, localThread2);
        return false;
      }
      if (localThread1 == localThread2) {
        return false;
      }
      while (requests.containsKey(paramString)) {
        try
        {
          requests.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
    return true;
  }
  
  private static void requestCompleted(String paramString)
  {
    synchronized (requests)
    {
      Thread localThread = (Thread)requests.get(paramString);
      if ((localThread != null) && (localThread == Thread.currentThread()))
      {
        int i = requests.remove(paramString) != null ? 1 : 0;
        assert (i != 0);
      }
      requests.notifyAll();
    }
  }
  
  public AuthenticationInfo(char paramChar, AuthScheme paramAuthScheme, String paramString1, int paramInt, String paramString2)
  {
    this.type = paramChar;
    this.authScheme = paramAuthScheme;
    this.protocol = "";
    this.host = paramString1.toLowerCase();
    this.port = paramInt;
    this.realm = paramString2;
    this.path = null;
  }
  
  public Object clone()
  {
    try
    {
      return super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public AuthenticationInfo(char paramChar, AuthScheme paramAuthScheme, URL paramURL, String paramString)
  {
    this.type = paramChar;
    this.authScheme = paramAuthScheme;
    this.protocol = paramURL.getProtocol().toLowerCase();
    this.host = paramURL.getHost().toLowerCase();
    this.port = paramURL.getPort();
    if (this.port == -1) {
      this.port = paramURL.getDefaultPort();
    }
    this.realm = paramString;
    String str = paramURL.getPath();
    if (str.length() == 0) {
      this.path = str;
    } else {
      this.path = reducePath(str);
    }
  }
  
  static String reducePath(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf('.');
    if (i != -1)
    {
      if (i < j) {
        return paramString.substring(0, i + 1);
      }
      return paramString;
    }
    return paramString;
  }
  
  static AuthenticationInfo getServerAuth(URL paramURL)
  {
    int i = paramURL.getPort();
    if (i == -1) {
      i = paramURL.getDefaultPort();
    }
    String str = "s:" + paramURL.getProtocol().toLowerCase() + ":" + paramURL.getHost().toLowerCase() + ":" + i;
    return getAuth(str, paramURL);
  }
  
  static String getServerAuthKey(URL paramURL, String paramString, AuthScheme paramAuthScheme)
  {
    int i = paramURL.getPort();
    if (i == -1) {
      i = paramURL.getDefaultPort();
    }
    String str = "s:" + paramAuthScheme + ":" + paramURL.getProtocol().toLowerCase() + ":" + paramURL.getHost().toLowerCase() + ":" + i + ":" + paramString;
    return str;
  }
  
  static AuthenticationInfo getServerAuth(String paramString)
  {
    AuthenticationInfo localAuthenticationInfo = getAuth(paramString, null);
    if ((localAuthenticationInfo == null) && (requestIsInProgress(paramString))) {
      localAuthenticationInfo = getAuth(paramString, null);
    }
    return localAuthenticationInfo;
  }
  
  static AuthenticationInfo getAuth(String paramString, URL paramURL)
  {
    if (paramURL == null) {
      return (AuthenticationInfo)cache.get(paramString, null);
    }
    return (AuthenticationInfo)cache.get(paramString, paramURL.getPath());
  }
  
  static AuthenticationInfo getProxyAuth(String paramString, int paramInt)
  {
    String str = "p::" + paramString.toLowerCase() + ":" + paramInt;
    AuthenticationInfo localAuthenticationInfo = (AuthenticationInfo)cache.get(str, null);
    return localAuthenticationInfo;
  }
  
  static String getProxyAuthKey(String paramString1, int paramInt, String paramString2, AuthScheme paramAuthScheme)
  {
    String str = "p:" + paramAuthScheme + "::" + paramString1.toLowerCase() + ":" + paramInt + ":" + paramString2;
    return str;
  }
  
  static AuthenticationInfo getProxyAuth(String paramString)
  {
    AuthenticationInfo localAuthenticationInfo = (AuthenticationInfo)cache.get(paramString, null);
    if ((localAuthenticationInfo == null) && (requestIsInProgress(paramString))) {
      localAuthenticationInfo = (AuthenticationInfo)cache.get(paramString, null);
    }
    return localAuthenticationInfo;
  }
  
  void addToCache()
  {
    String str = cacheKey(true);
    cache.put(str, this);
    if (supportsPreemptiveAuthorization()) {
      cache.put(cacheKey(false), this);
    }
    endAuthRequest(str);
  }
  
  static void endAuthRequest(String paramString)
  {
    if (!serializeAuth) {
      return;
    }
    synchronized (requests)
    {
      requestCompleted(paramString);
    }
  }
  
  void removeFromCache()
  {
    cache.remove(cacheKey(true), this);
    if (supportsPreemptiveAuthorization()) {
      cache.remove(cacheKey(false), this);
    }
  }
  
  public abstract boolean supportsPreemptiveAuthorization();
  
  public String getHeaderName()
  {
    if (this.type == 's') {
      return "Authorization";
    }
    return "Proxy-authorization";
  }
  
  public abstract String getHeaderValue(URL paramURL, String paramString);
  
  public abstract boolean setHeaders(HttpURLConnection paramHttpURLConnection, HeaderParser paramHeaderParser, String paramString);
  
  public abstract boolean isAuthorizationStale(String paramString);
  
  String cacheKey(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.type + ":" + this.authScheme + ":" + this.protocol + ":" + this.host + ":" + this.port + ":" + this.realm;
    }
    return this.type + ":" + this.protocol + ":" + this.host + ":" + this.port;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.pw = new PasswordAuthentication(this.s1, this.s2.toCharArray());
    this.s1 = null;
    this.s2 = null;
  }
  
  private synchronized void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    this.s1 = this.pw.getUserName();
    this.s2 = new String(this.pw.getPassword());
    paramObjectOutputStream.defaultWriteObject();
  }
}
