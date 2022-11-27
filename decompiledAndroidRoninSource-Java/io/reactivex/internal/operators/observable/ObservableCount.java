package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableCount<T>
  extends AbstractObservableWithUpstream<T, Long>
{
  public ObservableCount(ObservableSource<T> paramObservableSource)
  {
    super(paramObservableSource);
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CountObserver
    implements Observer<Object>, Disposable
  {
    long count;
    final Observer<? super Long> downstream;
    Disposable upstream;
    
    CountObserver(Observer<? super Long> paramObserver)
    {
      this.downstream = paramObserver;
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.count += 1L;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */