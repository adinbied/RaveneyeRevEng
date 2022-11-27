package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcGetSlaveList
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcGetSlaveList instance;
  
  public static DataRcGetSlaveList getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcGetSlaveList();
      }
      DataRcGetSlaveList localDataRcGetSlaveList = instance;
      return localDataRcGetSlaveList;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public SparseArray<RcModel> getList()
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
  
  public static class RcModel
  {
    public int id;
    public boolean isOpen;
    public String name;
    public int password;
    public boolean pitch;
    public boolean playback;
    public int quality;
    public boolean record;
    public boolean roll;
    public boolean takephoto;
    public boolean yaw;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcGetSlaveList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */