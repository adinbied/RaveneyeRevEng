package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorArray
  extends Completable
{
  final CompletableSource[] sources;
  
  public CompletableMergeDelayErrorArray(CompletableSource[] paramArrayOfCompletableSource)
  {
    this.sources = paramArrayOfCompletableSource;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MergeInnerCompletableObserver
    implements CompletableObserver
  {
    final CompletableObserver downstream;
    final AtomicThrowable error;
    final CompositeDisposable set;
    final AtomicInteger wip;
    
    MergeInnerCompletableObserver(CompletableObserver paramCompletableObserver, CompositeDisposable paramCompositeDisposable, AtomicThrowable paramAtomicThrowable, AtomicInteger paramAtomicInteger)
    {
      this.downstream = paramCompletableObserver;
      this.set = paramCompositeDisposable;
      this.error = paramAtomicThrowable;
      this.wip = paramAtomicInteger;
    }
    
    public void onComplete()
    {
      tryTerminate();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.set.add(paramDisposable);
    }
    
    /* Error */
    void tryTerminate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMergeDelayErrorArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */