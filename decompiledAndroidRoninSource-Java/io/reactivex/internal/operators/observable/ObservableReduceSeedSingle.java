package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public final class ObservableReduceSeedSingle<T, R>
  extends Single<R>
{
  final BiFunction<R, ? super T, R> reducer;
  final R seed;
  final ObservableSource<T> source;
  
  public ObservableReduceSeedSingle(ObservableSource<T> paramObservableSource, R paramR, BiFunction<R, ? super T, R> paramBiFunction)
  {
    this.source = paramObservableSource;
    this.seed = paramR;
    this.reducer = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ReduceSeedObserver<T, R>
    implements Observer<T>, Disposable
  {
    final SingleObserver<? super R> downstream;
    final BiFunction<R, ? super T, R> reducer;
    Disposable upstream;
    R value;
    
    ReduceSeedObserver(SingleObserver<? super R> paramSingleObserver, BiFunction<R, ? super T, R> paramBiFunction, R paramR)
    {
      this.downstream = paramSingleObserver;
      this.value = paramR;
      this.reducer = paramBiFunction;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableReduceSeedSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */