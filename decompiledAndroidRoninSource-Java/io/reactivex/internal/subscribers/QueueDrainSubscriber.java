package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.QueueDrain;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V>
  extends QueueDrainSubscriberPad4
  implements FlowableSubscriber<T>, QueueDrain<U, V>
{
  protected volatile boolean cancelled;
  protected volatile boolean done;
  protected final Subscriber<? super V> downstream;
  protected Throwable error;
  protected final SimplePlainQueue<U> queue;
  
  public QueueDrainSubscriber(Subscriber<? super V> paramSubscriber, SimplePlainQueue<U> paramSimplePlainQueue)
  {
    this.downstream = paramSubscriber;
    this.queue = paramSimplePlainQueue;
  }
  
  public boolean accept(Subscriber<? super V> paramSubscriber, U paramU)
  {
    return false;
  }
  
  public final boolean cancelled()
  {
    return this.cancelled;
  }
  
  public final boolean done()
  {
    return this.done;
  }
  
  public final boolean enter()
  {
    return false;
  }
  
  public final Throwable error()
  {
    return this.error;
  }
  
  public final boolean fastEnter()
  {
    return false;
  }
  
  /* Error */
  protected final void fastPathEmitMax(U arg1, boolean arg2, io.reactivex.disposables.Disposable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void fastPathOrderedEmitMax(U arg1, boolean arg2, io.reactivex.disposables.Disposable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final int leave(int paramInt)
  {
    return this.wip.addAndGet(paramInt);
  }
  
  public final long produced(long paramLong)
  {
    return this.requested.addAndGet(-paramLong);
  }
  
  public final long requested()
  {
    return this.requested.get();
  }
  
  /* Error */
  public final void requested(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\QueueDrainSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */