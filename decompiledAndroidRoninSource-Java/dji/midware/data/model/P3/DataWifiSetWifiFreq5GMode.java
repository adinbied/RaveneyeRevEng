package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetWifiFreq5GMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetWifiFreq5GMode instance;
  private int frequencyMode = 0;
  
  public static DataWifiSetWifiFreq5GMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataWifiSetWifiFreq5GMode();
      }
      DataWifiSetWifiFreq5GMode localDataWifiSetWifiFreq5GMode = instance;
      return localDataWifiSetWifiFreq5GMode;
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
  
  public DataWifiSetWifiFreq5GMode setFrequencyMode(int paramInt)
  {
    this.frequencyMode = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetWifiFreq5GMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */