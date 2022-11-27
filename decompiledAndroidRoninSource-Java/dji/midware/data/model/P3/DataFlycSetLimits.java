package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetLimits
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetLimits instance;
  private DataFlycGetLimits.MODE mode;
  private int value;
  
  public static DataFlycSetLimits getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetLimits();
      }
      DataFlycSetLimits localDataFlycSetLimits = instance;
      return localDataFlycSetLimits;
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
  
  public DataFlycSetLimits setMode(DataFlycGetLimits.MODE paramMODE)
  {
    this.mode = paramMODE;
    return this;
  }
  
  public DataFlycSetLimits setValue(int paramInt)
  {
    this.value = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetLimits.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */