package io.reactivex.internal.fuseable;

import io.reactivex.SingleSource;

public abstract interface HasUpstreamSingleSource<T>
{
  public abstract SingleSource<T> source();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\HasUpstreamSingleSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */