package com.google.android.datatransport;

public abstract interface TransportFactory
{
  public abstract <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Encoding paramEncoding, Transformer<T, byte[]> paramTransformer);
  
  @Deprecated
  public abstract <T> Transport<T> getTransport(String paramString, Class<T> paramClass, Transformer<T, byte[]> paramTransformer);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\TransportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */