package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReplay<T>
  extends ConnectableFlowable<T>
  implements HasUpstreamPublisher<T>, ResettableConnectable
{
  static final Callable DEFAULT_UNBOUNDED_FACTORY = new DefaultUnboundedFactory();
  final Callable<? extends ReplayBuffer<T>> bufferFactory;
  final AtomicReference<ReplaySubscriber<T>> current;
  final Publisher<T> onSubscribe;
  final Flowable<T> source;
  
  private FlowableReplay(Publisher<T> paramPublisher, Flowable<T> paramFlowable, AtomicReference<ReplaySubscriber<T>> paramAtomicReference, Callable<? extends ReplayBuffer<T>> paramCallable)
  {
    this.onSubscribe = paramPublisher;
    this.source = paramFlowable;
    this.current = paramAtomicReference;
    this.bufferFactory = paramCallable;
  }
  
  public static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return createFrom(paramFlowable);
    }
    return create(paramFlowable, new ReplayBufferTask(paramInt));
  }
  
  public static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(paramFlowable, paramLong, paramTimeUnit, paramScheduler, Integer.MAX_VALUE);
  }
  
  public static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return create(paramFlowable, new ScheduledReplayBufferTask(paramInt, paramLong, paramTimeUnit, paramScheduler));
  }
  
  static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, Callable<? extends ReplayBuffer<T>> paramCallable)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return RxJavaPlugins.onAssembly(new FlowableReplay(new ReplayPublisher(localAtomicReference, paramCallable), paramFlowable, localAtomicReference, paramCallable));
  }
  
  public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> paramFlowable)
  {
    return create(paramFlowable, DEFAULT_UNBOUNDED_FACTORY);
  }
  
  public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> paramCallable, Function<? super Flowable<U>, ? extends Publisher<R>> paramFunction)
  {
    return new MulticastFlowable(paramCallable, paramFunction);
  }
  
  public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> paramConnectableFlowable, Scheduler paramScheduler)
  {
    return RxJavaPlugins.onAssembly(new ConnectableFlowableReplay(paramConnectableFlowable, paramConnectableFlowable.observeOn(paramScheduler)));
  }
  
  /* Error */
  public void connect(Consumer<? super Disposable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void resetIf(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Publisher<T> source()
  {
    return this.source;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber)
  {
    this.onSubscribe.subscribe(paramSubscriber);
  }
  
  static class BoundedReplayBuffer<T>
    extends AtomicReference<FlowableReplay.Node>
    implements FlowableReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    int size;
    FlowableReplay.Node tail;
    
    BoundedReplayBuffer()
    {
      FlowableReplay.Node localNode = new FlowableReplay.Node(null, 0L);
      this.tail = localNode;
      set(localNode);
    }
    
    /* Error */
    final void addLast(FlowableReplay.Node arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    final void collect(java.util.Collection<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    Object enterTransform(Object paramObject)
    {
      return paramObject;
    }
    
    /* Error */
    public final void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    FlowableReplay.Node getHead()
    {
      return (FlowableReplay.Node)get();
    }
    
    boolean hasCompleted()
    {
      return false;
    }
    
    boolean hasError()
    {
      return false;
    }
    
    Object leaveTransform(Object paramObject)
    {
      return paramObject;
    }
    
    /* Error */
    public final void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    final void removeFirst()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    final void removeSome(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void replay(FlowableReplay.InnerSubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final void setFirst(FlowableReplay.Node paramNode)
    {
      set(paramNode);
    }
    
    /* Error */
    final void trimHead()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void truncate() {}
    
    void truncateFinal()
    {
      trimHead();
    }
  }
  
  static final class ConnectableFlowableReplay<T>
    extends ConnectableFlowable<T>
  {
    private final ConnectableFlowable<T> cf;
    private final Flowable<T> flowable;
    
    ConnectableFlowableReplay(ConnectableFlowable<T> paramConnectableFlowable, Flowable<T> paramFlowable)
    {
      this.cf = paramConnectableFlowable;
      this.flowable = paramFlowable;
    }
    
    public void connect(Consumer<? super Disposable> paramConsumer)
    {
      this.cf.connect(paramConsumer);
    }
    
    protected void subscribeActual(Subscriber<? super T> paramSubscriber)
    {
      this.flowable.subscribe(paramSubscriber);
    }
  }
  
  static final class DefaultUnboundedFactory
    implements Callable<Object>
  {
    public Object call()
    {
      return new FlowableReplay.UnboundedReplayBuffer(16);
    }
  }
  
  static final class InnerSubscription<T>
    extends AtomicLong
    implements Subscription, Disposable
  {
    static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final FlowableReplay.ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;
    
    InnerSubscription(FlowableReplay.ReplaySubscriber<T> paramReplaySubscriber, Subscriber<? super T> paramSubscriber)
    {
      this.parent = paramReplaySubscriber;
      this.child = paramSubscriber;
      this.totalRequested = new AtomicLong();
    }
    
    public void cancel()
    {
      dispose();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    <U> U index()
    {
      return (U)this.index;
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public long produced(long paramLong)
    {
      return BackpressureHelper.producedCancel(this, paramLong);
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
  
  static final class MulticastFlowable<R, U>
    extends Flowable<R>
  {
    private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
    private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;
    
    MulticastFlowable(Callable<? extends ConnectableFlowable<U>> paramCallable, Function<? super Flowable<U>, ? extends Publisher<R>> paramFunction)
    {
      this.connectableFactory = paramCallable;
      this.selector = paramFunction;
    }
    
    /* Error */
    protected void subscribeActual(Subscriber<? super R> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final class DisposableConsumer
      implements Consumer<Disposable>
    {
      private final SubscriberResourceWrapper<R> srw;
      
      DisposableConsumer()
      {
        SubscriberResourceWrapper localSubscriberResourceWrapper;
        this.srw = localSubscriberResourceWrapper;
      }
      
      public void accept(Disposable paramDisposable)
      {
        this.srw.setResource(paramDisposable);
      }
    }
  }
  
  static final class Node
    extends AtomicReference<Node>
  {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;
    
    Node(Object paramObject, long paramLong)
    {
      this.value = paramObject;
      this.index = paramLong;
    }
  }
  
  static abstract interface ReplayBuffer<T>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract void next(T paramT);
    
    public abstract void replay(FlowableReplay.InnerSubscription<T> paramInnerSubscription);
  }
  
  static final class ReplayBufferTask<T>
    implements Callable<FlowableReplay.ReplayBuffer<T>>
  {
    private final int bufferSize;
    
    ReplayBufferTask(int paramInt)
    {
      this.bufferSize = paramInt;
    }
    
    public FlowableReplay.ReplayBuffer<T> call()
    {
      return new FlowableReplay.SizeBoundReplayBuffer(this.bufferSize);
    }
  }
  
  static final class ReplayPublisher<T>
    implements Publisher<T>
  {
    private final Callable<? extends FlowableReplay.ReplayBuffer<T>> bufferFactory;
    private final AtomicReference<FlowableReplay.ReplaySubscriber<T>> curr;
    
    ReplayPublisher(AtomicReference<FlowableReplay.ReplaySubscriber<T>> paramAtomicReference, Callable<? extends FlowableReplay.ReplayBuffer<T>> paramCallable)
    {
      this.curr = paramAtomicReference;
      this.bufferFactory = paramCallable;
    }
    
    /* Error */
    public void subscribe(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class ReplaySubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>, Disposable
  {
    static final FlowableReplay.InnerSubscription[] EMPTY = new FlowableReplay.InnerSubscription[0];
    static final FlowableReplay.InnerSubscription[] TERMINATED = new FlowableReplay.InnerSubscription[0];
    private static final long serialVersionUID = 7224554242710036740L;
    final FlowableReplay.ReplayBuffer<T> buffer;
    boolean done;
    final AtomicInteger management;
    long maxChildRequested;
    long maxUpstreamRequested;
    final AtomicBoolean shouldConnect;
    final AtomicReference<FlowableReplay.InnerSubscription<T>[]> subscribers;
    
    ReplaySubscriber(FlowableReplay.ReplayBuffer<T> paramReplayBuffer)
    {
      this.buffer = paramReplayBuffer;
      this.management = new AtomicInteger();
      this.subscribers = new AtomicReference(EMPTY);
      this.shouldConnect = new AtomicBoolean();
    }
    
    boolean add(FlowableReplay.InnerSubscription<T> paramInnerSubscription)
    {
      return false;
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
      return false;
    }
    
    /* Error */
    void manageRequests()
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
    void remove(FlowableReplay.InnerSubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ScheduledReplayBufferTask<T>
    implements Callable<FlowableReplay.ReplayBuffer<T>>
  {
    private final int bufferSize;
    private final long maxAge;
    private final Scheduler scheduler;
    private final TimeUnit unit;
    
    ScheduledReplayBufferTask(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.bufferSize = paramInt;
      this.maxAge = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public FlowableReplay.ReplayBuffer<T> call()
    {
      return null;
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    extends FlowableReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final Scheduler scheduler;
    final TimeUnit unit;
    
    SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.scheduler = paramScheduler;
      this.limit = paramInt;
      this.maxAge = paramLong;
      this.unit = paramTimeUnit;
    }
    
    Object enterTransform(Object paramObject)
    {
      return null;
    }
    
    FlowableReplay.Node getHead()
    {
      return null;
    }
    
    Object leaveTransform(Object paramObject)
    {
      return ((Timed)paramObject).value();
    }
    
    /* Error */
    void truncate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void truncateFinal()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SizeBoundReplayBuffer<T>
    extends FlowableReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;
    
    SizeBoundReplayBuffer(int paramInt)
    {
      this.limit = paramInt;
    }
    
    /* Error */
    void truncate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class UnboundedReplayBuffer<T>
    extends ArrayList<Object>
    implements FlowableReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;
    
    UnboundedReplayBuffer(int paramInt)
    {
      super();
    }
    
    /* Error */
    public void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void error(Throwable paramThrowable)
    {
      add(NotificationLite.error(paramThrowable));
      this.size += 1;
    }
    
    public void next(T paramT)
    {
      add(NotificationLite.next(paramT));
      this.size += 1;
    }
    
    /* Error */
    public void replay(FlowableReplay.InnerSubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */