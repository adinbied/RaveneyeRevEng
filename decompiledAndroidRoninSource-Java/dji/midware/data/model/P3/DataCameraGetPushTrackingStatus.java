package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushTrackingStatus
  extends DJICameraDataBase
{
  private static DataCameraGetPushTrackingStatus instance;
  
  public static DataCameraGetPushTrackingStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushTrackingStatus();
      }
      DataCameraGetPushTrackingStatus localDataCameraGetPushTrackingStatus = instance;
      return localDataCameraGetPushTrackingStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public boolean getStatus()
  {
    return false;
  }
  
  public int getXCoord()
  {
    return 0;
  }
  
  public int getYCoord()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushTrackingStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */