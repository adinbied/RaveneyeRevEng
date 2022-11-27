package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final int count;
  
  public ObservableTakeLast(ObservableSource<T> paramObservableSource, int paramInt)
  {
    super(paramObservableSource);
    this.count = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeLastObserver<T>
    extends ArrayDeque<T>
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 7240042530241604978L;
    volatile boolean cancelled;
    final int count;
    final Observer<? super T> downstream;
    Disposable upstream;
    
    TakeLastObserver(Observer<? super T> paramObserver, int paramInt)
    {
      this.downstream = paramObserver;
      this.count = paramInt;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTakeLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */