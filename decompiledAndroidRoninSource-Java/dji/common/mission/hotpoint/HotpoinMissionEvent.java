package dji.common.mission.hotpoint;

import dji.common.error.DJIError;

public class HotpoinMissionEvent
{
  private final HotpointMissionState currentState;
  private final DJIError error;
  private final HotpointMissionState previousState;
  private final float radius;
  
  public HotpoinMissionEvent(Builder paramBuilder)
  {
    this.error = paramBuilder.error;
    this.previousState = paramBuilder.previousState;
    this.currentState = paramBuilder.currentState;
    this.radius = paramBuilder.radius;
  }
  
  public HotpointMissionState getCurrentState()
  {
    return this.currentState;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public HotpointMissionState getPreviousState()
  {
    return this.previousState;
  }
  
  public float getRadius()
  {
    return this.radius;
  }
  
  public static final class Builder
  {
    private HotpointMissionState currentState;
    private DJIError error;
    private HotpointMissionState previousState;
    private float radius;
    
    public HotpoinMissionEvent build()
    {
      return new HotpoinMissionEvent(this);
    }
    
    public Builder currentState(HotpointMissionState paramHotpointMissionState)
    {
      this.currentState = paramHotpointMissionState;
      return this;
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder previousState(HotpointMissionState paramHotpointMissionState)
    {
      this.previousState = paramHotpointMissionState;
      return this;
    }
    
    public Builder radius(float paramFloat)
    {
      this.radius = paramFloat;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\hotpoint\HotpoinMissionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */