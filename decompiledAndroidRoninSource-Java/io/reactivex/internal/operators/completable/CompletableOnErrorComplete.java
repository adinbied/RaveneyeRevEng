package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public final class CompletableOnErrorComplete
  extends Completable
{
  final Predicate<? super Throwable> predicate;
  final CompletableSource source;
  
  public CompletableOnErrorComplete(CompletableSource paramCompletableSource, Predicate<? super Throwable> paramPredicate)
  {
    this.source = paramCompletableSource;
    this.predicate = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class OnError
    implements CompletableObserver
  {
    private final CompletableObserver downstream;
    
    OnError(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.downstream.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableOnErrorComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */