package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableDelaySubscriptionOther<T, U>
  extends Observable<T>
{
  final ObservableSource<? extends T> main;
  final ObservableSource<U> other;
  
  public ObservableDelaySubscriptionOther(ObservableSource<? extends T> paramObservableSource, ObservableSource<U> paramObservableSource1)
  {
    this.main = paramObservableSource;
    this.other = paramObservableSource1;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DelayObserver
    implements Observer<U>
  {
    final Observer<? super T> child;
    boolean done;
    final SequentialDisposable serial;
    
    DelayObserver(Observer<? super T> paramObserver)
    {
      this.serial = paramObserver;
      Observer localObserver;
      this.child = localObserver;
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
      onComplete();
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.serial.update(paramDisposable);
    }
    
    final class OnComplete
      implements Observer<T>
    {
      OnComplete() {}
      
      public void onComplete()
      {
        ObservableDelaySubscriptionOther.DelayObserver.this.child.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        ObservableDelaySubscriptionOther.DelayObserver.this.child.onError(paramThrowable);
      }
      
      public void onNext(T paramT)
      {
        ObservableDelaySubscriptionOther.DelayObserver.this.child.onNext(paramT);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        ObservableDelaySubscriptionOther.DelayObserver.this.serial.update(paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDelaySubscriptionOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */