package com.sun.media.sound;

import javax.sound.midi.MidiDevice;

public final class MidiOutDeviceProvider
  extends AbstractMidiDeviceProvider
{
  private static AbstractMidiDeviceProvider.Info[] infos = null;
  private static MidiDevice[] devices = null;
  private static final boolean enabled = Platform.isMidiIOEnabled();
  
  public MidiOutDeviceProvider() {}
  
  AbstractMidiDeviceProvider.Info createInfo(int paramInt)
  {
    if (!enabled) {
      return null;
    }
    return new MidiOutDeviceInfo(paramInt, MidiOutDeviceProvider.class, null);
  }
  
  MidiDevice createDevice(AbstractMidiDeviceProvider.Info paramInfo)
  {
    if ((enabled) && ((paramInfo instanceof MidiOutDeviceInfo))) {
      return new MidiOutDevice(paramInfo);
    }
    return null;
  }
  
  int getNumDevices()
  {
    if (!enabled) {
      return 0;
    }
    return nGetNumDevices();
  }
  
  MidiDevice[] getDeviceCache()
  {
    return devices;
  }
  
  void setDeviceCache(MidiDevice[] paramArrayOfMidiDevice)
  {
    devices = paramArrayOfMidiDevice;
  }
  
  AbstractMidiDeviceProvider.Info[] getInfoCache()
  {
    return infos;
  }
  
  void setInfoCache(AbstractMidiDeviceProvider.Info[] paramArrayOfInfo)
  {
    infos = paramArrayOfInfo;
  }
  
  private static native int nGetNumDevices();
  
  private static native String nGetName(int paramInt);
  
  private static native String nGetVendor(int paramInt);
  
  private static native String nGetDescription(int paramInt);
  
  private static native String nGetVersion(int paramInt);
  
  static
  {
    Platform.initialize();
  }
  
  static final class MidiOutDeviceInfo
    extends AbstractMidiDeviceProvider.Info
  {
    private final Class providerClass;
    
    private MidiOutDeviceInfo(int paramInt, Class paramClass)
    {
      super(MidiOutDeviceProvider.nGetVendor(paramInt), MidiOutDeviceProvider.nGetDescription(paramInt), MidiOutDeviceProvider.nGetVersion(paramInt), paramInt);
      this.providerClass = paramClass;
    }
  }
}
