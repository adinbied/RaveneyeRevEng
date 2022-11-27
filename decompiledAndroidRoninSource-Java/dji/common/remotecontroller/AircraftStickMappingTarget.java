package dji.common.remotecontroller;

public enum AircraftStickMappingTarget
{
  private int value;
  
  static
  {
    PITCH = new AircraftStickMappingTarget("PITCH", 1, 1);
    ROLL = new AircraftStickMappingTarget("ROLL", 2, 2);
    YAW = new AircraftStickMappingTarget("YAW", 3, 3);
    AircraftStickMappingTarget localAircraftStickMappingTarget = new AircraftStickMappingTarget("NONE", 4, 255);
    NONE = localAircraftStickMappingTarget;
    $VALUES = new AircraftStickMappingTarget[] { THROTTLE, PITCH, ROLL, YAW, localAircraftStickMappingTarget };
  }
  
  private AircraftStickMappingTarget(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static AircraftStickMappingTarget find(int paramInt)
  {
    AircraftStickMappingTarget localAircraftStickMappingTarget = NONE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localAircraftStickMappingTarget;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\AircraftStickMappingTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */