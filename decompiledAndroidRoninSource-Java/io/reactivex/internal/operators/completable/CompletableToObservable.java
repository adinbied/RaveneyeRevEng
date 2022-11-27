package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class CompletableToObservable<T>
  extends Observable<T>
{
  final CompletableSource source;
  
  public CompletableToObservable(CompletableSource paramCompletableSource)
  {
    this.source = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ObserverCompletableObserver
    extends BasicQueueDisposable<Void>
    implements CompletableObserver
  {
    final Observer<?> observer;
    Disposable upstream;
    
    ObserverCompletableObserver(Observer<?> paramObserver)
    {
      this.observer = paramObserver;
    }
    
    public void clear() {}
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public void onComplete()
    {
      this.observer.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.observer.onError(paramThrowable);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Void poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return paramInt & 0x2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */