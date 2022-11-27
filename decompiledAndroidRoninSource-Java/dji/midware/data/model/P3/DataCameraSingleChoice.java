package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraSingleChoice
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraSingleChoice instance;
  private int index;
  
  public static DataCameraSingleChoice getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraSingleChoice();
      }
      DataCameraSingleChoice localDataCameraSingleChoice = instance;
      return localDataCameraSingleChoice;
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
  
  public DataCameraSingleChoice setKey(int paramInt)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraSingleChoice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */