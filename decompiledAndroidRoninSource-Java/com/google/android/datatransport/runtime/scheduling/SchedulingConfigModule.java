package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SchedulingConfigModule
{
  @Provides
  static SchedulerConfig config(Clock paramClock)
  {
    return SchedulerConfig.getDefault(paramClock);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\SchedulingConfigModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */