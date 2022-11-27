package dji.common.mission.waypoint;

import dji.common.error.DJIError;

public final class WaypointMissionUploadEvent
  extends WaypointMissionEvent
{
  private final WaypointMissionState currentState;
  private final WaypointMissionState previousState;
  private final WaypointUploadProgress progress;
  
  public WaypointMissionUploadEvent(Builder paramBuilder)
  {
    super(paramBuilder.error);
    this.previousState = paramBuilder.previousState;
    this.currentState = paramBuilder.currentState;
    this.progress = paramBuilder.progress;
  }
  
  public WaypointMissionState getCurrentState()
  {
    return this.currentState;
  }
  
  public WaypointMissionState getPreviousState()
  {
    return this.previousState;
  }
  
  public WaypointUploadProgress getProgress()
  {
    return this.progress;
  }
  
  public static final class Builder
  {
    private WaypointMissionState currentState;
    private DJIError error;
    private WaypointMissionState previousState;
    private WaypointUploadProgress progress;
    
    public WaypointMissionUploadEvent build()
    {
      return new WaypointMissionUploadEvent(this);
    }
    
    public Builder currentState(WaypointMissionState paramWaypointMissionState)
    {
      this.currentState = paramWaypointMissionState;
      return this;
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder previousState(WaypointMissionState paramWaypointMissionState)
    {
      this.previousState = paramWaypointMissionState;
      return this;
    }
    
    public Builder progress(WaypointUploadProgress paramWaypointUploadProgress)
    {
      this.progress = paramWaypointUploadProgress;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\waypoint\WaypointMissionUploadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */