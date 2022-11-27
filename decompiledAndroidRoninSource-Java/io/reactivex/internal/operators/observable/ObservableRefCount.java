package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T>
  extends Observable<T>
{
  RefConnection connection;
  final int n;
  final Scheduler scheduler;
  final ConnectableObservable<T> source;
  final long timeout;
  final TimeUnit unit;
  
  public ObservableRefCount(ConnectableObservable<T> paramConnectableObservable)
  {
    this(paramConnectableObservable, 1, 0L, TimeUnit.NANOSECONDS, null);
  }
  
  public ObservableRefCount(ConnectableObservable<T> paramConnectableObservable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.source = paramConnectableObservable;
    this.n = paramInt;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  void cancel(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void terminated(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void timeout(RefConnection arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class RefConnection
    extends AtomicReference<Disposable>
    implements Runnable, Consumer<Disposable>
  {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final ObservableRefCount<?> parent;
    long subscriberCount;
    Disposable timer;
    
    RefConnection(ObservableRefCount<?> paramObservableRefCount)
    {
      this.parent = paramObservableRefCount;
    }
    
    /* Error */
    public void accept(Disposable arg1)
      throws java.lang.Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void run()
    {
      this.parent.timeout(this);
    }
  }
  
  static final class RefCountObserver<T>
    extends AtomicBoolean
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -7419642935409022375L;
    final ObservableRefCount.RefConnection connection;
    final Observer<? super T> downstream;
    final ObservableRefCount<T> parent;
    Disposable upstream;
    
    RefCountObserver(Observer<? super T> paramObserver, ObservableRefCount<T> paramObservableRefCount, ObservableRefCount.RefConnection paramRefConnection)
    {
      this.downstream = paramObserver;
      this.parent = paramObservableRefCount;
      this.connection = paramRefConnection;
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
      return this.upstream.isDisposed();
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRefCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */