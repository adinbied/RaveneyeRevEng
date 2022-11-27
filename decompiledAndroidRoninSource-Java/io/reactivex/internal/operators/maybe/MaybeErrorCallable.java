package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import java.util.concurrent.Callable;

public final class MaybeErrorCallable<T>
  extends Maybe<T>
{
  final Callable<? extends Throwable> errorSupplier;
  
  public MaybeErrorCallable(Callable<? extends Throwable> paramCallable)
  {
    this.errorSupplier = paramCallable;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeErrorCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */