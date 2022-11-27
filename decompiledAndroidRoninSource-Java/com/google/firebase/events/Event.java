package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

public class Event<T>
{
  private final T payload;
  private final Class<T> type;
  
  public Event(Class<T> paramClass, T paramT)
  {
    this.type = ((Class)Preconditions.checkNotNull(paramClass));
    this.payload = Preconditions.checkNotNull(paramT);
  }
  
  public T getPayload()
  {
    return (T)this.payload;
  }
  
  public Class<T> getType()
  {
    return this.type;
  }
  
  public String toString()
  {
    return String.format("Event{type: %s, payload: %s}", new Object[] { this.type, this.payload });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\events\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */