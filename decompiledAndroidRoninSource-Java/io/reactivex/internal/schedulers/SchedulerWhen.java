package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen
  extends Scheduler
  implements Disposable
{
  static final Disposable DISPOSED = Disposables.disposed();
  static final Disposable SUBSCRIBED = new SubscribedDisposable();
  private final Scheduler actualScheduler;
  private Disposable disposable;
  private final FlowableProcessor<Flowable<Completable>> workerProcessor;
  
  public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> paramFunction, Scheduler paramScheduler)
  {
    this.actualScheduler = paramScheduler;
    paramScheduler = UnicastProcessor.create().toSerialized();
    this.workerProcessor = paramScheduler;
    try
    {
      this.disposable = ((Completable)paramFunction.apply(paramScheduler)).subscribe();
      return;
    }
    finally {}
  }
  
  public Scheduler.Worker createWorker()
  {
    return null;
  }
  
  public void dispose()
  {
    this.disposable.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.disposable.isDisposed();
  }
  
  static final class CreateWorkerFunction
    implements Function<SchedulerWhen.ScheduledAction, Completable>
  {
    final Scheduler.Worker actualWorker;
    
    CreateWorkerFunction(Scheduler.Worker paramWorker)
    {
      this.actualWorker = paramWorker;
    }
    
    public Completable apply(SchedulerWhen.ScheduledAction paramScheduledAction)
    {
      return new WorkerCompletable(paramScheduledAction);
    }
    
    final class WorkerCompletable
      extends Completable
    {
      final SchedulerWhen.ScheduledAction action;
      
      WorkerCompletable(SchedulerWhen.ScheduledAction paramScheduledAction)
      {
        this.action = paramScheduledAction;
      }
      
      /* Error */
      protected void subscribeActual(CompletableObserver arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
  
  static class DelayedAction
    extends SchedulerWhen.ScheduledAction
  {
    private final Runnable action;
    private final long delayTime;
    private final TimeUnit unit;
    
    DelayedAction(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      this.action = paramRunnable;
      this.delayTime = paramLong;
      this.unit = paramTimeUnit;
    }
    
    protected Disposable callActual(Scheduler.Worker paramWorker, CompletableObserver paramCompletableObserver)
    {
      return null;
    }
  }
  
  static class ImmediateAction
    extends SchedulerWhen.ScheduledAction
  {
    private final Runnable action;
    
    ImmediateAction(Runnable paramRunnable)
    {
      this.action = paramRunnable;
    }
    
    protected Disposable callActual(Scheduler.Worker paramWorker, CompletableObserver paramCompletableObserver)
    {
      return null;
    }
  }
  
  static class OnCompletedAction
    implements Runnable
  {
    final Runnable action;
    final CompletableObserver actionCompletable;
    
    OnCompletedAction(Runnable paramRunnable, CompletableObserver paramCompletableObserver)
    {
      this.action = paramRunnable;
      this.actionCompletable = paramCompletableObserver;
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
  
  static final class QueueWorker
    extends Scheduler.Worker
  {
    private final FlowableProcessor<SchedulerWhen.ScheduledAction> actionProcessor;
    private final Scheduler.Worker actualWorker;
    private final AtomicBoolean unsubscribed;
    
    QueueWorker(FlowableProcessor<SchedulerWhen.ScheduledAction> paramFlowableProcessor, Scheduler.Worker paramWorker)
    {
      this.actionProcessor = paramFlowableProcessor;
      this.actualWorker = paramWorker;
      this.unsubscribed = new AtomicBoolean();
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
      return this.unsubscribed.get();
    }
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
  
  static abstract class ScheduledAction
    extends AtomicReference<Disposable>
    implements Disposable
  {
    ScheduledAction()
    {
      super();
    }
    
    /* Error */
    void call(Scheduler.Worker arg1, CompletableObserver arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected abstract Disposable callActual(Scheduler.Worker paramWorker, CompletableObserver paramCompletableObserver);
    
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
  }
  
  static final class SubscribedDisposable
    implements Disposable
  {
    public void dispose() {}
    
    public boolean isDisposed()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\SchedulerWhen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */