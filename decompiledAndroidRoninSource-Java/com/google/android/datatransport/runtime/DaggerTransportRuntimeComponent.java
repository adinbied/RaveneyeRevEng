package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;
import javax.inject.Provider;

final class DaggerTransportRuntimeComponent
  extends TransportRuntimeComponent
{
  private Provider<SchedulerConfig> configProvider;
  private Provider creationContextFactoryProvider;
  private Provider<DefaultScheduler> defaultSchedulerProvider;
  private Provider<Executor> executorProvider;
  private Provider metadataBackendRegistryProvider;
  private Provider<SQLiteEventStore> sQLiteEventStoreProvider;
  private Provider schemaManagerProvider;
  private Provider<Context> setApplicationContextProvider;
  private Provider<TransportRuntime> transportRuntimeProvider;
  private Provider<Uploader> uploaderProvider;
  private Provider<WorkInitializer> workInitializerProvider;
  private Provider<WorkScheduler> workSchedulerProvider;
  
  private DaggerTransportRuntimeComponent(Context paramContext)
  {
    initialize(paramContext);
  }
  
  public static TransportRuntimeComponent.Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Context paramContext)
  {
    this.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
    paramContext = InstanceFactory.create(paramContext);
    this.setApplicationContextProvider = paramContext;
    paramContext = CreationContextFactory_Factory.create(paramContext, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
    this.creationContextFactoryProvider = paramContext;
    this.metadataBackendRegistryProvider = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, paramContext));
    this.schemaManagerProvider = SchemaManager_Factory.create(this.setApplicationContextProvider, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
    this.sQLiteEventStoreProvider = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.schemaManagerProvider));
    paramContext = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
    this.configProvider = paramContext;
    paramContext = SchedulingModule_WorkSchedulerFactory.create(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, paramContext, TimeModule_UptimeClockFactory.create());
    this.workSchedulerProvider = paramContext;
    Provider localProvider1 = this.executorProvider;
    Provider localProvider2 = this.metadataBackendRegistryProvider;
    Provider localProvider3 = this.sQLiteEventStoreProvider;
    this.defaultSchedulerProvider = DefaultScheduler_Factory.create(localProvider1, localProvider2, paramContext, localProvider3, localProvider3);
    paramContext = this.setApplicationContextProvider;
    localProvider1 = this.metadataBackendRegistryProvider;
    localProvider2 = this.sQLiteEventStoreProvider;
    this.uploaderProvider = Uploader_Factory.create(paramContext, localProvider1, localProvider2, this.workSchedulerProvider, this.executorProvider, localProvider2, TimeModule_EventClockFactory.create());
    paramContext = this.executorProvider;
    localProvider1 = this.sQLiteEventStoreProvider;
    this.workInitializerProvider = WorkInitializer_Factory.create(paramContext, localProvider1, this.workSchedulerProvider, localProvider1);
    this.transportRuntimeProvider = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.defaultSchedulerProvider, this.uploaderProvider, this.workInitializerProvider));
  }
  
  EventStore getEventStore()
  {
    return (EventStore)this.sQLiteEventStoreProvider.get();
  }
  
  TransportRuntime getTransportRuntime()
  {
    return (TransportRuntime)this.transportRuntimeProvider.get();
  }
  
  private static final class Builder
    implements TransportRuntimeComponent.Builder
  {
    private Context setApplicationContext;
    
    public TransportRuntimeComponent build()
    {
      Preconditions.checkBuilderRequirement(this.setApplicationContext, Context.class);
      return new DaggerTransportRuntimeComponent(this.setApplicationContext, null);
    }
    
    public Builder setApplicationContext(Context paramContext)
    {
      this.setApplicationContext = ((Context)Preconditions.checkNotNull(paramContext));
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\DaggerTransportRuntimeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */