package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class WorkInitializer_Factory
  implements Factory<WorkInitializer>
{
  private final Provider<Executor> executorProvider;
  private final Provider<SynchronizationGuard> guardProvider;
  private final Provider<WorkScheduler> schedulerProvider;
  private final Provider<EventStore> storeProvider;
  
  public WorkInitializer_Factory(Provider<Executor> paramProvider, Provider<EventStore> paramProvider1, Provider<WorkScheduler> paramProvider2, Provider<SynchronizationGuard> paramProvider3)
  {
    this.executorProvider = paramProvider;
    this.storeProvider = paramProvider1;
    this.schedulerProvider = paramProvider2;
    this.guardProvider = paramProvider3;
  }
  
  public static WorkInitializer_Factory create(Provider<Executor> paramProvider, Provider<EventStore> paramProvider1, Provider<WorkScheduler> paramProvider2, Provider<SynchronizationGuard> paramProvider3)
  {
    return new WorkInitializer_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public static WorkInitializer newInstance(Executor paramExecutor, EventStore paramEventStore, WorkScheduler paramWorkScheduler, SynchronizationGuard paramSynchronizationGuard)
  {
    return new WorkInitializer(paramExecutor, paramEventStore, paramWorkScheduler, paramSynchronizationGuard);
  }
  
  public WorkInitializer get()
  {
    return new WorkInitializer((Executor)this.executorProvider.get(), (EventStore)this.storeProvider.get(), (WorkScheduler)this.schedulerProvider.get(), (SynchronizationGuard)this.guardProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\WorkInitializer_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */