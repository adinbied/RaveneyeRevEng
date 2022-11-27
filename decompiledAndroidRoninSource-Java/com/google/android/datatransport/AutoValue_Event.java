package com.google.android.datatransport;

final class AutoValue_Event<T>
  extends Event<T>
{
  private final Integer code;
  private final T payload;
  private final Priority priority;
  
  AutoValue_Event(Integer paramInteger, T paramT, Priority paramPriority)
  {
    this.code = paramInteger;
    if (paramT != null)
    {
      this.payload = paramT;
      if (paramPriority != null)
      {
        this.priority = paramPriority;
        return;
      }
      throw new NullPointerException("Null priority");
    }
    throw new NullPointerException("Null payload");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Event))
    {
      paramObject = (Event)paramObject;
      Integer localInteger = this.code;
      return (localInteger == null ? ((Event)paramObject).getCode() == null : localInteger.equals(((Event)paramObject).getCode())) && (this.payload.equals(((Event)paramObject).getPayload())) && (this.priority.equals(((Event)paramObject).getPriority()));
    }
    return false;
  }
  
  public Integer getCode()
  {
    return this.code;
  }
  
  public T getPayload()
  {
    return (T)this.payload;
  }
  
  public Priority getPriority()
  {
    return this.priority;
  }
  
  public int hashCode()
  {
    Integer localInteger = this.code;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.hashCode();
    }
    return ((i ^ 0xF4243) * 1000003 ^ this.payload.hashCode()) * 1000003 ^ this.priority.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", payload=");
    localStringBuilder.append(this.payload);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.priority);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\AutoValue_Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */