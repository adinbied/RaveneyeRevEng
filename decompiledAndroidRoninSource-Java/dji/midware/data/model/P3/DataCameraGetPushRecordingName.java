package dji.midware.data.model.P3;

import dji.logic.album.manager.litchis.DJIFileType;
import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushRecordingName
  extends DataBase
{
  private static DataCameraGetPushRecordingName instance;
  
  public static DataCameraGetPushRecordingName getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushRecordingName();
      }
      DataCameraGetPushRecordingName localDataCameraGetPushRecordingName = instance;
      return localDataCameraGetPushRecordingName;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getFileType()
  {
    return 0;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public long getSize()
  {
    return 277655169L;
  }
  
  public int getSubIndex()
  {
    return 0;
  }
  
  public long getTime()
  {
    return 277655177L;
  }
  
  public DJIFileType getType()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushRecordingName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */