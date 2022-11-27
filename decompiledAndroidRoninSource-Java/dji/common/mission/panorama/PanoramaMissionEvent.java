package dji.common.mission.panorama;

import dji.common.error.DJIError;

public class PanoramaMissionEvent
{
  private final PanoramaMissionState currentState;
  private final DJIError error;
  private final PanoramaMissionExecutionState executionState;
  private final PanoramaMissionState previousState;
  
  public PanoramaMissionEvent(PanoramaMissionState paramPanoramaMissionState1, PanoramaMissionState paramPanoramaMissionState2, PanoramaMissionExecutionState paramPanoramaMissionExecutionState, DJIError paramDJIError)
  {
    this.previousState = paramPanoramaMissionState1;
    this.currentState = paramPanoramaMissionState2;
    this.executionState = paramPanoramaMissionExecutionState;
    this.error = paramDJIError;
  }
  
  public PanoramaMissionState getCurrentState()
  {
    return this.currentState;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public PanoramaMissionExecutionState getExecutionState()
  {
    return this.executionState;
  }
  
  public PanoramaMissionState getPreviousState()
  {
    return this.previousState;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\panorama\PanoramaMissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */