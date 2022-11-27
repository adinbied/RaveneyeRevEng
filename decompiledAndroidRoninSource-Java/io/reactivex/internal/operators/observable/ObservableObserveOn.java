package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableObserveOn<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final int bufferSize;
  final boolean delayError;
  final Scheduler scheduler;
  
  public ObservableObserveOn(ObservableSource<T> paramObservableSource, Scheduler paramScheduler, boolean paramBoolean, int paramInt)
  {
    super(paramObservableSource);
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
    this.bufferSize = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ObserveOnObserver<T>
    extends BasicIntQueueDisposable<T>
    implements Observer<T>, Runnable
  {
    private static final long serialVersionUID = 6576896619930983584L;
    final int bufferSize;
    final boolean delayError;
    volatile boolean disposed;
    volatile boolean done;
    final Observer<? super T> downstream;
    Throwable error;
    boolean outputFused;
    SimpleQueue<T> queue;
    int sourceMode;
    Disposable upstream;
    final Scheduler.Worker worker;
    
    ObserveOnObserver(Observer<? super T> paramObserver, Scheduler.Worker paramWorker, boolean paramBoolean, int paramInt)
    {
      this.downstream = paramObserver;
      this.worker = paramWorker;
      this.delayError = paramBoolean;
      this.bufferSize = paramInt;
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Observer<? super T> paramObserver)
    {
      return false;
    }
    
    public void clear()
    {
      this.queue.clear();
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
    void drainFused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainNormal()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
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
    
    public T poll()
      throws Exception
    {
      return (T)this.queue.poll();
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void schedule()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */