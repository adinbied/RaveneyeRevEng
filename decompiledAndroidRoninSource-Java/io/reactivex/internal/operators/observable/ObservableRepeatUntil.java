package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final BooleanSupplier until;
  
  public ObservableRepeatUntil(Observable<T> paramObservable, BooleanSupplier paramBooleanSupplier)
  {
    super(paramObservable);
    this.until = paramBooleanSupplier;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RepeatUntilObserver<T>
    extends AtomicInteger
    implements Observer<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    final ObservableSource<? extends T> source;
    final BooleanSupplier stop;
    final SequentialDisposable upstream;
    
    RepeatUntilObserver(Observer<? super T> paramObserver, BooleanSupplier paramBooleanSupplier, SequentialDisposable paramSequentialDisposable, ObservableSource<? extends T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.upstream = paramSequentialDisposable;
      this.source = paramObservableSource;
      this.stop = paramBooleanSupplier;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      this.upstream.replace(paramDisposable);
    }
    
    /* Error */
    void subscribeNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRepeatUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */