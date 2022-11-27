package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class UnicastProcessor<T>
  extends FlowableProcessor<T>
{
  volatile boolean cancelled;
  final boolean delayError;
  volatile boolean done;
  final AtomicReference<Subscriber<? super T>> downstream;
  boolean enableOperatorFusion;
  Throwable error;
  final AtomicReference<Runnable> onTerminate;
  final AtomicBoolean once;
  final SpscLinkedArrayQueue<T> queue;
  final AtomicLong requested;
  final BasicIntQueueSubscription<T> wip;
  
  UnicastProcessor(int paramInt)
  {
    this(paramInt, null, true);
  }
  
  UnicastProcessor(int paramInt, Runnable paramRunnable)
  {
    this(paramInt, paramRunnable, true);
  }
  
  UnicastProcessor(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    this.onTerminate = new AtomicReference(paramRunnable);
    this.delayError = paramBoolean;
    this.downstream = new AtomicReference();
    this.once = new AtomicBoolean();
    this.wip = new UnicastQueueSubscription();
    this.requested = new AtomicLong();
  }
  
  @CheckReturnValue
  public static <T> UnicastProcessor<T> create()
  {
    return new UnicastProcessor(bufferSize());
  }
  
  @CheckReturnValue
  public static <T> UnicastProcessor<T> create(int paramInt)
  {
    return new UnicastProcessor(paramInt);
  }
  
  @CheckReturnValue
  public static <T> UnicastProcessor<T> create(int paramInt, Runnable paramRunnable)
  {
    ObjectHelper.requireNonNull(paramRunnable, "onTerminate");
    return new UnicastProcessor(paramInt, paramRunnable);
  }
  
  @CheckReturnValue
  public static <T> UnicastProcessor<T> create(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    ObjectHelper.requireNonNull(paramRunnable, "onTerminate");
    return new UnicastProcessor(paramInt, paramRunnable, paramBoolean);
  }
  
  @CheckReturnValue
  public static <T> UnicastProcessor<T> create(boolean paramBoolean)
  {
    return new UnicastProcessor(bufferSize(), null, paramBoolean);
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Subscriber<? super T> paramSubscriber, SpscLinkedArrayQueue<T> paramSpscLinkedArrayQueue)
  {
    return false;
  }
  
  /* Error */
  void doTerminate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  void drainFused(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void drainRegular(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public boolean hasComplete()
  {
    return false;
  }
  
  public boolean hasSubscribers()
  {
    return false;
  }
  
  public boolean hasThrowable()
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
  public void onSubscribe(org.reactivestreams.Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class UnicastQueueSubscription
    extends BasicIntQueueSubscription<T>
  {
    private static final long serialVersionUID = -4896760517184205454L;
    
    UnicastQueueSubscription() {}
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      UnicastProcessor.this.queue.clear();
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public T poll()
    {
      return null;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\UnicastProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */