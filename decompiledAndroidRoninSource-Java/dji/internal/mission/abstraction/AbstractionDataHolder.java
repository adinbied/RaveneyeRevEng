package dji.internal.mission.abstraction;

import dji.common.error.DJIError;
import dji.common.mission.MissionEvent;
import dji.common.mission.MissionState;

public class AbstractionDataHolder
{
  private final MissionState currentState;
  private final DJIError error;
  private final MissionEvent event;
  private final Object extra;
  private final MissionState previousState;
  
  public AbstractionDataHolder(Builder paramBuilder)
  {
    this.previousState = paramBuilder.previousState;
    this.currentState = paramBuilder.currentState;
    this.extra = paramBuilder.extra;
    this.error = paramBuilder.error;
    this.event = paramBuilder.event;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public MissionState getCurrentState()
  {
    return this.currentState;
  }
  
  public DJIError getError()
  {
    return this.error;
  }
  
  public MissionEvent getEvent()
  {
    return this.event;
  }
  
  public Object getExtra()
  {
    return this.extra;
  }
  
  public MissionState getPreviousState()
  {
    return this.previousState;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public static class Builder
  {
    protected MissionState currentState;
    protected DJIError error;
    protected MissionEvent event;
    protected Object extra;
    protected MissionState previousState;
    
    public Builder() {}
    
    public Builder(MissionEvent paramMissionEvent)
    {
      this.event = paramMissionEvent;
    }
    
    public AbstractionDataHolder build()
    {
      return null;
    }
    
    public Builder currentState(MissionState paramMissionState)
    {
      return null;
    }
    
    public Builder error(DJIError paramDJIError)
    {
      this.error = paramDJIError;
      return this;
    }
    
    public Builder event(MissionEvent paramMissionEvent)
    {
      this.event = paramMissionEvent;
      return this;
    }
    
    public Builder extra(Object paramObject)
    {
      this.extra = paramObject;
      return this;
    }
    
    public Builder previousState(MissionState paramMissionState)
    {
      this.previousState = paramMissionState;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mission\abstraction\AbstractionDataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */