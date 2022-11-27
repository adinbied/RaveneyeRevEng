package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;

final class AutoValue_SendRequest
  extends SendRequest
{
  private final Encoding encoding;
  private final Event<?> event;
  private final Transformer<?, byte[]> transformer;
  private final TransportContext transportContext;
  private final String transportName;
  
  private AutoValue_SendRequest(TransportContext paramTransportContext, String paramString, Event<?> paramEvent, Transformer<?, byte[]> paramTransformer, Encoding paramEncoding)
  {
    this.transportContext = paramTransportContext;
    this.transportName = paramString;
    this.event = paramEvent;
    this.transformer = paramTransformer;
    this.encoding = paramEncoding;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SendRequest))
    {
      paramObject = (SendRequest)paramObject;
      return (this.transportContext.equals(((SendRequest)paramObject).getTransportContext())) && (this.transportName.equals(((SendRequest)paramObject).getTransportName())) && (this.event.equals(((SendRequest)paramObject).getEvent())) && (this.transformer.equals(((SendRequest)paramObject).getTransformer())) && (this.encoding.equals(((SendRequest)paramObject).getEncoding()));
    }
    return false;
  }
  
  public Encoding getEncoding()
  {
    return this.encoding;
  }
  
  Event<?> getEvent()
  {
    return this.event;
  }
  
  Transformer<?, byte[]> getTransformer()
  {
    return this.transformer;
  }
  
  public TransportContext getTransportContext()
  {
    return this.transportContext;
  }
  
  public String getTransportName()
  {
    return this.transportName;
  }
  
  public int hashCode()
  {
    return ((((this.transportContext.hashCode() ^ 0xF4243) * 1000003 ^ this.transportName.hashCode()) * 1000003 ^ this.event.hashCode()) * 1000003 ^ this.transformer.hashCode()) * 1000003 ^ this.encoding.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendRequest{transportContext=");
    localStringBuilder.append(this.transportContext);
    localStringBuilder.append(", transportName=");
    localStringBuilder.append(this.transportName);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.event);
    localStringBuilder.append(", transformer=");
    localStringBuilder.append(this.transformer);
    localStringBuilder.append(", encoding=");
    localStringBuilder.append(this.encoding);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends SendRequest.Builder
  {
    private Encoding encoding;
    private Event<?> event;
    private Transformer<?, byte[]> transformer;
    private TransportContext transportContext;
    private String transportName;
    
    public SendRequest build()
    {
      Object localObject2 = this.transportContext;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" transportContext");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.transportName == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" transportName");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.event == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" event");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.transformer == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" transformer");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.encoding == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" encoding");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_SendRequest(this.transportContext, this.transportName, this.event, this.transformer, this.encoding, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    SendRequest.Builder setEncoding(Encoding paramEncoding)
    {
      if (paramEncoding != null)
      {
        this.encoding = paramEncoding;
        return this;
      }
      throw new NullPointerException("Null encoding");
    }
    
    SendRequest.Builder setEvent(Event<?> paramEvent)
    {
      if (paramEvent != null)
      {
        this.event = paramEvent;
        return this;
      }
      throw new NullPointerException("Null event");
    }
    
    SendRequest.Builder setTransformer(Transformer<?, byte[]> paramTransformer)
    {
      if (paramTransformer != null)
      {
        this.transformer = paramTransformer;
        return this;
      }
      throw new NullPointerException("Null transformer");
    }
    
    public SendRequest.Builder setTransportContext(TransportContext paramTransportContext)
    {
      if (paramTransportContext != null)
      {
        this.transportContext = paramTransportContext;
        return this;
      }
      throw new NullPointerException("Null transportContext");
    }
    
    public SendRequest.Builder setTransportName(String paramString)
    {
      if (paramString != null)
      {
        this.transportName = paramString;
        return this;
      }
      throw new NullPointerException("Null transportName");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\AutoValue_SendRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */