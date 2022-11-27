package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycNoeMissionPauseOrResume
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataFlycNoeMissionPauseOrResume instance;
  private boolean isPause;
  
  public static DataFlycNoeMissionPauseOrResume getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycNoeMissionPauseOrResume();
      }
      DataFlycNoeMissionPauseOrResume localDataFlycNoeMissionPauseOrResume = instance;
      return localDataFlycNoeMissionPauseOrResume;
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
  
  public int getResult()
  {
    return 0;
  }
  
  public DataFlycNoeMissionPauseOrResume pauseMission()
  {
    this.isPause = true;
    return this;
  }
  
  public DataFlycNoeMissionPauseOrResume resumeMission()
  {
    this.isPause = false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycNoeMissionPauseOrResume.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */