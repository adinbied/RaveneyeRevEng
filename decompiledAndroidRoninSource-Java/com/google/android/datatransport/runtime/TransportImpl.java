package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

final class TransportImpl<T>
  implements Transport<T>
{
  private final String name;
  private final Encoding payloadEncoding;
  private final Transformer<T, byte[]> transformer;
  private final TransportContext transportContext;
  private final TransportInternal transportInternal;
  
  TransportImpl(TransportContext paramTransportContext, String paramString, Encoding paramEncoding, Transformer<T, byte[]> paramTransformer, TransportInternal paramTransportInternal)
  {
    this.transportContext = paramTransportContext;
    this.name = paramString;
    this.payloadEncoding = paramEncoding;
    this.transformer = paramTransformer;
    this.transportInternal = paramTransportInternal;
  }
  
  public void schedule(Event<T> paramEvent, TransportScheduleCallback paramTransportScheduleCallback)
  {
    this.transportInternal.send(SendRequest.builder().setTransportContext(this.transportContext).setEvent(paramEvent).setTransportName(this.name).setTransformer(this.transformer).setEncoding(this.payloadEncoding).build(), paramTransportScheduleCallback);
  }
  
  public void send(Event<T> paramEvent)
  {
    schedule(paramEvent, TransportImpl..Lambda.1.lambdaFactory$());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\TransportImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */