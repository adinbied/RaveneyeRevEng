package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class BehaviorProcessor<T>
  extends FlowableProcessor<T>
{
  static final BehaviorSubscription[] EMPTY = new BehaviorSubscription[0];
  static final Object[] EMPTY_ARRAY = new Object[0];
  static final BehaviorSubscription[] TERMINATED = new BehaviorSubscription[0];
  long index;
  final ReadWriteLock lock;
  final Lock readLock;
  final AtomicReference<BehaviorSubscription<T>[]> subscribers;
  final AtomicReference<Throwable> terminalEvent;
  final AtomicReference<Object> value = new AtomicReference();
  final Lock writeLock;
  
  BehaviorProcessor()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.lock = localReentrantReadWriteLock;
    this.readLock = localReentrantReadWriteLock.readLock();
    this.writeLock = this.lock.writeLock();
    this.subscribers = new AtomicReference(EMPTY);
    this.terminalEvent = new AtomicReference();
  }
  
  BehaviorProcessor(T paramT)
  {
    this();
    this.value.lazySet(ObjectHelper.requireNonNull(paramT, "defaultValue is null"));
  }
  
  @CheckReturnValue
  public static <T> BehaviorProcessor<T> create()
  {
    return new BehaviorProcessor();
  }
  
  @CheckReturnValue
  public static <T> BehaviorProcessor<T> createDefault(T paramT)
  {
    ObjectHelper.requireNonNull(paramT, "defaultValue is null");
    return new BehaviorProcessor(paramT);
  }
  
  boolean add(BehaviorSubscription<T> paramBehaviorSubscription)
  {
    return false;
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  @Deprecated
  public Object[] getValues()
  {
    return null;
  }
  
  @Deprecated
  public T[] getValues(T[] paramArrayOfT)
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
  
  public boolean hasValue()
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
  void remove(BehaviorSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setCurrent(Object arg1)
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
  
  int subscriberCount()
  {
    return 0;
  }
  
  BehaviorSubscription<T>[] terminate(Object paramObject)
  {
    return null;
  }
  
  static final class BehaviorSubscription<T>
    extends AtomicLong
    implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>
  {
    private static final long serialVersionUID = 3293175281126227086L;
    volatile boolean cancelled;
    final Subscriber<? super T> downstream;
    boolean emitting;
    boolean fastPath;
    long index;
    boolean next;
    AppendOnlyLinkedArrayList<Object> queue;
    final BehaviorProcessor<T> state;
    
    BehaviorSubscription(Subscriber<? super T> paramSubscriber, BehaviorProcessor<T> paramBehaviorProcessor)
    {
      this.downstream = paramSubscriber;
      this.state = paramBehaviorProcessor;
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
    void emitFirst()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void emitLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void emitNext(Object arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isFull()
    {
      return false;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public boolean test(Object paramObject)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\BehaviorProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */