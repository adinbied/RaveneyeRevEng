package dji.midware.data.model.P3;

import dji.midware.data.config.P3.DeviceType;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiRequestPushSnr
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiRequestPushSnr mInstance;
  private DeviceType mDeviceType = DeviceType.WIFI_G;
  private boolean mRequestPush = true;
  
  public static DataWifiRequestPushSnr getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiRequestPushSnr();
      }
      DataWifiRequestPushSnr localDataWifiRequestPushSnr = mInstance;
      return localDataWifiRequestPushSnr;
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
  
  public DataWifiRequestPushSnr setPush(boolean paramBoolean)
  {
    this.mRequestPush = paramBoolean;
    return this;
  }
  
  public DataWifiRequestPushSnr setReceiver(DeviceType paramDeviceType)
  {
    this.mDeviceType = paramDeviceType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiRequestPushSnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */