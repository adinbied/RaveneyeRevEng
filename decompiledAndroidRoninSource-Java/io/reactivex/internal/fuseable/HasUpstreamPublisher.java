package io.reactivex.internal.fuseable;

import org.reactivestreams.Publisher;

public abstract interface HasUpstreamPublisher<T>
{
  public abstract Publisher<T> source();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\HasUpstreamPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */