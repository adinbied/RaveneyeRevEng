package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.concurrent.Callable;

public final class SingleDefer<T>
  extends Single<T>
{
  final Callable<? extends SingleSource<? extends T>> singleSupplier;
  
  public SingleDefer(Callable<? extends SingleSource<? extends T>> paramCallable)
  {
    this.singleSupplier = paramCallable;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */