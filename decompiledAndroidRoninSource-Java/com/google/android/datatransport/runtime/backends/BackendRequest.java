package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;

public abstract class BackendRequest
{
  public static Builder builder()
  {
    return new AutoValue_BackendRequest.Builder();
  }
  
  public static BackendRequest create(Iterable<EventInternal> paramIterable)
  {
    return builder().setEvents(paramIterable).build();
  }
  
  public abstract Iterable<EventInternal> getEvents();
  
  public abstract byte[] getExtras();
  
  public static abstract class Builder
  {
    public abstract BackendRequest build();
    
    public abstract Builder setEvents(Iterable<EventInternal> paramIterable);
    
    public abstract Builder setExtras(byte[] paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\BackendRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */