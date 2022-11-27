package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeIsEmptySingle<T>
  extends Single<Boolean>
  implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean>
{
  final MaybeSource<T> source;
  
  public MaybeIsEmptySingle(MaybeSource<T> paramMaybeSource)
  {
    this.source = paramMaybeSource;
  }
  
  public Maybe<Boolean> fuseToMaybe()
  {
    return null;
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
  
  static final class IsEmptyMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final SingleObserver<? super Boolean> downstream;
    Disposable upstream;
    
    IsEmptyMaybeObserver(SingleObserver<? super Boolean> paramSingleObserver)
    {
      this.downstream = paramSingleObserver;
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
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeIsEmptySingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */