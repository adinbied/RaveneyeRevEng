package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R>
  extends Single<R>
{
  final BiFunction<R, ? super T, R> reducer;
  final Callable<R> seedSupplier;
  final ObservableSource<T> source;
  
  public ObservableReduceWithSingle(ObservableSource<T> paramObservableSource, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    this.source = paramObservableSource;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableReduceWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */