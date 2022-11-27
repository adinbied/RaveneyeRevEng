package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

public final class CompletableFromSingle<T>
  extends Completable
{
  final SingleSource<T> single;
  
  public CompletableFromSingle(SingleSource<T> paramSingleSource)
  {
    this.single = paramSingleSource;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableFromSingleObserver<T>
    implements SingleObserver<T>
  {
    final CompletableObserver co;
    
    CompletableFromSingleObserver(CompletableObserver paramCompletableObserver)
    {
      this.co = paramCompletableObserver;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.co.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.co.onSubscribe(paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.co.onComplete();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */