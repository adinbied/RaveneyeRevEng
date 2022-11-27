package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;

final class AutoValue_SchedulerConfig_ConfigValue
  extends SchedulerConfig.ConfigValue
{
  private final long delta;
  private final Set<SchedulerConfig.Flag> flags;
  private final long maxAllowedDelay;
  
  private AutoValue_SchedulerConfig_ConfigValue(long paramLong1, long paramLong2, Set<SchedulerConfig.Flag> paramSet)
  {
    this.delta = paramLong1;
    this.maxAllowedDelay = paramLong2;
    this.flags = paramSet;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SchedulerConfig.ConfigValue))
    {
      paramObject = (SchedulerConfig.ConfigValue)paramObject;
      return (this.delta == ((SchedulerConfig.ConfigValue)paramObject).getDelta()) && (this.maxAllowedDelay == ((SchedulerConfig.ConfigValue)paramObject).getMaxAllowedDelay()) && (this.flags.equals(((SchedulerConfig.ConfigValue)paramObject).getFlags()));
    }
    return false;
  }
  
  long getDelta()
  {
    return this.delta;
  }
  
  Set<SchedulerConfig.Flag> getFlags()
  {
    return this.flags;
  }
  
  long getMaxAllowedDelay()
  {
    return this.maxAllowedDelay;
  }
  
  public int hashCode()
  {
    long l = this.delta;
    int i = (int)(l ^ l >>> 32);
    l = this.maxAllowedDelay;
    int j = (int)(l >>> 32 ^ l);
    return this.flags.hashCode() ^ ((i ^ 0xF4243) * 1000003 ^ j) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConfigValue{delta=");
    localStringBuilder.append(this.delta);
    localStringBuilder.append(", maxAllowedDelay=");
    localStringBuilder.append(this.maxAllowedDelay);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.flags);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends SchedulerConfig.ConfigValue.Builder
  {
    private Long delta;
    private Set<SchedulerConfig.Flag> flags;
    private Long maxAllowedDelay;
    
    public SchedulerConfig.ConfigValue build()
    {
      Object localObject2 = this.delta;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" delta");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.maxAllowedDelay == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" maxAllowedDelay");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.flags == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" flags");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_SchedulerConfig_ConfigValue(this.delta.longValue(), this.maxAllowedDelay.longValue(), this.flags, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public SchedulerConfig.ConfigValue.Builder setDelta(long paramLong)
    {
      this.delta = Long.valueOf(paramLong);
      return this;
    }
    
    public SchedulerConfig.ConfigValue.Builder setFlags(Set<SchedulerConfig.Flag> paramSet)
    {
      if (paramSet != null)
      {
        this.flags = paramSet;
        return this;
      }
      throw new NullPointerException("Null flags");
    }
    
    public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long paramLong)
    {
      this.maxAllowedDelay = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\AutoValue_SchedulerConfig_ConfigValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */