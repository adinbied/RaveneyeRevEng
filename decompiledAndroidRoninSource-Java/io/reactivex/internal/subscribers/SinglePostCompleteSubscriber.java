package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R>
  extends AtomicLong
  implements FlowableSubscriber<T>, Subscription
{
  static final long COMPLETE_MASK = Long.MIN_VALUE;
  static final long REQUEST_MASK = Long.MAX_VALUE;
  private static final long serialVersionUID = 7917814472626990048L;
  protected final Subscriber<? super R> downstream;
  protected long produced;
  protected Subscription upstream;
  protected R value;
  
  public SinglePostCompleteSubscriber(Subscriber<? super R> paramSubscriber)
  {
    this.downstream = paramSubscriber;
  }
  
  public void cancel()
  {
    this.upstream.cancel();
  }
  
  /* Error */
  protected final void complete(R arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onDrop(R paramR) {}
  
  /* Error */
  public void onSubscribe(Subscription arg1)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\SinglePostCompleteSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */