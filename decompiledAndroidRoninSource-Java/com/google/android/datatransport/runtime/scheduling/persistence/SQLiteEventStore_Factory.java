package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SQLiteEventStore_Factory
  implements Factory<SQLiteEventStore>
{
  private final Provider<Clock> clockProvider;
  private final Provider<EventStoreConfig> configProvider;
  private final Provider<SchemaManager> schemaManagerProvider;
  private final Provider<Clock> wallClockProvider;
  
  public SQLiteEventStore_Factory(Provider<Clock> paramProvider1, Provider<Clock> paramProvider2, Provider<EventStoreConfig> paramProvider, Provider<SchemaManager> paramProvider3)
  {
    this.wallClockProvider = paramProvider1;
    this.clockProvider = paramProvider2;
    this.configProvider = paramProvider;
    this.schemaManagerProvider = paramProvider3;
  }
  
  public static SQLiteEventStore_Factory create(Provider<Clock> paramProvider1, Provider<Clock> paramProvider2, Provider<EventStoreConfig> paramProvider, Provider<SchemaManager> paramProvider3)
  {
    return new SQLiteEventStore_Factory(paramProvider1, paramProvider2, paramProvider, paramProvider3);
  }
  
  public static SQLiteEventStore newInstance(Clock paramClock1, Clock paramClock2, Object paramObject1, Object paramObject2)
  {
    return new SQLiteEventStore(paramClock1, paramClock2, (EventStoreConfig)paramObject1, (SchemaManager)paramObject2);
  }
  
  public SQLiteEventStore get()
  {
    return new SQLiteEventStore((Clock)this.wallClockProvider.get(), (Clock)this.clockProvider.get(), (EventStoreConfig)this.configProvider.get(), (SchemaManager)this.schemaManagerProvider.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\SQLiteEventStore_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */