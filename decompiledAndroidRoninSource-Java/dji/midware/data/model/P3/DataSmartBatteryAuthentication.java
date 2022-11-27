package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryAuthentication
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSmartBatteryAuthentication mInstance;
  private byte[] data;
  private int index = 0;
  private boolean random = false;
  
  public static DataSmartBatteryAuthentication getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryAuthentication();
    }
    return mInstance;
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getData()
  {
    return null;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public boolean isRandom()
  {
    return false;
  }
  
  public DataSmartBatteryAuthentication setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    return this;
  }
  
  public DataSmartBatteryAuthentication setIndex(int paramInt)
  {
    this.index = paramInt;
    return this;
  }
  
  public DataSmartBatteryAuthentication setType(boolean paramBoolean)
  {
    this.random = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */