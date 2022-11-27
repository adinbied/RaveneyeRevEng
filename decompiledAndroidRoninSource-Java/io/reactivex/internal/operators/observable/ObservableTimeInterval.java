package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T>
  extends AbstractObservableWithUpstream<T, Timed<T>>
{
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public ObservableTimeInterval(ObservableSource<T> paramObservableSource, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    super(paramObservableSource);
    this.scheduler = paramScheduler;
    this.unit = paramTimeUnit;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Timed<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeIntervalObserver<T>
    implements Observer<T>, Disposable
  {
    final Observer<? super Timed<T>> downstream;
    long lastTime;
    final Scheduler scheduler;
    final TimeUnit unit;
    Disposable upstream;
    
    TimeIntervalObserver(Observer<? super Timed<T>> paramObserver, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.downstream = paramObserver;
      this.scheduler = paramScheduler;
      this.unit = paramTimeUnit;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */