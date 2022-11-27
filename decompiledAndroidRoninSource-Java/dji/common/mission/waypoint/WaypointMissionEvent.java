package dji.common.mission.waypoint;

import dji.common.error.DJIError;

public abstract class WaypointMissionEvent
{
  private final DJIError error;
  
  public WaypointMissionEvent(DJIError paramDJIError)
  {
    this.error = paramDJIError;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */