package com.google.android.datatransport.runtime.scheduling.persistence;

import dagger.internal.Factory;

public final class EventStoreModule_SchemaVersionFactory
  implements Factory<Integer>
{
  private static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();
  
  public static EventStoreModule_SchemaVersionFactory create()
  {
    return INSTANCE;
  }
  
  public static int schemaVersion()
  {
    return EventStoreModule.schemaVersion();
  }
  
  public Integer get()
  {
    return Integer.valueOf(schemaVersion());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStoreModule_SchemaVersionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */