package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.observables.ConnectableObservable;
import dji.thirdparty.rx.schedulers.Timestamped;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorReplay<T>
  extends ConnectableObservable<T>
{
  static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0()
  {
    public Object call()
    {
      return new OperatorReplay.UnboundedReplayBuffer(16);
    }
  };
  final Func0<? extends ReplayBuffer<T>> bufferFactory;
  final AtomicReference<ReplaySubscriber<T>> current;
  final Observable<? extends T> source;
  
  private OperatorReplay(Observable.OnSubscribe<T> paramOnSubscribe, Observable<? extends T> paramObservable, AtomicReference<ReplaySubscriber<T>> paramAtomicReference, Func0<? extends ReplayBuffer<T>> paramFunc0)
  {
    super(paramOnSubscribe);
    this.source = paramObservable;
    this.current = paramAtomicReference;
    this.bufferFactory = paramFunc0;
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable)
  {
    return create(paramObservable, DEFAULT_UNBOUNDED_FACTORY);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return create(paramObservable);
    }
    create(paramObservable, new Func0()
    {
      public OperatorReplay.ReplayBuffer<T> call()
      {
        return new OperatorReplay.SizeBoundReplayBuffer(this.val$bufferSize);
      }
    });
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(paramObservable, paramLong, paramTimeUnit, paramScheduler, Integer.MAX_VALUE);
  }
  
  public static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    create(paramObservable, new Func0()
    {
      public OperatorReplay.ReplayBuffer<T> call()
      {
        return null;
      }
    });
  }
  
  static <T> ConnectableObservable<T> create(Observable<? extends T> paramObservable, final Func0<? extends ReplayBuffer<T>> paramFunc0)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    new OperatorReplay(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }, paramObservable, localAtomicReference, paramFunc0);
  }
  
  public static <T, U, R> Observable<R> multicastSelector(Func0<? extends ConnectableObservable<U>> paramFunc0, final Func1<? super Observable<U>, ? extends Observable<R>> paramFunc1)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super R> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
  }
  
  public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> paramConnectableObservable, Scheduler paramScheduler)
  {
    new ConnectableObservable(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    })
    {
      public void connect(Action1<? super Subscription> paramAnonymousAction1)
      {
        paramConnectableObservable.connect(paramAnonymousAction1);
      }
    };
  }
  
  /* Error */
  public void connect(Action1<? super Subscription> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class BoundedReplayBuffer<T>
    extends AtomicReference<OperatorReplay.Node>
    implements OperatorReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    final NotificationLite<T> nl = NotificationLite.instance();
    int size;
    OperatorReplay.Node tail;
    
    public BoundedReplayBuffer()
    {
      OperatorReplay.Node localNode = new OperatorReplay.Node(null, 0L);
      this.tail = localNode;
      set(localNode);
    }
    
    /* Error */
    final void addLast(OperatorReplay.Node arg1)
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
    public final void replay(OperatorReplay.InnerProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final void setFirst(OperatorReplay.Node paramNode)
    {
      set(paramNode);
    }
    
    void truncate() {}
    
    void truncateFinal() {}
  }
  
  static final class InnerProducer<T>
    extends AtomicLong
    implements Producer, Subscription
  {
    static final long UNSUBSCRIBED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    final Subscriber<? super T> child;
    boolean emitting;
    Object index;
    boolean missed;
    final OperatorReplay.ReplaySubscriber<T> parent;
    final AtomicLong totalRequested;
    
    public InnerProducer(OperatorReplay.ReplaySubscriber<T> paramReplaySubscriber, Subscriber<? super T> paramSubscriber)
    {
      this.parent = paramReplaySubscriber;
      this.child = paramSubscriber;
      this.totalRequested = new AtomicLong();
    }
    
    /* Error */
    void addTotalRequested(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    <U> U index()
    {
      return (U)this.index;
    }
    
    public boolean isUnsubscribed()
    {
      return false;
    }
    
    public long produced(long paramLong)
    {
      return 277874083L;
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
  
  static final class Node
    extends AtomicReference<Node>
  {
    private static final long serialVersionUID = 245354315435971818L;
    final long index;
    final Object value;
    
    public Node(Object paramObject, long paramLong)
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
    
    public abstract void replay(OperatorReplay.InnerProducer<T> paramInnerProducer);
  }
  
  static final class ReplaySubscriber<T>
    extends Subscriber<T>
    implements Subscription
  {
    static final OperatorReplay.InnerProducer[] EMPTY = new OperatorReplay.InnerProducer[0];
    static final OperatorReplay.InnerProducer[] TERMINATED = new OperatorReplay.InnerProducer[0];
    final OperatorReplay.ReplayBuffer<T> buffer;
    boolean done;
    boolean emitting;
    long maxChildRequested;
    long maxUpstreamRequested;
    boolean missed;
    final NotificationLite<T> nl;
    volatile Producer producer;
    final AtomicReference<OperatorReplay.InnerProducer[]> producers;
    final AtomicBoolean shouldConnect;
    
    public ReplaySubscriber(AtomicReference<ReplaySubscriber<T>> paramAtomicReference, OperatorReplay.ReplayBuffer<T> paramReplayBuffer)
    {
      this.buffer = paramReplayBuffer;
      this.nl = NotificationLite.instance();
      this.producers = new AtomicReference(EMPTY);
      this.shouldConnect = new AtomicBoolean();
      request(0L);
    }
    
    boolean add(OperatorReplay.InnerProducer<T> paramInnerProducer)
    {
      return false;
    }
    
    /* Error */
    void init()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void manageRequests()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void remove(OperatorReplay.InnerProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void replay()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setProducer(Producer arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    extends OperatorReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAgeInMillis;
    final Scheduler scheduler;
    
    public SizeAndTimeBoundReplayBuffer(int paramInt, long paramLong, Scheduler paramScheduler)
    {
      this.scheduler = paramScheduler;
      this.limit = paramInt;
      this.maxAgeInMillis = paramLong;
    }
    
    Object enterTransform(Object paramObject)
    {
      return null;
    }
    
    Object leaveTransform(Object paramObject)
    {
      return ((Timestamped)paramObject).getValue();
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
    extends OperatorReplay.BoundedReplayBuffer<T>
  {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;
    
    public SizeBoundReplayBuffer(int paramInt)
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
    implements OperatorReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 7063189396499112664L;
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile int size;
    
    public UnboundedReplayBuffer(int paramInt)
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
    
    /* Error */
    public void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    public void replay(OperatorReplay.InnerProducer<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorReplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */