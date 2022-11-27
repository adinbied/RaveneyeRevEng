package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T>
  extends Single<T>
  implements SingleObserver<T>
{
  static final CacheDisposable[] EMPTY = new CacheDisposable[0];
  static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
  Throwable error;
  final AtomicReference<CacheDisposable<T>[]> observers;
  final SingleSource<? extends T> source;
  T value;
  final AtomicInteger wip;
  
  public SingleCache(SingleSource<? extends T> paramSingleSource)
  {
    this.source = paramSingleSource;
    this.wip = new AtomicInteger();
    this.observers = new AtomicReference(EMPTY);
  }
  
  boolean add(CacheDisposable<T> paramCacheDisposable)
  {
    return false;
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
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CacheDisposable<T>
    extends AtomicBoolean
    implements Disposable
  {
    private static final long serialVersionUID = 7514387411091976596L;
    final SingleObserver<? super T> downstream;
    final SingleCache<T> parent;
    
    CacheDisposable(SingleObserver<? super T> paramSingleObserver, SingleCache<T> paramSingleCache)
    {
      this.downstream = paramSingleObserver;
      this.parent = paramSingleCache;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */