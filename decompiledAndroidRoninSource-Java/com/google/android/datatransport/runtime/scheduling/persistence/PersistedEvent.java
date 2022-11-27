package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

public abstract class PersistedEvent
{
  public static PersistedEvent create(long paramLong, TransportContext paramTransportContext, EventInternal paramEventInternal)
  {
    return new AutoValue_PersistedEvent(paramLong, paramTransportContext, paramEventInternal);
  }
  
  public abstract EventInternal getEvent();
  
  public abstract long getId();
  
  public abstract TransportContext getTransportContext();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\PersistedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */