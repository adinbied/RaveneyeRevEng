package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer
  extends Single<Long>
{
  final long delay;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public SingleTimer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimerDisposable
    extends AtomicReference<Disposable>
    implements Disposable, Runnable
  {
    private static final long serialVersionUID = 8465401857522493082L;
    final SingleObserver<? super Long> downstream;
    
    TimerDisposable(SingleObserver<? super Long> paramSingleObserver)
    {
      this.downstream = paramSingleObserver;
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
    
    void setFuture(Disposable paramDisposable)
    {
      DisposableHelper.replace(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */