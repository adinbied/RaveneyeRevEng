package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class FlowableReduceWithSingle<T, R>
  extends Single<R>
{
  final BiFunction<R, ? super T, R> reducer;
  final Callable<R> seedSupplier;
  final Publisher<T> source;
  
  public FlowableReduceWithSingle(Publisher<T> paramPublisher, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    this.source = paramPublisher;
    this.seedSupplier = paramCallable;
    this.reducer = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */