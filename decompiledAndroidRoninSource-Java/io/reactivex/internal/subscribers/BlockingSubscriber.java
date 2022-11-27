package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T>
  extends AtomicReference<Subscription>
  implements FlowableSubscriber<T>, Subscription
{
  public static final Object TERMINATED = new Object();
  private static final long serialVersionUID = -4875965440900746268L;
  final Queue<Object> queue;
  
  public BlockingSubscriber(Queue<Object> paramQueue)
  {
    this.queue = paramQueue;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isCancelled()
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
  
  /* Error */
  public void request(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\BlockingSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */