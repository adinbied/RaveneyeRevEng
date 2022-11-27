package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final int bufferSize;
  final boolean delayError;
  final Action onOverflow;
  final boolean unbounded;
  
  public FlowableOnBackpressureBuffer(Flowable<T> paramFlowable, int paramInt, boolean paramBoolean1, boolean paramBoolean2, Action paramAction)
  {
    super(paramFlowable);
    this.bufferSize = paramInt;
    this.unbounded = paramBoolean1;
    this.delayError = paramBoolean2;
    this.onOverflow = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BackpressureBufferSubscriber<T>
    extends BasicIntQueueSubscription<T>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -2514538129242366402L;
    volatile boolean cancelled;
    final boolean delayError;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final Action onOverflow;
    boolean outputFused;
    final SimplePlainQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    
    BackpressureBufferSubscriber(Subscriber<? super T> paramSubscriber, int paramInt, boolean paramBoolean1, boolean paramBoolean2, Action paramAction)
    {
      this.downstream = paramSubscriber;
      this.onOverflow = paramAction;
      this.delayError = paramBoolean2;
      if (paramBoolean1) {
        paramSubscriber = new SpscLinkedArrayQueue(paramInt);
      } else {
        paramSubscriber = new SpscArrayQueue(paramInt);
      }
      this.queue = paramSubscriber;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber)
    {
      return false;
    }
    
    public void clear()
    {
      this.queue.clear();
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
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
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
      throws Exception
    {
      return (T)this.queue.poll();
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */