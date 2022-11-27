package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final SingleSource<? extends T> other;
  
  public ObservableConcatWithSingle(Observable<T> paramObservable, SingleSource<? extends T> paramSingleSource)
  {
    super(paramObservable);
    this.other = paramSingleSource;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatWithObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -1953724749712440952L;
    final Observer<? super T> downstream;
    boolean inSingle;
    SingleSource<? extends T> other;
    
    ConcatWithObserver(Observer<? super T> paramObserver, SingleSource<? extends T> paramSingleSource)
    {
      this.downstream = paramObserver;
      this.other = paramSingleSource;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if ((DisposableHelper.setOnce(this, paramDisposable)) && (!this.inSingle)) {
        this.downstream.onSubscribe(this);
      }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableConcatWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */