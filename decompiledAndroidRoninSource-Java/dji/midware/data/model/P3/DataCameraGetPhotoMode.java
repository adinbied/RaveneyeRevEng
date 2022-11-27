package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCameraGetPhotoMode
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCameraGetPhotoMode instance;
  
  public static DataCameraGetPhotoMode getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPhotoMode();
      }
      DataCameraGetPhotoMode localDataCameraGetPhotoMode = instance;
      return localDataCameraGetPhotoMode;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getContinueNum()
  {
    return 0;
  }
  
  public int getTimeInterval()
  {
    return 0;
  }
  
  public int getTimeNum()
  {
    return 0;
  }
  
  public int getTimeType()
  {
    return 0;
  }
  
  public DataCameraSetPhoto.TYPE getType()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPhotoMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */