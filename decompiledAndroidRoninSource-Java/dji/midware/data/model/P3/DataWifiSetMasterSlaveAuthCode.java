package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetMasterSlaveAuthCode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetMasterSlaveAuthCode mInstance;
  private String mAuthCode;
  
  public static DataWifiSetMasterSlaveAuthCode getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiSetMasterSlaveAuthCode();
      }
      DataWifiSetMasterSlaveAuthCode localDataWifiSetMasterSlaveAuthCode = mInstance;
      return localDataWifiSetMasterSlaveAuthCode;
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
  
  public DataWifiSetMasterSlaveAuthCode setAuthCode(String paramString)
  {
    this.mAuthCode = paramString;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetMasterSlaveAuthCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */