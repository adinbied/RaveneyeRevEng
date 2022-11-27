package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U>
  extends AbstractObservableWithUpstream<T, U>
{
  final int bufferSize;
  final boolean delayErrors;
  final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
  final int maxConcurrency;
  
  public ObservableFlatMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.bufferSize = paramInt2;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class InnerObserver<T, U>
    extends AtomicReference<Disposable>
    implements Observer<U>
  {
    private static final long serialVersionUID = -4606175640614850599L;
    volatile boolean done;
    int fusionMode;
    final long id;
    final ObservableFlatMap.MergeObserver<T, U> parent;
    volatile SimpleQueue<U> queue;
    
    InnerObserver(ObservableFlatMap.MergeObserver<T, U> paramMergeObserver, long paramLong)
    {
      this.id = paramLong;
      this.parent = paramMergeObserver;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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
    public void onNext(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class MergeObserver<T, U>
    extends AtomicInteger
    implements Disposable, Observer<T>
  {
    static final ObservableFlatMap.InnerObserver<?, ?>[] CANCELLED = new ObservableFlatMap.InnerObserver[0];
    static final ObservableFlatMap.InnerObserver<?, ?>[] EMPTY = new ObservableFlatMap.InnerObserver[0];
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Observer<? super U> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    final int maxConcurrency;
    final AtomicReference<ObservableFlatMap.InnerObserver<?, ?>[]> observers;
    volatile SimplePlainQueue<U> queue;
    Queue<ObservableSource<? extends U>> sources;
    long uniqueId;
    Disposable upstream;
    int wip;
    
    MergeObserver(Observer<? super U> paramObserver, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.delayErrors = paramBoolean;
      this.maxConcurrency = paramInt1;
      this.bufferSize = paramInt2;
      if (paramInt1 != Integer.MAX_VALUE) {
        this.sources = new ArrayDeque(paramInt1);
      }
      this.observers = new AtomicReference(EMPTY);
    }
    
    boolean addInner(ObservableFlatMap.InnerObserver<T, U> paramInnerObserver)
    {
      return false;
    }
    
    boolean checkTerminate()
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
    
    boolean disposeAll()
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
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void removeInner(ObservableFlatMap.InnerObserver<T, U> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void subscribeInner(ObservableSource<? extends U> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void tryEmit(U arg1, ObservableFlatMap.InnerObserver<T, U> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean tryEmitScalar(Callable<? extends U> paramCallable)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */