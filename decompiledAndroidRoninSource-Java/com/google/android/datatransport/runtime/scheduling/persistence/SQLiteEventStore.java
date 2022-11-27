package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal.Builder;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SQLiteEventStore
  implements EventStore, SynchronizationGuard
{
  private static final int LOCK_RETRY_BACK_OFF_MILLIS = 50;
  private static final String LOG_TAG = "SQLiteEventStore";
  static final int MAX_RETRIES = 16;
  private static final Encoding PROTOBUF_ENCODING = Encoding.of("proto");
  private final EventStoreConfig config;
  private final Clock monotonicClock;
  private final SchemaManager schemaManager;
  private final Clock wallClock;
  
  @Inject
  SQLiteEventStore(Clock paramClock1, Clock paramClock2, EventStoreConfig paramEventStoreConfig, SchemaManager paramSchemaManager)
  {
    this.schemaManager = paramSchemaManager;
    this.wallClock = paramClock1;
    this.monotonicClock = paramClock2;
    this.config = paramEventStoreConfig;
  }
  
  private void ensureBeginTransaction(SQLiteDatabase paramSQLiteDatabase)
  {
    retryIfDbLocked(SQLiteEventStore..Lambda.18.lambdaFactory$(paramSQLiteDatabase), SQLiteEventStore..Lambda.19.lambdaFactory$());
  }
  
  private long ensureTransportContext(SQLiteDatabase paramSQLiteDatabase, TransportContext paramTransportContext)
  {
    Object localObject = getTransportContextId(paramSQLiteDatabase, paramTransportContext);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("backend_name", paramTransportContext.getBackendName());
    ((ContentValues)localObject).put("priority", Integer.valueOf(PriorityMapping.toInt(paramTransportContext.getPriority())));
    ((ContentValues)localObject).put("next_request_ms", Integer.valueOf(0));
    if (paramTransportContext.getExtras() != null) {
      ((ContentValues)localObject).put("extras", Base64.encodeToString(paramTransportContext.getExtras(), 0));
    }
    return paramSQLiteDatabase.insert("transport_contexts", null, (ContentValues)localObject);
  }
  
  private long getPageCount()
  {
    return getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
  }
  
  private long getPageSize()
  {
    return getDb().compileStatement("PRAGMA page_size").simpleQueryForLong();
  }
  
  private Long getTransportContextId(SQLiteDatabase paramSQLiteDatabase, TransportContext paramTransportContext)
  {
    StringBuilder localStringBuilder = new StringBuilder("backend_name = ? and priority = ?");
    Object localObject = new ArrayList(Arrays.asList(new String[] { paramTransportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(paramTransportContext.getPriority())) }));
    if (paramTransportContext.getExtras() != null)
    {
      localStringBuilder.append(" and extras = ?");
      ((ArrayList)localObject).add(Base64.encodeToString(paramTransportContext.getExtras(), 0));
    }
    paramTransportContext = localStringBuilder.toString();
    localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
    return (Long)tryWithCursor(paramSQLiteDatabase.query("transport_contexts", new String[] { "_id" }, paramTransportContext, (String[])localObject, null, null, null), SQLiteEventStore..Lambda.6.lambdaFactory$());
  }
  
  private <T> T inTransaction(Function<SQLiteDatabase, T> paramFunction)
  {
    SQLiteDatabase localSQLiteDatabase = getDb();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramFunction = paramFunction.apply(localSQLiteDatabase);
      localSQLiteDatabase.setTransactionSuccessful();
      return paramFunction;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private boolean isStorageAtLimit()
  {
    return getPageCount() * getPageSize() >= this.config.getMaxStorageSizeInBytes();
  }
  
  private List<PersistedEvent> join(List<PersistedEvent> paramList, Map<Long, Set<Metadata>> paramMap)
  {
    ListIterator localListIterator = paramList.listIterator();
    while (localListIterator.hasNext())
    {
      PersistedEvent localPersistedEvent = (PersistedEvent)localListIterator.next();
      if (paramMap.containsKey(Long.valueOf(localPersistedEvent.getId())))
      {
        EventInternal.Builder localBuilder = localPersistedEvent.getEvent().toBuilder();
        Iterator localIterator = ((Set)paramMap.get(Long.valueOf(localPersistedEvent.getId()))).iterator();
        while (localIterator.hasNext())
        {
          Metadata localMetadata = (Metadata)localIterator.next();
          localBuilder.addMetadata(localMetadata.key, localMetadata.value);
        }
        localListIterator.set(PersistedEvent.create(localPersistedEvent.getId(), localPersistedEvent.getTransportContext(), localBuilder.build()));
      }
    }
    return paramList;
  }
  
  private List<PersistedEvent> loadEvents(SQLiteDatabase paramSQLiteDatabase, TransportContext paramTransportContext)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getTransportContextId(paramSQLiteDatabase, paramTransportContext);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((Long)localObject).toString();
    int i = this.config.getLoadBatchSize();
    tryWithCursor(paramSQLiteDatabase.query("events", new String[] { "_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline" }, "context_id = ?", new String[] { localObject }, null, null, null, String.valueOf(i)), SQLiteEventStore..Lambda.15.lambdaFactory$(this, localArrayList, paramTransportContext));
    return localArrayList;
  }
  
  private Map<Long, Set<Metadata>> loadMetadata(SQLiteDatabase paramSQLiteDatabase, List<PersistedEvent> paramList)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder("event_id IN (");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((PersistedEvent)paramList.get(i)).getId());
      if (i < paramList.size() - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append(')');
    paramList = localStringBuilder.toString();
    tryWithCursor(paramSQLiteDatabase.query("event_metadata", new String[] { "event_id", "name", "value" }, paramList, null, null, null, null), SQLiteEventStore..Lambda.17.lambdaFactory$(localHashMap));
    return localHashMap;
  }
  
  private static byte[] maybeBase64Decode(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 0);
  }
  
  private byte[] readPayload(long paramLong)
  {
    return (byte[])tryWithCursor(getDb().query("event_payloads", new String[] { "bytes" }, "event_id = ?", new String[] { String.valueOf(paramLong) }, null, null, "sequence_num"), SQLiteEventStore..Lambda.16.lambdaFactory$());
  }
  
  private <T> T retryIfDbLocked(Producer<T> paramProducer, Function<Throwable, T> paramFunction)
  {
    long l = this.monotonicClock.getTime();
    for (;;)
    {
      try
      {
        Object localObject = paramProducer.produce();
        return (T)localObject;
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        if (this.monotonicClock.getTime() >= this.config.getCriticalSectionEnterTimeoutMs() + l) {
          return (T)paramFunction.apply(localSQLiteDatabaseLockedException);
        }
        SystemClock.sleep(50L);
      }
    }
  }
  
  private static Encoding toEncoding(String paramString)
  {
    if (paramString == null) {
      return PROTOBUF_ENCODING;
    }
    return Encoding.of(paramString);
  }
  
  private static String toIdList(Iterable<PersistedEvent> paramIterable)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localStringBuilder.append(((PersistedEvent)paramIterable.next()).getId());
      if (paramIterable.hasNext()) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private static <T> T tryWithCursor(Cursor paramCursor, Function<Cursor, T> paramFunction)
  {
    try
    {
      paramFunction = paramFunction.apply(paramCursor);
      return paramFunction;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public int cleanUp()
  {
    return ((Integer)inTransaction(SQLiteEventStore..Lambda.13.lambdaFactory$(this.wallClock.getTime() - this.config.getEventCleanUpAge()))).intValue();
  }
  
  public void clearDb()
  {
    inTransaction(SQLiteEventStore..Lambda.14.lambdaFactory$());
  }
  
  public void close()
  {
    this.schemaManager.close();
  }
  
  long getByteSize()
  {
    return getPageCount() * getPageSize();
  }
  
  SQLiteDatabase getDb()
  {
    SchemaManager localSchemaManager = this.schemaManager;
    localSchemaManager.getClass();
    return (SQLiteDatabase)retryIfDbLocked(SQLiteEventStore..Lambda.1.lambdaFactory$(localSchemaManager), SQLiteEventStore..Lambda.4.lambdaFactory$());
  }
  
  public long getNextCallTime(TransportContext paramTransportContext)
  {
    return ((Long)tryWithCursor(getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[] { paramTransportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(paramTransportContext.getPriority())) }), SQLiteEventStore..Lambda.8.lambdaFactory$())).longValue();
  }
  
  public boolean hasPendingEventsFor(TransportContext paramTransportContext)
  {
    return ((Boolean)inTransaction(SQLiteEventStore..Lambda.9.lambdaFactory$(this, paramTransportContext))).booleanValue();
  }
  
  public Iterable<TransportContext> loadActiveContexts()
  {
    return (Iterable)inTransaction(SQLiteEventStore..Lambda.12.lambdaFactory$());
  }
  
  public Iterable<PersistedEvent> loadBatch(TransportContext paramTransportContext)
  {
    return (Iterable)inTransaction(SQLiteEventStore..Lambda.11.lambdaFactory$(this, paramTransportContext));
  }
  
  public PersistedEvent persist(TransportContext paramTransportContext, EventInternal paramEventInternal)
  {
    Logging.d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", new Object[] { paramTransportContext.getPriority(), paramEventInternal.getTransportName(), paramTransportContext.getBackendName() });
    long l = ((Long)inTransaction(SQLiteEventStore..Lambda.5.lambdaFactory$(this, paramTransportContext, paramEventInternal))).longValue();
    if (l < 1L) {
      return null;
    }
    return PersistedEvent.create(l, paramTransportContext, paramEventInternal);
  }
  
  public void recordFailure(Iterable<PersistedEvent> paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
    localStringBuilder.append(toIdList(paramIterable));
    inTransaction(SQLiteEventStore..Lambda.7.lambdaFactory$(localStringBuilder.toString()));
  }
  
  public void recordNextCallTime(TransportContext paramTransportContext, long paramLong)
  {
    inTransaction(SQLiteEventStore..Lambda.10.lambdaFactory$(paramLong, paramTransportContext));
  }
  
  public void recordSuccess(Iterable<PersistedEvent> paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM events WHERE _id in ");
    localStringBuilder.append(toIdList(paramIterable));
    paramIterable = localStringBuilder.toString();
    getDb().compileStatement(paramIterable).execute();
  }
  
  public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> paramCriticalSection)
  {
    SQLiteDatabase localSQLiteDatabase = getDb();
    ensureBeginTransaction(localSQLiteDatabase);
    try
    {
      paramCriticalSection = paramCriticalSection.execute();
      localSQLiteDatabase.setTransactionSuccessful();
      return paramCriticalSection;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  static abstract interface Function<T, U>
  {
    public abstract U apply(T paramT);
  }
  
  private static class Metadata
  {
    final String key;
    final String value;
    
    private Metadata(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }
  }
  
  static abstract interface Producer<T>
  {
    public abstract T produce();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\SQLiteEventStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */