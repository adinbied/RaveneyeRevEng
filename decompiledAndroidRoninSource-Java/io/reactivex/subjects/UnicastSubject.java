package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T>
  extends Subject<T>
{
  final boolean delayError;
  volatile boolean disposed;
  volatile boolean done;
  final AtomicReference<Observer<? super T>> downstream;
  boolean enableOperatorFusion;
  Throwable error;
  final AtomicReference<Runnable> onTerminate;
  final AtomicBoolean once;
  final SpscLinkedArrayQueue<T> queue;
  final BasicIntQueueDisposable<T> wip;
  
  UnicastSubject(int paramInt, Runnable paramRunnable)
  {
    this(paramInt, paramRunnable, true);
  }
  
  UnicastSubject(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    this.onTerminate = new AtomicReference(ObjectHelper.requireNonNull(paramRunnable, "onTerminate"));
    this.delayError = paramBoolean;
    this.downstream = new AtomicReference();
    this.once = new AtomicBoolean();
    this.wip = new UnicastQueueDisposable();
  }
  
  UnicastSubject(int paramInt, boolean paramBoolean)
  {
    this.queue = new SpscLinkedArrayQueue(ObjectHelper.verifyPositive(paramInt, "capacityHint"));
    this.onTerminate = new AtomicReference();
    this.delayError = paramBoolean;
    this.downstream = new AtomicReference();
    this.once = new AtomicBoolean();
    this.wip = new UnicastQueueDisposable();
  }
  
  @CheckReturnValue
  public static <T> UnicastSubject<T> create()
  {
    return new UnicastSubject(bufferSize(), true);
  }
  
  @CheckReturnValue
  public static <T> UnicastSubject<T> create(int paramInt)
  {
    return new UnicastSubject(paramInt, true);
  }
  
  @CheckReturnValue
  public static <T> UnicastSubject<T> create(int paramInt, Runnable paramRunnable)
  {
    return new UnicastSubject(paramInt, paramRunnable, true);
  }
  
  @CheckReturnValue
  public static <T> UnicastSubject<T> create(int paramInt, Runnable paramRunnable, boolean paramBoolean)
  {
    return new UnicastSubject(paramInt, paramRunnable, paramBoolean);
  }
  
  @CheckReturnValue
  public static <T> UnicastSubject<T> create(boolean paramBoolean)
  {
    return new UnicastSubject(bufferSize(), paramBoolean);
  }
  
  /* Error */
  void doTerminate()
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
  void drainFused(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void drainNormal(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void errorOrComplete(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  boolean failedFast(SimpleQueue<T> paramSimpleQueue, Observer<? super T> paramObserver)
  {
    return false;
  }
  
  public Throwable getThrowable()
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
  public void onSubscribe(io.reactivex.disposables.Disposable arg1)
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
  
  final class UnicastQueueDisposable
    extends BasicIntQueueDisposable<T>
  {
    private static final long serialVersionUID = 7926949470189395511L;
    
    UnicastQueueDisposable() {}
    
    public void clear()
    {
      UnicastSubject.this.queue.clear();
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
      return UnicastSubject.this.disposed;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\subjects\UnicastSubject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */