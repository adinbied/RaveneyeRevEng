package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import java.util.concurrent.Callable;

public final class SingleError<T>
  extends Single<T>
{
  final Callable<? extends Throwable> errorSupplier;
  
  public SingleError(Callable<? extends Throwable> paramCallable)
  {
    this.errorSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */