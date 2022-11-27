package dji.thirdparty.rx.subjects;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.operators.NotificationLite;
import dji.thirdparty.rx.internal.util.UtilityFunctions;
import dji.thirdparty.rx.schedulers.Timestamped;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ReplaySubject<T>
  extends Subject<T, T>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  final SubjectSubscriptionManager<T> ssm;
  final ReplayState<T, ?> state;
  
  ReplaySubject(Observable.OnSubscribe<T> paramOnSubscribe, SubjectSubscriptionManager<T> paramSubjectSubscriptionManager, ReplayState<T, ?> paramReplayState)
  {
    super(paramOnSubscribe);
    this.ssm = paramSubjectSubscriptionManager;
    this.state = paramReplayState;
  }
  
  private boolean caughtUp(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
  {
    return false;
  }
  
  public static <T> ReplaySubject<T> create()
  {
    return create(16);
  }
  
  public static <T> ReplaySubject<T> create(int paramInt)
  {
    UnboundedReplayState localUnboundedReplayState = new UnboundedReplayState(paramInt);
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    localSubjectSubscriptionManager.onAdded = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
    localSubjectSubscriptionManager.onTerminated = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, localUnboundedReplayState);
  }
  
  static <T> ReplaySubject<T> createUnbounded()
  {
    BoundedState localBoundedState = new BoundedState(new EmptyEvictionPolicy(), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  public static <T> ReplaySubject<T> createWithSize(int paramInt)
  {
    BoundedState localBoundedState = new BoundedState(new SizeEvictionPolicy(paramInt), UtilityFunctions.identity(), UtilityFunctions.identity());
    return createWithState(localBoundedState, new DefaultOnAdd(localBoundedState));
  }
  
  static <T> ReplaySubject<T> createWithState(BoundedState<T> paramBoundedState, Action1<SubjectSubscriptionManager.SubjectObserver<T>> paramAction1)
  {
    SubjectSubscriptionManager localSubjectSubscriptionManager = new SubjectSubscriptionManager();
    localSubjectSubscriptionManager.onStart = paramAction1;
    localSubjectSubscriptionManager.onAdded = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
    localSubjectSubscriptionManager.onTerminated = new Action1()
    {
      /* Error */
      public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
    return new ReplaySubject(localSubjectSubscriptionManager, localSubjectSubscriptionManager, paramBoundedState);
  }
  
  public static <T> ReplaySubject<T> createWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  public static <T> ReplaySubject<T> createWithTimeAndSize(long paramLong, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    paramTimeUnit = new BoundedState(new PairEvictionPolicy(new SizeEvictionPolicy(paramInt), new TimeEvictionPolicy(paramTimeUnit.toMillis(paramLong), paramScheduler)), new AddTimestamped(paramScheduler), new RemoveTimestamped());
    return createWithState(paramTimeUnit, new TimedOnAdd(paramTimeUnit, paramScheduler));
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return (T)this.state.latest();
  }
  
  public Object[] getValues()
  {
    return null;
  }
  
  public T[] getValues(T[] paramArrayOfT)
  {
    return this.state.toArray(paramArrayOfT);
  }
  
  public boolean hasAnyValue()
  {
    return false;
  }
  
  public boolean hasCompleted()
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
    return hasAnyValue();
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
  
  public int size()
  {
    return this.state.size();
  }
  
  int subscriberCount()
  {
    return 0;
  }
  
  static final class AddTimestamped
    implements Func1<Object, Object>
  {
    final Scheduler scheduler;
    
    public AddTimestamped(Scheduler paramScheduler)
    {
      this.scheduler = paramScheduler;
    }
    
    public Object call(Object paramObject)
    {
      return null;
    }
  }
  
  static final class BoundedState<T>
    implements ReplaySubject.ReplayState<T, ReplaySubject.NodeList.Node<Object>>
  {
    final Func1<Object, Object> enterTransform;
    final ReplaySubject.EvictionPolicy evictionPolicy;
    final Func1<Object, Object> leaveTransform;
    final ReplaySubject.NodeList<Object> list;
    final NotificationLite<T> nl = NotificationLite.instance();
    volatile ReplaySubject.NodeList.Node<Object> tail;
    volatile boolean terminated;
    
    public BoundedState(ReplaySubject.EvictionPolicy paramEvictionPolicy, Func1<Object, Object> paramFunc11, Func1<Object, Object> paramFunc12)
    {
      ReplaySubject.NodeList localNodeList = new ReplaySubject.NodeList();
      this.list = localNodeList;
      this.tail = localNodeList.tail;
      this.evictionPolicy = paramEvictionPolicy;
      this.enterTransform = paramFunc11;
      this.leaveTransform = paramFunc12;
    }
    
    /* Error */
    public void accept(dji.thirdparty.rx.Observer<? super T> arg1, ReplaySubject.NodeList.Node<Object> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void acceptTest(dji.thirdparty.rx.Observer<? super T> arg1, ReplaySubject.NodeList.Node<Object> arg2, long arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    public ReplaySubject.NodeList.Node<Object> head()
    {
      return this.list.head;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public T latest()
    {
      return null;
    }
    
    /* Error */
    public void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      return false;
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndex(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      return null;
    }
    
    public ReplaySubject.NodeList.Node<Object> replayObserverFromIndexTest(ReplaySubject.NodeList.Node<Object> paramNode, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      return null;
    }
    
    public int size()
    {
      return 0;
    }
    
    public ReplaySubject.NodeList.Node<Object> tail()
    {
      return this.tail;
    }
    
    public boolean terminated()
    {
      return this.terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      return null;
    }
  }
  
  static final class DefaultOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final ReplaySubject.BoundedState<T> state;
    
    public DefaultOnAdd(ReplaySubject.BoundedState<T> paramBoundedState)
    {
      this.state = paramBoundedState;
    }
    
    /* Error */
    public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class EmptyEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    public void evict(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList) {}
    
    public boolean test(Object paramObject, long paramLong)
    {
      return true;
    }
  }
  
  static abstract interface EvictionPolicy
  {
    public abstract void evict(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract void evictFinal(ReplaySubject.NodeList<Object> paramNodeList);
    
    public abstract boolean test(Object paramObject, long paramLong);
  }
  
  static final class NodeList<T>
  {
    final Node<T> head;
    int size;
    Node<T> tail;
    
    NodeList()
    {
      Node localNode = new Node(null);
      this.head = localNode;
      this.tail = localNode;
    }
    
    /* Error */
    public void addLast(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      this.tail = this.head;
      this.size = 0;
    }
    
    public boolean isEmpty()
    {
      return this.size == 0;
    }
    
    public T removeFirst()
    {
      return null;
    }
    
    public int size()
    {
      return this.size;
    }
    
    static final class Node<T>
    {
      volatile Node<T> next;
      final T value;
      
      Node(T paramT)
      {
        this.value = paramT;
      }
    }
  }
  
  static final class PairEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final ReplaySubject.EvictionPolicy first;
    final ReplaySubject.EvictionPolicy second;
    
    public PairEvictionPolicy(ReplaySubject.EvictionPolicy paramEvictionPolicy1, ReplaySubject.EvictionPolicy paramEvictionPolicy2)
    {
      this.first = paramEvictionPolicy1;
      this.second = paramEvictionPolicy2;
    }
    
    /* Error */
    public void evict(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void evictFinal(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return false;
    }
  }
  
  static final class RemoveTimestamped
    implements Func1<Object, Object>
  {
    public Object call(Object paramObject)
    {
      return ((Timestamped)paramObject).getValue();
    }
  }
  
  static abstract interface ReplayState<T, I>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract boolean isEmpty();
    
    public abstract T latest();
    
    public abstract void next(T paramT);
    
    public abstract boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndex(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
    
    public abstract I replayObserverFromIndexTest(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong);
    
    public abstract int size();
    
    public abstract boolean terminated();
    
    public abstract T[] toArray(T[] paramArrayOfT);
  }
  
  static final class SizeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final int maxSize;
    
    public SizeEvictionPolicy(int paramInt)
    {
      this.maxSize = paramInt;
    }
    
    /* Error */
    public void evict(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void evictFinal(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return false;
    }
  }
  
  static final class TimeEvictionPolicy
    implements ReplaySubject.EvictionPolicy
  {
    final long maxAgeMillis;
    final Scheduler scheduler;
    
    public TimeEvictionPolicy(long paramLong, Scheduler paramScheduler)
    {
      this.maxAgeMillis = paramLong;
      this.scheduler = paramScheduler;
    }
    
    /* Error */
    public void evict(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void evictFinal(ReplaySubject.NodeList<Object> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean test(Object paramObject, long paramLong)
    {
      return false;
    }
  }
  
  static final class TimedOnAdd<T>
    implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
  {
    final Scheduler scheduler;
    final ReplaySubject.BoundedState<T> state;
    
    public TimedOnAdd(ReplaySubject.BoundedState<T> paramBoundedState, Scheduler paramScheduler)
    {
      this.state = paramBoundedState;
      this.scheduler = paramScheduler;
    }
    
    /* Error */
    public void call(SubjectSubscriptionManager.SubjectObserver<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class UnboundedReplayState<T>
    extends AtomicInteger
    implements ReplaySubject.ReplayState<T, Integer>
  {
    private final ArrayList<Object> list;
    private final NotificationLite<T> nl = NotificationLite.instance();
    private volatile boolean terminated;
    
    public UnboundedReplayState(int paramInt)
    {
      this.list = new ArrayList(paramInt);
    }
    
    /* Error */
    public void accept(dji.thirdparty.rx.Observer<? super T> arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public T latest()
    {
      return null;
    }
    
    /* Error */
    public void next(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      return false;
    }
    
    public Integer replayObserverFromIndex(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver)
    {
      return null;
    }
    
    public Integer replayObserverFromIndexTest(Integer paramInteger, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong)
    {
      return replayObserverFromIndex(paramInteger, paramSubjectObserver);
    }
    
    public int size()
    {
      return 0;
    }
    
    public boolean terminated()
    {
      return this.terminated;
    }
    
    public T[] toArray(T[] paramArrayOfT)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\subjects\ReplaySubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */