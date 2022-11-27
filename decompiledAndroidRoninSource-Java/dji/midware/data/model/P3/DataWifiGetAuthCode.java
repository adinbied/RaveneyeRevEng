package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import dji.midware.util.BytesUtil;

public class DataWifiGetAuthCode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiGetAuthCode mInstance;
  private String mAuthCode;
  private String mMasterId;
  
  public static DataWifiGetAuthCode getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiGetAuthCode();
      }
      DataWifiGetAuthCode localDataWifiGetAuthCode = mInstance;
      return localDataWifiGetAuthCode;
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
  
  public String getAuthCode()
  {
    return this.mAuthCode;
  }
  
  public DataWifiGetAuthCode setMasterId(String paramString)
  {
    this.mMasterId = paramString;
    return this;
  }
  
  public void setRecData(byte[] paramArrayOfByte)
  {
    super.setRecData(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      this.mAuthCode = BytesUtil.getStringUTF8(paramArrayOfByte);
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiGetAuthCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */