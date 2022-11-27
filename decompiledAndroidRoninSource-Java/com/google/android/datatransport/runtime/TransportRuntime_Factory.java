package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TransportRuntime_Factory
  implements Factory<TransportRuntime>
{
  private final Provider<Clock> eventClockProvider;
  private final Provider<WorkInitializer> initializerProvider;
  private final Provider<Scheduler> schedulerProvider;
  private final Provider<Uploader> uploaderProvider;
  private final Provider<Clock> uptimeClockProvider;
  
  public TransportRuntime_Factory(Provider<Clock> paramProvider1, Provider<Clock> paramProvider2, Provider<Scheduler> paramProvider, Provider<Uploader> paramProvider3, Provider<WorkInitializer> paramProvider4)
  {
    this.eventClockProvider = paramProvider1;
    this.uptimeClockProvider = paramProvider2;
    this.schedulerProvider = paramProvider;
    this.uploaderProvider = paramProvider3;
    this.initializerProvider = paramProvider4;
  }
  
  public static TransportRuntime_Factory create(Provider<Clock> paramProvider1, Provider<Clock> paramProvider2, Provider<Scheduler> paramProvider, Provider<Uploader> paramProvider3, Provider<WorkInitializer> paramProvider4)
  {
    return new TransportRuntime_Factory(paramProvider1, paramProvider2, paramProvider, paramProvider3, paramProvider4);
  }
  
  public static TransportRuntime newInstance(Clock paramClock1, Clock paramClock2, Scheduler paramScheduler, Uploader paramUploader, WorkInitializer paramWorkInitializer)
  {
    return new TransportRuntime(paramClock1, paramClock2, paramScheduler, paramUploader, paramWorkInitializer);
  }
  
  public TransportRuntime get()
  {
    return new TransportRuntime((Clock)this.eventClockProvider.get(), (Clock)this.uptimeClockProvider.get(), (Scheduler)this.schedulerProvider.get(), (Uploader)this.uploaderProvider.get(), (WorkInitializer)this.initializerProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\TransportRuntime_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */