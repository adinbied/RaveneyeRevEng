package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final CompletableSource other;
  
  public ObservableConcatWithCompletable(Observable<T> paramObservable, CompletableSource paramCompletableSource)
  {
    super(paramObservable);
    this.other = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatWithObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, CompletableObserver, Disposable
  {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inCompletable;
    CompletableSource other;
    
    ConcatWithObserver(Observer<? super T> paramObserver, CompletableSource paramCompletableSource)
    {
      this.downstream = paramObserver;
      this.other = paramCompletableSource;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if ((DisposableHelper.setOnce(this, paramDisposable)) && (!this.inCompletable)) {
        this.downstream.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableConcatWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */