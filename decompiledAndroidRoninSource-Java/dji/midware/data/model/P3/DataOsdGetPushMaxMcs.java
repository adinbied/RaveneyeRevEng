package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataOsdGetPushMaxMcs
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataOsdGetPushMaxMcs instance;
  
  public static DataOsdGetPushMaxMcs getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdGetPushMaxMcs();
      }
      DataOsdGetPushMaxMcs localDataOsdGetPushMaxMcs = instance;
      return localDataOsdGetPushMaxMcs;
    }
    finally {}
  }
  
  protected void doPack()
  {
    this._sendData = new byte[1];
  }
  
  public int getMaxMcs()
  {
    return 0;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdGetPushMaxMcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */