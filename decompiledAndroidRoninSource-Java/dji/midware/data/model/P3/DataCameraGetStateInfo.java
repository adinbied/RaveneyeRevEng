package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetStateInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetStateInfo instance;
  
  public static DataCameraGetStateInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetStateInfo();
      }
      DataCameraGetStateInfo localDataCameraGetStateInfo = instance;
      return localDataCameraGetStateInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getConnectState()
  {
    return false;
  }
  
  public FirmErrorType getFirmUpgradeErrorState()
  {
    return null;
  }
  
  public boolean getFirmUpgradeState()
  {
    return false;
  }
  
  public boolean getHotState()
  {
    return false;
  }
  
  public DataCameraGetMode.MODE getMode()
  {
    return null;
  }
  
  public PhotoState getPhotoState()
  {
    return null;
  }
  
  public boolean getRecordState()
  {
    return false;
  }
  
  public boolean getSDCardInsertState()
  {
    return false;
  }
  
  public SDCardState getSDCardState()
  {
    return null;
  }
  
  public boolean getSensorState()
  {
    return false;
  }
  
  public boolean getTimeSyncState()
  {
    return false;
  }
  
  public boolean getUsbState()
  {
    return false;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum FirmErrorType
  {
    private int data;
    
    static
    {
      FirmErrorType localFirmErrorType = new FirmErrorType("OTHER", 3, 6);
      OTHER = localFirmErrorType;
      $VALUES = new FirmErrorType[] { NO, Nomatch, UpgradeError, localFirmErrorType };
    }
    
    private FirmErrorType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FirmErrorType find(int paramInt)
    {
      FirmErrorType localFirmErrorType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFirmErrorType;
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
  
  public static enum PhotoState
  {
    private int data;
    
    static
    {
      Multiple = new PhotoState("Multiple", 2, 2);
      Hdr = new PhotoState("Hdr", 3, 3);
      FullView = new PhotoState("FullView", 4, 4);
      RawBurst = new PhotoState("RawBurst", 5, 5);
      PhotoState localPhotoState = new PhotoState("OTHER", 6, 6);
      OTHER = localPhotoState;
      $VALUES = new PhotoState[] { NO, Single, Multiple, Hdr, FullView, RawBurst, localPhotoState };
    }
    
    private PhotoState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PhotoState find(int paramInt)
    {
      PhotoState localPhotoState = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoState;
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
  
  public static enum SDCardState
  {
    private int data;
    
    static
    {
      None = new SDCardState("None", 1, 1);
      Invalid = new SDCardState("Invalid", 2, 2);
      WriteProtection = new SDCardState("WriteProtection", 3, 3);
      Unformat = new SDCardState("Unformat", 4, 4);
      Formating = new SDCardState("Formating", 5, 5);
      Illegal = new SDCardState("Illegal", 6, 6);
      Busy = new SDCardState("Busy", 7, 7);
      Full = new SDCardState("Full", 8, 8);
      Slow = new SDCardState("Slow", 9, 9);
      Unknow = new SDCardState("Unknow", 10, 10);
      IndexMax = new SDCardState("IndexMax", 11, 11);
      Initialzing = new SDCardState("Initialzing", 12, 12);
      ToFormat = new SDCardState("ToFormat", 13, 13);
      TryToRecoverFile = new SDCardState("TryToRecoverFile", 14, 14);
      BecomeSlow = new SDCardState("BecomeSlow", 15, 15);
      USBConnected = new SDCardState("USBConnected", 16, 99);
      SDCardState localSDCardState = new SDCardState("OTHER", 17, 100);
      OTHER = localSDCardState;
      $VALUES = new SDCardState[] { Normal, None, Invalid, WriteProtection, Unformat, Formating, Illegal, Busy, Full, Slow, Unknow, IndexMax, Initialzing, ToFormat, TryToRecoverFile, BecomeSlow, USBConnected, localSDCardState };
    }
    
    private SDCardState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SDCardState find(int paramInt)
    {
      SDCardState localSDCardState = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSDCardState;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */