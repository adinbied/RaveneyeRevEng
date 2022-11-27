package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V>
  extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>>
{
  final int bufferSize;
  final boolean delayError;
  final Function<? super T, ? extends K> keySelector;
  final Function<? super T, ? extends V> valueSelector;
  
  public ObservableGroupBy(ObservableSource<T> paramObservableSource, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, int paramInt, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.keySelector = paramFunction;
    this.valueSelector = paramFunction1;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super GroupedObservable<K, V>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static final class GroupByObserver<T, K, V>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    final Observer<? super GroupedObservable<K, V>> downstream;
    final Map<Object, ObservableGroupBy.GroupedUnicast<K, V>> groups;
    final Function<? super T, ? extends K> keySelector;
    Disposable upstream;
    final Function<? super T, ? extends V> valueSelector;
    
    public GroupByObserver(Observer<? super GroupedObservable<K, V>> paramObserver, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.keySelector = paramFunction;
      this.valueSelector = paramFunction1;
      this.bufferSize = paramInt;
      this.delayError = paramBoolean;
      this.groups = new ConcurrentHashMap();
      lazySet(1);
    }
    
    /* Error */
    public void cancel(K arg1)
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
    
    public boolean isDisposed()
    {
      return this.cancelled.get();
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
  }
  
  static final class GroupedUnicast<K, T>
    extends GroupedObservable<K, T>
  {
    final ObservableGroupBy.State<T, K> state;
    
    protected GroupedUnicast(K paramK, ObservableGroupBy.State<T, K> paramState)
    {
      super();
      this.state = paramState;
    }
    
    public static <T, K> GroupedUnicast<K, T> createWith(K paramK, int paramInt, ObservableGroupBy.GroupByObserver<?, K, T> paramGroupByObserver, boolean paramBoolean)
    {
      return new GroupedUnicast(paramK, new ObservableGroupBy.State(paramInt, paramGroupByObserver, paramK, paramBoolean));
    }
    
    public void onComplete()
    {
      this.state.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.state.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.state.onNext(paramT);
    }
    
    protected void subscribeActual(Observer<? super T> paramObserver)
    {
      this.state.subscribe(paramObserver);
    }
  }
  
  static final class State<T, K>
    extends AtomicInteger
    implements Disposable, ObservableSource<T>
  {
    private static final long serialVersionUID = -3852313036005250360L;
    final AtomicReference<Observer<? super T>> actual = new AtomicReference();
    final AtomicBoolean cancelled = new AtomicBoolean();
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final K key;
    final AtomicBoolean once = new AtomicBoolean();
    final ObservableGroupBy.GroupByObserver<?, K, T> parent;
    final SpscLinkedArrayQueue<T> queue;
    
    State(int paramInt, ObservableGroupBy.GroupByObserver<?, K, T> paramGroupByObserver, K paramK, boolean paramBoolean)
    {
      this.queue = new SpscLinkedArrayQueue(paramInt);
      this.parent = paramGroupByObserver;
      this.key = paramK;
      this.delayError = paramBoolean;
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Observer<? super T> paramObserver, boolean paramBoolean3)
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
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.cancelled.get();
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      drain();
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
    public void subscribe(Observer<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableGroupBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */