package dji.common.mission.followme;

public enum FollowMeMissionExecuteState
{
  private int value;
  
  static
  {
    FollowMeMissionExecuteState localFollowMeMissionExecuteState = new FollowMeMissionExecuteState("WAITING", 2, 2);
    WAITING = localFollowMeMissionExecuteState;
    $VALUES = new FollowMeMissionExecuteState[] { INITIALIZING, MOVING, localFollowMeMissionExecuteState };
  }
  
  private FollowMeMissionExecuteState(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static FollowMeMissionExecuteState find(int paramInt)
  {
    FollowMeMissionExecuteState localFollowMeMissionExecuteState = WAITING;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localFollowMeMissionExecuteState;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeMissionExecuteState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */