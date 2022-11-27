package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;

public final class FlowableConcatMapPublisher<T, R>
  extends Flowable<R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final int prefetch;
  final Publisher<T> source;
  
  public FlowableConcatMapPublisher(Publisher<T> paramPublisher, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode)
  {
    this.source = paramPublisher;
    this.mapper = paramFunction;
    this.prefetch = paramInt;
    this.errorMode = paramErrorMode;
  }
  
  /* Error */
  protected void subscribeActual(org.reactivestreams.Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatMapPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */