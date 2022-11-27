package dji.common.mission.tapfly;

public enum BypassDirection
{
  private int value;
  
  static
  {
    LEFT = new BypassDirection("LEFT", 2, 2);
    OVER = new BypassDirection("OVER", 3, 3);
    BypassDirection localBypassDirection = new BypassDirection("UNKNOWN", 4, 255);
    UNKNOWN = localBypassDirection;
    $VALUES = new BypassDirection[] { NONE, RIGHT, LEFT, OVER, localBypassDirection };
  }
  
  private BypassDirection(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static BypassDirection find(int paramInt)
  {
    BypassDirection localBypassDirection = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localBypassDirection;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\tapfly\BypassDirection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */