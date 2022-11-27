package com.google.android.datatransport;

public abstract interface Transport<T>
{
  public abstract void schedule(Event<T> paramEvent, TransportScheduleCallback paramTransportScheduleCallback);
  
  public abstract void send(Event<T> paramEvent);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\Transport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */