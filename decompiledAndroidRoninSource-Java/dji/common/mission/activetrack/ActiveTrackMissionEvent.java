package dji.common.mission.activetrack;

import dji.common.error.DJIError;

public class ActiveTrackMissionEvent
{
  private ActiveTrackState currentState;
  private DJIError error;
  private ActiveTrackState previousState;
  private ActiveTrackTrackingState trackingState;
  
  public ActiveTrackMissionEvent(ActiveTrackState paramActiveTrackState1, ActiveTrackState paramActiveTrackState2, DJIError paramDJIError, ActiveTrackTrackingState paramActiveTrackTrackingState)
  {
    this.previousState = paramActiveTrackState1;
    this.currentState = paramActiveTrackState2;
    this.error = paramDJIError;
    this.trackingState = paramActiveTrackTrackingState;
  }
  
  public ActiveTrackState getCurrentState()
  {
    return this.currentState;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public ActiveTrackState getPreviousState()
  {
    return this.previousState;
  }
  
  public ActiveTrackTrackingState getTrackingState()
  {
    return this.trackingState;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\activetrack\ActiveTrackMissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */