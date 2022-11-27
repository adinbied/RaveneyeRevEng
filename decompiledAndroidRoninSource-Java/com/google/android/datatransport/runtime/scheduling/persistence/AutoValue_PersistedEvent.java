package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

final class AutoValue_PersistedEvent
  extends PersistedEvent
{
  private final EventInternal event;
  private final long id;
  private final TransportContext transportContext;
  
  AutoValue_PersistedEvent(long paramLong, TransportContext paramTransportContext, EventInternal paramEventInternal)
  {
    this.id = paramLong;
    if (paramTransportContext != null)
    {
      this.transportContext = paramTransportContext;
      if (paramEventInternal != null)
      {
        this.event = paramEventInternal;
        return;
      }
      throw new NullPointerException("Null event");
    }
    throw new NullPointerException("Null transportContext");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PersistedEvent))
    {
      paramObject = (PersistedEvent)paramObject;
      return (this.id == ((PersistedEvent)paramObject).getId()) && (this.transportContext.equals(((PersistedEvent)paramObject).getTransportContext())) && (this.event.equals(((PersistedEvent)paramObject).getEvent()));
    }
    return false;
  }
  
  public EventInternal getEvent()
  {
    return this.event;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public TransportContext getTransportContext()
  {
    return this.transportContext;
  }
  
  public int hashCode()
  {
    long l = this.id;
    int i = (int)(l ^ l >>> 32);
    int j = this.transportContext.hashCode();
    return this.event.hashCode() ^ ((i ^ 0xF4243) * 1000003 ^ j) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedEvent{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", transportContext=");
    localStringBuilder.append(this.transportContext);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.event);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\AutoValue_PersistedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */