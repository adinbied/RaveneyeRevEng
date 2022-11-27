package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;

public final class MaybeIsEmpty<T>
  extends AbstractMaybeWithUpstream<T, Boolean>
{
  public MaybeIsEmpty(MaybeSource<T> paramMaybeSource)
  {
    super(paramMaybeSource);
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class IsEmptyMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super Boolean> downstream;
    Disposable upstream;
    
    IsEmptyMaybeObserver(MaybeObserver<? super Boolean> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeIsEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */