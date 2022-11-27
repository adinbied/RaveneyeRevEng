package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class MaybeJust<T>
  extends Maybe<T>
  implements ScalarCallable<T>
{
  final T value;
  
  public MaybeJust(T paramT)
  {
    this.value = paramT;
  }
  
  public T call()
  {
    return (T)this.value;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */