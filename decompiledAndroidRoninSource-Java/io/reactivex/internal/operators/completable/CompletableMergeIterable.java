package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable
  extends Completable
{
  final Iterable<? extends CompletableSource> sources;
  
  public CompletableMergeIterable(Iterable<? extends CompletableSource> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class MergeCompletableObserver
    extends AtomicBoolean
    implements CompletableObserver
  {
    private static final long serialVersionUID = -7730517613164279224L;
    final CompletableObserver downstream;
    final CompositeDisposable set;
    final AtomicInteger wip;
    
    MergeCompletableObserver(CompletableObserver paramCompletableObserver, CompositeDisposable paramCompositeDisposable, AtomicInteger paramAtomicInteger)
    {
      this.downstream = paramCompletableObserver;
      this.set = paramCompositeDisposable;
      this.wip = paramAtomicInteger;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMergeIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */