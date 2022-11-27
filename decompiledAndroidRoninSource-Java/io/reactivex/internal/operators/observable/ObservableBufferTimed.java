package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>>
  extends AbstractObservableWithUpstream<T, U>
{
  final Callable<U> bufferSupplier;
  final int maxSize;
  final boolean restartTimerOnMaxSize;
  final Scheduler scheduler;
  final long timeskip;
  final long timespan;
  final TimeUnit unit;
  
  public ObservableBufferTimed(ObservableSource<T> paramObservableSource, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, Callable<U> paramCallable, int paramInt, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.bufferSupplier = paramCallable;
    this.maxSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BufferExactBoundedObserver<T, U extends Collection<? super T>>
    extends QueueDrainObserver<T, U, U>
    implements Runnable, Disposable
  {
    U buffer;
    final Callable<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    Disposable timer;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker w;
    
    BufferExactBoundedObserver(Observer<? super U> paramObserver, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, int paramInt, boolean paramBoolean, Scheduler.Worker paramWorker)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.maxSize = paramInt;
      this.restartTimerOnMaxSize = paramBoolean;
      this.w = paramWorker;
    }
    
    public void accept(Observer<? super U> paramObserver, U paramU)
    {
      paramObserver.onNext(paramU);
    }
    
    /* Error */
    public void dispose()
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
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>>
    extends QueueDrainObserver<T, U, U>
    implements Runnable, Disposable
  {
    U buffer;
    final Callable<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    
    BufferExactUnboundedObserver(Observer<? super U> paramObserver, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public void accept(Observer<? super U> paramObserver, U paramU)
    {
      this.downstream.onNext(paramU);
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
      return false;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>>
    extends QueueDrainObserver<T, U, U>
    implements Runnable, Disposable
  {
    final Callable<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final Scheduler.Worker w;
    
    BufferSkipBoundedObserver(Observer<? super U> paramObserver, Callable<U> paramCallable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler.Worker paramWorker)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong1;
      this.timeskip = paramLong2;
      this.unit = paramTimeUnit;
      this.w = paramWorker;
      this.buffers = new LinkedList();
    }
    
    public void accept(Observer<? super U> paramObserver, U paramU)
    {
      paramObserver.onNext(paramU);
    }
    
    /* Error */
    void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      return this.cancelled;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final class RemoveFromBuffer
      implements Runnable
    {
      private final U b;
      
      RemoveFromBuffer()
      {
        Collection localCollection;
        this.b = localCollection;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
    
    final class RemoveFromBufferEmit
      implements Runnable
    {
      private final U buffer;
      
      RemoveFromBufferEmit()
      {
        Collection localCollection;
        this.buffer = localCollection;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBufferTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */