package dji.common.mission.waypoint;

public enum WaypointMissionFlightPathMode
{
  private int value;
  
  static
  {
    WaypointMissionFlightPathMode localWaypointMissionFlightPathMode = new WaypointMissionFlightPathMode("CURVED", 1, 1);
    CURVED = localWaypointMissionFlightPathMode;
    $VALUES = new WaypointMissionFlightPathMode[] { NORMAL, localWaypointMissionFlightPathMode };
  }
  
  private WaypointMissionFlightPathMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WaypointMissionFlightPathMode find(int paramInt)
  {
    WaypointMissionFlightPathMode localWaypointMissionFlightPathMode = NORMAL;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localWaypointMissionFlightPathMode;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionFlightPathMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */