package dji.common.mission.waypoint;

public class WaypointAction
{
  public int actionParam = 0;
  public WaypointActionType actionType;
  
  public WaypointAction(WaypointActionType paramWaypointActionType, int paramInt)
  {
    this.actionType = paramWaypointActionType;
    this.actionParam = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */