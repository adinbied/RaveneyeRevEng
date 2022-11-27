package dji.common.flightcontroller.imu;

public enum OrientationCalibrationState
{
  private int data;
  
  static
  {
    CALIBRATING = new OrientationCalibrationState("CALIBRATING", 1, 0);
    OrientationCalibrationState localOrientationCalibrationState = new OrientationCalibrationState("COMPLETED", 2, 1);
    COMPLETED = localOrientationCalibrationState;
    $VALUES = new OrientationCalibrationState[] { UNKNOWN, CALIBRATING, localOrientationCalibrationState };
  }
  
  private OrientationCalibrationState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static OrientationCalibrationState find(int paramInt)
  {
    OrientationCalibrationState localOrientationCalibrationState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        localOrientationCalibrationState = values()[i];
      }
      i += 1;
    }
    return localOrientationCalibrationState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\imu\OrientationCalibrationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */