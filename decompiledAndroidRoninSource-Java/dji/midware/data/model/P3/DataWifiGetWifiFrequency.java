package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiGetWifiFrequency
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "WifiGetWifiFrequency";
  private static DataWifiGetWifiFrequency instance;
  private boolean isFromLongan = false;
  
  public static DataWifiGetWifiFrequency getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWifiGetWifiFrequency();
      }
      DataWifiGetWifiFrequency localDataWifiGetWifiFrequency = instance;
      return localDataWifiGetWifiFrequency;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getResult()
  {
    return 0;
  }
  
  public DataWifiGetWifiFrequency setFromLongan(boolean paramBoolean)
  {
    this.isFromLongan = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetWifiFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */