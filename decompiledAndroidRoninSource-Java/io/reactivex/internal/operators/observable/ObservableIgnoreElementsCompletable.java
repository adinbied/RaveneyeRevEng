package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableIgnoreElementsCompletable<T>
  extends Completable
  implements FuseToObservable<T>
{
  final ObservableSource<T> source;
  
  public ObservableIgnoreElementsCompletable(ObservableSource<T> paramObservableSource)
  {
    this.source = paramObservableSource;
  }
  
  public Observable<T> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class IgnoreObservable<T>
    implements Observer<T>, Disposable
  {
    final CompletableObserver downstream;
    Disposable upstream;
    
    IgnoreObservable(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
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
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.upstream = paramDisposable;
      this.downstream.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableIgnoreElementsCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */