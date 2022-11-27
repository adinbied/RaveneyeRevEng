package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U>
  extends AbstractObservableWithUpstream<T, T>
{
  final ObservableSource<U> other;
  
  public ObservableSkipUntil(ObservableSource<T> paramObservableSource, ObservableSource<U> paramObservableSource1)
  {
    super(paramObservableSource);
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
  
  final class SkipUntil
    implements Observer<U>
  {
    final ArrayCompositeDisposable frc;
    final SerializedObserver<T> serial;
    final ObservableSkipUntil.SkipUntilObserver<T> sus;
    Disposable upstream;
    
    SkipUntil(ObservableSkipUntil.SkipUntilObserver<T> paramSkipUntilObserver, SerializedObserver<T> paramSerializedObserver)
    {
      this.frc = paramSkipUntilObserver;
      this.sus = paramSerializedObserver;
      SerializedObserver localSerializedObserver;
      this.serial = localSerializedObserver;
    }
    
    public void onComplete()
    {
      this.sus.notSkipping = true;
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
    public void onNext(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SkipUntilObserver<T>
    implements Observer<T>
  {
    final Observer<? super T> downstream;
    final ArrayCompositeDisposable frc;
    volatile boolean notSkipping;
    boolean notSkippingLocal;
    Disposable upstream;
    
    SkipUntilObserver(Observer<? super T> paramObserver, ArrayCompositeDisposable paramArrayCompositeDisposable)
    {
      this.downstream = paramObserver;
      this.frc = paramArrayCompositeDisposable;
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSkipUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */