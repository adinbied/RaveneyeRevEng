package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class FlowableJust<T>
  extends Flowable<T>
  implements ScalarCallable<T>
{
  private final T value;
  
  public FlowableJust(T paramT)
  {
    this.value = paramT;
  }
  
  public T call()
  {
    return (T)this.value;
  }
  
  /* Error */
  protected void subscribeActual(org.reactivestreams.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */