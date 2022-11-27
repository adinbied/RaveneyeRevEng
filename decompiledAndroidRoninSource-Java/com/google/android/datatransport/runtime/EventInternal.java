package com.google.android.datatransport.runtime;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class EventInternal
{
  public static Builder builder()
  {
    return new AutoValue_EventInternal.Builder().setAutoMetadata(new HashMap());
  }
  
  public final String get(String paramString)
  {
    String str = (String)getAutoMetadata().get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  protected abstract Map<String, String> getAutoMetadata();
  
  public abstract Integer getCode();
  
  public abstract EncodedPayload getEncodedPayload();
  
  public abstract long getEventMillis();
  
  public final int getInteger(String paramString)
  {
    paramString = (String)getAutoMetadata().get(paramString);
    if (paramString == null) {
      return 0;
    }
    return Integer.valueOf(paramString).intValue();
  }
  
  public final long getLong(String paramString)
  {
    paramString = (String)getAutoMetadata().get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return Long.valueOf(paramString).longValue();
  }
  
  public final Map<String, String> getMetadata()
  {
    return Collections.unmodifiableMap(getAutoMetadata());
  }
  
  public final String getOrDefault(String paramString1, String paramString2)
  {
    paramString1 = (String)getAutoMetadata().get(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  @Deprecated
  public byte[] getPayload()
  {
    return getEncodedPayload().getBytes();
  }
  
  public abstract String getTransportName();
  
  public abstract long getUptimeMillis();
  
  public Builder toBuilder()
  {
    return new AutoValue_EventInternal.Builder().setTransportName(getTransportName()).setCode(getCode()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).setAutoMetadata(new HashMap(getAutoMetadata()));
  }
  
  public static abstract class Builder
  {
    public final Builder addMetadata(String paramString, int paramInt)
    {
      getAutoMetadata().put(paramString, String.valueOf(paramInt));
      return this;
    }
    
    public final Builder addMetadata(String paramString, long paramLong)
    {
      getAutoMetadata().put(paramString, String.valueOf(paramLong));
      return this;
    }
    
    public final Builder addMetadata(String paramString1, String paramString2)
    {
      getAutoMetadata().put(paramString1, paramString2);
      return this;
    }
    
    public abstract EventInternal build();
    
    protected abstract Map<String, String> getAutoMetadata();
    
    protected abstract Builder setAutoMetadata(Map<String, String> paramMap);
    
    public abstract Builder setCode(Integer paramInteger);
    
    public abstract Builder setEncodedPayload(EncodedPayload paramEncodedPayload);
    
    public abstract Builder setEventMillis(long paramLong);
    
    public abstract Builder setTransportName(String paramString);
    
    public abstract Builder setUptimeMillis(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\EventInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */