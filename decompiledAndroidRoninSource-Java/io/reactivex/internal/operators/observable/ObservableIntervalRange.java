package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange
  extends Observable<Long>
{
  final long end;
  final long initialDelay;
  final long period;
  final Scheduler scheduler;
  final long start;
  final TimeUnit unit;
  
  public ObservableIntervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.initialDelay = paramLong3;
    this.period = paramLong4;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.start = paramLong1;
    this.end = paramLong2;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class IntervalRangeObserver
    extends AtomicReference<Disposable>
    implements Disposable, Runnable
  {
    private static final long serialVersionUID = 1891866368734007884L;
    long count;
    final Observer<? super Long> downstream;
    final long end;
    
    IntervalRangeObserver(Observer<? super Long> paramObserver, long paramLong1, long paramLong2)
    {
      this.downstream = paramObserver;
      this.count = paramLong1;
      this.end = paramLong2;
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
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setResource(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableIntervalRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */