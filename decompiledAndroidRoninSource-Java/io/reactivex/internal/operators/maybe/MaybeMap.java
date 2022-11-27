package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class MaybeMap<T, R>
  extends AbstractMaybeWithUpstream<T, R>
{
  final Function<? super T, ? extends R> mapper;
  
  public MaybeMap(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends R> paramFunction)
  {
    super(paramMaybeSource);
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapMaybeObserver<T, R>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends R> mapper;
    Disposable upstream;
    
    MapMaybeObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, ? extends R> paramFunction)
    {
      this.downstream = paramMaybeObserver;
      this.mapper = paramFunction;
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
    
    public void onComplete()
    {
      this.downstream.onComplete();
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
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */