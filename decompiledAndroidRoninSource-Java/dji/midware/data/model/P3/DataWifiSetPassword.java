package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetPassword
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetPassword mInstance;
  private boolean isFromLongan = false;
  private byte[] mPassword = null;
  
  public static DataWifiSetPassword getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiSetPassword();
      }
      DataWifiSetPassword localDataWifiSetPassword = mInstance;
      return localDataWifiSetPassword;
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
  
  public DataWifiSetPassword setFromLongan(boolean paramBoolean)
  {
    this.isFromLongan = paramBoolean;
    return this;
  }
  
  public DataWifiSetPassword setPassword(byte[] paramArrayOfByte)
  {
    this.mPassword = paramArrayOfByte;
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
  
  public DataWifiSetPassword setReceiverId(int paramInt)
  {
    this.receiverID = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetPassword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */