package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiGetCountryCode
  extends DataBase
  implements DJIDataSyncListener
{
  private static final String TAG = "DataWifiSetCountryCode";
  private String mCountryCode = "";
  
  protected void doPack() {}
  
  public String getCountryCode()
  {
    return this.mCountryCode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetCountryCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */