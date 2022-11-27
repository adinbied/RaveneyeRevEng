package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class EventStoreModule_DbNameFactory
  implements Factory<String>
{
  private static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();
  
  public static EventStoreModule_DbNameFactory create()
  {
    return INSTANCE;
  }
  
  public static String dbName()
  {
    return (String)Preconditions.checkNotNull(EventStoreModule.dbName(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public String get()
  {
    return dbName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStoreModule_DbNameFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */