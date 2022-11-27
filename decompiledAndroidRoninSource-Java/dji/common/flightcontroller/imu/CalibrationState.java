package dji.common.flightcontroller.imu;

public enum CalibrationState
{
  private int data;
  
  static
  {
    CALIBRATING = new CalibrationState("CALIBRATING", 1, 1);
    SUCCESSFUL = new CalibrationState("SUCCESSFUL", 2, 2);
    FAILED = new CalibrationState("FAILED", 3, 3);
    CalibrationState localCalibrationState = new CalibrationState("UNKNOWN", 4, 255);
    UNKNOWN = localCalibrationState;
    $VALUES = new CalibrationState[] { NONE, CALIBRATING, SUCCESSFUL, FAILED, localCalibrationState };
  }
  
  private CalibrationState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CalibrationState convertIMUCalibrationStatus(int paramInt)
  {
    if ((paramInt != 12) && (paramInt != 80) && (paramInt != 81))
    {
      if (paramInt == 0) {
        return NONE;
      }
      if ((paramInt > 0) && (paramInt < 12)) {
        return CALIBRATING;
      }
      return FAILED;
    }
    return SUCCESSFUL;
  }
  
  public static CalibrationState find(int paramInt)
  {
    CalibrationState localCalibrationState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localCalibrationState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\imu\CalibrationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */