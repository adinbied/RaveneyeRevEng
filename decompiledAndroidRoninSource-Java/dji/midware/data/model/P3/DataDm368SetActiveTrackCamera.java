package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataDm368SetActiveTrackCamera
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataDm368SetActiveTrackCamera instance;
  private DataCameraGetPushStateInfo.CameraType cameraType = DataCameraGetPushStateInfo.CameraType.OTHER;
  
  public static DataDm368SetActiveTrackCamera getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataDm368SetActiveTrackCamera();
      }
      DataDm368SetActiveTrackCamera localDataDm368SetActiveTrackCamera = instance;
      return localDataDm368SetActiveTrackCamera;
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
  
  public DataDm368SetActiveTrackCamera setCameraType(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    this.cameraType = paramCameraType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataDm368SetActiveTrackCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */