package sun.management;

import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import javax.management.MBeanNotificationInfo;
import javax.management.ObjectName;

class MemoryManagerImpl
  extends NotificationEmitterSupport
  implements MemoryManagerMXBean
{
  private final String name;
  private final boolean isValid;
  private MemoryPoolMXBean[] pools;
  private MBeanNotificationInfo[] notifInfo = null;
  
  MemoryManagerImpl(String paramString)
  {
    this.name = paramString;
    this.isValid = true;
    this.pools = null;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
  
  public String[] getMemoryPoolNames()
  {
    MemoryPoolMXBean[] arrayOfMemoryPoolMXBean = getMemoryPools();
    String[] arrayOfString = new String[arrayOfMemoryPoolMXBean.length];
    for (int i = 0; i < arrayOfMemoryPoolMXBean.length; i++) {
      arrayOfString[i] = arrayOfMemoryPoolMXBean[i].getName();
    }
    return arrayOfString;
  }
  
  synchronized MemoryPoolMXBean[] getMemoryPools()
  {
    if (this.pools == null) {
      this.pools = getMemoryPools0();
    }
    return this.pools;
  }
  
  private native MemoryPoolMXBean[] getMemoryPools0();
  
  public MBeanNotificationInfo[] getNotificationInfo()
  {
    synchronized (this)
    {
      if (this.notifInfo == null) {
        this.notifInfo = new MBeanNotificationInfo[0];
      }
    }
    return this.notifInfo;
  }
  
  public ObjectName getObjectName()
  {
    return Util.newObjectName("java.lang:type=MemoryManager", getName());
  }
}
