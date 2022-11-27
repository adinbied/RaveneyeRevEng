package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MetadataBackendRegistry_Factory
  implements Factory<MetadataBackendRegistry>
{
  private final Provider<Context> applicationContextProvider;
  private final Provider<CreationContextFactory> creationContextFactoryProvider;
  
  public MetadataBackendRegistry_Factory(Provider<Context> paramProvider, Provider<CreationContextFactory> paramProvider1)
  {
    this.applicationContextProvider = paramProvider;
    this.creationContextFactoryProvider = paramProvider1;
  }
  
  public static MetadataBackendRegistry_Factory create(Provider<Context> paramProvider, Provider<CreationContextFactory> paramProvider1)
  {
    return new MetadataBackendRegistry_Factory(paramProvider, paramProvider1);
  }
  
  public static MetadataBackendRegistry newInstance(Context paramContext, Object paramObject)
  {
    return new MetadataBackendRegistry(paramContext, (CreationContextFactory)paramObject);
  }
  
  public MetadataBackendRegistry get()
  {
    return new MetadataBackendRegistry((Context)this.applicationContextProvider.get(), (CreationContextFactory)this.creationContextFactoryProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\MetadataBackendRegistry_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */