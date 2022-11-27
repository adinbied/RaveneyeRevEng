package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCenterSetBatteryCommon
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCenterSetBatteryCommon instance;
  private int rate;
  private int timeOut = 10;
  
  public static DataCenterSetBatteryCommon getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCenterSetBatteryCommon();
      }
      DataCenterSetBatteryCommon localDataCenterSetBatteryCommon = instance;
      return localDataCenterSetBatteryCommon;
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
  
  public DataCenterSetBatteryCommon setRate(int paramInt)
  {
    this.rate = paramInt;
    return this;
  }
  
  public DataCenterSetBatteryCommon setTimeOut(int paramInt)
  {
    this.timeOut = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterSetBatteryCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */