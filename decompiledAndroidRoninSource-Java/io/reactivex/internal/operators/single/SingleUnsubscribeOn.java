package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T>
  extends Single<T>
{
  final Scheduler scheduler;
  final SingleSource<T> source;
  
  public SingleUnsubscribeOn(SingleSource<T> paramSingleSource, Scheduler paramScheduler)
  {
    this.source = paramSingleSource;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class UnsubscribeOnSingleObserver<T>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = 3256698449646456986L;
    final SingleObserver<? super T> downstream;
    Disposable ds;
    final Scheduler scheduler;
    
    UnsubscribeOnSingleObserver(SingleObserver<? super T> paramSingleObserver, Scheduler paramScheduler)
    {
      this.downstream = paramSingleObserver;
      this.scheduler = paramScheduler;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
    
    public void run()
    {
      this.ds.dispose();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleUnsubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */