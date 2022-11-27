package dji.common.flightcontroller;

public enum GoHomeExecutionState
{
  private int data;
  
  static
  {
    GO_UP_TO_HEIGHT = new GoHomeExecutionState("GO_UP_TO_HEIGHT", 2, 1);
    AUTO_FLY_TO_HOME_POINT = new GoHomeExecutionState("AUTO_FLY_TO_HOME_POINT", 3, 4);
    GO_DOWN_TO_GROUND = new GoHomeExecutionState("GO_DOWN_TO_GROUND", 4, 7);
    COMPLETED = new GoHomeExecutionState("COMPLETED", 5, 8);
    BRAKING = new GoHomeExecutionState("BRAKING", 6, 5);
    BYPASSING = new GoHomeExecutionState("BYPASSING", 7, 6);
    GoHomeExecutionState localGoHomeExecutionState = new GoHomeExecutionState("UNKNOWN", 8, 255);
    UNKNOWN = localGoHomeExecutionState;
    $VALUES = new GoHomeExecutionState[] { NOT_EXECUTING, TURN_DIRECTION_TO_HOME_POINT, GO_UP_TO_HEIGHT, AUTO_FLY_TO_HOME_POINT, GO_DOWN_TO_GROUND, COMPLETED, BRAKING, BYPASSING, localGoHomeExecutionState };
  }
  
  private GoHomeExecutionState(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static GoHomeExecutionState find(int paramInt)
  {
    GoHomeExecutionState localGoHomeExecutionState = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localGoHomeExecutionState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\GoHomeExecutionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */