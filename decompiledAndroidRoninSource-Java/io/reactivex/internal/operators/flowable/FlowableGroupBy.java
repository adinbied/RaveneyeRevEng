package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V>
  extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>>
{
  final int bufferSize;
  final boolean delayError;
  final Function<? super T, ? extends K> keySelector;
  final Function<? super Consumer<Object>, ? extends Map<K, Object>> mapFactory;
  final Function<? super T, ? extends V> valueSelector;
  
  public FlowableGroupBy(Flowable<T> paramFlowable, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, int paramInt, boolean paramBoolean, Function<? super Consumer<Object>, ? extends Map<K, Object>> paramFunction2)
  {
    super(paramFlowable);
    this.keySelector = paramFunction;
    this.valueSelector = paramFunction1;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
    this.mapFactory = paramFunction2;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class EvictionAction<K, V>
    implements Consumer<FlowableGroupBy.GroupedUnicast<K, V>>
  {
    final Queue<FlowableGroupBy.GroupedUnicast<K, V>> evictedGroups;
    
    EvictionAction(Queue<FlowableGroupBy.GroupedUnicast<K, V>> paramQueue)
    {
      this.evictedGroups = paramQueue;
    }
    
    public void accept(FlowableGroupBy.GroupedUnicast<K, V> paramGroupedUnicast)
    {
      this.evictedGroups.offer(paramGroupedUnicast);
    }
  }
  
  public static final class GroupBySubscriber<T, K, V>
    extends BasicIntQueueSubscription<GroupedFlowable<K, V>>
    implements FlowableSubscriber<T>
  {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    boolean done;
    final Subscriber<? super GroupedFlowable<K, V>> downstream;
    Throwable error;
    final Queue<FlowableGroupBy.GroupedUnicast<K, V>> evictedGroups;
    volatile boolean finished;
    final AtomicInteger groupCount = new AtomicInteger(1);
    final Map<Object, FlowableGroupBy.GroupedUnicast<K, V>> groups;
    final Function<? super T, ? extends K> keySelector;
    boolean outputFused;
    final SpscLinkedArrayQueue<GroupedFlowable<K, V>> queue;
    final AtomicLong requested = new AtomicLong();
    Subscription upstream;
    final Function<? super T, ? extends V> valueSelector;
    
    public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> paramSubscriber, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, int paramInt, boolean paramBoolean, Map<Object, FlowableGroupBy.GroupedUnicast<K, V>> paramMap, Queue<FlowableGroupBy.GroupedUnicast<K, V>> paramQueue)
    {
      this.downstream = paramSubscriber;
      this.keySelector = paramFunction;
      this.valueSelector = paramFunction1;
      this.bufferSize = paramInt;
      this.delayError = paramBoolean;
      this.groups = paramMap;
      this.evictedGroups = paramQueue;
      this.queue = new SpscLinkedArrayQueue(paramInt);
    }
    
    /* Error */
    private void completeEvictions()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, SpscLinkedArrayQueue<?> paramSpscLinkedArrayQueue)
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
    
    /* Error */
    void drainFused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainNormal()
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
    
    public GroupedFlowable<K, V> poll()
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
  
  static final class GroupedUnicast<K, T>
    extends GroupedFlowable<K, T>
  {
    final FlowableGroupBy.State<T, K> state;
    
    protected GroupedUnicast(K paramK, FlowableGroupBy.State<T, K> paramState)
    {
      super();
      this.state = paramState;
    }
    
    public static <T, K> GroupedUnicast<K, T> createWith(K paramK, int paramInt, FlowableGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, boolean paramBoolean)
    {
      return new GroupedUnicast(paramK, new FlowableGroupBy.State(paramInt, paramGroupBySubscriber, paramK, paramBoolean));
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
    
    protected void subscribeActual(Subscriber<? super T> paramSubscriber)
    {
      this.state.subscribe(paramSubscriber);
    }
  }
  
  static final class State<T, K>
    extends BasicIntQueueSubscription<T>
    implements Publisher<T>
  {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Subscriber<? super T>> actual = new AtomicReference();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once = new AtomicBoolean();
    boolean outputFused;
    final FlowableGroupBy.GroupBySubscriber<?, K, T> parent;
    int produced;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicLong requested = new AtomicLong();
    
    State(int paramInt, FlowableGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, K paramK, boolean paramBoolean)
    {
      this.queue = new SpscLinkedArrayQueue(paramInt);
      this.parent = paramGroupBySubscriber;
      this.key = paramK;
      this.delayError = paramBoolean;
    }
    
    /* Error */
    public void cancel()
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
    
    /* Error */
    void drainFused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainNormal()
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
    
    /* Error */
    public void subscribe(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableGroupBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */