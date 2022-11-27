package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import java.util.concurrent.Callable;

public final class MaybeDefer<T>
  extends Maybe<T>
{
  final Callable<? extends MaybeSource<? extends T>> maybeSupplier;
  
  public MaybeDefer(Callable<? extends MaybeSource<? extends T>> paramCallable)
  {
    this.maybeSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */