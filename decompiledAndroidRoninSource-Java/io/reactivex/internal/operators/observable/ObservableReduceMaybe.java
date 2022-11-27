package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public final class ObservableReduceMaybe<T>
  extends Maybe<T>
{
  final BiFunction<T, T, T> reducer;
  final ObservableSource<T> source;
  
  public ObservableReduceMaybe(ObservableSource<T> paramObservableSource, BiFunction<T, T, T> paramBiFunction)
  {
    this.source = paramObservableSource;
    this.reducer = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ReduceObserver<T>
    implements Observer<T>, Disposable
  {
    boolean done;
    final MaybeObserver<? super T> downstream;
    final BiFunction<T, T, T> reducer;
    Disposable upstream;
    T value;
    
    ReduceObserver(MaybeObserver<? super T> paramMaybeObserver, BiFunction<T, T, T> paramBiFunction)
    {
      this.downstream = paramMaybeObserver;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableReduceMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */