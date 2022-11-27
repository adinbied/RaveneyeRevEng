package io.reactivex.internal.fuseable;

import io.reactivex.Observable;

public abstract interface FuseToObservable<T>
{
  public abstract Observable<T> fuseToObservable();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\FuseToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */