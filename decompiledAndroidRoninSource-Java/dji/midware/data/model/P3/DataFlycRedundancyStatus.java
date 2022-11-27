package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.List;

public class DataFlycRedundancyStatus
  extends DataBase
  implements DJIDataSyncListener
{
  public static final int acc_err_version = 1;
  public static final int baro_err_version = 1;
  public static final int comm_version = 1;
  public static final int compass_err_version = 1;
  public static final int gps_err_version = 1;
  public static final int gyro_err_version = 1;
  public static final int imu_err_version = 1;
  private static DataFlycRedundancyStatus instance;
  public static final int radar_err_version = 1;
  public static final int rtk_err_version = 1;
  public static final int us_err_version = 1;
  public static final int vo_err_version = 1;
  private RS_CMD_TYPE mCmdID = RS_CMD_TYPE.ASK_VERSION;
  
  public static DataFlycRedundancyStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycRedundancyStatus();
      }
      DataFlycRedundancyStatus localDataFlycRedundancyStatus = instance;
      return localDataFlycRedundancyStatus;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public RS_CMD_TYPE getCmdType()
  {
    return null;
  }
  
  public List<IMUStatus> getIMUStatus()
  {
    return null;
  }
  
  public VersionResult getVersionResult()
  {
    return null;
  }
  
  public DataFlycRedundancyStatus setCmdType(RS_CMD_TYPE paramRS_CMD_TYPE)
  {
    this.mCmdID = paramRS_CMD_TYPE;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum COLOR_STATUS
  {
    private int mValue = 0;
    
    static
    {
      RED = new COLOR_STATUS("RED", 3, 3);
      GREEN_FLASH = new COLOR_STATUS("GREEN_FLASH", 4, 17);
      YELLOW_FLASH = new COLOR_STATUS("YELLOW_FLASH", 5, 18);
      COLOR_STATUS localCOLOR_STATUS = new COLOR_STATUS("RED_FLASH", 6, 19);
      RED_FLASH = localCOLOR_STATUS;
      $VALUES = new COLOR_STATUS[] { GRAY, GREEN, YELLOW, RED, GREEN_FLASH, YELLOW_FLASH, localCOLOR_STATUS };
    }
    
    private COLOR_STATUS(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static COLOR_STATUS ofValue(int paramInt)
    {
      COLOR_STATUS[] arrayOfCOLOR_STATUS = values();
      int j = arrayOfCOLOR_STATUS.length;
      int i = 0;
      while (i < j)
      {
        COLOR_STATUS localCOLOR_STATUS = arrayOfCOLOR_STATUS[i];
        if (localCOLOR_STATUS.belongs(paramInt)) {
          return localCOLOR_STATUS;
        }
        i += 1;
      }
      return GRAY;
    }
    
    public boolean belongs(int paramInt)
    {
      return this.mValue == paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
  
  public static class IMUStatus
  {
    public boolean canProduction;
    public boolean canRepairForFree;
    public int colorStatus;
    public int devErrCode;
    public int devIndex;
    public int devType;
    public int id;
    public int imuIndex;
    public boolean isCtrlUsed;
    public boolean isNSUsed;
    public boolean isNeedAnalyseByApp;
    public boolean isNeedRefreshLed;
    public boolean isNeedShowAtStatusBar;
    public boolean isRealInAir;
    public long time;
    public int userAction;
  }
  
  public static enum RS_CMD_TYPE
  {
    private int mValue = 0;
    
    static
    {
      ASK_ERR_STATE = new RS_CMD_TYPE("ASK_ERR_STATE", 1, 2);
      SEND_ERR_STATE = new RS_CMD_TYPE("SEND_ERR_STATE", 2, 3);
      RS_CMD_TYPE localRS_CMD_TYPE = new RS_CMD_TYPE("SEND_SWITCH_STATE", 3, 4);
      SEND_SWITCH_STATE = localRS_CMD_TYPE;
      $VALUES = new RS_CMD_TYPE[] { ASK_VERSION, ASK_ERR_STATE, SEND_ERR_STATE, localRS_CMD_TYPE };
    }
    
    private RS_CMD_TYPE(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static RS_CMD_TYPE ofValue(int paramInt)
    {
      RS_CMD_TYPE[] arrayOfRS_CMD_TYPE = values();
      int j = arrayOfRS_CMD_TYPE.length;
      int i = 0;
      while (i < j)
      {
        RS_CMD_TYPE localRS_CMD_TYPE = arrayOfRS_CMD_TYPE[i];
        if (localRS_CMD_TYPE.belongs(paramInt)) {
          return localRS_CMD_TYPE;
        }
        i += 1;
      }
      return ASK_VERSION;
    }
    
    public boolean belongs(int paramInt)
    {
      return this.mValue == paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
  
  public static enum USER_ACTION
  {
    private int mValue = 0;
    
    static
    {
      CALC_IMU = new USER_ACTION("CALC_IMU", 1, 1);
      CALC_COMPASS = new USER_ACTION("CALC_COMPASS", 2, 2);
      WAIT_WARM_UP = new USER_ACTION("WAIT_WARM_UP", 3, 3);
      FILL_INSTALL = new USER_ACTION("FILL_INSTALL", 4, 4);
      CHECK_INSTALL = new USER_ACTION("CHECK_INSTALL", 5, 5);
      STAY_GROUND = new USER_ACTION("STAY_GROUND", 6, 6);
      CHECK_CONNECTION = new USER_ACTION("CHECK_CONNECTION", 7, 7);
      REBOOT_PILOT = new USER_ACTION("REBOOT_PILOT", 8, 8);
      UPGRATE = new USER_ACTION("UPGRATE", 9, 9);
      LANDING_FOR_CHECKING = new USER_ACTION("LANDING_FOR_CHECKING", 10, 10);
      STABLE_FLY = new USER_ACTION("STABLE_FLY", 11, 11);
      SWITCH_ATTI_MODE = new USER_ACTION("SWITCH_ATTI_MODE", 12, 12);
      REPAIR = new USER_ACTION("REPAIR", 13, 13);
      WAIT_FILOT_COLD = new USER_ACTION("WAIT_FILOT_COLD", 14, 14);
      SWITCH_IMU = new USER_ACTION("SWITCH_IMU", 15, 15);
      FIND_LARGE_PLACE = new USER_ACTION("FIND_LARGE_PLACE", 16, 16);
      REQUEST_PERMISSION = new USER_ACTION("REQUEST_PERMISSION", 17, 17);
      UNLOCK = new USER_ACTION("UNLOCK", 18, 18);
      USER_ACTION localUSER_ACTION = new USER_ACTION("FILL_RIGHT_PARAMS", 19, 19);
      FILL_RIGHT_PARAMS = localUSER_ACTION;
      $VALUES = new USER_ACTION[] { None, CALC_IMU, CALC_COMPASS, WAIT_WARM_UP, FILL_INSTALL, CHECK_INSTALL, STAY_GROUND, CHECK_CONNECTION, REBOOT_PILOT, UPGRATE, LANDING_FOR_CHECKING, STABLE_FLY, SWITCH_ATTI_MODE, REPAIR, WAIT_FILOT_COLD, SWITCH_IMU, FIND_LARGE_PLACE, REQUEST_PERMISSION, UNLOCK, localUSER_ACTION };
    }
    
    private USER_ACTION(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static USER_ACTION ofValue(int paramInt)
    {
      USER_ACTION[] arrayOfUSER_ACTION = values();
      int j = arrayOfUSER_ACTION.length;
      int i = 0;
      while (i < j)
      {
        USER_ACTION localUSER_ACTION = arrayOfUSER_ACTION[i];
        if (localUSER_ACTION.belongs(paramInt)) {
          return localUSER_ACTION;
        }
        i += 1;
      }
      return None;
    }
    
    public boolean belongs(int paramInt)
    {
      return this.mValue == paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
  
  public static class VersionResult
  {
    public int ACC;
    public int BARO;
    public int COMM;
    public int COMPASS;
    public int GPS;
    public int GYRO;
    public int IMU;
    public int RADAR;
    public int RTK;
    public int US;
    public int VO;
    
    public boolean isVersionMatch()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycRedundancyStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */