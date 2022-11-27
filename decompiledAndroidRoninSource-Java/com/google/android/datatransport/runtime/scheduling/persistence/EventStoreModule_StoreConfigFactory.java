package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class EventStoreModule_StoreConfigFactory
  implements Factory<EventStoreConfig>
{
  private static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();
  
  public static EventStoreModule_StoreConfigFactory create()
  {
    return INSTANCE;
  }
  
  public static EventStoreConfig storeConfig()
  {
    return (EventStoreConfig)Preconditions.checkNotNull(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public EventStoreConfig get()
  {
    return storeConfig();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStoreModule_StoreConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */