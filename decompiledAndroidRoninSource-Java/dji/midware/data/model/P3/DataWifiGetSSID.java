package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiGetSSID
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiGetSSID mInstance;
  private boolean isFromLongan = false;
  
  public static DataWifiGetSSID getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetSSID();
      }
      DataWifiGetSSID localDataWifiGetSSID = mInstance;
      return localDataWifiGetSSID;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public String getSSID()
  {
    return null;
  }
  
  public DataWifiGetSSID setFromLongan(boolean paramBoolean)
  {
    this.isFromLongan = paramBoolean;
    return this;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetSSID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */