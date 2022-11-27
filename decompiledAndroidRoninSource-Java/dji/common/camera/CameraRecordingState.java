package dji.common.camera;

public enum CameraRecordingState
{
  private int data;
  
  static
  {
    RecordingToCache = new CameraRecordingState("RecordingToCache", 4, 4);
    CameraRecordingState localCameraRecordingState = new CameraRecordingState("Unknown", 5, 7);
    Unknown = localCameraRecordingState;
    $VALUES = new CameraRecordingState[] { NotRecording, Preparing, Recording, Stoping, RecordingToCache, localCameraRecordingState };
  }
  
  private CameraRecordingState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CameraRecordingState find(int paramInt)
  {
    CameraRecordingState localCameraRecordingState = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localCameraRecordingState;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\CameraRecordingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */