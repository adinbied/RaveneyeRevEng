package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

public final class SingleFromUnsafeSource<T>
  extends Single<T>
{
  final SingleSource<T> source;
  
  public SingleFromUnsafeSource(SingleSource<T> paramSingleSource)
  {
    this.source = paramSingleSource;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver)
  {
    this.source.subscribe(paramSingleObserver);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFromUnsafeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */