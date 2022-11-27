package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleTimed<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final boolean emitLast;
  final long period;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public ObservableSampleTimed(ObservableSource<T> paramObservableSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.period = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.emitLast = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SampleTimedEmitLast<T>
    extends ObservableSampleTimed.SampleTimedObserver<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip = new AtomicInteger(1);
    
    SampleTimedEmitLast(Observer<? super T> paramObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(paramLong, paramTimeUnit, paramScheduler);
    }
    
    /* Error */
    void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SampleTimedNoLast<T>
    extends ObservableSampleTimed.SampleTimedObserver<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    
    SampleTimedNoLast(Observer<? super T> paramObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(paramLong, paramTimeUnit, paramScheduler);
    }
    
    void complete()
    {
      this.downstream.onComplete();
    }
    
    public void run()
    {
      emit();
    }
  }
  
  static abstract class SampleTimedObserver<T>
    extends AtomicReference<T>
    implements Observer<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final long period;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final TimeUnit unit;
    Disposable upstream;
    
    SampleTimedObserver(Observer<? super T> paramObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.downstream = paramObserver;
      this.period = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    void cancelTimer()
    {
      DisposableHelper.dispose(this.timer);
    }
    
    abstract void complete();
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      cancelTimer();
      complete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(T paramT)
    {
      lazySet(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSampleTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */