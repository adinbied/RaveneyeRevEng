package dji.common.flightcontroller;

public enum CalibrationOrientation
{
  private int data;
  
  static
  {
    NOSE_DOWN = new CalibrationOrientation("NOSE_DOWN", 1, 0);
    TAIL_DOWN = new CalibrationOrientation("TAIL_DOWN", 2, 1);
    RIGHT_DOWN = new CalibrationOrientation("RIGHT_DOWN", 3, 2);
    LEFT_DOWN = new CalibrationOrientation("LEFT_DOWN", 4, 3);
    BOTTOM_DOWN = new CalibrationOrientation("BOTTOM_DOWN", 5, 4);
    CalibrationOrientation localCalibrationOrientation = new CalibrationOrientation("TOP_DOWN", 6, 5);
    TOP_DOWN = localCalibrationOrientation;
    $VALUES = new CalibrationOrientation[] { UNKNOWN, NOSE_DOWN, TAIL_DOWN, RIGHT_DOWN, LEFT_DOWN, BOTTOM_DOWN, localCalibrationOrientation };
  }
  
  private CalibrationOrientation(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CalibrationOrientation find(int paramInt)
  {
    CalibrationOrientation localCalibrationOrientation = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        localCalibrationOrientation = values()[i];
      }
      i += 1;
    }
    return localCalibrationOrientation;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\CalibrationOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */