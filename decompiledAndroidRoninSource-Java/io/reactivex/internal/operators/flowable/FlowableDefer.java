package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class FlowableDefer<T>
  extends Flowable<T>
{
  final Callable<? extends Publisher<? extends T>> supplier;
  
  public FlowableDefer(Callable<? extends Publisher<? extends T>> paramCallable)
  {
    this.supplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(org.reactivestreams.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */