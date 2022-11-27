package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V>
  extends AbstractObservableWithUpstream<T, Observable<T>>
{
  final int bufferSize;
  final Function<? super B, ? extends ObservableSource<V>> close;
  final ObservableSource<B> open;
  
  public ObservableWindowBoundarySelector(ObservableSource<T> paramObservableSource, ObservableSource<B> paramObservableSource1, Function<? super B, ? extends ObservableSource<V>> paramFunction, int paramInt)
  {
    super(paramObservableSource);
    this.open = paramObservableSource1;
    this.close = paramFunction;
    this.bufferSize = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Observable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OperatorWindowBoundaryCloseObserver<T, V>
    extends DisposableObserver<V>
  {
    boolean done;
    final ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> parent;
    final UnicastSubject<T> w;
    
    OperatorWindowBoundaryCloseObserver(ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, ?, V> paramWindowBoundaryMainObserver, UnicastSubject<T> paramUnicastSubject)
    {
      this.parent = paramWindowBoundaryMainObserver;
      this.w = paramUnicastSubject;
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
    
    public void onNext(V paramV)
    {
      dispose();
      onComplete();
    }
  }
  
  static final class OperatorWindowBoundaryOpenObserver<T, B>
    extends DisposableObserver<B>
  {
    final ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> parent;
    
    OperatorWindowBoundaryOpenObserver(ObservableWindowBoundarySelector.WindowBoundaryMainObserver<T, B, ?> paramWindowBoundaryMainObserver)
    {
      this.parent = paramWindowBoundaryMainObserver;
    }
    
    public void onComplete()
    {
      this.parent.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.parent.open(paramB);
    }
  }
  
  static final class WindowBoundaryMainObserver<T, B, V>
    extends QueueDrainObserver<T, Object, Observable<T>>
    implements Disposable
  {
    final AtomicReference<Disposable> boundary = new AtomicReference();
    final int bufferSize;
    final Function<? super B, ? extends ObservableSource<V>> close;
    final ObservableSource<B> open;
    final CompositeDisposable resources;
    final AtomicBoolean stopWindows = new AtomicBoolean();
    Disposable upstream;
    final AtomicLong windows = new AtomicLong();
    final List<UnicastSubject<T>> ws;
    
    WindowBoundaryMainObserver(Observer<? super Observable<T>> paramObserver, ObservableSource<B> paramObservableSource, Function<? super B, ? extends ObservableSource<V>> paramFunction, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.open = paramObservableSource;
      this.close = paramFunction;
      this.bufferSize = paramInt;
      this.resources = new CompositeDisposable();
      this.ws = new ArrayList();
      this.windows.lazySet(1L);
    }
    
    public void accept(Observer<? super Observable<T>> paramObserver, Object paramObject) {}
    
    /* Error */
    void close(ObservableWindowBoundarySelector.OperatorWindowBoundaryCloseObserver<T, V> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    void disposeBoundary()
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
    
    /* Error */
    void error(Throwable arg1)
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
    void open(B arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class WindowOperation<T, B>
  {
    final B open;
    final UnicastSubject<T> w;
    
    WindowOperation(UnicastSubject<T> paramUnicastSubject, B paramB)
    {
      this.w = paramUnicastSubject;
      this.open = paramB;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWindowBoundarySelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */