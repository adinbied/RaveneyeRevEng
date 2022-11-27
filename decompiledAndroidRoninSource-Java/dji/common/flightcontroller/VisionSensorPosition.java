package dji.common.flightcontroller;

public enum VisionSensorPosition
{
  private final int value;
  
  static
  {
    RIGHT = new VisionSensorPosition("RIGHT", 2, 2);
    LEFT = new VisionSensorPosition("LEFT", 3, 3);
    VisionSensorPosition localVisionSensorPosition = new VisionSensorPosition("UNKNOWN", 4, 255);
    UNKNOWN = localVisionSensorPosition;
    $VALUES = new VisionSensorPosition[] { NOSE, TAIL, RIGHT, LEFT, localVisionSensorPosition };
  }
  
  private VisionSensorPosition(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static VisionSensorPosition find(int paramInt)
  {
    VisionSensorPosition localVisionSensorPosition = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localVisionSensorPosition;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\VisionSensorPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */