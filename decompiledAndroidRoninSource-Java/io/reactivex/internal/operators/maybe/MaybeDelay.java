package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final long delay;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public MaybeDelay(MaybeSource<T> paramMaybeSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    super(paramMaybeSource);
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DelayMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    final TimeUnit unit;
    T value;
    
    DelayMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.downstream = paramMaybeObserver;
      this.delay = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      schedule();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      schedule();
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.value = paramT;
      schedule();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void schedule()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */