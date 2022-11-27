package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.schedulers.GenericScheduledExecutorService;
import dji.thirdparty.rx.internal.schedulers.ScheduledAction;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import dji.thirdparty.rx.subscriptions.MultipleAssignmentSubscription;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class ExecutorScheduler
  extends Scheduler
{
  final Executor executor;
  
  public ExecutorScheduler(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new ExecutorSchedulerWorker(this.executor);
  }
  
  static final class ExecutorSchedulerWorker
    extends Scheduler.Worker
    implements Runnable
  {
    final Executor executor;
    final ConcurrentLinkedQueue<ScheduledAction> queue;
    final ScheduledExecutorService service;
    final CompositeSubscription tasks;
    final AtomicInteger wip;
    
    public ExecutorSchedulerWorker(Executor paramExecutor)
    {
      this.executor = paramExecutor;
      this.queue = new ConcurrentLinkedQueue();
      this.wip = new AtomicInteger();
      this.tasks = new CompositeSubscription();
      this.service = GenericScheduledExecutorService.getInstance();
    }
    
    public boolean isUnsubscribed()
    {
      return this.tasks.isUnsubscribed();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return null;
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public void unsubscribe()
    {
      this.tasks.unsubscribe();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\ExecutorScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */