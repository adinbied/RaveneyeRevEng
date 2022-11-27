package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray
  extends Completable
{
  final CompletableSource[] sources;
  
  public CompletableMergeArray(CompletableSource[] paramArrayOfCompletableSource)
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
  
  static final class InnerCompletableObserver
    extends AtomicInteger
    implements CompletableObserver
  {
    private static final long serialVersionUID = -8360547806504310570L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final CompositeDisposable set;
    
    InnerCompletableObserver(CompletableObserver paramCompletableObserver, AtomicBoolean paramAtomicBoolean, CompositeDisposable paramCompositeDisposable, int paramInt)
    {
      this.downstream = paramCompletableObserver;
      this.once = paramAtomicBoolean;
      this.set = paramCompositeDisposable;
      lazySet(paramInt);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMergeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */