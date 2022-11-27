package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T>
  extends Single<T>
{
  final SingleSource<? extends T> other;
  final Scheduler scheduler;
  final SingleSource<T> source;
  final long timeout;
  final TimeUnit unit;
  
  public SingleTimeout(SingleSource<T> paramSingleSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, SingleSource<? extends T> paramSingleSource1)
  {
    this.source = paramSingleSource;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.other = paramSingleSource1;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeoutMainObserver<T>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Runnable, Disposable
  {
    private static final long serialVersionUID = 37497744973048446L;
    final SingleObserver<? super T> downstream;
    final TimeoutFallbackObserver<T> fallback;
    SingleSource<? extends T> other;
    final AtomicReference<Disposable> task;
    final long timeout;
    final TimeUnit unit;
    
    TimeoutMainObserver(SingleObserver<? super T> paramSingleObserver, SingleSource<? extends T> paramSingleSource, long paramLong, TimeUnit paramTimeUnit)
    {
      this.downstream = paramSingleObserver;
      this.other = paramSingleSource;
      this.timeout = paramLong;
      this.unit = paramTimeUnit;
      this.task = new AtomicReference();
      if (paramSingleSource != null)
      {
        this.fallback = new TimeoutFallbackObserver(paramSingleObserver);
        return;
      }
      this.fallback = null;
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
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
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
    
    static final class TimeoutFallbackObserver<T>
      extends AtomicReference<Disposable>
      implements SingleObserver<T>
    {
      private static final long serialVersionUID = 2071387740092105509L;
      final SingleObserver<? super T> downstream;
      
      TimeoutFallbackObserver(SingleObserver<? super T> paramSingleObserver)
      {
        this.downstream = paramSingleObserver;
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      public void onSuccess(T paramT)
      {
        this.downstream.onSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */