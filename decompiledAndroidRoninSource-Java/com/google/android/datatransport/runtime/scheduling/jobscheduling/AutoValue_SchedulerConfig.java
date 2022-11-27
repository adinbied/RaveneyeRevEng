package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

final class AutoValue_SchedulerConfig
  extends SchedulerConfig
{
  private final Clock clock;
  private final Map<Priority, SchedulerConfig.ConfigValue> values;
  
  AutoValue_SchedulerConfig(Clock paramClock, Map<Priority, SchedulerConfig.ConfigValue> paramMap)
  {
    if (paramClock != null)
    {
      this.clock = paramClock;
      if (paramMap != null)
      {
        this.values = paramMap;
        return;
      }
      throw new NullPointerException("Null values");
    }
    throw new NullPointerException("Null clock");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig))
    {
      paramObject = (SchedulerConfig)paramObject;
      return (this.clock.equals(((SchedulerConfig)paramObject).getClock())) && (this.values.equals(((SchedulerConfig)paramObject).getValues()));
    }
    return false;
  }
  
  Clock getClock()
  {
    return this.clock;
  }
  
  Map<Priority, SchedulerConfig.ConfigValue> getValues()
  {
    return this.values;
  }
  
  public int hashCode()
  {
    return (this.clock.hashCode() ^ 0xF4243) * 1000003 ^ this.values.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SchedulerConfig{clock=");
    localStringBuilder.append(this.clock);
    localStringBuilder.append(", values=");
    localStringBuilder.append(this.values);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\AutoValue_SchedulerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */