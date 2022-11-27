package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final boolean delayError;
  final int prefetch;
  final Scheduler scheduler;
  
  public FlowableObserveOn(Flowable<T> paramFlowable, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
    this.prefetch = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseObserveOnSubscriber<T>
    extends BasicIntQueueSubscription<T>
    implements FlowableSubscriber<T>, Runnable
  {
    private static final long serialVersionUID = -8241002408341274697L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    boolean outputFused;
    final int prefetch;
    long produced;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    int sourceMode;
    Subscription upstream;
    final Scheduler.Worker worker;
    
    BaseObserveOnSubscriber(Scheduler.Worker paramWorker, boolean paramBoolean, int paramInt)
    {
      this.worker = paramWorker;
      this.delayError = paramBoolean;
      this.prefetch = paramInt;
      this.requested = new AtomicLong();
      this.limit = (paramInt - (paramInt >> 2));
    }
    
    /* Error */
    public final void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber)
    {
      return false;
    }
    
    public final void clear()
    {
      this.queue.clear();
    }
    
    public final boolean isEmpty()
    {
      return this.queue.isEmpty();
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
    
    public final int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void runAsync();
    
    abstract void runBackfused();
    
    abstract void runSync();
    
    /* Error */
    final void trySchedule()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ObserveOnConditionalSubscriber<T>
    extends FlowableObserveOn.BaseObserveOnSubscriber<T>
  {
    private static final long serialVersionUID = 644624475404284533L;
    long consumed;
    final ConditionalSubscriber<? super T> downstream;
    
    ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, Scheduler.Worker paramWorker, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt);
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
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    /* Error */
    void runAsync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void runBackfused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void runSync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class ObserveOnSubscriber<T>
    extends FlowableObserveOn.BaseObserveOnSubscriber<T>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -4547113800637756442L;
    final Subscriber<? super T> downstream;
    
    ObserveOnSubscriber(Subscriber<? super T> paramSubscriber, Scheduler.Worker paramWorker, boolean paramBoolean, int paramInt)
    {
      super(paramBoolean, paramInt);
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
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    /* Error */
    void runAsync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void runBackfused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void runSync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */