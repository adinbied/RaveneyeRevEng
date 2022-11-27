package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T>
  extends Single<T>
{
  final boolean delayError;
  final Scheduler scheduler;
  final SingleSource<? extends T> source;
  final long time;
  final TimeUnit unit;
  
  public SingleDelay(SingleSource<? extends T> paramSingleSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    this.source = paramSingleSource;
    this.time = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class Delay
    implements SingleObserver<T>
  {
    final SingleObserver<? super T> downstream;
    private final SequentialDisposable sd;
    
    Delay(SingleObserver<? super T> paramSingleObserver)
    {
      this.sd = paramSingleObserver;
      SingleObserver localSingleObserver;
      this.downstream = localSingleObserver;
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
      this.sd.replace(paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class OnError
      implements Runnable
    {
      private final Throwable e;
      
      OnError(Throwable paramThrowable)
      {
        this.e = paramThrowable;
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
    
    final class OnSuccess
      implements Runnable
    {
      private final T value;
      
      OnSuccess()
      {
        Object localObject;
        this.value = localObject;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */