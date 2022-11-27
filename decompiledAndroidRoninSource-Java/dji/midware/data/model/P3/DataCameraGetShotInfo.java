package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetShotInfo
  extends DJICameraDataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetShotInfo instance;
  
  public static DataCameraGetShotInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetShotInfo();
      }
      DataCameraGetShotInfo localDataCameraGetShotInfo = instance;
      return localDataCameraGetShotInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getHardVersion()
  {
    return 0;
  }
  
  public int getMemberId()
  {
    return 0;
  }
  
  public int getModelId()
  {
    return 0;
  }
  
  public String getName()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetShotInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */