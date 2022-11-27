package dji.common.mission.waypoint;

public enum WaypointMissionExecuteState
{
  private int value;
  
  static
  {
    CURVE_MODE_MOVING = new WaypointMissionExecuteState("CURVE_MODE_MOVING", 2, 2);
    CURVE_MODE_TURNING = new WaypointMissionExecuteState("CURVE_MODE_TURNING", 3, 3);
    BEGIN_ACTION = new WaypointMissionExecuteState("BEGIN_ACTION", 4, 4);
    DOING_ACTION = new WaypointMissionExecuteState("DOING_ACTION", 5, 5);
    FINISHED_ACTION = new WaypointMissionExecuteState("FINISHED_ACTION", 6, 6);
    RETURN_TO_FIRST_WAYPOINT = new WaypointMissionExecuteState("RETURN_TO_FIRST_WAYPOINT", 7, 8);
    WaypointMissionExecuteState localWaypointMissionExecuteState = new WaypointMissionExecuteState("PAUSED", 8, 9);
    PAUSED = localWaypointMissionExecuteState;
    $VALUES = new WaypointMissionExecuteState[] { INITIALIZING, MOVING, CURVE_MODE_MOVING, CURVE_MODE_TURNING, BEGIN_ACTION, DOING_ACTION, FINISHED_ACTION, RETURN_TO_FIRST_WAYPOINT, localWaypointMissionExecuteState };
  }
  
  private WaypointMissionExecuteState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointMissionExecuteState find(int paramInt)
  {
    WaypointMissionExecuteState localWaypointMissionExecuteState = INITIALIZING;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointMissionExecuteState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionExecuteState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */