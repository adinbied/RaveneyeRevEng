package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetPassword
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetPassword instance;
  
  public static DataRcGetPassword getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetPassword();
      }
      DataRcGetPassword localDataRcGetPassword = instance;
      return localDataRcGetPassword;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getPw()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetPassword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */