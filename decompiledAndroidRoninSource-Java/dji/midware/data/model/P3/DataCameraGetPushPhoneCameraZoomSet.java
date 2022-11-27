package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushPhoneCameraZoomSet
  extends DataBase
{
  private static DataCameraGetPushPhoneCameraZoomSet instance;
  private final String TAG = DataCameraGetPushPhoneCameraZoomSet.class.getSimpleName();
  
  public static DataCameraGetPushPhoneCameraZoomSet getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushPhoneCameraZoomSet();
      }
      DataCameraGetPushPhoneCameraZoomSet localDataCameraGetPushPhoneCameraZoomSet = instance;
      return localDataCameraGetPushPhoneCameraZoomSet;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getSetZoomSpeed()
  {
    return 0;
  }
  
  public int getZoomDirection()
  {
    return 0;
  }
  
  public int getZoomFocusLenthHigh()
  {
    return 0;
  }
  
  public int getZoomType()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushPhoneCameraZoomSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */