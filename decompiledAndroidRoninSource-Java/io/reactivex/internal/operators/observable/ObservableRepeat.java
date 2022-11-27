package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final long count;
  
  public ObservableRepeat(Observable<T> paramObservable, long paramLong)
  {
    super(paramObservable);
    this.count = paramLong;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RepeatObserver<T>
    extends AtomicInteger
    implements Observer<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final Observer<? super T> downstream;
    long remaining;
    final SequentialDisposable sd;
    final ObservableSource<? extends T> source;
    
    RepeatObserver(Observer<? super T> paramObserver, long paramLong, SequentialDisposable paramSequentialDisposable, ObservableSource<? extends T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.sd = paramSequentialDisposable;
      this.source = paramObservableSource;
      this.remaining = paramLong;
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
      this.sd.replace(paramDisposable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRepeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */