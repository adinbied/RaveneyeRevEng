package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundary<T, B>
  extends AbstractObservableWithUpstream<T, Observable<T>>
{
  final int capacityHint;
  final ObservableSource<B> other;
  
  public ObservableWindowBoundary(ObservableSource<T> paramObservableSource, ObservableSource<B> paramObservableSource1, int paramInt)
  {
    super(paramObservableSource);
    this.other = paramObservableSource1;
    this.capacityHint = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Observable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WindowBoundaryInnerObserver<T, B>
    extends DisposableObserver<B>
  {
    boolean done;
    final ObservableWindowBoundary.WindowBoundaryMainObserver<T, B> parent;
    
    WindowBoundaryInnerObserver(ObservableWindowBoundary.WindowBoundaryMainObserver<T, B> paramWindowBoundaryMainObserver)
    {
      this.parent = paramWindowBoundaryMainObserver;
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
    
    public void onNext(B paramB)
    {
      if (this.done) {
        return;
      }
      this.parent.innerNext();
    }
  }
  
  static final class WindowBoundaryMainObserver<T, B>
    extends AtomicInteger
    implements Observer<T>, Disposable, Runnable
  {
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final ObservableWindowBoundary.WindowBoundaryInnerObserver<T, B> boundaryObserver;
    final int capacityHint;
    volatile boolean done;
    final Observer<? super Observable<T>> downstream;
    final AtomicThrowable errors;
    final MpscLinkedQueue<Object> queue;
    final AtomicBoolean stopWindows;
    final AtomicReference<Disposable> upstream;
    UnicastSubject<T> window;
    final AtomicInteger windows;
    
    WindowBoundaryMainObserver(Observer<? super Observable<T>> paramObserver, int paramInt)
    {
      this.downstream = paramObserver;
      this.capacityHint = paramInt;
      this.boundaryObserver = new ObservableWindowBoundary.WindowBoundaryInnerObserver(this);
      this.upstream = new AtomicReference();
      this.windows = new AtomicInteger(1);
      this.queue = new MpscLinkedQueue();
      this.errors = new AtomicThrowable();
      this.stopWindows = new AtomicBoolean();
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
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.stopWindows.get();
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWindowBoundary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */