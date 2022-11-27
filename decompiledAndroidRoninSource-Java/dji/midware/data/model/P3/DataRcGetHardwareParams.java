package dji.midware.data.model.P3;

import android.util.SparseIntArray;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetHardwareParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetHardwareParams instance;
  
  public static DataRcGetHardwareParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetHardwareParams();
      }
      DataRcGetHardwareParams localDataRcGetHardwareParams = instance;
      return localDataRcGetHardwareParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public SparseIntArray getList()
  {
    return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetHardwareParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */