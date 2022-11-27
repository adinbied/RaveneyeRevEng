package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten<T, R>
  extends AbstractMaybeWithUpstream<T, R>
{
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  
  public MaybeFlatten(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
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
  
  static final class FlatMapMaybeObserver<T, R>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    Disposable upstream;
    
    FlatMapMaybeObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
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
      return false;
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
    
    final class InnerObserver
      implements MaybeObserver<R>
    {
      InnerObserver() {}
      
      public void onComplete()
      {
        MaybeFlatten.FlatMapMaybeObserver.this.downstream.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        MaybeFlatten.FlatMapMaybeObserver.this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(MaybeFlatten.FlatMapMaybeObserver.this, paramDisposable);
      }
      
      public void onSuccess(R paramR)
      {
        MaybeFlatten.FlatMapMaybeObserver.this.downstream.onSuccess(paramR);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatten.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */