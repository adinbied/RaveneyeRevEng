package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetSlavePermission
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetSlavePermission instance;
  private SparseArray<DataRcSetSlavePermission.RcSlavePermission> result = new SparseArray();
  
  public static DataRcGetSlavePermission getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetSlavePermission();
      }
      DataRcGetSlavePermission localDataRcGetSlavePermission = instance;
      return localDataRcGetSlavePermission;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public DataRcSetSlavePermission.RcSlavePermission getPermission(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetSlavePermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */