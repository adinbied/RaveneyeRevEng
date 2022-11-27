package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T>
  extends Maybe<T>
  implements MaybeObserver<T>
{
  static final CacheDisposable[] EMPTY = new CacheDisposable[0];
  static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
  Throwable error;
  final AtomicReference<CacheDisposable<T>[]> observers;
  final AtomicReference<MaybeSource<T>> source;
  T value;
  
  public MaybeCache(MaybeSource<T> paramMaybeSource)
  {
    this.source = new AtomicReference(paramMaybeSource);
    this.observers = new AtomicReference(EMPTY);
  }
  
  boolean add(CacheDisposable<T> paramCacheDisposable)
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
  public void onSuccess(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(CacheDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CacheDisposable<T>
    extends AtomicReference<MaybeCache<T>>
    implements Disposable
  {
    private static final long serialVersionUID = -5791853038359966195L;
    final MaybeObserver<? super T> downstream;
    
    CacheDisposable(MaybeObserver<? super T> paramMaybeObserver, MaybeCache<T> paramMaybeCache)
    {
      super();
      this.downstream = paramMaybeObserver;
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
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */