package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import java.util.Arrays;

final class AutoValue_TransportContext
  extends TransportContext
{
  private final String backendName;
  private final byte[] extras;
  private final Priority priority;
  
  private AutoValue_TransportContext(String paramString, byte[] paramArrayOfByte, Priority paramPriority)
  {
    this.backendName = paramString;
    this.extras = paramArrayOfByte;
    this.priority = paramPriority;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof TransportContext))
    {
      TransportContext localTransportContext = (TransportContext)paramObject;
      if (this.backendName.equals(localTransportContext.getBackendName()))
      {
        byte[] arrayOfByte = this.extras;
        if ((localTransportContext instanceof AutoValue_TransportContext)) {
          paramObject = ((AutoValue_TransportContext)localTransportContext).extras;
        } else {
          paramObject = localTransportContext.getExtras();
        }
        if ((Arrays.equals(arrayOfByte, (byte[])paramObject)) && (this.priority.equals(localTransportContext.getPriority()))) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public String getBackendName()
  {
    return this.backendName;
  }
  
  public byte[] getExtras()
  {
    return this.extras;
  }
  
  public Priority getPriority()
  {
    return this.priority;
  }
  
  public int hashCode()
  {
    return ((this.backendName.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.extras)) * 1000003 ^ this.priority.hashCode();
  }
  
  static final class Builder
    extends TransportContext.Builder
  {
    private String backendName;
    private byte[] extras;
    private Priority priority;
    
    public TransportContext build()
    {
      Object localObject2 = this.backendName;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" backendName");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.priority == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" priority");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_TransportContext(this.backendName, this.extras, this.priority, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public TransportContext.Builder setBackendName(String paramString)
    {
      if (paramString != null)
      {
        this.backendName = paramString;
        return this;
      }
      throw new NullPointerException("Null backendName");
    }
    
    public TransportContext.Builder setExtras(byte[] paramArrayOfByte)
    {
      this.extras = paramArrayOfByte;
      return this;
    }
    
    public TransportContext.Builder setPriority(Priority paramPriority)
    {
      if (paramPriority != null)
      {
        this.priority = paramPriority;
        return this;
      }
      throw new NullPointerException("Null priority");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\AutoValue_TransportContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */