package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T>
  extends CountDownLatch
  implements FlowableSubscriber<T>
{
  volatile boolean cancelled;
  Throwable error;
  Subscription upstream;
  T value;
  
  public BlockingBaseSubscriber()
  {
    super(1);
  }
  
  public final T blockingGet()
  {
    return null;
  }
  
  public final void onComplete()
  {
    countDown();
  }
  
  /* Error */
  public final void onSubscribe(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\BlockingBaseSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */