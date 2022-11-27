package dji.common.mission.waypoint;

public enum WaypointMissionHeadingMode
{
  private int value;
  
  static
  {
    CONTROL_BY_REMOTE_CONTROLLER = new WaypointMissionHeadingMode("CONTROL_BY_REMOTE_CONTROLLER", 2, 2);
    USING_WAYPOINT_HEADING = new WaypointMissionHeadingMode("USING_WAYPOINT_HEADING", 3, 3);
    WaypointMissionHeadingMode localWaypointMissionHeadingMode = new WaypointMissionHeadingMode("TOWARD_POINT_OF_INTEREST", 4, 4);
    TOWARD_POINT_OF_INTEREST = localWaypointMissionHeadingMode;
    $VALUES = new WaypointMissionHeadingMode[] { AUTO, USING_INITIAL_DIRECTION, CONTROL_BY_REMOTE_CONTROLLER, USING_WAYPOINT_HEADING, localWaypointMissionHeadingMode };
  }
  
  private WaypointMissionHeadingMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointMissionHeadingMode find(int paramInt)
  {
    WaypointMissionHeadingMode localWaypointMissionHeadingMode = AUTO;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointMissionHeadingMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionHeadingMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */