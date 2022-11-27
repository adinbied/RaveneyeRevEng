package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

public final class FlowableTakePublisher<T>
  extends Flowable<T>
{
  final long limit;
  final Publisher<T> source;
  
  public FlowableTakePublisher(Publisher<T> paramPublisher, long paramLong)
  {
    this.source = paramPublisher;
    this.limit = paramLong;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTakePublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */