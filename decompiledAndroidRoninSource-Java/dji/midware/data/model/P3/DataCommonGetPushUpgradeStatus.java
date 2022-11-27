package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.util.BytesUtil;

public class DataCommonGetPushUpgradeStatus
  extends DataBase
{
  private static int MONITOR_UPGRADE_PUSH_DATA_SIZE = 3;
  private static final String TAG = "DataCommonGetPushUpgradeStatus";
  private static DataCommonGetPushUpgradeStatus instance;
  private DataCommonGetPushUpgradeStatusInfo info;
  
  public static DataCommonGetPushUpgradeStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonGetPushUpgradeStatus();
      }
      DataCommonGetPushUpgradeStatus localDataCommonGetPushUpgradeStatus = instance;
      return localDataCommonGetPushUpgradeStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public byte[] getBytes()
  {
    return this._recData;
  }
  
  public int getSenderDeviceId()
  {
    return 0;
  }
  
  public DeviceType getSenderDeviceType()
  {
    return null;
  }
  
  public DataCommonGetPushUpgradeStatusInfo getUpgradeStatusInfo()
  {
    return null;
  }
  
  protected boolean isChanged(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  /* Error */
  protected void setPushRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DJIUpgradeCompleteReason
  {
    private int data;
    
    static
    {
      Failure = new DJIUpgradeCompleteReason("Failure", 1, 2);
      FirmwareError = new DJIUpgradeCompleteReason("FirmwareError", 2, 3);
      SameVersion = new DJIUpgradeCompleteReason("SameVersion", 3, 4);
      UserCancel = new DJIUpgradeCompleteReason("UserCancel", 4, 5);
      TimeOut = new DJIUpgradeCompleteReason("TimeOut", 5, 6);
      MotorWorking = new DJIUpgradeCompleteReason("MotorWorking", 6, 7);
      FirmNotMatch = new DJIUpgradeCompleteReason("FirmNotMatch", 7, 8);
      IllegalDegrade = new DJIUpgradeCompleteReason("IllegalDegrade", 8, 9);
      NoConnectRC = new DJIUpgradeCompleteReason("NoConnectRC", 9, 10);
      DJIUpgradeCompleteReason localDJIUpgradeCompleteReason = new DJIUpgradeCompleteReason("OTHER", 10, 100);
      OTHER = localDJIUpgradeCompleteReason;
      $VALUES = new DJIUpgradeCompleteReason[] { Success, Failure, FirmwareError, SameVersion, UserCancel, TimeOut, MotorWorking, FirmNotMatch, IllegalDegrade, NoConnectRC, localDJIUpgradeCompleteReason };
    }
    
    private DJIUpgradeCompleteReason(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIUpgradeCompleteReason find(int paramInt)
    {
      DJIUpgradeCompleteReason localDJIUpgradeCompleteReason = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIUpgradeCompleteReason;
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
  
  public static enum DJIUpgradeStep
  {
    private int data;
    
    static
    {
      UserConfirm = new DJIUpgradeStep("UserConfirm", 1, 2);
      Upgrading = new DJIUpgradeStep("Upgrading", 2, 3);
      Complete = new DJIUpgradeStep("Complete", 3, 4);
      DataUpgrading = new DJIUpgradeStep("DataUpgrading", 4, 5);
      Reboot = new DJIUpgradeStep("Reboot", 5, 6);
      DJIUpgradeStep localDJIUpgradeStep = new DJIUpgradeStep("OTHER", 6, 100);
      OTHER = localDJIUpgradeStep;
      $VALUES = new DJIUpgradeStep[] { Verify, UserConfirm, Upgrading, Complete, DataUpgrading, Reboot, localDJIUpgradeStep };
    }
    
    private DJIUpgradeStep(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIUpgradeStep find(int paramInt)
    {
      DJIUpgradeStep localDJIUpgradeStep = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIUpgradeStep;
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
  
  public static class DataCommonGetPushUpgradeStatusDescInfo
  {
    public int mDeviceId;
    public int mDeviceType;
    public int mFirmwareType;
    public int mFirmwareVersion;
    public int mModuleId;
    public int mUpgradeProcess;
    public int mUpgradeStatus;
    
    static DataCommonGetPushUpgradeStatusDescInfo parseItem(byte[] paramArrayOfByte, int paramInt)
    {
      DataCommonGetPushUpgradeStatusDescInfo localDataCommonGetPushUpgradeStatusDescInfo = new DataCommonGetPushUpgradeStatusDescInfo();
      int i = BytesUtil.getInt(paramArrayOfByte[paramInt]);
      localDataCommonGetPushUpgradeStatusDescInfo.mModuleId = i;
      localDataCommonGetPushUpgradeStatusDescInfo.mDeviceId = (i >> 5);
      localDataCommonGetPushUpgradeStatusDescInfo.mDeviceType = (i & 0x1F);
      localDataCommonGetPushUpgradeStatusDescInfo.mFirmwareType = BytesUtil.getInt(paramArrayOfByte[(paramInt + 1)]);
      localDataCommonGetPushUpgradeStatusDescInfo.mFirmwareVersion = BytesUtil.getInt(paramArrayOfByte, paramInt + 2);
      localDataCommonGetPushUpgradeStatusDescInfo.mUpgradeStatus = BytesUtil.getInt(paramArrayOfByte[(paramInt + 6)]);
      localDataCommonGetPushUpgradeStatusDescInfo.mUpgradeProcess = BytesUtil.getInt(paramArrayOfByte[(paramInt + 7)]);
      return localDataCommonGetPushUpgradeStatusDescInfo;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static class DataCommonGetPushUpgradeStatusInfo
  {
    public DataCommonGetPushUpgradeStatus.DJIUpgradeCompleteReason completeReason;
    public DataCommonGetPushUpgradeStatus.DataUpgradeStatusInfo dataUpgradeStatusInfo;
    public int mCurUpgradeIndex;
    public int mRebootTimeout;
    public DataCommonGetPushUpgradeStatus.DataCommonGetPushUpgradeStatusDescInfo mUpgradeDescInfo;
    public int mUpgradeProcess;
    public int mUpgradeResult;
    public int mUpgradeState;
    public DataCommonGetPushUpgradeStatus.DJIUpgradeStep mUpgradeStep;
    public int mUpgradeTimes;
    public int mUserReserve;
    public int mUserTime;
    
    /* Error */
    public void parse(byte[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static enum DataUpgradeStatus
  {
    private int data;
    
    static
    {
      Failure = new DataUpgradeStatus("Failure", 1, 1);
      FirmwareErr = new DataUpgradeStatus("FirmwareErr", 2, 2);
      TimeOut = new DataUpgradeStatus("TimeOut", 3, 3);
      AirDataLinkError = new DataUpgradeStatus("AirDataLinkError", 4, 4);
      AirSdrError = new DataUpgradeStatus("AirSdrError", 5, 5);
      GdSdrError = new DataUpgradeStatus("GdSdrError", 6, 6);
      TransFromAirToGdError = new DataUpgradeStatus("TransFromAirToGdError", 7, 7);
      AirCtrLinkError = new DataUpgradeStatus("AirCtrLinkError", 8, 8);
      ReqAirToRecvError = new DataUpgradeStatus("ReqAirToRecvError", 9, 9);
      DataParseError = new DataUpgradeStatus("DataParseError", 10, 10);
      verifyError = new DataUpgradeStatus("verifyError", 11, 11);
      DataCopyError = new DataUpgradeStatus("DataCopyError", 12, 12);
      FtpError = new DataUpgradeStatus("FtpError", 13, 13);
      DataUpgradeStatus localDataUpgradeStatus = new DataUpgradeStatus("OTHER", 14, 100);
      OTHER = localDataUpgradeStatus;
      $VALUES = new DataUpgradeStatus[] { Success, Failure, FirmwareErr, TimeOut, AirDataLinkError, AirSdrError, GdSdrError, TransFromAirToGdError, AirCtrLinkError, ReqAirToRecvError, DataParseError, verifyError, DataCopyError, FtpError, localDataUpgradeStatus };
    }
    
    private DataUpgradeStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DataUpgradeStatus find(int paramInt)
    {
      DataUpgradeStatus localDataUpgradeStatus = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDataUpgradeStatus;
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
  
  public static class DataUpgradeStatusInfo
  {
    public int mUpgradeProcess;
    public DataCommonGetPushUpgradeStatus.DataUpgradeStatus mUpgradeState;
    
    /* Error */
    public void parse(byte[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetPushUpgradeStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */