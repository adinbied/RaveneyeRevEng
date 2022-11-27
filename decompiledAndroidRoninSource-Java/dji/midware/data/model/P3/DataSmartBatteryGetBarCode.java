package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryGetBarCode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataSmartBatteryGetBarCode mInstance;
  private int index = 0;
  
  public static DataSmartBatteryGetBarCode getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetBarCode();
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
  
  public String getBarCode()
  {
    return null;
  }
  
  public byte[] getBarCodeBytes()
  {
    return null;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getLength()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public DataSmartBatteryGetBarCode setIndex(int paramInt)
  {
    this.index = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetBarCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */