package dji.common.mission.waypoint;

import dji.common.mission.MissionState;

public final class WaypointMissionState
  extends MissionState
{
  public static final WaypointMissionState DISCONNECTED;
  public static final WaypointMissionState EXECUTING = new WaypointMissionState("EXECUTING");
  public static final WaypointMissionState EXECUTION_PAUSED = new WaypointMissionState("EXECUTION_PAUSED");
  public static final WaypointMissionState NOT_SUPPORTED;
  public static final WaypointMissionState READY_TO_EXECUTE;
  public static final WaypointMissionState READY_TO_UPLOAD;
  public static final WaypointMissionState RECOVERING;
  public static final WaypointMissionState UNKNOWN = new WaypointMissionState("UNKNOWN");
  public static final WaypointMissionState UPLOADING;
  
  static
  {
    DISCONNECTED = new WaypointMissionState("DISCONNECTED");
    NOT_SUPPORTED = new WaypointMissionState("NOT_SUPPORTED");
    RECOVERING = new WaypointMissionState("RECOVERING");
    READY_TO_UPLOAD = new WaypointMissionState("READY_TO_UPLOAD");
    UPLOADING = new WaypointMissionState("UPLOADING");
    READY_TO_EXECUTE = new WaypointMissionState("READY_TO_EXECUTE");
  }
  
  private WaypointMissionState(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */