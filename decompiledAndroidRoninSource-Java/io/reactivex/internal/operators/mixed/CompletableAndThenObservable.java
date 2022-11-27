package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable<R>
  extends Observable<R>
{
  final ObservableSource<? extends R> other;
  final CompletableSource source;
  
  public CompletableAndThenObservable(CompletableSource paramCompletableSource, ObservableSource<? extends R> paramObservableSource)
  {
    this.source = paramCompletableSource;
    this.other = paramObservableSource;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AndThenObservableObserver<R>
    extends AtomicReference<Disposable>
    implements Observer<R>, CompletableObserver, Disposable
  {
    private static final long serialVersionUID = -8948264376121066672L;
    final Observer<? super R> downstream;
    ObservableSource<? extends R> other;
    
    AndThenObservableObserver(Observer<? super R> paramObserver, ObservableSource<? extends R> paramObservableSource)
    {
      this.other = paramObservableSource;
      this.downstream = paramObserver;
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
    
    public void onNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.replace(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\CompletableAndThenObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */