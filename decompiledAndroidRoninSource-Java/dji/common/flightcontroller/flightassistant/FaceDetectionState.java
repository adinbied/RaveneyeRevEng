package dji.common.flightcontroller.flightassistant;

public enum FaceDetectionState
{
  private final int data;
  
  static
  {
    DETECTING = new FaceDetectionState("DETECTING", 1, 1);
    SUCCESS = new FaceDetectionState("SUCCESS", 2, 2);
    DETECTION_FAIL = new FaceDetectionState("DETECTION_FAIL", 3, 3);
    AIRCRAFT_IS_NOT_READY = new FaceDetectionState("AIRCRAFT_IS_NOT_READY", 4, 4);
    FaceDetectionState localFaceDetectionState = new FaceDetectionState("OTHER", 5, 100);
    OTHER = localFaceDetectionState;
    $VALUES = new FaceDetectionState[] { IDLE, DETECTING, SUCCESS, DETECTION_FAIL, AIRCRAFT_IS_NOT_READY, localFaceDetectionState };
  }
  
  private FaceDetectionState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static FaceDetectionState find(int paramInt)
  {
    FaceDetectionState localFaceDetectionState1 = IDLE;
    FaceDetectionState[] arrayOfFaceDetectionState = values();
    int j = arrayOfFaceDetectionState.length;
    int i = 0;
    while (i < j)
    {
      FaceDetectionState localFaceDetectionState2 = arrayOfFaceDetectionState[i];
      if (localFaceDetectionState2._equals(paramInt)) {
        return localFaceDetectionState2;
      }
      i += 1;
    }
    return localFaceDetectionState1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\flightassistant\FaceDetectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */