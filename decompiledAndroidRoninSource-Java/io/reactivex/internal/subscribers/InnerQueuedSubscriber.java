package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T>
  extends AtomicReference<Subscription>
  implements FlowableSubscriber<T>, Subscription
{
  private static final long serialVersionUID = 22876611072430776L;
  volatile boolean done;
  int fusionMode;
  final int limit;
  final InnerQueuedSubscriberSupport<T> parent;
  final int prefetch;
  long produced;
  volatile SimpleQueue<T> queue;
  
  public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> paramInnerQueuedSubscriberSupport, int paramInt)
  {
    this.parent = paramInnerQueuedSubscriberSupport;
    this.prefetch = paramInt;
    this.limit = (paramInt - (paramInt >> 2));
  }
  
  public void cancel()
  {
    SubscriptionHelper.cancel(this);
  }
  
  public boolean isDone()
  {
    return this.done;
  }
  
  public void onComplete()
  {
    this.parent.innerComplete(this);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.innerError(this, paramThrowable);
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
  
  public SimpleQueue<T> queue()
  {
    return this.queue;
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
  public void requestOne()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDone()
  {
    this.done = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\InnerQueuedSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */