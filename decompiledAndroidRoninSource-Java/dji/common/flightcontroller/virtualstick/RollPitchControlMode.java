package dji.common.flightcontroller.virtualstick;

public enum RollPitchControlMode
{
  private int data;
  
  static
  {
    RollPitchControlMode localRollPitchControlMode = new RollPitchControlMode("VELOCITY", 1, 1);
    VELOCITY = localRollPitchControlMode;
    $VALUES = new RollPitchControlMode[] { ANGLE, localRollPitchControlMode };
  }
  
  private RollPitchControlMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static RollPitchControlMode find(int paramInt)
  {
    RollPitchControlMode localRollPitchControlMode = ANGLE;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localRollPitchControlMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\virtualstick\RollPitchControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */