package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class MaybeNever
  extends Maybe<Object>
{
  public static final MaybeNever INSTANCE = new MaybeNever();
  
  protected void subscribeActual(MaybeObserver<? super Object> paramMaybeObserver)
  {
    paramMaybeObserver.onSubscribe(EmptyDisposable.NEVER);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */