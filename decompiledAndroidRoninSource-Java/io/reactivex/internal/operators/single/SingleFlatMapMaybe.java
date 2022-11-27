package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapMaybe<T, R>
  extends Maybe<R>
{
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  final SingleSource<? extends T> source;
  
  public SingleFlatMapMaybe(SingleSource<? extends T> paramSingleSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
  {
    this.mapper = paramFunction;
    this.source = paramSingleSource;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapMaybeObserver<R>
    implements MaybeObserver<R>
  {
    final MaybeObserver<? super R> downstream;
    final AtomicReference<Disposable> parent;
    
    FlatMapMaybeObserver(AtomicReference<Disposable> paramAtomicReference, MaybeObserver<? super R> paramMaybeObserver)
    {
      this.parent = paramAtomicReference;
      this.downstream = paramMaybeObserver;
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
      DisposableHelper.replace(this.parent, paramDisposable);
    }
    
    public void onSuccess(R paramR)
    {
      this.downstream.onSuccess(paramR);
    }
  }
  
  static final class FlatMapSingleObserver<T, R>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -5843758257109742742L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    
    FlatMapSingleObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction)
    {
      this.downstream = paramMaybeObserver;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMapMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */