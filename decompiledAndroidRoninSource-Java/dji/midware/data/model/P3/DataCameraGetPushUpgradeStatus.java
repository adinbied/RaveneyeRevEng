package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushUpgradeStatus
  extends DJICameraDataBase
{
  private static DataCameraGetPushUpgradeStatus instance;
  private SparseArray<UpgradeStatusModel> list = new SparseArray();
  
  public static DataCameraGetPushUpgradeStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushUpgradeStatus();
      }
      DataCameraGetPushUpgradeStatus localDataCameraGetPushUpgradeStatus = instance;
      return localDataCameraGetPushUpgradeStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCountdown()
  {
    return 0;
  }
  
  public UpgradeEndCause getEndCause()
  {
    return null;
  }
  
  public int getFirmwareCount()
  {
    return 0;
  }
  
  public SparseArray<UpgradeStatusModel> getList()
  {
    return null;
  }
  
  public int getProgress()
  {
    return 0;
  }
  
  public int getRound()
  {
    return 0;
  }
  
  public UpgradeStep getStep()
  {
    return null;
  }
  
  public static enum FirmwareType
  {
    private int data;
    
    static
    {
      App = new FirmwareType("App", 2, 3);
      FirmwareType localFirmwareType = new FirmwareType("OTHER", 3, 100);
      OTHER = localFirmwareType;
      $VALUES = new FirmwareType[] { Loader, Sys, App, localFirmwareType };
    }
    
    private FirmwareType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FirmwareType find(int paramInt)
    {
      FirmwareType localFirmwareType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFirmwareType;
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
  
  public static enum FirmwareUpgradeStatus
  {
    private int data;
    
    static
    {
      Progressing = new FirmwareUpgradeStatus("Progressing", 1, 1);
      Waiting = new FirmwareUpgradeStatus("Waiting", 2, 2);
      Error = new FirmwareUpgradeStatus("Error", 3, 3);
      CanotCheck = new FirmwareUpgradeStatus("CanotCheck", 4, 4);
      FirmwareUpgradeStatus localFirmwareUpgradeStatus = new FirmwareUpgradeStatus("OTHER", 5, 100);
      OTHER = localFirmwareUpgradeStatus;
      $VALUES = new FirmwareUpgradeStatus[] { Success, Progressing, Waiting, Error, CanotCheck, localFirmwareUpgradeStatus };
    }
    
    private FirmwareUpgradeStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FirmwareUpgradeStatus find(int paramInt)
    {
      FirmwareUpgradeStatus localFirmwareUpgradeStatus = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFirmwareUpgradeStatus;
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
  
  public static enum UpgradeEndCause
  {
    private int data;
    
    static
    {
      Failed = new UpgradeEndCause("Failed", 1, 2);
      FirmwareError = new UpgradeEndCause("FirmwareError", 2, 3);
      VersionSame = new UpgradeEndCause("VersionSame", 3, 4);
      UserCancel = new UpgradeEndCause("UserCancel", 4, 5);
      TimeoutCancel = new UpgradeEndCause("TimeoutCancel", 5, 6);
      MotorUp = new UpgradeEndCause("MotorUp", 6, 7);
      UpgradeEndCause localUpgradeEndCause = new UpgradeEndCause("OTHER", 7, 100);
      OTHER = localUpgradeEndCause;
      $VALUES = new UpgradeEndCause[] { Success, Failed, FirmwareError, VersionSame, UserCancel, TimeoutCancel, MotorUp, localUpgradeEndCause };
    }
    
    private UpgradeEndCause(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static UpgradeEndCause find(int paramInt)
    {
      UpgradeEndCause localUpgradeEndCause = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localUpgradeEndCause;
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
  
  public static class UpgradeStatusModel
  {
    public int degree;
    public DeviceType deviceType;
    public DataCameraGetPushUpgradeStatus.FirmwareUpgradeStatus status;
    public DataCameraGetPushUpgradeStatus.FirmwareType type;
    public String version;
  }
  
  public static enum UpgradeStep
  {
    private int data;
    
    static
    {
      Ack = new UpgradeStep("Ack", 1, 2);
      Progress = new UpgradeStep("Progress", 2, 3);
      End = new UpgradeStep("End", 3, 4);
      UpgradeStep localUpgradeStep = new UpgradeStep("OTHER", 4, 100);
      OTHER = localUpgradeStep;
      $VALUES = new UpgradeStep[] { Check, Ack, Progress, End, localUpgradeStep };
    }
    
    private UpgradeStep(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static UpgradeStep find(int paramInt)
    {
      UpgradeStep localUpgradeStep = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localUpgradeStep;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushUpgradeStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */