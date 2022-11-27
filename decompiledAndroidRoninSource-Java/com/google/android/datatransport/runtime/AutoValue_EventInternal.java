package com.google.android.datatransport.runtime;

import java.util.Map;

final class AutoValue_EventInternal
  extends EventInternal
{
  private final Map<String, String> autoMetadata;
  private final Integer code;
  private final EncodedPayload encodedPayload;
  private final long eventMillis;
  private final String transportName;
  private final long uptimeMillis;
  
  private AutoValue_EventInternal(String paramString, Integer paramInteger, EncodedPayload paramEncodedPayload, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    this.transportName = paramString;
    this.code = paramInteger;
    this.encodedPayload = paramEncodedPayload;
    this.eventMillis = paramLong1;
    this.uptimeMillis = paramLong2;
    this.autoMetadata = paramMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof EventInternal))
    {
      paramObject = (EventInternal)paramObject;
      if (this.transportName.equals(((EventInternal)paramObject).getTransportName()))
      {
        Integer localInteger = this.code;
        if ((localInteger == null ? ((EventInternal)paramObject).getCode() == null : localInteger.equals(((EventInternal)paramObject).getCode())) && (this.encodedPayload.equals(((EventInternal)paramObject).getEncodedPayload())) && (this.eventMillis == ((EventInternal)paramObject).getEventMillis()) && (this.uptimeMillis == ((EventInternal)paramObject).getUptimeMillis()) && (this.autoMetadata.equals(((EventInternal)paramObject).getAutoMetadata()))) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  protected Map<String, String> getAutoMetadata()
  {
    return this.autoMetadata;
  }
  
  public Integer getCode()
  {
    return this.code;
  }
  
  public EncodedPayload getEncodedPayload()
  {
    return this.encodedPayload;
  }
  
  public long getEventMillis()
  {
    return this.eventMillis;
  }
  
  public String getTransportName()
  {
    return this.transportName;
  }
  
  public long getUptimeMillis()
  {
    return this.uptimeMillis;
  }
  
  public int hashCode()
  {
    int j = this.transportName.hashCode();
    Integer localInteger = this.code;
    int i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.hashCode();
    }
    int k = this.encodedPayload.hashCode();
    long l = this.eventMillis;
    int m = (int)(l ^ l >>> 32);
    l = this.uptimeMillis;
    return (((((j ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ (int)(l ^ l >>> 32)) * 1000003 ^ this.autoMetadata.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventInternal{transportName=");
    localStringBuilder.append(this.transportName);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", encodedPayload=");
    localStringBuilder.append(this.encodedPayload);
    localStringBuilder.append(", eventMillis=");
    localStringBuilder.append(this.eventMillis);
    localStringBuilder.append(", uptimeMillis=");
    localStringBuilder.append(this.uptimeMillis);
    localStringBuilder.append(", autoMetadata=");
    localStringBuilder.append(this.autoMetadata);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends EventInternal.Builder
  {
    private Map<String, String> autoMetadata;
    private Integer code;
    private EncodedPayload encodedPayload;
    private Long eventMillis;
    private String transportName;
    private Long uptimeMillis;
    
    public EventInternal build()
    {
      Object localObject2 = this.transportName;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" transportName");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.encodedPayload == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" encodedPayload");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.eventMillis == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" eventMillis");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.uptimeMillis == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" uptimeMillis");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.autoMetadata == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" autoMetadata");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_EventInternal(this.transportName, this.code, this.encodedPayload, this.eventMillis.longValue(), this.uptimeMillis.longValue(), this.autoMetadata, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    protected Map<String, String> getAutoMetadata()
    {
      Map localMap = this.autoMetadata;
      if (localMap != null) {
        return localMap;
      }
      throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }
    
    protected EventInternal.Builder setAutoMetadata(Map<String, String> paramMap)
    {
      if (paramMap != null)
      {
        this.autoMetadata = paramMap;
        return this;
      }
      throw new NullPointerException("Null autoMetadata");
    }
    
    public EventInternal.Builder setCode(Integer paramInteger)
    {
      this.code = paramInteger;
      return this;
    }
    
    public EventInternal.Builder setEncodedPayload(EncodedPayload paramEncodedPayload)
    {
      if (paramEncodedPayload != null)
      {
        this.encodedPayload = paramEncodedPayload;
        return this;
      }
      throw new NullPointerException("Null encodedPayload");
    }
    
    public EventInternal.Builder setEventMillis(long paramLong)
    {
      this.eventMillis = Long.valueOf(paramLong);
      return this;
    }
    
    public EventInternal.Builder setTransportName(String paramString)
    {
      if (paramString != null)
      {
        this.transportName = paramString;
        return this;
      }
      throw new NullPointerException("Null transportName");
    }
    
    public EventInternal.Builder setUptimeMillis(long paramLong)
    {
      this.uptimeMillis = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\AutoValue_EventInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */