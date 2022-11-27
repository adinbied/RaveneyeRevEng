package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R>
  extends Single<R>
{
  final Function<? super T, ? extends SingleSource<? extends R>> mapper;
  final SingleSource<? extends T> source;
  
  public SingleFlatMap(SingleSource<? extends T> paramSingleSource, Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
  {
    this.mapper = paramFunction;
    this.source = paramSingleSource;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SingleFlatMapCallback<T, R>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = 3258103020495908596L;
    final SingleObserver<? super R> downstream;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    
    SingleFlatMapCallback(SingleObserver<? super R> paramSingleObserver, Function<? super T, ? extends SingleSource<? extends R>> paramFunction)
    {
      this.downstream = paramSingleObserver;
      this.mapper = paramFunction;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    static final class FlatMapSingleObserver<R>
      implements SingleObserver<R>
    {
      final SingleObserver<? super R> downstream;
      final AtomicReference<Disposable> parent;
      
      FlatMapSingleObserver(AtomicReference<Disposable> paramAtomicReference, SingleObserver<? super R> paramSingleObserver)
      {
        this.parent = paramAtomicReference;
        this.downstream = paramSingleObserver;
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.replace(this.parent, paramDisposable);
      }
      
      public void onSuccess(R paramR)
      {
        this.downstream.onSuccess(paramR);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */