package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetAndGetRedundancyIMUIndex
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetAndGetRedundancyIMUIndex mInstance;
  private CMD_ACTION cmdAction = CMD_ACTION.SET;
  private int deviceIndex = 0;
  private DEVICE_TYPE deviceType = DEVICE_TYPE.IMU;
  
  public static DataFlycSetAndGetRedundancyIMUIndex getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataFlycSetAndGetRedundancyIMUIndex();
    }
    return mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCurIMUIndex()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycSetAndGetRedundancyIMUIndex setCmdAction(CMD_ACTION paramCMD_ACTION)
  {
    this.cmdAction = paramCMD_ACTION;
    return this;
  }
  
  public DataFlycSetAndGetRedundancyIMUIndex setDeviceIndex(int paramInt)
  {
    this.deviceIndex = paramInt;
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
  
  public static enum CMD_ACTION
  {
    private int mValue = 0;
    
    static
    {
      CMD_ACTION localCMD_ACTION = new CMD_ACTION("SET", 1, 2);
      SET = localCMD_ACTION;
      $VALUES = new CMD_ACTION[] { GET, localCMD_ACTION };
    }
    
    private CMD_ACTION(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static CMD_ACTION ofValue(byte paramByte)
    {
      CMD_ACTION[] arrayOfCMD_ACTION = values();
      int j = arrayOfCMD_ACTION.length;
      int i = 0;
      while (i < j)
      {
        CMD_ACTION localCMD_ACTION = arrayOfCMD_ACTION[i];
        if (localCMD_ACTION.belongs(paramByte)) {
          return localCMD_ACTION;
        }
        i += 1;
      }
      return SET;
    }
    
    public boolean belongs(byte paramByte)
    {
      return this.mValue == paramByte;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
  
  public static enum DEVICE_TYPE
  {
    private int mValue = 0;
    
    static
    {
      DEVICE_TYPE localDEVICE_TYPE = new DEVICE_TYPE("IMU", 0, 6);
      IMU = localDEVICE_TYPE;
      $VALUES = new DEVICE_TYPE[] { localDEVICE_TYPE };
    }
    
    private DEVICE_TYPE(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static DEVICE_TYPE ofValue(byte paramByte)
    {
      DEVICE_TYPE[] arrayOfDEVICE_TYPE = values();
      int j = arrayOfDEVICE_TYPE.length;
      int i = 0;
      while (i < j)
      {
        DEVICE_TYPE localDEVICE_TYPE = arrayOfDEVICE_TYPE[i];
        if (localDEVICE_TYPE.belongs(paramByte)) {
          return localDEVICE_TYPE;
        }
        i += 1;
      }
      return IMU;
    }
    
    public boolean belongs(byte paramByte)
    {
      return this.mValue == paramByte;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetAndGetRedundancyIMUIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */