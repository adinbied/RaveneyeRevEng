package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
  final int maxConcurrency;
  final int prefetch;
  
  public ObservableConcatMapEager(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, ErrorMode paramErrorMode, int paramInt1, int paramInt2)
  {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.errorMode = paramErrorMode;
    this.maxConcurrency = paramInt1;
    this.prefetch = paramInt2;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapEagerMainObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable, InnerQueuedObserverSupport<R>
  {
    private static final long serialVersionUID = 8080567949447303262L;
    int activeCount;
    volatile boolean cancelled;
    InnerQueuedObserver<R> current;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final ErrorMode errorMode;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final int maxConcurrency;
    final ArrayDeque<InnerQueuedObserver<R>> observers;
    final int prefetch;
    SimpleQueue<T> queue;
    int sourceMode;
    Disposable upstream;
    
    ConcatMapEagerMainObserver(Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt1, int paramInt2, ErrorMode paramErrorMode)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.maxConcurrency = paramInt1;
      this.prefetch = paramInt2;
      this.errorMode = paramErrorMode;
      this.error = new AtomicThrowable();
      this.observers = new ArrayDeque();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void disposeAll()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drainAndDispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void innerComplete(InnerQueuedObserver<R> paramInnerQueuedObserver)
    {
      paramInnerQueuedObserver.setDone();
      drain();
    }
    
    /* Error */
    public void innerError(InnerQueuedObserver<R> arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void innerNext(InnerQueuedObserver<R> paramInnerQueuedObserver, R paramR)
    {
      paramInnerQueuedObserver.queue().offer(paramR);
      drain();
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableConcatMapEager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */