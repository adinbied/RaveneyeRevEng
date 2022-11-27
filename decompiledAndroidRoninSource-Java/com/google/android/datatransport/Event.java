package com.google.android.datatransport;

public abstract class Event<T>
{
  public static <T> Event<T> ofData(int paramInt, T paramT)
  {
    return new AutoValue_Event(Integer.valueOf(paramInt), paramT, Priority.DEFAULT);
  }
  
  public static <T> Event<T> ofData(T paramT)
  {
    return new AutoValue_Event(null, paramT, Priority.DEFAULT);
  }
  
  public static <T> Event<T> ofTelemetry(int paramInt, T paramT)
  {
    return new AutoValue_Event(Integer.valueOf(paramInt), paramT, Priority.VERY_LOW);
  }
  
  public static <T> Event<T> ofTelemetry(T paramT)
  {
    return new AutoValue_Event(null, paramT, Priority.VERY_LOW);
  }
  
  public static <T> Event<T> ofUrgent(int paramInt, T paramT)
  {
    return new AutoValue_Event(Integer.valueOf(paramInt), paramT, Priority.HIGHEST);
  }
  
  public static <T> Event<T> ofUrgent(T paramT)
  {
    return new AutoValue_Event(null, paramT, Priority.HIGHEST);
  }
  
  public abstract Integer getCode();
  
  public abstract T getPayload();
  
  public abstract Priority getPriority();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */