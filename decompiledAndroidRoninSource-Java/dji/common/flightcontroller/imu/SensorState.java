package dji.common.flightcontroller.imu;

public enum SensorState
{
  private int data;
  
  static
  {
    DISCONNECTED = new SensorState("DISCONNECTED", 1, 1);
    CALIBRATING = new SensorState("CALIBRATING", 2, 2);
    CALIBRATION_FAILED = new SensorState("CALIBRATION_FAILED", 3, 3);
    DATA_EXCEPTION = new SensorState("DATA_EXCEPTION", 4, 4);
    WARMING_UP = new SensorState("WARMING_UP", 5, 5);
    IN_MOTION = new SensorState("IN_MOTION", 6, 6);
    NORMAL_BIAS = new SensorState("NORMAL_BIAS", 7, 7);
    MEDIUM_BIAS = new SensorState("MEDIUM_BIAS", 8, 8);
    SensorState localSensorState = new SensorState("LARGE_BIAS", 9, 9);
    LARGE_BIAS = localSensorState;
    $VALUES = new SensorState[] { UNKNOWN, DISCONNECTED, CALIBRATING, CALIBRATION_FAILED, DATA_EXCEPTION, WARMING_UP, IN_MOTION, NORMAL_BIAS, MEDIUM_BIAS, localSensorState };
  }
  
  private SensorState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static SensorState find(int paramInt)
  {
    SensorState localSensorState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localSensorState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\imu\SensorState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */