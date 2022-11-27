package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonGetDeviceStatus
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonGetDeviceStatus instance;
  private int mFirst = 0;
  private boolean mForceSetReceiveId = false;
  private int mReceiveId = 0;
  private DeviceType mReceiveType = DeviceType.RC;
  private int mSecond = 0;
  
  public static DataCommonGetDeviceStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonGetDeviceStatus();
      }
      DataCommonGetDeviceStatus localDataCommonGetDeviceStatus = instance;
      return localDataCommonGetDeviceStatus;
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
  
  public int getMode()
  {
    return 0;
  }
  
  public DataCommonGetDeviceStatus setReceiveId(int paramInt)
  {
    this.mReceiveId = paramInt;
    return this;
  }
  
  public DataCommonGetDeviceStatus setReceiveIdForce(int paramInt)
  {
    this.mReceiveId = paramInt;
    this.mForceSetReceiveId = true;
    return this;
  }
  
  public DataCommonGetDeviceStatus setReceiveType(DeviceType paramDeviceType)
  {
    this.mReceiveType = paramDeviceType;
    return this;
  }
  
  public DataCommonGetDeviceStatus setVersioin(int paramInt1, int paramInt2)
  {
    this.mFirst = paramInt1;
    this.mSecond = paramInt2;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonGetDeviceStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */