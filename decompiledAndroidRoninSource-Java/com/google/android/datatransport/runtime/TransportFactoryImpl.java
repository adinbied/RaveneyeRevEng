package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

final class TransportFactoryImpl
  implements TransportFactory
{
  private final Set<Encoding> supportedPayloadEncodings;
  private final TransportContext transportContext;
  private final TransportInternal transportInternal;
  
  TransportFactoryImpl(Set<Encoding> paramSet, TransportContext paramTransportContext, TransportInternal paramTransportInternal)
  {
    this.supportedPayloadEncodings = paramSet;
    this.transportContext = paramTransportContext;
    this.transportInternal = paramTransportInternal;
  }
  
  public <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Encoding paramEncoding, Transformer<T, byte[]> paramTransformer)
  {
    if (this.supportedPayloadEncodings.contains(paramEncoding)) {
      return new TransportImpl(this.transportContext, paramString, paramEncoding, paramTransformer, this.transportInternal);
    }
    throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[] { paramEncoding, this.supportedPayloadEncodings }));
  }
  
  public <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Transformer<T, byte[]> paramTransformer)
  {
    return getTransport(paramString, paramClass, Encoding.of("proto"), paramTransformer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\TransportFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */