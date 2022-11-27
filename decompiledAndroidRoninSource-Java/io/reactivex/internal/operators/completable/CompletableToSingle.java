package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T>
  extends Single<T>
{
  final T completionValue;
  final Callable<? extends T> completionValueSupplier;
  final CompletableSource source;
  
  public CompletableToSingle(CompletableSource paramCompletableSource, Callable<? extends T> paramCallable, T paramT)
  {
    this.source = paramCompletableSource;
    this.completionValue = paramT;
    this.completionValueSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class ToSingle
    implements CompletableObserver
  {
    private final SingleObserver<? super T> observer;
    
    ToSingle()
    {
      SingleObserver localSingleObserver;
      this.observer = localSingleObserver;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.observer.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.observer.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableToSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */