package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetCustomFuction
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetCustomFuction instance;
  
  public static DataRcGetCustomFuction getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetCustomFuction();
      }
      DataRcGetCustomFuction localDataRcGetCustomFuction = instance;
      return localDataRcGetCustomFuction;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getC1()
  {
    return 0;
  }
  
  public int getC2()
  {
    return 0;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetCustomFuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */