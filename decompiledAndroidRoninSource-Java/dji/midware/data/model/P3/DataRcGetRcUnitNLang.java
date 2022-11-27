package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetRcUnitNLang
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetRcUnitNLang instance;
  
  public static DataRcGetRcUnitNLang getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetRcUnitNLang();
      }
      DataRcGetRcUnitNLang localDataRcGetRcUnitNLang = instance;
      return localDataRcGetRcUnitNLang;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getLang()
  {
    return 0;
  }
  
  public int getUnit()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetRcUnitNLang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */