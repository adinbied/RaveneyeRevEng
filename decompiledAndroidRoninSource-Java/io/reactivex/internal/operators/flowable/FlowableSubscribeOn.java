package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final boolean nonScheduledRequests;
  final Scheduler scheduler;
  
  public FlowableSubscribeOn(Flowable<T> paramFlowable, Scheduler paramScheduler, boolean paramBoolean)
  {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.nonScheduledRequests = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SubscribeOnSubscriber<T>
    extends AtomicReference<Thread>
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = 8094547886072529208L;
    final Subscriber<? super T> downstream;
    final boolean nonScheduledRequests;
    final AtomicLong requested;
    Publisher<T> source;
    final AtomicReference<Subscription> upstream;
    final Scheduler.Worker worker;
    
    SubscribeOnSubscriber(Subscriber<? super T> paramSubscriber, Scheduler.Worker paramWorker, Publisher<T> paramPublisher, boolean paramBoolean)
    {
      this.downstream = paramSubscriber;
      this.worker = paramWorker;
      this.source = paramPublisher;
      this.upstream = new AtomicReference();
      this.requested = new AtomicLong();
      this.nonScheduledRequests = (paramBoolean ^ true);
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void requestUpstream(long arg1, Subscription arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
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
    
    static final class Request
      implements Runnable
    {
      final long n;
      final Subscription upstream;
      
      Request(Subscription paramSubscription, long paramLong)
      {
        this.upstream = paramSubscription;
        this.n = paramLong;
      }
      
      public void run()
      {
        this.upstream.request(this.n);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */