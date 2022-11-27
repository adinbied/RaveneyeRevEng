package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelRunOn<T>
  extends ParallelFlowable<T>
{
  final int prefetch;
  final Scheduler scheduler;
  final ParallelFlowable<? extends T> source;
  
  public ParallelRunOn(ParallelFlowable<? extends T> paramParallelFlowable, Scheduler paramScheduler, int paramInt)
  {
    this.source = paramParallelFlowable;
    this.scheduler = paramScheduler;
    this.prefetch = paramInt;
  }
  
  /* Error */
  void createSubscriber(int arg1, Subscriber<? super T>[] arg2, Subscriber<T>[] arg3, Scheduler.Worker arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  public void subscribe(Subscriber<? super T>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseRunOnSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    final Scheduler.Worker worker;
    
    BaseRunOnSubscriber(int paramInt, SpscArrayQueue<T> paramSpscArrayQueue, Scheduler.Worker paramWorker)
    {
      this.prefetch = paramInt;
      this.queue = paramSpscArrayQueue;
      this.limit = (paramInt - (paramInt >> 2));
      this.worker = paramWorker;
    }
    
    /* Error */
    public final void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    final void schedule()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  final class MultiWorkerCallback
    implements SchedulerMultiWorkerSupport.WorkerCallback
  {
    final Subscriber<T>[] parents;
    final Subscriber<? super T>[] subscribers;
    
    MultiWorkerCallback(Subscriber<T>[] paramArrayOfSubscriber)
    {
      this.subscribers = paramArrayOfSubscriber;
      Subscriber[] arrayOfSubscriber;
      this.parents = arrayOfSubscriber;
    }
    
    /* Error */
    public void onWorker(int arg1, Scheduler.Worker arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  }
  
  static final class RunOnConditionalSubscriber<T>
    extends ParallelRunOn.BaseRunOnSubscriber<T>
  {
    private static final long serialVersionUID = 1075119423897941642L;
    final ConditionalSubscriber<? super T> downstream;
    
    RunOnConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, int paramInt, SpscArrayQueue<T> paramSpscArrayQueue, Scheduler.Worker paramWorker)
    {
      super(paramSpscArrayQueue, paramWorker);
      this.downstream = paramConditionalSubscriber;
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
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
  
  static final class RunOnSubscriber<T>
    extends ParallelRunOn.BaseRunOnSubscriber<T>
  {
    private static final long serialVersionUID = 1075119423897941642L;
    final Subscriber<? super T> downstream;
    
    RunOnSubscriber(Subscriber<? super T> paramSubscriber, int paramInt, SpscArrayQueue<T> paramSpscArrayQueue, Scheduler.Worker paramWorker)
    {
      super(paramSpscArrayQueue, paramWorker);
      this.downstream = paramSubscriber;
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelRunOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */