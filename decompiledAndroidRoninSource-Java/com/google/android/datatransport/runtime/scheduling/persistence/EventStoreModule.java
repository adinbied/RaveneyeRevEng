package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public abstract class EventStoreModule
{
  @Provides
  @Named("SQLITE_DB_NAME")
  static String dbName()
  {
    return "com.google.android.datatransport.events";
  }
  
  @Provides
  @Named("SCHEMA_VERSION")
  static int schemaVersion()
  {
    return SchemaManager.SCHEMA_VERSION;
  }
  
  @Provides
  static EventStoreConfig storeConfig()
  {
    return EventStoreConfig.DEFAULT;
  }
  
  @Binds
  abstract EventStore eventStore(SQLiteEventStore paramSQLiteEventStore);
  
  @Binds
  abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore paramSQLiteEventStore);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStoreModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */