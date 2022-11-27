package io.reactivex.internal.fuseable;

import io.reactivex.ObservableSource;

public abstract interface HasUpstreamObservableSource<T>
{
  public abstract ObservableSource<T> source();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\HasUpstreamObservableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */