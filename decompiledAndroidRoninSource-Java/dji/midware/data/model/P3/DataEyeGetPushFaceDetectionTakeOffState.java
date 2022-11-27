package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyeGetPushFaceDetectionTakeOffState
  extends DataBase
{
  public static DataEyeGetPushFaceDetectionTakeOffState instance;
  
  public static DataEyeGetPushFaceDetectionTakeOffState getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetPushFaceDetectionTakeOffState();
      }
      DataEyeGetPushFaceDetectionTakeOffState localDataEyeGetPushFaceDetectionTakeOffState = instance;
      return localDataEyeGetPushFaceDetectionTakeOffState;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getDetectionTakeOffState()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetPushFaceDetectionTakeOffState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */