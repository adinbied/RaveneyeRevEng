package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class SingleNever
  extends Single<Object>
{
  public static final Single<Object> INSTANCE = new SingleNever();
  
  protected void subscribeActual(SingleObserver<? super Object> paramSingleObserver)
  {
    paramSingleObserver.onSubscribe(EmptyDisposable.NEVER);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */