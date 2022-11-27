package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import dji.thirdparty.afinal.core.Arrays;

public class DataCenterGetBatteryHistory
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCenterGetBatteryHistory mInstance;
  private final int[] mHistories;
  
  private DataCenterGetBatteryHistory()
  {
    int[] arrayOfInt = new int[31];
    this.mHistories = arrayOfInt;
    Arrays.fill(arrayOfInt, 0);
  }
  
  public static DataCenterGetBatteryHistory getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DataCenterGetBatteryHistory();
      }
      DataCenterGetBatteryHistory localDataCenterGetBatteryHistory = mInstance;
      return localDataCenterGetBatteryHistory;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int[] getHistory()
  {
    return null;
  }
  
  public long[] getHistoryLong()
  {
    return null;
  }
  
  public void resetHistory()
  {
    Arrays.fill(this.mHistories, 0);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCenterGetBatteryHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */