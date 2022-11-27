package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetTimeZone
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycSetTimeZone instance;
  public int mTimeZone = -4;
  
  public static DataFlycSetTimeZone getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycSetTimeZone();
      }
      DataFlycSetTimeZone localDataFlycSetTimeZone = instance;
      return localDataFlycSetTimeZone;
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
  
  public DataFlycSetTimeZone setTimeZone(int paramInt)
  {
    this.mTimeZone = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetTimeZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */