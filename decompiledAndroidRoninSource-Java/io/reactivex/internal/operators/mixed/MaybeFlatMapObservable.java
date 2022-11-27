package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapObservable<T, R>
  extends Observable<R>
{
  final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
  final MaybeSource<T> source;
  
  public MaybeFlatMapObservable(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapObserver<T, R>
    extends AtomicReference<Disposable>
    implements Observer<R>, MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = -8948264376121066672L;
    final Observer<? super R> downstream;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    
    FlatMapObserver(Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
    {
      this.downstream = paramObserver;
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
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.replace(this, paramDisposable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\MaybeFlatMapObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */