package dji.common.flightcontroller;

public enum ControlGimbalBehavior
{
  private int data;
  
  static
  {
    BOTH_MOVE = new ControlGimbalBehavior("BOTH_MOVE", 2, 2);
    ControlGimbalBehavior localControlGimbalBehavior = new ControlGimbalBehavior("UNKNOWN", 3, 255);
    UNKNOWN = localControlGimbalBehavior;
    $VALUES = new ControlGimbalBehavior[] { ONLY_LEFT_MOVE, ONLY_RIGHT_MOVE, BOTH_MOVE, localControlGimbalBehavior };
  }
  
  private ControlGimbalBehavior(int paramInt)
  {
    this.data = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public static ControlGimbalBehavior find(int paramInt)
  {
    ControlGimbalBehavior localControlGimbalBehavior = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localControlGimbalBehavior;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\ControlGimbalBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */