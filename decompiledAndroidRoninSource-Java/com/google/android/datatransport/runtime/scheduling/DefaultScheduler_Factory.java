package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class DefaultScheduler_Factory
  implements Factory<DefaultScheduler>
{
  private final Provider<BackendRegistry> backendRegistryProvider;
  private final Provider<EventStore> eventStoreProvider;
  private final Provider<Executor> executorProvider;
  private final Provider<SynchronizationGuard> guardProvider;
  private final Provider<WorkScheduler> workSchedulerProvider;
  
  public DefaultScheduler_Factory(Provider<Executor> paramProvider, Provider<BackendRegistry> paramProvider1, Provider<WorkScheduler> paramProvider2, Provider<EventStore> paramProvider3, Provider<SynchronizationGuard> paramProvider4)
  {
    this.executorProvider = paramProvider;
    this.backendRegistryProvider = paramProvider1;
    this.workSchedulerProvider = paramProvider2;
    this.eventStoreProvider = paramProvider3;
    this.guardProvider = paramProvider4;
  }
  
  public static DefaultScheduler_Factory create(Provider<Executor> paramProvider, Provider<BackendRegistry> paramProvider1, Provider<WorkScheduler> paramProvider2, Provider<EventStore> paramProvider3, Provider<SynchronizationGuard> paramProvider4)
  {
    return new DefaultScheduler_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
  
  public static DefaultScheduler newInstance(Executor paramExecutor, BackendRegistry paramBackendRegistry, WorkScheduler paramWorkScheduler, EventStore paramEventStore, SynchronizationGuard paramSynchronizationGuard)
  {
    return new DefaultScheduler(paramExecutor, paramBackendRegistry, paramWorkScheduler, paramEventStore, paramSynchronizationGuard);
  }
  
  public DefaultScheduler get()
  {
    return new DefaultScheduler((Executor)this.executorProvider.get(), (BackendRegistry)this.backendRegistryProvider.get(), (WorkScheduler)this.workSchedulerProvider.get(), (EventStore)this.eventStoreProvider.get(), (SynchronizationGuard)this.guardProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\DefaultScheduler_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */