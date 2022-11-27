package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonRestartDevice
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonRestartDevice instance;
  private int mDelay = 0;
  private int mEncrypt = 0;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private int mRestartType = 0;
  
  public static DataCommonRestartDevice getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonRestartDevice();
      }
      DataCommonRestartDevice localDataCommonRestartDevice = instance;
      return localDataCommonRestartDevice;
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
  
  public DataCommonRestartDevice setDelay(int paramInt)
  {
    this.mDelay = paramInt;
    return this;
  }
  
  public DataCommonRestartDevice setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonRestartDevice setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonRestartDevice setRestartType(int paramInt)
  {
    this.mRestartType = paramInt;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonRestartDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */