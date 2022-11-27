package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache
  extends Completable
  implements CompletableObserver
{
  static final InnerCompletableCache[] EMPTY = new InnerCompletableCache[0];
  static final InnerCompletableCache[] TERMINATED = new InnerCompletableCache[0];
  Throwable error;
  final AtomicReference<InnerCompletableCache[]> observers;
  final AtomicBoolean once;
  final CompletableSource source;
  
  public CompletableCache(CompletableSource paramCompletableSource)
  {
    this.source = paramCompletableSource;
    this.observers = new AtomicReference(EMPTY);
    this.once = new AtomicBoolean();
  }
  
  boolean add(InnerCompletableCache paramInnerCompletableCache)
  {
    return false;
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
  
  public void onSubscribe(Disposable paramDisposable) {}
  
  /* Error */
  void remove(InnerCompletableCache arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class InnerCompletableCache
    extends AtomicBoolean
    implements Disposable
  {
    private static final long serialVersionUID = 8943152917179642732L;
    final CompletableObserver downstream;
    
    InnerCompletableCache(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return get();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */