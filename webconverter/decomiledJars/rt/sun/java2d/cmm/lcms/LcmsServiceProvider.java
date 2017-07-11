package sun.java2d.cmm.lcms;

import sun.java2d.cmm.CMMServiceProvider;
import sun.java2d.cmm.PCMM;

public final class LcmsServiceProvider
  extends CMMServiceProvider
{
  public LcmsServiceProvider() {}
  
  protected PCMM getModule()
  {
    return LCMS.getModule();
  }
}
