package io.reactivex.internal.operators.single;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U>
  extends Single<T>
{
  final ObservableSource<U> other;
  final SingleSource<T> source;
  
  public SingleDelayWithObservable(SingleSource<T> paramSingleSource, ObservableSource<U> paramObservableSource)
  {
    this.source = paramSingleSource;
    this.other = paramObservableSource;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OtherSubscriber<T, U>
    extends AtomicReference<Disposable>
    implements Observer<U>, Disposable
  {
    private static final long serialVersionUID = -8565274649390031272L;
    boolean done;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;
    
    OtherSubscriber(SingleObserver<? super T> paramSingleObserver, SingleSource<T> paramSingleSource)
    {
      this.downstream = paramSingleObserver;
      this.source = paramSingleSource;
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
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(U paramU)
    {
      ((Disposable)get()).dispose();
      onComplete();
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.set(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDelayWithObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */