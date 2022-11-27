package dji.midware.data.model.P3;

import android.util.SparseArray;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataRcSetChannelParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataRcSetChannelParams instance;
  private SparseArray<DataRcGetChannelParams.DJIChannel> list;
  
  public static DataRcSetChannelParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataRcSetChannelParams();
      }
      DataRcSetChannelParams localDataRcSetChannelParams = instance;
      return localDataRcSetChannelParams;
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
  
  public DataRcSetChannelParams setList(SparseArray<DataRcGetChannelParams.DJIChannel> paramSparseArray)
  {
    this.list = paramSparseArray;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataRcSetChannelParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */