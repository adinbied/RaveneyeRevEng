package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SchedulingModule_WorkSchedulerFactory
  implements Factory<WorkScheduler>
{
  private final Provider<Clock> clockProvider;
  private final Provider<SchedulerConfig> configProvider;
  private final Provider<Context> contextProvider;
  private final Provider<EventStore> eventStoreProvider;
  
  public SchedulingModule_WorkSchedulerFactory(Provider<Context> paramProvider, Provider<EventStore> paramProvider1, Provider<SchedulerConfig> paramProvider2, Provider<Clock> paramProvider3)
  {
    this.contextProvider = paramProvider;
    this.eventStoreProvider = paramProvider1;
    this.configProvider = paramProvider2;
    this.clockProvider = paramProvider3;
  }
  
  public static SchedulingModule_WorkSchedulerFactory create(Provider<Context> paramProvider, Provider<EventStore> paramProvider1, Provider<SchedulerConfig> paramProvider2, Provider<Clock> paramProvider3)
  {
    return new SchedulingModule_WorkSchedulerFactory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public static WorkScheduler workScheduler(Context paramContext, EventStore paramEventStore, SchedulerConfig paramSchedulerConfig, Clock paramClock)
  {
    return (WorkScheduler)Preconditions.checkNotNull(SchedulingModule.workScheduler(paramContext, paramEventStore, paramSchedulerConfig, paramClock), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public WorkScheduler get()
  {
    return workScheduler((Context)this.contextProvider.get(), (EventStore)this.eventStoreProvider.get(), (SchedulerConfig)this.configProvider.get(), (Clock)this.clockProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\SchedulingModule_WorkSchedulerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */