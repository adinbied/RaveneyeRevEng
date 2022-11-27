package dji.internal.gimbal;

public enum CalibrationState
{
  static
  {
    FAIL = new CalibrationState("FAIL", 2);
    CalibrationState localCalibrationState = new CalibrationState("SUCCESS", 3);
    SUCCESS = localCalibrationState;
    $VALUES = new CalibrationState[] { DEFAULT, START, FAIL, localCalibrationState };
  }
  
  private CalibrationState() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\gimbal\CalibrationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */