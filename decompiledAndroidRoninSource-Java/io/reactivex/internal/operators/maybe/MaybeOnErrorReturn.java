package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class MaybeOnErrorReturn<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public MaybeOnErrorReturn(MaybeSource<T> paramMaybeSource, Function<? super Throwable, ? extends T> paramFunction)
  {
    super(paramMaybeSource);
    this.valueSupplier = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorReturnMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    Disposable upstream;
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Function<? super Throwable, ? extends T> paramFunction)
    {
      this.downstream = paramMaybeObserver;
      this.valueSupplier = paramFunction;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */