package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter
  extends AtomicInteger
  implements Subscription
{
  private static final long serialVersionUID = -2189523197179400958L;
  Subscription actual;
  final boolean cancelOnReplace;
  volatile boolean cancelled;
  final AtomicLong missedProduced;
  final AtomicLong missedRequested;
  final AtomicReference<Subscription> missedSubscription;
  long requested;
  protected boolean unbounded;
  
  public SubscriptionArbiter(boolean paramBoolean)
  {
    this.cancelOnReplace = paramBoolean;
    this.missedSubscription = new AtomicReference();
    this.missedRequested = new AtomicLong();
    this.missedProduced = new AtomicLong();
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
  final void drain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  final void drainLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public final boolean isUnbounded()
  {
    return this.unbounded;
  }
  
  /* Error */
  public final void produced(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
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
  public final void setSubscription(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscriptions\SubscriptionArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */