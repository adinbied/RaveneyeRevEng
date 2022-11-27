package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataWifiSetSSID
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataWifiSetSSID mInstance;
  private boolean isFromLongan = false;
  private byte[] mSSID = null;
  
  public static DataWifiSetSSID getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataWifiSetSSID();
      }
      DataWifiSetSSID localDataWifiSetSSID = mInstance;
      return localDataWifiSetSSID;
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
  
  public DataWifiSetSSID setFromLongan(boolean paramBoolean)
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
  
  public DataWifiSetSSID setReceiverId(int paramInt)
  {
    this.receiverID = paramInt;
    return this;
  }
  
  public DataWifiSetSSID setSSID(byte[] paramArrayOfByte)
  {
    this.mSSID = paramArrayOfByte;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataWifiSetSSID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */