package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.internal.util.UtilityFunctions;
import dji.thirdparty.rx.observables.GroupedObservable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class OperatorGroupBy<T, K, V>
  implements Observable.Operator<GroupedObservable<K, V>, T>
{
  final int bufferSize;
  final boolean delayError;
  final Func1<? super T, ? extends K> keySelector;
  final Func1<? super T, ? extends V> valueSelector;
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1)
  {
    this(paramFunc1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false);
  }
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11)
  {
    this(paramFunc1, paramFunc11, RxRingBuffer.SIZE, false);
  }
  
  public OperatorGroupBy(Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, int paramInt, boolean paramBoolean)
  {
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> paramSubscriber)
  {
    return null;
  }
  
  public static final class GroupByProducer
    implements Producer
  {
    final OperatorGroupBy.GroupBySubscriber<?, ?, ?> parent;
    
    public GroupByProducer(OperatorGroupBy.GroupBySubscriber<?, ?, ?> paramGroupBySubscriber)
    {
      this.parent = paramGroupBySubscriber;
    }
    
    public void request(long paramLong)
    {
      this.parent.requestMore(paramLong);
    }
  }
  
  public static final class GroupBySubscriber<T, K, V>
    extends Subscriber<T>
  {
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> CANCELLED;
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> GROUP_COUNT = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "groupCount");
    static final Object NULL_KEY = new Object();
    static final AtomicLongFieldUpdater<GroupBySubscriber> REQUESTED;
    static final AtomicIntegerFieldUpdater<GroupBySubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "wip");
    final Subscriber<? super GroupedObservable<K, V>> actual;
    final int bufferSize;
    volatile int cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    volatile int groupCount;
    final Map<Object, OperatorGroupBy.GroupedUnicast<K, V>> groups;
    final Func1<? super T, ? extends K> keySelector;
    final OperatorGroupBy.GroupByProducer producer;
    final Queue<GroupedObservable<K, V>> queue;
    volatile long requested;
    final ProducerArbiter s;
    final Func1<? super T, ? extends V> valueSelector;
    volatile int wip;
    
    static
    {
      CANCELLED = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "cancelled");
      REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "requested");
    }
    
    public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, int paramInt, boolean paramBoolean)
    {
      this.actual = paramSubscriber;
      this.keySelector = paramFunc1;
      this.valueSelector = paramFunc11;
      this.bufferSize = paramInt;
      this.delayError = paramBoolean;
      this.groups = new ConcurrentHashMap();
      this.queue = new ConcurrentLinkedQueue();
      GROUP_COUNT.lazySet(this, 1);
      paramSubscriber = new ProducerArbiter();
      this.s = paramSubscriber;
      paramSubscriber.request(paramInt);
      this.producer = new OperatorGroupBy.GroupByProducer(this);
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
    public void cancel(K arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Queue<?> paramQueue)
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
    void errorAll(Subscriber<? super GroupedObservable<K, V>> arg1, Queue<?> arg2, Throwable arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onCompleted()
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
    public void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.s.setProducer(paramProducer);
    }
  }
  
  static final class GroupedUnicast<K, T>
    extends GroupedObservable<K, T>
  {
    final OperatorGroupBy.State<T, K> state;
    
    protected GroupedUnicast(K paramK, OperatorGroupBy.State<T, K> paramState)
    {
      super(paramState);
      this.state = paramState;
    }
    
    public static <T, K> GroupedUnicast<K, T> createWith(K paramK, int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, boolean paramBoolean)
    {
      return new GroupedUnicast(paramK, new OperatorGroupBy.State(paramInt, paramGroupBySubscriber, paramK, paramBoolean));
    }
    
    public void onComplete()
    {
      this.state.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.state.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.state.onNext(paramT);
    }
  }
  
  static final class State<T, K>
    extends AtomicInteger
    implements Producer, Subscription, Observable.OnSubscribe<T>
  {
    static final AtomicReferenceFieldUpdater<State, Subscriber> ACTUAL = AtomicReferenceFieldUpdater.newUpdater(State.class, Subscriber.class, "actual");
    static final AtomicIntegerFieldUpdater<State> CANCELLED;
    static final AtomicIntegerFieldUpdater<State> ONCE = AtomicIntegerFieldUpdater.newUpdater(State.class, "once");
    static final AtomicLongFieldUpdater<State> REQUESTED = AtomicLongFieldUpdater.newUpdater(State.class, "requested");
    private static final long serialVersionUID = -3852313036005250360L;
    volatile Subscriber<? super T> actual;
    volatile int cancelled;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    volatile int once;
    final OperatorGroupBy.GroupBySubscriber<?, K, T> parent;
    final Queue<Object> queue = new ConcurrentLinkedQueue();
    volatile long requested;
    
    static
    {
      CANCELLED = AtomicIntegerFieldUpdater.newUpdater(State.class, "cancelled");
    }
    
    public State(int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, K paramK, boolean paramBoolean)
    {
      this.parent = paramGroupBySubscriber;
      this.key = paramK;
      this.delayError = paramBoolean;
    }
    
    /* Error */
    public void call(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, boolean paramBoolean3)
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
    
    public boolean isUnsubscribed()
    {
      return this.cancelled != 0;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorGroupBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */