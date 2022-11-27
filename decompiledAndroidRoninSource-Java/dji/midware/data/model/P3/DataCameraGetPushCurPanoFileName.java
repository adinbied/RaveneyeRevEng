package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushCurPanoFileName
  extends DataBase
{
  private static DataCameraGetPushCurPanoFileName instance;
  
  public static DataCameraGetPushCurPanoFileName getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushCurPanoFileName();
      }
      DataCameraGetPushCurPanoFileName localDataCameraGetPushCurPanoFileName = instance;
      return localDataCameraGetPushCurPanoFileName;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public long getCreateTime()
  {
    return 277654524L;
  }
  
  public int getCurSavedNumber()
  {
    return 0;
  }
  
  public int getCurTakenNumber()
  {
    return 0;
  }
  
  public long getFileSize()
  {
    return 277654536L;
  }
  
  public long getIndex()
  {
    return 277654540L;
  }
  
  public long getPanoCreateTime()
  {
    return 277654544L;
  }
  
  public int getTotalNumber()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushCurPanoFileName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */