package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay
  extends Completable
{
  final long delay;
  final boolean delayError;
  final Scheduler scheduler;
  final CompletableSource source;
  final TimeUnit unit;
  
  public CompletableDelay(CompletableSource paramCompletableSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    this.source = paramCompletableSource;
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class Delay
    extends AtomicReference<Disposable>
    implements CompletableObserver, Runnable, Disposable
  {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final CompletableObserver downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;
    
    Delay(CompletableObserver paramCompletableObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
    {
      this.downstream = paramCompletableObserver;
      this.delay = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
      this.delayError = paramBoolean;
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
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */