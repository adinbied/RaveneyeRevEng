package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;

final class AutoValue_BackendRequest
  extends BackendRequest
{
  private final Iterable<EventInternal> events;
  private final byte[] extras;
  
  private AutoValue_BackendRequest(Iterable<EventInternal> paramIterable, byte[] paramArrayOfByte)
  {
    this.events = paramIterable;
    this.extras = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BackendRequest))
    {
      paramObject = (BackendRequest)paramObject;
      if (this.events.equals(((BackendRequest)paramObject).getEvents()))
      {
        byte[] arrayOfByte = this.extras;
        if ((paramObject instanceof AutoValue_BackendRequest)) {
          paramObject = ((AutoValue_BackendRequest)paramObject).extras;
        } else {
          paramObject = ((BackendRequest)paramObject).getExtras();
        }
        if (Arrays.equals(arrayOfByte, (byte[])paramObject)) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public Iterable<EventInternal> getEvents()
  {
    return this.events;
  }
  
  public byte[] getExtras()
  {
    return this.extras;
  }
  
  public int hashCode()
  {
    return (this.events.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.extras);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendRequest{events=");
    localStringBuilder.append(this.events);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(Arrays.toString(this.extras));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends BackendRequest.Builder
  {
    private Iterable<EventInternal> events;
    private byte[] extras;
    
    public BackendRequest build()
    {
      Object localObject2 = this.events;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" events");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_BackendRequest(this.events, this.extras, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public BackendRequest.Builder setEvents(Iterable<EventInternal> paramIterable)
    {
      if (paramIterable != null)
      {
        this.events = paramIterable;
        return this;
      }
      throw new NullPointerException("Null events");
    }
    
    public BackendRequest.Builder setExtras(byte[] paramArrayOfByte)
    {
      this.extras = paramArrayOfByte;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\AutoValue_BackendRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */