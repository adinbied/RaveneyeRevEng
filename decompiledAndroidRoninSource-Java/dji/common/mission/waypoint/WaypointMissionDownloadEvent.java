package dji.common.mission.waypoint;

import dji.common.error.DJIError;

public class WaypointMissionDownloadEvent
  extends WaypointMissionEvent
{
  private final WaypointDownloadProgress progress;
  
  public WaypointMissionDownloadEvent(Builder paramBuilder)
  {
    super(paramBuilder.error);
    this.progress = paramBuilder.progress;
  }
  
  public WaypointDownloadProgress getProgress()
  {
    return this.progress;
  }
  
  public static final class Builder
  {
    private DJIError error;
    private WaypointDownloadProgress progress;
    
    public WaypointMissionDownloadEvent build()
    {
      return new WaypointMissionDownloadEvent(this);
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder progress(WaypointDownloadProgress paramWaypointDownloadProgress)
    {
      this.progress = paramWaypointDownloadProgress;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionDownloadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */