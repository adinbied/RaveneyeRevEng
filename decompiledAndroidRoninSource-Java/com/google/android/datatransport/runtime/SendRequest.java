package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;

abstract class SendRequest
{
  public static Builder builder()
  {
    return new AutoValue_SendRequest.Builder();
  }
  
  public abstract Encoding getEncoding();
  
  abstract Event<?> getEvent();
  
  public byte[] getPayload()
  {
    return (byte[])getTransformer().apply(getEvent().getPayload());
  }
  
  abstract Transformer<?, byte[]> getTransformer();
  
  public abstract TransportContext getTransportContext();
  
  public abstract String getTransportName();
  
  public static abstract class Builder
  {
    public abstract SendRequest build();
    
    abstract Builder setEncoding(Encoding paramEncoding);
    
    abstract Builder setEvent(Event<?> paramEvent);
    
    public <T> Builder setEvent(Event<T> paramEvent, Encoding paramEncoding, Transformer<T, byte[]> paramTransformer)
    {
      setEvent(paramEvent);
      setEncoding(paramEncoding);
      setTransformer(paramTransformer);
      return this;
    }
    
    abstract Builder setTransformer(Transformer<?, byte[]> paramTransformer);
    
    public abstract Builder setTransportContext(TransportContext paramTransportContext);
    
    public abstract Builder setTransportName(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\SendRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */