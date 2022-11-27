package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

public final class Uploader_Factory
  implements Factory<Uploader>
{
  private final Provider<BackendRegistry> backendRegistryProvider;
  private final Provider<Clock> clockProvider;
  private final Provider<Context> contextProvider;
  private final Provider<EventStore> eventStoreProvider;
  private final Provider<Executor> executorProvider;
  private final Provider<SynchronizationGuard> guardProvider;
  private final Provider<WorkScheduler> workSchedulerProvider;
  
  public Uploader_Factory(Provider<Context> paramProvider, Provider<BackendRegistry> paramProvider1, Provider<EventStore> paramProvider2, Provider<WorkScheduler> paramProvider3, Provider<Executor> paramProvider4, Provider<SynchronizationGuard> paramProvider5, Provider<Clock> paramProvider6)
  {
    this.contextProvider = paramProvider;
    this.backendRegistryProvider = paramProvider1;
    this.eventStoreProvider = paramProvider2;
    this.workSchedulerProvider = paramProvider3;
    this.executorProvider = paramProvider4;
    this.guardProvider = paramProvider5;
    this.clockProvider = paramProvider6;
  }
  
  public static Uploader_Factory create(Provider<Context> paramProvider, Provider<BackendRegistry> paramProvider1, Provider<EventStore> paramProvider2, Provider<WorkScheduler> paramProvider3, Provider<Executor> paramProvider4, Provider<SynchronizationGuard> paramProvider5, Provider<Clock> paramProvider6)
  {
    return new Uploader_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6);
  }
  
  public static Uploader newInstance(Context paramContext, BackendRegistry paramBackendRegistry, EventStore paramEventStore, WorkScheduler paramWorkScheduler, Executor paramExecutor, SynchronizationGuard paramSynchronizationGuard, Clock paramClock)
  {
    return new Uploader(paramContext, paramBackendRegistry, paramEventStore, paramWorkScheduler, paramExecutor, paramSynchronizationGuard, paramClock);
  }
  
  public Uploader get()
  {
    return new Uploader((Context)this.contextProvider.get(), (BackendRegistry)this.backendRegistryProvider.get(), (EventStore)this.eventStoreProvider.get(), (WorkScheduler)this.workSchedulerProvider.get(), (Executor)this.executorProvider.get(), (SynchronizationGuard)this.guardProvider.get(), (Clock)this.clockProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\Uploader_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */