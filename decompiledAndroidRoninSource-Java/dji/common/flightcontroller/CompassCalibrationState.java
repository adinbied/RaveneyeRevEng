package dji.common.flightcontroller;

public enum CompassCalibrationState
{
  private int data;
  
  static
  {
    HORIZONTAL = new CompassCalibrationState("HORIZONTAL", 1, 0);
    VERTICAL = new CompassCalibrationState("VERTICAL", 2, 1);
    SUCCESSFUL = new CompassCalibrationState("SUCCESSFUL", 3, 2);
    FAILED = new CompassCalibrationState("FAILED", 4, 3);
    CompassCalibrationState localCompassCalibrationState = new CompassCalibrationState("UNKNOWN", 5, 255);
    UNKNOWN = localCompassCalibrationState;
    $VALUES = new CompassCalibrationState[] { NOT_CALIBRATING, HORIZONTAL, VERTICAL, SUCCESSFUL, FAILED, localCompassCalibrationState };
  }
  
  private CompassCalibrationState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CompassCalibrationState find(int paramInt)
  {
    CompassCalibrationState localCompassCalibrationState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localCompassCalibrationState;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(CompassCalibrationState paramCompassCalibrationState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\CompassCalibrationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */