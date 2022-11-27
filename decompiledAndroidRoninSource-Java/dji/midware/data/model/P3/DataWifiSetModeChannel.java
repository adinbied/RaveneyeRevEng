package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetModeChannel
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetModeChannel instance;
  private int mWifiChannel;
  private int mWifiMode = 1;
  
  public static DataWifiSetModeChannel getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWifiSetModeChannel();
      }
      DataWifiSetModeChannel localDataWifiSetModeChannel = instance;
      return localDataWifiSetModeChannel;
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
  
  public DataWifiSetModeChannel setWifiChannel(int paramInt)
  {
    this.mWifiChannel = paramInt;
    return this;
  }
  
  public DataWifiSetModeChannel setWifiMode(int paramInt)
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetModeChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */