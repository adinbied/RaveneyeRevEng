package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T>
  extends FlowableProcessor<T>
{
  static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
  private static final Object[] EMPTY_ARRAY = new Object[0];
  static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
  final ReplayBuffer<T> buffer;
  boolean done;
  final AtomicReference<ReplaySubscription<T>[]> subscribers;
  
  ReplayProcessor(ReplayBuffer<T> paramReplayBuffer)
  {
    this.buffer = paramReplayBuffer;
    this.subscribers = new AtomicReference(EMPTY);
  }
  
  @CheckReturnValue
  public static <T> ReplayProcessor<T> create()
  {
    return new ReplayProcessor(new UnboundedReplayBuffer(16));
  }
  
  @CheckReturnValue
  public static <T> ReplayProcessor<T> create(int paramInt)
  {
    return new ReplayProcessor(new UnboundedReplayBuffer(paramInt));
  }
  
  static <T> ReplayProcessor<T> createUnbounded()
  {
    return new ReplayProcessor(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
  }
  
  @CheckReturnValue
  public static <T> ReplayProcessor<T> createWithSize(int paramInt)
  {
    return new ReplayProcessor(new SizeBoundReplayBuffer(paramInt));
  }
  
  @CheckReturnValue
  public static <T> ReplayProcessor<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  public static <T> ReplayProcessor<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return new ReplayProcessor(new SizeAndTimeBoundReplayBuffer(paramInt, paramLong, paramTimeUnit, paramScheduler));
  }
  
  boolean add(ReplaySubscription<T> paramReplaySubscription)
  {
    return false;
  }
  
  public void cleanupBuffer()
  {
    this.buffer.trimHead();
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return (T)this.buffer.getValue();
  }
  
  public Object[] getValues()
  {
    return null;
  }
  
  public T[] getValues(T[] paramArrayOfT)
  {
    return this.buffer.getValues(paramArrayOfT);
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
  
  public boolean hasValue()
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
  void remove(ReplaySubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int size()
  {
    return this.buffer.size();
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int subscriberCount()
  {
    return 0;
  }
  
  static final class Node<T>
    extends AtomicReference<Node<T>>
  {
    private static final long serialVersionUID = 6404226426336033100L;
    final T value;
    
    Node(T paramT)
    {
      this.value = paramT;
    }
  }
  
  static abstract interface ReplayBuffer<T>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract Throwable getError();
    
    public abstract T getValue();
    
    public abstract T[] getValues(T[] paramArrayOfT);
    
    public abstract boolean isDone();
    
    public abstract void next(T paramT);
    
    public abstract void replay(ReplayProcessor.ReplaySubscription<T> paramReplaySubscription);
    
    public abstract int size();
    
    public abstract void trimHead();
  }
  
  static final class ReplaySubscription<T>
    extends AtomicInteger
    implements Subscription
  {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final Subscriber<? super T> downstream;
    long emitted;
    Object index;
    final AtomicLong requested;
    final ReplayProcessor<T> state;
    
    ReplaySubscription(Subscriber<? super T> paramSubscriber, ReplayProcessor<T> paramReplayProcessor)
    {
      this.downstream = paramSubscriber;
      this.state = paramReplayProcessor;
      this.requested = new AtomicLong();
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    implements ReplayProcessor.ReplayBuffer<T>
  {
    volatile boolean done;
    Throwable error;
    volatile ReplayProcessor.TimedNode<T> head;
    final long maxAge;
    final int maxSize;
    final Scheduler scheduler;
    int size;
    ReplayProcessor.TimedNode<T> tail;
    final TimeUnit unit;
    
    SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.maxSize = ObjectHelper.verifyPositive(paramInt, "maxSize");
      this.maxAge = ObjectHelper.verifyPositive(paramLong, "maxAge");
      this.unit = ((TimeUnit)ObjectHelper.requireNonNull(paramTimeUnit, "unit is null"));
      this.scheduler = ((Scheduler)ObjectHelper.requireNonNull(paramScheduler, "scheduler is null"));
      paramTimeUnit = new ReplayProcessor.TimedNode(null, 0L);
      this.tail = paramTimeUnit;
      this.head = paramTimeUnit;
    }
    
    public void complete()
    {
      trimFinal();
      this.done = true;
    }
    
    public void error(Throwable paramThrowable)
    {
      trimFinal();
      this.error = paramThrowable;
      this.done = true;
    }
    
    public Throwable getError()
    {
      return this.error;
    }
    
    ReplayProcessor.TimedNode<T> getHead()
    {
      return null;
    }
    
    public T getValue()
    {
      return null;
    }
    
    public T[] getValues(T[] paramArrayOfT)
    {
      return null;
    }
    
    public boolean isDone()
    {
      return this.done;
    }
    
    /* Error */
    public void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void replay(ReplayProcessor.ReplaySubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public int size()
    {
      return 0;
    }
    
    int size(ReplayProcessor.TimedNode<T> paramTimedNode)
    {
      return 0;
    }
    
    /* Error */
    void trim()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void trimFinal()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void trimHead()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SizeBoundReplayBuffer<T>
    implements ReplayProcessor.ReplayBuffer<T>
  {
    volatile boolean done;
    Throwable error;
    volatile ReplayProcessor.Node<T> head;
    final int maxSize;
    int size;
    ReplayProcessor.Node<T> tail;
    
    SizeBoundReplayBuffer(int paramInt)
    {
      this.maxSize = ObjectHelper.verifyPositive(paramInt, "maxSize");
      ReplayProcessor.Node localNode = new ReplayProcessor.Node(null);
      this.tail = localNode;
      this.head = localNode;
    }
    
    public void complete()
    {
      trimHead();
      this.done = true;
    }
    
    public void error(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      trimHead();
      this.done = true;
    }
    
    public Throwable getError()
    {
      return this.error;
    }
    
    public T getValue()
    {
      return null;
    }
    
    public T[] getValues(T[] paramArrayOfT)
    {
      return null;
    }
    
    public boolean isDone()
    {
      return this.done;
    }
    
    /* Error */
    public void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void replay(ReplayProcessor.ReplaySubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public int size()
    {
      return 0;
    }
    
    /* Error */
    void trim()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void trimHead()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TimedNode<T>
    extends AtomicReference<TimedNode<T>>
  {
    private static final long serialVersionUID = 6404226426336033100L;
    final long time;
    final T value;
    
    TimedNode(T paramT, long paramLong)
    {
      this.value = paramT;
      this.time = paramLong;
    }
  }
  
  static final class UnboundedReplayBuffer<T>
    implements ReplayProcessor.ReplayBuffer<T>
  {
    final List<T> buffer;
    volatile boolean done;
    Throwable error;
    volatile int size;
    
    UnboundedReplayBuffer(int paramInt)
    {
      this.buffer = new ArrayList(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    }
    
    public void complete()
    {
      this.done = true;
    }
    
    public void error(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
    }
    
    public Throwable getError()
    {
      return this.error;
    }
    
    public T getValue()
    {
      return null;
    }
    
    public T[] getValues(T[] paramArrayOfT)
    {
      return null;
    }
    
    public boolean isDone()
    {
      return this.done;
    }
    
    /* Error */
    public void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void replay(ReplayProcessor.ReplaySubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public int size()
    {
      return this.size;
    }
    
    public void trimHead() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\ReplayProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */