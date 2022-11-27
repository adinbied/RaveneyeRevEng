package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R>
  implements FlowableSubscriber<T>, QueueSubscription<R>
{
  protected boolean done;
  protected final Subscriber<? super R> downstream;
  protected QueueSubscription<T> qs;
  protected int sourceMode;
  protected Subscription upstream;
  
  public BasicFuseableSubscriber(Subscriber<? super R> paramSubscriber)
  {
    this.downstream = paramSubscriber;
  }
  
  protected void afterDownstream() {}
  
  protected boolean beforeDownstream()
  {
    return true;
  }
  
  public void cancel()
  {
    this.upstream.cancel();
  }
  
  public void clear()
  {
    this.qs.clear();
  }
  
  /* Error */
  protected final void fail(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isEmpty()
  {
    return this.qs.isEmpty();
  }
  
  public final boolean offer(R paramR)
  {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(R paramR1, R paramR2)
  {
    throw new UnsupportedOperationException("Should not be called!");
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
  public final void onSubscribe(Subscription arg1)
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
  
  protected final int transitiveBoundaryFusion(int paramInt)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\BasicFuseableSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */