package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T>
  extends Subject<T>
{
  static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
  private static final Object[] EMPTY_ARRAY = new Object[0];
  static final ReplayDisposable[] TERMINATED = new ReplayDisposable[0];
  final ReplayBuffer<T> buffer;
  boolean done;
  final AtomicReference<ReplayDisposable<T>[]> observers;
  
  ReplaySubject(ReplayBuffer<T> paramReplayBuffer)
  {
    this.buffer = paramReplayBuffer;
    this.observers = new AtomicReference(EMPTY);
  }
  
  @CheckReturnValue
  public static <T> ReplaySubject<T> create()
  {
    return new ReplaySubject(new UnboundedReplayBuffer(16));
  }
  
  @CheckReturnValue
  public static <T> ReplaySubject<T> create(int paramInt)
  {
    return new ReplaySubject(new UnboundedReplayBuffer(paramInt));
  }
  
  static <T> ReplaySubject<T> createUnbounded()
  {
    return new ReplaySubject(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
  }
  
  @CheckReturnValue
  public static <T> ReplaySubject<T> createWithSize(int paramInt)
  {
    return new ReplaySubject(new SizeBoundReplayBuffer(paramInt));
  }
  
  @CheckReturnValue
  public static <T> ReplaySubject<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, paramLong, paramTimeUnit, paramScheduler));
  }
  
  @CheckReturnValue
  public static <T> ReplaySubject<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(paramInt, paramLong, paramTimeUnit, paramScheduler));
  }
  
  boolean add(ReplayDisposable<T> paramReplayDisposable)
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
  
  public boolean hasObservers()
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
  
  int observerCount()
  {
    return 0;
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
  
  public void onSubscribe(Disposable paramDisposable)
  {
    if (this.done) {
      paramDisposable.dispose();
    }
  }
  
  /* Error */
  void remove(ReplayDisposable<T> arg1)
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
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  ReplayDisposable<T>[] terminate(Object paramObject)
  {
    return null;
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
    public abstract void add(T paramT);
    
    public abstract void addFinal(Object paramObject);
    
    public abstract boolean compareAndSet(Object paramObject1, Object paramObject2);
    
    public abstract Object get();
    
    public abstract T getValue();
    
    public abstract T[] getValues(T[] paramArrayOfT);
    
    public abstract void replay(ReplaySubject.ReplayDisposable<T> paramReplayDisposable);
    
    public abstract int size();
    
    public abstract void trimHead();
  }
  
  static final class ReplayDisposable<T>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = 466549804534799122L;
    volatile boolean cancelled;
    final Observer<? super T> downstream;
    Object index;
    final ReplaySubject<T> state;
    
    ReplayDisposable(Observer<? super T> paramObserver, ReplaySubject<T> paramReplaySubject)
    {
      this.downstream = paramObserver;
      this.state = paramReplaySubject;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    extends AtomicReference<Object>
    implements ReplaySubject.ReplayBuffer<T>
  {
    private static final long serialVersionUID = -8056260896137901749L;
    volatile boolean done;
    volatile ReplaySubject.TimedNode<Object> head;
    final long maxAge;
    final int maxSize;
    final Scheduler scheduler;
    int size;
    ReplaySubject.TimedNode<Object> tail;
    final TimeUnit unit;
    
    SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.maxSize = ObjectHelper.verifyPositive(paramInt, "maxSize");
      this.maxAge = ObjectHelper.verifyPositive(paramLong, "maxAge");
      this.unit = ((TimeUnit)ObjectHelper.requireNonNull(paramTimeUnit, "unit is null"));
      this.scheduler = ((Scheduler)ObjectHelper.requireNonNull(paramScheduler, "scheduler is null"));
      paramTimeUnit = new ReplaySubject.TimedNode(null, 0L);
      this.tail = paramTimeUnit;
      this.head = paramTimeUnit;
    }
    
    /* Error */
    public void add(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void addFinal(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    ReplaySubject.TimedNode<Object> getHead()
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
    
    /* Error */
    public void replay(ReplaySubject.ReplayDisposable<T> arg1)
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
    
    int size(ReplaySubject.TimedNode<Object> paramTimedNode)
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
    extends AtomicReference<Object>
    implements ReplaySubject.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 1107649250281456395L;
    volatile boolean done;
    volatile ReplaySubject.Node<Object> head;
    final int maxSize;
    int size;
    ReplaySubject.Node<Object> tail;
    
    SizeBoundReplayBuffer(int paramInt)
    {
      this.maxSize = ObjectHelper.verifyPositive(paramInt, "maxSize");
      ReplaySubject.Node localNode = new ReplaySubject.Node(null);
      this.tail = localNode;
      this.head = localNode;
    }
    
    /* Error */
    public void add(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void addFinal(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T getValue()
    {
      return null;
    }
    
    public T[] getValues(T[] paramArrayOfT)
    {
      return null;
    }
    
    /* Error */
    public void replay(ReplaySubject.ReplayDisposable<T> arg1)
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
    extends AtomicReference<Object>
    implements ReplaySubject.ReplayBuffer<T>
  {
    private static final long serialVersionUID = -733876083048047795L;
    final List<Object> buffer;
    volatile boolean done;
    volatile int size;
    
    UnboundedReplayBuffer(int paramInt)
    {
      this.buffer = new ArrayList(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    }
    
    /* Error */
    public void add(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void addFinal(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T getValue()
    {
      return null;
    }
    
    public T[] getValues(T[] paramArrayOfT)
    {
      return null;
    }
    
    /* Error */
    public void replay(ReplaySubject.ReplayDisposable<T> arg1)
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
    
    public void trimHead() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\ReplaySubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */