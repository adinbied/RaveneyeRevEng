package dji.common.flightcontroller;

public enum AdvancedGoHomeState
{
  private int data;
  
  static
  {
    EXECUTING_GO_HOME = new AdvancedGoHomeState("EXECUTING_GO_HOME", 2, 2);
    HOVERING_AT_SAFE_POINT = new AdvancedGoHomeState("HOVERING_AT_SAFE_POINT", 3, 3);
    PLANNING = new AdvancedGoHomeState("PLANNING", 4, 4);
    AdvancedGoHomeState localAdvancedGoHomeState = new AdvancedGoHomeState("UNKNOWN", 5, 255);
    UNKNOWN = localAdvancedGoHomeState;
    $VALUES = new AdvancedGoHomeState[] { NONE, TURNING_YAW, EXECUTING_GO_HOME, HOVERING_AT_SAFE_POINT, PLANNING, localAdvancedGoHomeState };
  }
  
  private AdvancedGoHomeState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static AdvancedGoHomeState find(int paramInt)
  {
    AdvancedGoHomeState localAdvancedGoHomeState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localAdvancedGoHomeState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\AdvancedGoHomeState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */