package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R>
  extends AbstractMaybeWithUpstream<T, R>
{
  final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
  final BiFunction<? super T, ? super U, ? extends R> resultSelector;
  
  public MaybeFlatMapBiSelector(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends MaybeSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
  {
    super(paramMaybeSource);
    this.mapper = paramFunction;
    this.resultSelector = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapBiMainObserver<T, U, R>
    implements MaybeObserver<T>, Disposable
  {
    final InnerObserver<T, U, R> inner;
    final Function<? super T, ? extends MaybeSource<? extends U>> mapper;
    
    FlatMapBiMainObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> paramFunction, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
    {
      this.inner = new InnerObserver(paramMaybeObserver, paramBiFunction);
      this.mapper = paramFunction;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.inner);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      this.inner.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.inner.downstream.onError(paramThrowable);
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
    
    static final class InnerObserver<T, U, R>
      extends AtomicReference<Disposable>
      implements MaybeObserver<U>
    {
      private static final long serialVersionUID = -2897979525538174559L;
      final MaybeObserver<? super R> downstream;
      final BiFunction<? super T, ? super U, ? extends R> resultSelector;
      T value;
      
      InnerObserver(MaybeObserver<? super R> paramMaybeObserver, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
      {
        this.downstream = paramMaybeObserver;
        this.resultSelector = paramBiFunction;
      }
      
      public void onComplete()
      {
        this.downstream.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      /* Error */
      public void onSuccess(U arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapBiSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */