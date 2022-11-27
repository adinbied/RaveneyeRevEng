package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SchedulingModule
{
  @Provides
  static WorkScheduler workScheduler(Context paramContext, EventStore paramEventStore, SchedulerConfig paramSchedulerConfig, Clock paramClock)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new JobInfoScheduler(paramContext, paramEventStore, paramSchedulerConfig);
    }
    return new AlarmManagerScheduler(paramContext, paramEventStore, paramClock, paramSchedulerConfig);
  }
  
  @Binds
  abstract Scheduler scheduler(DefaultScheduler paramDefaultScheduler);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\SchedulingModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */