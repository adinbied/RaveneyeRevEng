package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistryModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule;
import com.google.android.datatransport.runtime.time.TimeModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Component.Builder;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Component(modules={BackendRegistryModule.class, EventStoreModule.class, ExecutionModule.class, SchedulingModule.class, SchedulingConfigModule.class, TimeModule.class})
@Singleton
abstract class TransportRuntimeComponent
  implements Closeable
{
  public void close()
    throws IOException
  {
    getEventStore().close();
  }
  
  abstract EventStore getEventStore();
  
  abstract TransportRuntime getTransportRuntime();
  
  @Component.Builder
  static abstract interface Builder
  {
    public abstract TransportRuntimeComponent build();
    
    @BindsInstance
    public abstract Builder setApplicationContext(Context paramContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\TransportRuntimeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */