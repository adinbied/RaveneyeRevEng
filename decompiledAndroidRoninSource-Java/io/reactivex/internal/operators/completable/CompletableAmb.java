package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb
  extends Completable
{
  private final CompletableSource[] sources;
  private final Iterable<? extends CompletableSource> sourcesIterable;
  
  public CompletableAmb(CompletableSource[] paramArrayOfCompletableSource, Iterable<? extends CompletableSource> paramIterable)
  {
    this.sources = paramArrayOfCompletableSource;
    this.sourcesIterable = paramIterable;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class Amb
    implements CompletableObserver
  {
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final CompositeDisposable set;
    Disposable upstream;
    
    Amb(AtomicBoolean paramAtomicBoolean, CompositeDisposable paramCompositeDisposable, CompletableObserver paramCompletableObserver)
    {
      this.once = paramAtomicBoolean;
      this.set = paramCompositeDisposable;
      this.downstream = paramCompletableObserver;
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
      this.upstream = paramDisposable;
      this.set.add(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */