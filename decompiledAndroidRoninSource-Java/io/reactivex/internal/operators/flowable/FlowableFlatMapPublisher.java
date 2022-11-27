package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

public final class FlowableFlatMapPublisher<T, U>
  extends Flowable<U>
{
  final int bufferSize;
  final boolean delayErrors;
  final Function<? super T, ? extends Publisher<? extends U>> mapper;
  final int maxConcurrency;
  final Publisher<T> source;
  
  public FlowableFlatMapPublisher(Publisher<T> paramPublisher, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.source = paramPublisher;
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.bufferSize = paramInt2;
  }
  
  /* Error */
  protected void subscribeActual(org.reactivestreams.Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFlatMapPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */