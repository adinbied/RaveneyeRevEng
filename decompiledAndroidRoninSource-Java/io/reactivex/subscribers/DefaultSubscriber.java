package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T>
  implements FlowableSubscriber<T>
{
  Subscription upstream;
  
  /* Error */
  protected final void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void onSubscribe(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected final void request(long paramLong)
  {
    Subscription localSubscription = this.upstream;
    if (localSubscription != null) {
      localSubscription.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subscribers\DefaultSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */