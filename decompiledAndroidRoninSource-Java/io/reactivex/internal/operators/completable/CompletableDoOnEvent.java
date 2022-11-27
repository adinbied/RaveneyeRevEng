package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class CompletableDoOnEvent
  extends Completable
{
  final Consumer<? super Throwable> onEvent;
  final CompletableSource source;
  
  public CompletableDoOnEvent(CompletableSource paramCompletableSource, Consumer<? super Throwable> paramConsumer)
  {
    this.source = paramCompletableSource;
    this.onEvent = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnEvent
    implements CompletableObserver
  {
    private final CompletableObserver observer;
    
    DoOnEvent(CompletableObserver paramCompletableObserver)
    {
      this.observer = paramCompletableObserver;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      this.observer.onSubscribe(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */