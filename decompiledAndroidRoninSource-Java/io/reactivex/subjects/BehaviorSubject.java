package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T>
  extends Subject<T>
{
  static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];
  private static final Object[] EMPTY_ARRAY = new Object[0];
  static final BehaviorDisposable[] TERMINATED = new BehaviorDisposable[0];
  long index;
  final ReadWriteLock lock;
  final Lock readLock;
  final AtomicReference<BehaviorDisposable<T>[]> subscribers;
  final AtomicReference<Throwable> terminalEvent;
  final AtomicReference<Object> value;
  final Lock writeLock;
  
  BehaviorSubject()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.lock = localReentrantReadWriteLock;
    this.readLock = localReentrantReadWriteLock.readLock();
    this.writeLock = this.lock.writeLock();
    this.subscribers = new AtomicReference(EMPTY);
    this.value = new AtomicReference();
    this.terminalEvent = new AtomicReference();
  }
  
  BehaviorSubject(T paramT)
  {
    this();
    this.value.lazySet(ObjectHelper.requireNonNull(paramT, "defaultValue is null"));
  }
  
  @CheckReturnValue
  public static <T> BehaviorSubject<T> create()
  {
    return new BehaviorSubject();
  }
  
  @CheckReturnValue
  public static <T> BehaviorSubject<T> createDefault(T paramT)
  {
    return new BehaviorSubject(paramT);
  }
  
  boolean add(BehaviorDisposable<T> paramBehaviorDisposable)
  {
    return false;
  }
  
  public Throwable getThrowable()
  {
    return null;
  }
  
  public T getValue()
  {
    return null;
  }
  
  @Deprecated
  public Object[] getValues()
  {
    return null;
  }
  
  @Deprecated
  public T[] getValues(T[] paramArrayOfT)
  {
    return null;
  }
  
  public boolean hasComplete()
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
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void remove(BehaviorDisposable<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setCurrent(Object arg1)
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
  
  int subscriberCount()
  {
    return 0;
  }
  
  BehaviorDisposable<T>[] terminate(Object paramObject)
  {
    return null;
  }
  
  static final class BehaviorDisposable<T>
    implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>
  {
    volatile boolean cancelled;
    final Observer<? super T> downstream;
    boolean emitting;
    boolean fastPath;
    long index;
    boolean next;
    AppendOnlyLinkedArrayList<Object> queue;
    final BehaviorSubject<T> state;
    
    BehaviorDisposable(Observer<? super T> paramObserver, BehaviorSubject<T> paramBehaviorSubject)
    {
      this.downstream = paramObserver;
      this.state = paramBehaviorSubject;
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
    void emitFirst()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void emitLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void emitNext(Object arg1, long arg2)
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
    
    public boolean test(Object paramObject)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\BehaviorSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */