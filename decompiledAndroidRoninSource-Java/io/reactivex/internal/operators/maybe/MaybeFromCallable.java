package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T>
  extends Maybe<T>
  implements Callable<T>
{
  final Callable<? extends T> callable;
  
  public MaybeFromCallable(Callable<? extends T> paramCallable)
  {
    this.callable = paramCallable;
  }
  
  public T call()
    throws Exception
  {
    return (T)this.callable.call();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */