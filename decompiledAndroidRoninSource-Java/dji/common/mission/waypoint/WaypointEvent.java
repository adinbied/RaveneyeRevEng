package dji.common.mission.waypoint;

import dji.common.mission.MissionEvent;

public class WaypointEvent
  extends MissionEvent
{
  public static final WaypointEvent DOWNLOAD_DONE = new WaypointEvent("DOWNLOAD_DONE");
  public static final WaypointEvent DOWNLOAD_FAILED;
  public static final WaypointEvent DOWNLOAD_PROGRESS_UPDATE;
  public static final WaypointEvent EXECUTION_FINISHED = new WaypointEvent("EXECUTION_FINISHED");
  public static final WaypointEvent SIMULATION_OFF = new WaypointEvent("SIMULATION_OFF");
  public static final WaypointEvent UPLOAD_DONE;
  public static final WaypointEvent UPLOAD_FAILED = new WaypointEvent("UPLOAD_FAILED");
  public static final WaypointEvent UPLOAD_PROGRESS_UPDATE = new WaypointEvent("UPLOAD_PROGRESS_UPDATE");
  
  static
  {
    UPLOAD_DONE = new WaypointEvent("UPLOAD_DONE");
    DOWNLOAD_FAILED = new WaypointEvent("DOWNLOAD_FAILED");
    DOWNLOAD_PROGRESS_UPDATE = new WaypointEvent("DOWNLOAD_PROGRESS_UPDATE");
  }
  
  public WaypointEvent(String paramString)
  {
    super(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */