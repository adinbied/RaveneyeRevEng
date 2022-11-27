package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

public abstract interface EventStore
  extends Closeable
{
  public abstract int cleanUp();
  
  public abstract long getNextCallTime(TransportContext paramTransportContext);
  
  public abstract boolean hasPendingEventsFor(TransportContext paramTransportContext);
  
  public abstract Iterable<TransportContext> loadActiveContexts();
  
  public abstract Iterable<PersistedEvent> loadBatch(TransportContext paramTransportContext);
  
  public abstract PersistedEvent persist(TransportContext paramTransportContext, EventInternal paramEventInternal);
  
  public abstract void recordFailure(Iterable<PersistedEvent> paramIterable);
  
  public abstract void recordNextCallTime(TransportContext paramTransportContext, long paramLong);
  
  public abstract void recordSuccess(Iterable<PersistedEvent> paramIterable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\EventStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */