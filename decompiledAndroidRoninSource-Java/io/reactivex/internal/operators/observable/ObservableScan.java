package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public final class ObservableScan<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final BiFunction<T, T, T> accumulator;
  
  public ObservableScan(ObservableSource<T> paramObservableSource, BiFunction<T, T, T> paramBiFunction)
  {
    super(paramObservableSource);
    this.accumulator = paramBiFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ScanObserver<T>
    implements Observer<T>, Disposable
  {
    final BiFunction<T, T, T> accumulator;
    boolean done;
    final Observer<? super T> downstream;
    Disposable upstream;
    T value;
    
    ScanObserver(Observer<? super T> paramObserver, BiFunction<T, T, T> paramBiFunction)
    {
      this.downstream = paramObserver;
      this.accumulator = paramBiFunction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */