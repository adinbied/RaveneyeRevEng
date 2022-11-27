package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T>
  extends ConnectableObservable<T>
  implements HasUpstreamObservableSource<T>, ResettableConnectable
{
  static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
  final BufferSupplier<T> bufferFactory;
  final AtomicReference<ReplayObserver<T>> current;
  final ObservableSource<T> onSubscribe;
  final ObservableSource<T> source;
  
  private ObservableReplay(ObservableSource<T> paramObservableSource1, ObservableSource<T> paramObservableSource2, AtomicReference<ReplayObserver<T>> paramAtomicReference, BufferSupplier<T> paramBufferSupplier)
  {
    this.onSubscribe = paramObservableSource1;
    this.source = paramObservableSource2;
    this.current = paramAtomicReference;
    this.bufferFactory = paramBufferSupplier;
  }
  
  public static <T> ConnectableObservable<T> create(ObservableSource<T> paramObservableSource, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return createFrom(paramObservableSource);
    }
    return create(paramObservableSource, new ReplayBufferSupplier(paramInt));
  }
  
  public static <T> ConnectableObservable<T> create(ObservableSource<T> paramObservableSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return create(paramObservableSource, paramLong, paramTimeUnit, paramScheduler, Integer.MAX_VALUE);
  }
  
  public static <T> ConnectableObservable<T> create(ObservableSource<T> paramObservableSource, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
  {
    return create(paramObservableSource, new ScheduledReplaySupplier(paramInt, paramLong, paramTimeUnit, paramScheduler));
  }
  
  static <T> ConnectableObservable<T> create(ObservableSource<T> paramObservableSource, BufferSupplier<T> paramBufferSupplier)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return RxJavaPlugins.onAssembly(new ObservableReplay(new ReplaySource(localAtomicReference, paramBufferSupplier), paramObservableSource, localAtomicReference, paramBufferSupplier));
  }
  
  public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> paramObservableSource)
  {
    return create(paramObservableSource, DEFAULT_UNBOUNDED_FACTORY);
  }
  
  public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> paramCallable, Function<? super Observable<U>, ? extends ObservableSource<R>> paramFunction)
  {
    return RxJavaPlugins.onAssembly(new MulticastReplay(paramCallable, paramFunction));
  }
  
  public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> paramConnectableObservable, Scheduler paramScheduler)
  {
    return RxJavaPlugins.onAssembly(new Replay(paramConnectableObservable, paramConnectableObservable.observeOn(paramScheduler)));
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
  
  public ObservableSource<T> source()
  {
    return this.source;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver)
  {
    this.onSubscribe.subscribe(paramObserver);
  }
  
  static abstract class BoundedReplayBuffer<T>
    extends AtomicReference<ObservableReplay.Node>
    implements ObservableReplay.ReplayBuffer<T>
  {
    private static final long serialVersionUID = 2346567790059478686L;
    int size;
    ObservableReplay.Node tail;
    
    BoundedReplayBuffer()
    {
      ObservableReplay.Node localNode = new ObservableReplay.Node(null);
      this.tail = localNode;
      set(localNode);
    }
    
    /* Error */
    final void addLast(ObservableReplay.Node arg1)
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
    
    ObservableReplay.Node getHead()
    {
      return (ObservableReplay.Node)get();
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
    public final void replay(ObservableReplay.InnerDisposable<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final void setFirst(ObservableReplay.Node paramNode)
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
    
    abstract void truncate();
    
    void truncateFinal()
    {
      trimHead();
    }
  }
  
  static abstract interface BufferSupplier<T>
  {
    public abstract ObservableReplay.ReplayBuffer<T> call();
  }
  
  static final class DisposeConsumer<R>
    implements Consumer<Disposable>
  {
    private final ObserverResourceWrapper<R> srw;
    
    DisposeConsumer(ObserverResourceWrapper<R> paramObserverResourceWrapper)
    {
      this.srw = paramObserverResourceWrapper;
    }
    
    public void accept(Disposable paramDisposable)
    {
      this.srw.setResource(paramDisposable);
    }
  }
  
  static final class InnerDisposable<T>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = 2728361546769921047L;
    volatile boolean cancelled;
    final Observer<? super T> child;
    Object index;
    final ObservableReplay.ReplayObserver<T> parent;
    
    InnerDisposable(ObservableReplay.ReplayObserver<T> paramReplayObserver, Observer<? super T> paramObserver)
    {
      this.parent = paramReplayObserver;
      this.child = paramObserver;
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
      return this.cancelled;
    }
  }
  
  static final class MulticastReplay<R, U>
    extends Observable<R>
  {
    private final Callable<? extends ConnectableObservable<U>> connectableFactory;
    private final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;
    
    MulticastReplay(Callable<? extends ConnectableObservable<U>> paramCallable, Function<? super Observable<U>, ? extends ObservableSource<R>> paramFunction)
    {
      this.connectableFactory = paramCallable;
      this.selector = paramFunction;
    }
    
    /* Error */
    protected void subscribeActual(Observer<? super R> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class Node
    extends AtomicReference<Node>
  {
    private static final long serialVersionUID = 245354315435971818L;
    final Object value;
    
    Node(Object paramObject)
    {
      this.value = paramObject;
    }
  }
  
  static final class Replay<T>
    extends ConnectableObservable<T>
  {
    private final ConnectableObservable<T> co;
    private final Observable<T> observable;
    
    Replay(ConnectableObservable<T> paramConnectableObservable, Observable<T> paramObservable)
    {
      this.co = paramConnectableObservable;
      this.observable = paramObservable;
    }
    
    public void connect(Consumer<? super Disposable> paramConsumer)
    {
      this.co.connect(paramConsumer);
    }
    
    protected void subscribeActual(Observer<? super T> paramObserver)
    {
      this.observable.subscribe(paramObserver);
    }
  }
  
  static abstract interface ReplayBuffer<T>
  {
    public abstract void complete();
    
    public abstract void error(Throwable paramThrowable);
    
    public abstract void next(T paramT);
    
    public abstract void replay(ObservableReplay.InnerDisposable<T> paramInnerDisposable);
  }
  
  static final class ReplayBufferSupplier<T>
    implements ObservableReplay.BufferSupplier<T>
  {
    private final int bufferSize;
    
    ReplayBufferSupplier(int paramInt)
    {
      this.bufferSize = paramInt;
    }
    
    public ObservableReplay.ReplayBuffer<T> call()
    {
      return new ObservableReplay.SizeBoundReplayBuffer(this.bufferSize);
    }
  }
  
  static final class ReplayObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, Disposable
  {
    static final ObservableReplay.InnerDisposable[] EMPTY = new ObservableReplay.InnerDisposable[0];
    static final ObservableReplay.InnerDisposable[] TERMINATED = new ObservableReplay.InnerDisposable[0];
    private static final long serialVersionUID = -533785617179540163L;
    final ObservableReplay.ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ObservableReplay.InnerDisposable[]> observers;
    final AtomicBoolean shouldConnect;
    
    ReplayObserver(ObservableReplay.ReplayBuffer<T> paramReplayBuffer)
    {
      this.buffer = paramReplayBuffer;
      this.observers = new AtomicReference(EMPTY);
      this.shouldConnect = new AtomicBoolean();
    }
    
    boolean add(ObservableReplay.InnerDisposable<T> paramInnerDisposable)
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
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        replay();
      }
    }
    
    /* Error */
    void remove(ObservableReplay.InnerDisposable<T> arg1)
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
    void replayFinal()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ReplaySource<T>
    implements ObservableSource<T>
  {
    private final ObservableReplay.BufferSupplier<T> bufferFactory;
    private final AtomicReference<ObservableReplay.ReplayObserver<T>> curr;
    
    ReplaySource(AtomicReference<ObservableReplay.ReplayObserver<T>> paramAtomicReference, ObservableReplay.BufferSupplier<T> paramBufferSupplier)
    {
      this.curr = paramAtomicReference;
      this.bufferFactory = paramBufferSupplier;
    }
    
    /* Error */
    public void subscribe(Observer<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ScheduledReplaySupplier<T>
    implements ObservableReplay.BufferSupplier<T>
  {
    private final int bufferSize;
    private final long maxAge;
    private final Scheduler scheduler;
    private final TimeUnit unit;
    
    ScheduledReplaySupplier(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.bufferSize = paramInt;
      this.maxAge = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public ObservableReplay.ReplayBuffer<T> call()
    {
      return null;
    }
  }
  
  static final class SizeAndTimeBoundReplayBuffer<T>
    extends ObservableReplay.BoundedReplayBuffer<T>
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
    
    ObservableReplay.Node getHead()
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
    extends ObservableReplay.BoundedReplayBuffer<T>
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
  
  static final class UnBoundedFactory
    implements ObservableReplay.BufferSupplier<Object>
  {
    public ObservableReplay.ReplayBuffer<Object> call()
    {
      return new ObservableReplay.UnboundedReplayBuffer(16);
    }
  }
  
  static final class UnboundedReplayBuffer<T>
    extends ArrayList<Object>
    implements ObservableReplay.ReplayBuffer<T>
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
    public void replay(ObservableReplay.InnerDisposable<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableReplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */