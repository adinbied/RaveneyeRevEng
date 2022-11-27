package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class CompletableFromObservable<T>
  extends Completable
{
  final ObservableSource<T> observable;
  
  public CompletableFromObservable(ObservableSource<T> paramObservableSource)
  {
    this.observable = paramObservableSource;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableFromObservableObserver<T>
    implements Observer<T>
  {
    final CompletableObserver co;
    
    CompletableFromObservableObserver(CompletableObserver paramCompletableObserver)
    {
      this.co = paramCompletableObserver;
    }
    
    public void onComplete()
    {
      this.co.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.co.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.co.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */