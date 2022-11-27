package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushRawParams
  extends DJICameraDataBase
{
  private static DataCameraGetPushRawParams instance;
  
  public static DataCameraGetPushRawParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushRawParams();
      }
      DataCameraGetPushRawParams localDataCameraGetPushRawParams = instance;
      return localDataCameraGetPushRawParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getAHCIStatus()
  {
    return 0;
  }
  
  public long getAvailableCapacity()
  {
    return 277829283L;
  }
  
  public int getClipId()
  {
    return 0;
  }
  
  public String getClipName()
  {
    return null;
  }
  
  public int getCurrentRawBurstCount()
  {
    return 0;
  }
  
  public int getDiskAvailableTime()
  {
    return 0;
  }
  
  public int getDiskCapacity()
  {
    return 0;
  }
  
  public int getDiskConnectedValue()
  {
    return 0;
  }
  
  public DiskStatus getDiskStatus()
  {
    return null;
  }
  
  public int getDiskStatusValue()
  {
    return 0;
  }
  
  public String getEquipInfoBytes()
  {
    return null;
  }
  
  public char getEquipLabel()
  {
    return '\000';
  }
  
  public int getFps()
  {
    return 0;
  }
  
  public int getLooks()
  {
    return 0;
  }
  
  public PurchasedResolution getPurchasedResolution()
  {
    return null;
  }
  
  public RawMode getRawMode(int... paramVarArgs)
  {
    return null;
  }
  
  public int getRealName()
  {
    return 0;
  }
  
  public int getResolution()
  {
    return 0;
  }
  
  public int getSSDDigitalFilter()
  {
    return 0;
  }
  
  public int getSsdAccumulativeData()
  {
    return 0;
  }
  
  public int getSsdTotalCapacity()
  {
    return 0;
  }
  
  public UserTips getUserTips()
  {
    return null;
  }
  
  public boolean isDiskConnected()
  {
    return false;
  }
  
  public static enum DiskStatus
  {
    private int data;
    
    static
    {
      NA = new DiskStatus("NA", 1, 0);
      WAITING = new DiskStatus("WAITING", 2, 1);
      STORING = new DiskStatus("STORING", 3, 2);
      SLOW_FORMATING = new DiskStatus("SLOW_FORMATING", 4, 3);
      FAST_FORMATING = new DiskStatus("FAST_FORMATING", 5, 4);
      INITIALIZING = new DiskStatus("INITIALIZING", 6, 5);
      DEVICE_ERROR = new DiskStatus("DEVICE_ERROR", 7, 6);
      VERIFY_ERROR = new DiskStatus("VERIFY_ERROR", 8, 7);
      FULL = new DiskStatus("FULL", 9, 8);
      PoorConnection = new DiskStatus("PoorConnection", 10, 9);
      ChangingMode = new DiskStatus("ChangingMode", 11, 10);
      NeedFormat = new DiskStatus("NeedFormat", 12, 11);
      DiskStatus localDiskStatus = new DiskStatus("OTHER", 13, 12);
      OTHER = localDiskStatus;
      $VALUES = new DiskStatus[] { NOTCONNECTED, NA, WAITING, STORING, SLOW_FORMATING, FAST_FORMATING, INITIALIZING, DEVICE_ERROR, VERIFY_ERROR, FULL, PoorConnection, ChangingMode, NeedFormat, localDiskStatus };
    }
    
    private DiskStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DiskStatus find(int paramInt)
    {
      DiskStatus localDiskStatus = WAITING;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDiskStatus;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static class PurchasedResolution
  {
    public boolean is3840x2160JpegLosslessSupported;
    public boolean is3840x2160PRORES422HQSupported;
    public boolean is3840x2160PRORES444XQSupported;
    public boolean is4096x2160JpegLosslessSupported;
    public boolean is5280x2160JpegLosslessSupported;
    public boolean is5280x2160PRORES422HQSupported;
    public boolean isMaxResolutionJpegLosslessSupported;
    public boolean sMaxResolutionRawCaptureSupported;
    private int value = 0;
    
    public PurchasedResolution(int paramInt)
    {
      this.value = paramInt;
      setBooleanData();
    }
    
    /* Error */
    private void setBooleanData()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static enum RawMode
  {
    private int data;
    
    static
    {
      DRaw = new RawMode("DRaw", 1, 1);
      ProresHQ422 = new RawMode("ProresHQ422", 2, 16);
      ProresHQ444 = new RawMode("ProresHQ444", 3, 17);
      ProrseOFF = new RawMode("ProrseOFF", 4, 32);
      RawMode localRawMode = new RawMode("Unknow", 5, 255);
      Unknow = localRawMode;
      $VALUES = new RawMode[] { JPEGLossLess, DRaw, ProresHQ422, ProresHQ444, ProrseOFF, localRawMode };
    }
    
    private RawMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RawMode find(int paramInt)
    {
      RawMode localRawMode = ProrseOFF;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRawMode;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum UserTips
  {
    int mCmd;
    
    static
    {
      StopRecord_Full = new UserTips("StopRecord_Full", 1, 2);
      StopRecord_Unknown = new UserTips("StopRecord_Unknown", 2, 4);
      StartFailed = new UserTips("StartFailed", 3, 8);
      UserTips localUserTips = new UserTips("OTHER", 4, 31);
      OTHER = localUserTips;
      $VALUES = new UserTips[] { StopRecord_LoseFrame, StopRecord_Full, StopRecord_Unknown, StartFailed, localUserTips };
    }
    
    private UserTips(int paramInt)
    {
      this.mCmd = paramInt;
    }
    
    public static UserTips find(int paramInt)
    {
      UserTips localUserTips = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localUserTips;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mCmd == paramInt;
    }
    
    public int value()
    {
      return this.mCmd;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushRawParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */