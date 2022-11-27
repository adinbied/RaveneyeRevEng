package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

public class DefaultScheduler
  implements Scheduler
{
  private static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
  private final BackendRegistry backendRegistry;
  private final EventStore eventStore;
  private final Executor executor;
  private final SynchronizationGuard guard;
  private final WorkScheduler workScheduler;
  
  @Inject
  public DefaultScheduler(Executor paramExecutor, BackendRegistry paramBackendRegistry, WorkScheduler paramWorkScheduler, EventStore paramEventStore, SynchronizationGuard paramSynchronizationGuard)
  {
    this.executor = paramExecutor;
    this.backendRegistry = paramBackendRegistry;
    this.workScheduler = paramWorkScheduler;
    this.eventStore = paramEventStore;
    this.guard = paramSynchronizationGuard;
  }
  
  public void schedule(TransportContext paramTransportContext, EventInternal paramEventInternal, TransportScheduleCallback paramTransportScheduleCallback)
  {
    this.executor.execute(DefaultScheduler..Lambda.1.lambdaFactory$(this, paramTransportContext, paramTransportScheduleCallback, paramEventInternal));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\DefaultScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */