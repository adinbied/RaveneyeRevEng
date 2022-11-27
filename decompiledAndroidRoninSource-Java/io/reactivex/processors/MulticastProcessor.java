package io.reactivex.processors;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
public final class MulticastProcessor<T>
  extends FlowableProcessor<T>
{
  static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
  static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
  final int bufferSize;
  int consumed;
  volatile boolean done;
  volatile Throwable error;
  int fusionMode;
  final int limit;
  final AtomicBoolean once;
  volatile SimpleQueue<T> queue;
  final boolean refcount;
  final AtomicReference<MulticastSubscription<T>[]> subscribers;
  final AtomicReference<Subscription> upstream;
  final AtomicInteger wip;
  
  MulticastProcessor(int paramInt, boolean paramBoolean)
  {
    ObjectHelper.verifyPositive(paramInt, "bufferSize");
    this.bufferSize = paramInt;
    this.limit = (paramInt - (paramInt >> 2));
    this.wip = new AtomicInteger();
    this.subscribers = new AtomicReference(EMPTY);
    this.upstream = new AtomicReference();
    this.refcount = paramBoolean;
    this.once = new AtomicBoolean();
  }
  
  @CheckReturnValue
  public static <T> MulticastProcessor<T> create()
  {
    return new MulticastProcessor(bufferSize(), false);
  }
  
  @CheckReturnValue
  public static <T> MulticastProcessor<T> create(int paramInt)
  {
    return new MulticastProcessor(paramInt, false);
  }
  
  @CheckReturnValue
  public static <T> MulticastProcessor<T> create(int paramInt, boolean paramBoolean)
  {
    return new MulticastProcessor(paramInt, paramBoolean);
  }
  
  @CheckReturnValue
  public static <T> MulticastProcessor<T> create(boolean paramBoolean)
  {
    return new MulticastProcessor(bufferSize(), paramBoolean);
  }
  
  boolean add(MulticastSubscription<T> paramMulticastSubscription)
  {
    return false;
  }
  
  /* Error */
  void drain()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  
  public boolean offer(T paramT)
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
  public void onSubscribe(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(MulticastSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startUnbounded()
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
  
  static final class MulticastSubscription<T>
    extends AtomicLong
    implements Subscription
  {
    private static final long serialVersionUID = -363282618957264509L;
    final Subscriber<? super T> downstream;
    long emitted;
    final MulticastProcessor<T> parent;
    
    MulticastSubscription(Subscriber<? super T> paramSubscriber, MulticastProcessor<T> paramMulticastProcessor)
    {
      this.downstream = paramSubscriber;
      this.parent = paramMulticastProcessor;
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
    void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onNext(T arg1)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\MulticastProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */