package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowTimed<T>
  extends AbstractObservableWithUpstream<T, Observable<T>>
{
  final int bufferSize;
  final long maxSize;
  final boolean restartTimerOnMaxSize;
  final Scheduler scheduler;
  final long timeskip;
  final long timespan;
  final TimeUnit unit;
  
  public ObservableWindowTimed(ObservableSource<T> paramObservableSource, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong3, int paramInt, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.maxSize = paramLong3;
    this.bufferSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super Observable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WindowExactBoundedObserver<T>
    extends QueueDrainObserver<T, Object, Observable<T>>
    implements Disposable
  {
    final int bufferSize;
    long count;
    final long maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    UnicastSubject<T> window;
    final Scheduler.Worker worker;
    
    WindowExactBoundedObserver(Observer<? super Observable<T>> paramObserver, long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt, long paramLong2, boolean paramBoolean)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong1;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
      this.bufferSize = paramInt;
      this.maxSize = paramLong2;
      this.restartTimerOnMaxSize = paramBoolean;
      if (paramBoolean)
      {
        this.worker = paramScheduler.createWorker();
        return;
      }
      this.worker = null;
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    /* Error */
    void disposeTimer()
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
      //   2: goto -2 -> 0
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
    
    static final class ConsumerIndexHolder
      implements Runnable
    {
      final long index;
      final ObservableWindowTimed.WindowExactBoundedObserver<?> parent;
      
      ConsumerIndexHolder(long paramLong, ObservableWindowTimed.WindowExactBoundedObserver<?> paramWindowExactBoundedObserver)
      {
        this.index = paramLong;
        this.parent = paramWindowExactBoundedObserver;
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
  
  static final class WindowExactUnboundedObserver<T>
    extends QueueDrainObserver<T, Object, Observable<T>>
    implements Observer<T>, Disposable, Runnable
  {
    static final Object NEXT = new Object();
    final int bufferSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    UnicastSubject<T> window;
    
    WindowExactUnboundedObserver(Observer<? super Observable<T>> paramObserver, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
      this.bufferSize = paramInt;
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    void disposeTimer()
    {
      DisposableHelper.dispose(this.timer);
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    extends QueueDrainObserver<T, Object, Observable<T>>
    implements Disposable, Runnable
  {
    final int bufferSize;
    volatile boolean terminated;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final List<UnicastSubject<T>> windows;
    final Scheduler.Worker worker;
    
    WindowSkipObserver(Observer<? super Observable<T>> paramObserver, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler.Worker paramWorker, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong1;
      this.timeskip = paramLong2;
      this.unit = paramTimeUnit;
      this.worker = paramWorker;
      this.bufferSize = paramInt;
      this.windows = new LinkedList();
    }
    
    /* Error */
    void complete(UnicastSubject<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    void disposeWorker()
    {
      this.worker.dispose();
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    final class CompletionTask
      implements Runnable
    {
      private final UnicastSubject<T> w;
      
      CompletionTask()
      {
        UnicastSubject localUnicastSubject;
        this.w = localUnicastSubject;
      }
      
      public void run()
      {
        ObservableWindowTimed.WindowSkipObserver.this.complete(this.w);
      }
    }
    
    static final class SubjectWork<T>
    {
      final boolean open;
      final UnicastSubject<T> w;
      
      SubjectWork(UnicastSubject<T> paramUnicastSubject, boolean paramBoolean)
      {
        this.w = paramUnicastSubject;
        this.open = paramBoolean;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableWindowTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */