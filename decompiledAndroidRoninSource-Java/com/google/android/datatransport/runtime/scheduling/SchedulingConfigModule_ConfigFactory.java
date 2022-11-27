package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SchedulingConfigModule_ConfigFactory
  implements Factory<SchedulerConfig>
{
  private final Provider<Clock> clockProvider;
  
  public SchedulingConfigModule_ConfigFactory(Provider<Clock> paramProvider)
  {
    this.clockProvider = paramProvider;
  }
  
  public static SchedulerConfig config(Clock paramClock)
  {
    return (SchedulerConfig)Preconditions.checkNotNull(SchedulingConfigModule.config(paramClock), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public static SchedulingConfigModule_ConfigFactory create(Provider<Clock> paramProvider)
  {
    return new SchedulingConfigModule_ConfigFactory(paramProvider);
  }
  
  public SchedulerConfig get()
  {
    return config((Clock)this.clockProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\SchedulingConfigModule_ConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */