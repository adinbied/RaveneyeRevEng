package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSmartBatteryGetMultBatteryInfo
  extends DataBase
  implements DJIDataSyncListener
{
  public static int DATA_TYPE_IOC = 0;
  public static int DATA_TYPE_VOLTAGE = 1;
  private static DataSmartBatteryGetMultBatteryInfo mInstance;
  
  public static DataSmartBatteryGetMultBatteryInfo getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataSmartBatteryGetMultBatteryInfo();
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getNum()
  {
    return 0;
  }
  
  public int getResult()
  {
    return 0;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public int[] getValues()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartBatteryGetMultBatteryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */