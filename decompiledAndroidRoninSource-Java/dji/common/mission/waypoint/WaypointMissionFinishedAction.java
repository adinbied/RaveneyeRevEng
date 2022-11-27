package dji.common.mission.waypoint;

public enum WaypointMissionFinishedAction
{
  private int value;
  
  static
  {
    GO_HOME = new WaypointMissionFinishedAction("GO_HOME", 1, 1);
    AUTO_LAND = new WaypointMissionFinishedAction("AUTO_LAND", 2, 2);
    GO_FIRST_WAYPOINT = new WaypointMissionFinishedAction("GO_FIRST_WAYPOINT", 3, 3);
    WaypointMissionFinishedAction localWaypointMissionFinishedAction = new WaypointMissionFinishedAction("CONTINUE_UNTIL_END", 4, 4);
    CONTINUE_UNTIL_END = localWaypointMissionFinishedAction;
    $VALUES = new WaypointMissionFinishedAction[] { NO_ACTION, GO_HOME, AUTO_LAND, GO_FIRST_WAYPOINT, localWaypointMissionFinishedAction };
  }
  
  private WaypointMissionFinishedAction(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointMissionFinishedAction find(int paramInt)
  {
    WaypointMissionFinishedAction localWaypointMissionFinishedAction = NO_ACTION;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointMissionFinishedAction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionFinishedAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */