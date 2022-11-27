package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final long delay;
  final boolean delayError;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public FlowableDelay(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    super(paramFlowable);
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DelaySubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final long delay;
    final boolean delayError;
    final Subscriber<? super T> downstream;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;
    
    DelaySubscriber(Subscriber<? super T> paramSubscriber, long paramLong, TimeUnit paramTimeUnit, Scheduler.Worker paramWorker, boolean paramBoolean)
    {
      this.downstream = paramSubscriber;
      this.delay = paramLong;
      this.unit = paramTimeUnit;
      this.w = paramWorker;
      this.delayError = paramBoolean;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    final class OnComplete
      implements Runnable
    {
      OnComplete() {}
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
    
    final class OnError
      implements Runnable
    {
      private final Throwable t;
      
      OnError(Throwable paramThrowable)
      {
        this.t = paramThrowable;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
    
    final class OnNext
      implements Runnable
    {
      private final T t;
      
      OnNext()
      {
        Object localObject;
        this.t = localObject;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */