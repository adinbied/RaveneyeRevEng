package dji.common.remotecontroller;

public enum GimbalStickMappingTarget
{
  private int value;
  
  static
  {
    GimbalStickMappingTarget localGimbalStickMappingTarget = new GimbalStickMappingTarget("YAW", 3, 3);
    YAW = localGimbalStickMappingTarget;
    $VALUES = new GimbalStickMappingTarget[] { NONE, PITCH, ROLL, localGimbalStickMappingTarget };
  }
  
  private GimbalStickMappingTarget(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static GimbalStickMappingTarget find(int paramInt)
  {
    GimbalStickMappingTarget localGimbalStickMappingTarget = NONE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGimbalStickMappingTarget;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\GimbalStickMappingTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */