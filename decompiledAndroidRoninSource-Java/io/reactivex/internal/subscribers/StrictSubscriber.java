package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T>
  extends AtomicInteger
  implements FlowableSubscriber<T>, Subscription
{
  private static final long serialVersionUID = -4945028590049415624L;
  volatile boolean done;
  final Subscriber<? super T> downstream;
  final AtomicThrowable error;
  final AtomicBoolean once;
  final AtomicLong requested;
  final AtomicReference<Subscription> upstream;
  
  public StrictSubscriber(Subscriber<? super T> paramSubscriber)
  {
    this.downstream = paramSubscriber;
    this.error = new AtomicThrowable();
    this.requested = new AtomicLong();
    this.upstream = new AtomicReference();
    this.once = new AtomicBoolean();
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
    HalfSerializer.onNext(this.downstream, paramT, this, this.error);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\StrictSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */