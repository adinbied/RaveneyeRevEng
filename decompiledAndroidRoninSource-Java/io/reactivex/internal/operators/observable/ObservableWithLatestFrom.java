package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final BiFunction<? super T, ? super U, ? extends R> combiner;
  final ObservableSource<? extends U> other;
  
  public ObservableWithLatestFrom(ObservableSource<T> paramObservableSource, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, ObservableSource<? extends U> paramObservableSource1)
  {
    super(paramObservableSource);
    this.combiner = paramBiFunction;
    this.other = paramObservableSource1;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WithLatestFromObserver<T, U, R>
    extends AtomicReference<U>
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -312246233408980075L;
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Observer<? super R> downstream;
    final AtomicReference<Disposable> other = new AtomicReference();
    final AtomicReference<Disposable> upstream = new AtomicReference();
    
    WithLatestFromObserver(Observer<? super R> paramObserver, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
    {
      this.downstream = paramObserver;
      this.combiner = paramBiFunction;
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    public void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean setOther(Disposable paramDisposable)
    {
      return DisposableHelper.setOnce(this.other, paramDisposable);
    }
  }
  
  final class WithLatestFromOtherObserver
    implements Observer<U>
  {
    private final ObservableWithLatestFrom.WithLatestFromObserver<T, U, R> parent;
    
    WithLatestFromOtherObserver()
    {
      ObservableWithLatestFrom.WithLatestFromObserver localWithLatestFromObserver;
      this.parent = localWithLatestFromObserver;
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.otherError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      this.parent.lazySet(paramU);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.parent.setOther(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWithLatestFrom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */