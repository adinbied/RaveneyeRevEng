package dji.common.mission.followme;

import dji.common.error.DJIError;

public class FollowMeMissionEvent
{
  private final FollowMeMissionState currentState;
  private final float distanceToTarget;
  private final DJIError error;
  private final FollowMeMissionState previousState;
  
  public FollowMeMissionEvent(Builder paramBuilder)
  {
    this.error = paramBuilder.error;
    this.previousState = paramBuilder.previousState;
    this.currentState = paramBuilder.currentState;
    this.distanceToTarget = paramBuilder.distanceToTarget;
  }
  
  public FollowMeMissionState getCurrentState()
  {
    return this.currentState;
  }
  
  public float getDistanceToTarget()
  {
    return this.distanceToTarget;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public FollowMeMissionState getPreviousState()
  {
    return this.previousState;
  }
  
  public static final class Builder
  {
    private FollowMeMissionState currentState;
    private float distanceToTarget;
    private DJIError error;
    private FollowMeMissionState previousState;
    
    public FollowMeMissionEvent build()
    {
      return new FollowMeMissionEvent(this);
    }
    
    public Builder currentState(FollowMeMissionState paramFollowMeMissionState)
    {
      this.currentState = paramFollowMeMissionState;
      return this;
    }
    
    public Builder distanceToTarget(float paramFloat)
    {
      this.distanceToTarget = paramFloat;
      return this;
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder previousState(FollowMeMissionState paramFollowMeMissionState)
    {
      this.previousState = paramFollowMeMissionState;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\followme\FollowMeMissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */