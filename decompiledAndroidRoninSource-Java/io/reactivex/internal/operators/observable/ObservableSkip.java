package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableSkip<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final long n;
  
  public ObservableSkip(ObservableSource<T> paramObservableSource, long paramLong)
  {
    super(paramObservableSource);
    this.n = paramLong;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SkipObserver<T>
    implements Observer<T>, Disposable
  {
    final Observer<? super T> downstream;
    long remaining;
    Disposable upstream;
    
    SkipObserver(Observer<? super T> paramObserver, long paramLong)
    {
      this.downstream = paramObserver;
      this.remaining = paramLong;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */