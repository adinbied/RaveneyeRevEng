package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final ObservableSource<? extends T> other;
  
  public ObservableSwitchIfEmpty(ObservableSource<T> paramObservableSource, ObservableSource<? extends T> paramObservableSource1)
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
  
  static final class SwitchIfEmptyObserver<T>
    implements Observer<T>
  {
    final SequentialDisposable arbiter;
    final Observer<? super T> downstream;
    boolean empty;
    final ObservableSource<? extends T> other;
    
    SwitchIfEmptyObserver(Observer<? super T> paramObserver, ObservableSource<? extends T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.other = paramObservableSource;
      this.empty = true;
      this.arbiter = new SequentialDisposable();
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.arbiter.update(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */