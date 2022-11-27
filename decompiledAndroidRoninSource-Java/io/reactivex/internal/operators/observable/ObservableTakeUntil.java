package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U>
  extends AbstractObservableWithUpstream<T, T>
{
  final ObservableSource<? extends U> other;
  
  public ObservableTakeUntil(ObservableSource<T> paramObservableSource, ObservableSource<? extends U> paramObservableSource1)
  {
    super(paramObservableSource);
    this.other = paramObservableSource1;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeUntilMainObserver<T, U>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 1418547743690811973L;
    final Observer<? super T> downstream;
    final AtomicThrowable error;
    final TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
    final AtomicReference<Disposable> upstream;
    
    TakeUntilMainObserver(Observer<? super T> paramObserver)
    {
      this.downstream = paramObserver;
      this.upstream = new AtomicReference();
      this.otherObserver = new OtherObserver();
      this.error = new AtomicThrowable();
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
      return false;
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
    
    public void onNext(T paramT)
    {
      HalfSerializer.onNext(this.downstream, paramT, this, this.error);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    void otherComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class OtherObserver
      extends AtomicReference<Disposable>
      implements Observer<U>
    {
      private static final long serialVersionUID = -8693423678067375039L;
      
      OtherObserver() {}
      
      public void onComplete()
      {
        ObservableTakeUntil.TakeUntilMainObserver.this.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        ObservableTakeUntil.TakeUntilMainObserver.this.otherError(paramThrowable);
      }
      
      public void onNext(U paramU)
      {
        DisposableHelper.dispose(this);
        ObservableTakeUntil.TakeUntilMainObserver.this.otherComplete();
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTakeUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */