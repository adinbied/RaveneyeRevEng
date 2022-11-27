package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetSimulation
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetSimulation instance;
  private boolean mEnable = false;
  
  public static DataRcSetSimulation getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetSimulation();
      }
      DataRcSetSimulation localDataRcSetSimulation = instance;
      return localDataRcSetSimulation;
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
  
  public DataRcSetSimulation exitFlySimulation()
  {
    this.mEnable = false;
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
  
  public DataRcSetSimulation startFlySimulation()
  {
    this.mEnable = true;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetSimulation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */