package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Scheduler scheduler;
  
  public MaybeObserveOn(MaybeSource<T> paramMaybeSource, Scheduler paramScheduler)
  {
    super(paramMaybeSource);
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
  
  static final class ObserveOnMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = 8571289934935992137L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    final Scheduler scheduler;
    T value;
    
    ObserveOnMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Scheduler paramScheduler)
    {
      this.downstream = paramMaybeObserver;
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
      this.error = paramThrowable;
      DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
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
      DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */