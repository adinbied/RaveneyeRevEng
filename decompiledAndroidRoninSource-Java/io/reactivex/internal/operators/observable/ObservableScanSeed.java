package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final BiFunction<R, ? super T, R> accumulator;
  final Callable<R> seedSupplier;
  
  public ObservableScanSeed(ObservableSource<T> paramObservableSource, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    super(paramObservableSource);
    this.accumulator = paramBiFunction;
    this.seedSupplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ScanSeedObserver<T, R>
    implements Observer<T>, Disposable
  {
    final BiFunction<R, ? super T, R> accumulator;
    boolean done;
    final Observer<? super R> downstream;
    Disposable upstream;
    R value;
    
    ScanSeedObserver(Observer<? super R> paramObserver, BiFunction<R, ? super T, R> paramBiFunction, R paramR)
    {
      this.downstream = paramObserver;
      this.accumulator = paramBiFunction;
      this.value = paramR;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScanSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */