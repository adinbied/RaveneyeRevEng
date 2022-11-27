package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeContains<T>
  extends Single<Boolean>
  implements HasUpstreamMaybeSource<T>
{
  final MaybeSource<T> source;
  final Object value;
  
  public MaybeContains(MaybeSource<T> paramMaybeSource, Object paramObject)
  {
    this.source = paramMaybeSource;
    this.value = paramObject;
  }
  
  public MaybeSource<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ContainsMaybeObserver
    implements MaybeObserver<Object>, Disposable
  {
    final SingleObserver<? super Boolean> downstream;
    Disposable upstream;
    final Object value;
    
    ContainsMaybeObserver(SingleObserver<? super Boolean> paramSingleObserver, Object paramObject)
    {
      this.downstream = paramSingleObserver;
      this.value = paramObject;
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
      return this.upstream.isDisposed();
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
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeContains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */