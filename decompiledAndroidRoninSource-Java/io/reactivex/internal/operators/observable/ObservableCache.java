package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T>
  extends AbstractObservableWithUpstream<T, T>
  implements Observer<T>
{
  static final CacheDisposable[] EMPTY = new CacheDisposable[0];
  static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
  final int capacityHint;
  volatile boolean done;
  Throwable error;
  final Node<T> head;
  final AtomicReference<CacheDisposable<T>[]> observers;
  final AtomicBoolean once;
  volatile long size;
  Node<T> tail;
  int tailOffset;
  
  public ObservableCache(Observable<T> paramObservable, int paramInt)
  {
    super(paramObservable);
    this.capacityHint = paramInt;
    this.once = new AtomicBoolean();
    paramObservable = new Node(paramInt);
    this.head = paramObservable;
    this.tail = paramObservable;
    this.observers = new AtomicReference(EMPTY);
  }
  
  /* Error */
  void add(CacheDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  long cachedEventCount()
  {
    return this.size;
  }
  
  boolean hasObservers()
  {
    return false;
  }
  
  boolean isConnected()
  {
    return this.once.get();
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
  
  public void onSubscribe(Disposable paramDisposable) {}
  
  /* Error */
  void remove(CacheDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void replay(CacheDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CacheDisposable<T>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = 6770240836423125754L;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    long index;
    ObservableCache.Node<T> node;
    int offset;
    final ObservableCache<T> parent;
    
    CacheDisposable(Observer<? super T> paramObserver, ObservableCache<T> paramObservableCache)
    {
      this.downstream = paramObserver;
      this.parent = paramObservableCache;
      this.node = paramObservableCache.head;
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
      return this.disposed;
    }
  }
  
  static final class Node<T>
  {
    volatile Node<T> next;
    final T[] values;
    
    Node(int paramInt)
    {
      this.values = ((Object[])new Object[paramInt]);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */