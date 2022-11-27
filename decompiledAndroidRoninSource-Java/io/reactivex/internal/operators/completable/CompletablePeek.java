package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class CompletablePeek
  extends Completable
{
  final Action onAfterTerminate;
  final Action onComplete;
  final Action onDispose;
  final Consumer<? super Throwable> onError;
  final Consumer<? super Disposable> onSubscribe;
  final Action onTerminate;
  final CompletableSource source;
  
  public CompletablePeek(CompletableSource paramCompletableSource, Consumer<? super Disposable> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4)
  {
    this.source = paramCompletableSource;
    this.onSubscribe = paramConsumer;
    this.onError = paramConsumer1;
    this.onComplete = paramAction1;
    this.onTerminate = paramAction2;
    this.onAfterTerminate = paramAction3;
    this.onDispose = paramAction4;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class CompletableObserverImplementation
    implements CompletableObserver, Disposable
  {
    final CompletableObserver downstream;
    Disposable upstream;
    
    CompletableObserverImplementation(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void doAfter()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletablePeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */