package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

class DataCameraGetSDCardParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetSDCardParams instance;
  
  public static DataCameraGetSDCardParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetSDCardParams();
      }
      DataCameraGetSDCardParams localDataCameraGetSDCardParams = instance;
      return localDataCameraGetSDCardParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getRemainedShots()
  {
    return 0;
  }
  
  public int getRemainedTime()
  {
    return 0;
  }
  
  public int getSDCardFreeSize()
  {
    return 0;
  }
  
  public boolean getSDCardInsertState()
  {
    return false;
  }
  
  public DataCameraGetStateInfo.SDCardState getSDCardState()
  {
    return null;
  }
  
  public int getSDCardTotalSize()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetSDCardParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */