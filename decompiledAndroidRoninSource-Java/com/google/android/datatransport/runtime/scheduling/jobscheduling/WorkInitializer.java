package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class WorkInitializer
{
  private final Executor executor;
  private final SynchronizationGuard guard;
  private final WorkScheduler scheduler;
  private final EventStore store;
  
  @Inject
  WorkInitializer(Executor paramExecutor, EventStore paramEventStore, WorkScheduler paramWorkScheduler, SynchronizationGuard paramSynchronizationGuard)
  {
    this.executor = paramExecutor;
    this.store = paramEventStore;
    this.scheduler = paramWorkScheduler;
    this.guard = paramSynchronizationGuard;
  }
  
  public void ensureContextsScheduled()
  {
    this.executor.execute(WorkInitializer..Lambda.1.lambdaFactory$(this));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\WorkInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */