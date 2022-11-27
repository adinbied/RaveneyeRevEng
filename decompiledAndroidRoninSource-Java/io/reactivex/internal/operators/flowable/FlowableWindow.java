package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindow<T>
  extends AbstractFlowableWithUpstream<T, Flowable<T>>
{
  final int bufferSize;
  final long size;
  final long skip;
  
  public FlowableWindow(Flowable<T> paramFlowable, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramFlowable);
    this.size = paramLong1;
    this.skip = paramLong2;
    this.bufferSize = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Flowable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WindowExactSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = -2365647875069161133L;
    final int bufferSize;
    final Subscriber<? super Flowable<T>> downstream;
    long index;
    final AtomicBoolean once;
    final long size;
    Subscription upstream;
    UnicastProcessor<T> window;
    
    WindowExactSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong, int paramInt)
    {
      super();
      this.downstream = paramSubscriber;
      this.size = paramLong;
      this.once = new AtomicBoolean();
      this.bufferSize = paramInt;
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
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class WindowOverlapSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = 2428527070996323976L;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super Flowable<T>> downstream;
    Throwable error;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    long produced;
    final SpscLinkedArrayQueue<UnicastProcessor<T>> queue;
    final AtomicLong requested;
    final long size;
    final long skip;
    Subscription upstream;
    final ArrayDeque<UnicastProcessor<T>> windows;
    final AtomicInteger wip;
    
    WindowOverlapSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong1, long paramLong2, int paramInt)
    {
      super();
      this.downstream = paramSubscriber;
      this.size = paramLong1;
      this.skip = paramLong2;
      this.queue = new SpscLinkedArrayQueue(paramInt);
      this.windows = new ArrayDeque();
      this.once = new AtomicBoolean();
      this.firstRequest = new AtomicBoolean();
      this.requested = new AtomicLong();
      this.wip = new AtomicInteger();
      this.bufferSize = paramInt;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, SpscLinkedArrayQueue<?> paramSpscLinkedArrayQueue)
    {
      return false;
    }
    
    /* Error */
    void drain()
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
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class WindowSkipSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = -8792836352386833856L;
    final int bufferSize;
    final Subscriber<? super Flowable<T>> downstream;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    final long size;
    final long skip;
    Subscription upstream;
    UnicastProcessor<T> window;
    
    WindowSkipSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong1, long paramLong2, int paramInt)
    {
      super();
      this.downstream = paramSubscriber;
      this.size = paramLong1;
      this.skip = paramLong2;
      this.once = new AtomicBoolean();
      this.firstRequest = new AtomicBoolean();
      this.bufferSize = paramInt;
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
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */