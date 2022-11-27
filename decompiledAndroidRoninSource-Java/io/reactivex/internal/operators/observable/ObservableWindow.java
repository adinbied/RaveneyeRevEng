package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T>
  extends AbstractObservableWithUpstream<T, Observable<T>>
{
  final int capacityHint;
  final long count;
  final long skip;
  
  public ObservableWindow(ObservableSource<T> paramObservableSource, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramObservableSource);
    this.count = paramLong1;
    this.skip = paramLong2;
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
  
  static final class WindowExactObserver<T>
    extends AtomicInteger
    implements Observer<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = -7481782523886138128L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final Observer<? super Observable<T>> downstream;
    long size;
    Disposable upstream;
    UnicastSubject<T> window;
    
    WindowExactObserver(Observer<? super Observable<T>> paramObserver, long paramLong, int paramInt)
    {
      this.downstream = paramObserver;
      this.count = paramLong;
      this.capacityHint = paramInt;
    }
    
    public void dispose()
    {
      this.cancelled = true;
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
  
  static final class WindowSkipObserver<T>
    extends AtomicBoolean
    implements Observer<T>, Disposable, Runnable
  {
    private static final long serialVersionUID = 3366976432059579510L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final Observer<? super Observable<T>> downstream;
    long firstEmission;
    long index;
    final long skip;
    Disposable upstream;
    final ArrayDeque<UnicastSubject<T>> windows;
    final AtomicInteger wip = new AtomicInteger();
    
    WindowSkipObserver(Observer<? super Observable<T>> paramObserver, long paramLong1, long paramLong2, int paramInt)
    {
      this.downstream = paramObserver;
      this.count = paramLong1;
      this.skip = paramLong2;
      this.capacityHint = paramInt;
      this.windows = new ArrayDeque();
    }
    
    public void dispose()
    {
      this.cancelled = true;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */