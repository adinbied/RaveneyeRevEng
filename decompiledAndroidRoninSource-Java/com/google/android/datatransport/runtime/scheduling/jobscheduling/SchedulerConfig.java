package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo.Builder;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SchedulerConfig
{
  private static final long BACKOFF_LOG_BASE = 10000L;
  private static final long ONE_SECOND = 1000L;
  private static final long THIRTY_SECONDS = 30000L;
  private static final long TWENTY_FOUR_HOURS = 86400000L;
  
  private long adjustedExponentialBackoff(int paramInt, long paramLong)
  {
    paramInt -= 1;
    long l;
    if (paramLong > 1L) {
      l = paramLong;
    } else {
      l = 2L;
    }
    double d = Math.max(1.0D, Math.log(10000.0D) / Math.log(l * paramInt));
    return (Math.pow(3.0D, paramInt) * paramLong * d);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  static SchedulerConfig create(Clock paramClock, Map<Priority, ConfigValue> paramMap)
  {
    return new AutoValue_SchedulerConfig(paramClock, paramMap);
  }
  
  public static SchedulerConfig getDefault(Clock paramClock)
  {
    return builder().addConfig(Priority.DEFAULT, ConfigValue.builder().setDelta(30000L).setMaxAllowedDelay(86400000L).build()).addConfig(Priority.HIGHEST, ConfigValue.builder().setDelta(1000L).setMaxAllowedDelay(86400000L).build()).addConfig(Priority.VERY_LOW, ConfigValue.builder().setDelta(86400000L).setMaxAllowedDelay(86400000L).setFlags(immutableSetOf(new Flag[] { Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE })).build()).setClock(paramClock).build();
  }
  
  private static <T> Set<T> immutableSetOf(T... paramVarArgs)
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramVarArgs)));
  }
  
  private void populateFlags(JobInfo.Builder paramBuilder, Set<Flag> paramSet)
  {
    if (paramSet.contains(Flag.NETWORK_UNMETERED)) {
      paramBuilder.setRequiredNetworkType(2);
    } else {
      paramBuilder.setRequiredNetworkType(1);
    }
    if (paramSet.contains(Flag.DEVICE_CHARGING)) {
      paramBuilder.setRequiresCharging(true);
    }
    if (paramSet.contains(Flag.DEVICE_IDLE)) {
      paramBuilder.setRequiresDeviceIdle(true);
    }
  }
  
  public JobInfo.Builder configureJob(JobInfo.Builder paramBuilder, Priority paramPriority, long paramLong, int paramInt)
  {
    paramBuilder.setMinimumLatency(getScheduleDelay(paramPriority, paramLong, paramInt));
    populateFlags(paramBuilder, ((ConfigValue)getValues().get(paramPriority)).getFlags());
    return paramBuilder;
  }
  
  abstract Clock getClock();
  
  public Set<Flag> getFlags(Priority paramPriority)
  {
    return ((ConfigValue)getValues().get(paramPriority)).getFlags();
  }
  
  public long getScheduleDelay(Priority paramPriority, long paramLong, int paramInt)
  {
    long l = getClock().getTime();
    paramPriority = (ConfigValue)getValues().get(paramPriority);
    return Math.min(Math.max(adjustedExponentialBackoff(paramInt, paramPriority.getDelta()), paramLong - l), paramPriority.getMaxAllowedDelay());
  }
  
  abstract Map<Priority, ConfigValue> getValues();
  
  public static class Builder
  {
    private Clock clock;
    private Map<Priority, SchedulerConfig.ConfigValue> values = new HashMap();
    
    public Builder addConfig(Priority paramPriority, SchedulerConfig.ConfigValue paramConfigValue)
    {
      this.values.put(paramPriority, paramConfigValue);
      return this;
    }
    
    public SchedulerConfig build()
    {
      if (this.clock != null)
      {
        if (this.values.keySet().size() >= Priority.values().length)
        {
          Map localMap = this.values;
          this.values = new HashMap();
          return SchedulerConfig.create(this.clock, localMap);
        }
        throw new IllegalStateException("Not all priorities have been configured");
      }
      throw new NullPointerException("missing required property: clock");
    }
    
    public Builder setClock(Clock paramClock)
    {
      this.clock = paramClock;
      return this;
    }
  }
  
  public static abstract class ConfigValue
  {
    public static Builder builder()
    {
      return new AutoValue_SchedulerConfig_ConfigValue.Builder().setFlags(Collections.emptySet());
    }
    
    abstract long getDelta();
    
    abstract Set<SchedulerConfig.Flag> getFlags();
    
    abstract long getMaxAllowedDelay();
    
    public static abstract class Builder
    {
      public abstract SchedulerConfig.ConfigValue build();
      
      public abstract Builder setDelta(long paramLong);
      
      public abstract Builder setFlags(Set<SchedulerConfig.Flag> paramSet);
      
      public abstract Builder setMaxAllowedDelay(long paramLong);
    }
  }
  
  public static enum Flag
  {
    static
    {
      DEVICE_IDLE = new Flag("DEVICE_IDLE", 1);
      Flag localFlag = new Flag("DEVICE_CHARGING", 2);
      DEVICE_CHARGING = localFlag;
      $VALUES = new Flag[] { NETWORK_UNMETERED, DEVICE_IDLE, localFlag };
    }
    
    private Flag() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\SchedulerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */