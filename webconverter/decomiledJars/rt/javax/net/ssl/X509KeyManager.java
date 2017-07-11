package javax.net.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public abstract interface X509KeyManager
  extends KeyManager
{
  public abstract String[] getClientAliases(String paramString, Principal[] paramArrayOfPrincipal);
  
  public abstract String chooseClientAlias(String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, Socket paramSocket);
  
  public abstract String[] getServerAliases(String paramString, Principal[] paramArrayOfPrincipal);
  
  public abstract String chooseServerAlias(String paramString, Principal[] paramArrayOfPrincipal, Socket paramSocket);
  
  public abstract X509Certificate[] getCertificateChain(String paramString);
  
  public abstract PrivateKey getPrivateKey(String paramString);
}
