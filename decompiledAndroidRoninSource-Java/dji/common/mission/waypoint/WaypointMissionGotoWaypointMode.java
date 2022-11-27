package dji.common.mission.waypoint;

public enum WaypointMissionGotoWaypointMode
{
  private int value;
  
  static
  {
    WaypointMissionGotoWaypointMode localWaypointMissionGotoWaypointMode = new WaypointMissionGotoWaypointMode("POINT_TO_POINT", 1, 1);
    POINT_TO_POINT = localWaypointMissionGotoWaypointMode;
    $VALUES = new WaypointMissionGotoWaypointMode[] { SAFELY, localWaypointMissionGotoWaypointMode };
  }
  
  private WaypointMissionGotoWaypointMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointMissionGotoWaypointMode find(int paramInt)
  {
    WaypointMissionGotoWaypointMode localWaypointMissionGotoWaypointMode = SAFELY;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointMissionGotoWaypointMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionGotoWaypointMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */