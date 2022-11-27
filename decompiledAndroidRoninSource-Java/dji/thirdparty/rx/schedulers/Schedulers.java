package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.internal.schedulers.EventLoopsScheduler;
import dji.thirdparty.rx.internal.schedulers.GenericScheduledExecutorService;
import dji.thirdparty.rx.internal.schedulers.SchedulerLifecycle;
import dji.thirdparty.rx.internal.util.ObjectPool;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.plugins.RxJavaPlugins;
import dji.thirdparty.rx.plugins.RxJavaSchedulersHook;
import java.util.concurrent.Executor;

public final class Schedulers
{
  private static final Schedulers INSTANCE = new Schedulers();
  private final Scheduler computationScheduler;
  private final Scheduler ioScheduler;
  private final Scheduler newThreadScheduler;
  
  private Schedulers()
  {
    Scheduler localScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getComputationScheduler();
    if (localScheduler != null) {
      this.computationScheduler = localScheduler;
    } else {
      this.computationScheduler = new EventLoopsScheduler();
    }
    localScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getIOScheduler();
    if (localScheduler != null) {
      this.ioScheduler = localScheduler;
    } else {
      this.ioScheduler = new CachedThreadScheduler();
    }
    localScheduler = RxJavaPlugins.getInstance().getSchedulersHook().getNewThreadScheduler();
    if (localScheduler != null)
    {
      this.newThreadScheduler = localScheduler;
      return;
    }
    this.newThreadScheduler = NewThreadScheduler.instance();
  }
  
  public static Scheduler computation()
  {
    return INSTANCE.computationScheduler;
  }
  
  public static Scheduler from(Executor paramExecutor)
  {
    return new ExecutorScheduler(paramExecutor);
  }
  
  public static Scheduler immediate()
  {
    return ImmediateScheduler.instance();
  }
  
  public static Scheduler io()
  {
    return INSTANCE.ioScheduler;
  }
  
  public static Scheduler newThread()
  {
    return INSTANCE.newThreadScheduler;
  }
  
  public static void shutdown()
  {
    synchronized (INSTANCE)
    {
      if ((???.computationScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.computationScheduler).shutdown();
      }
      if ((???.ioScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.ioScheduler).shutdown();
      }
      if ((???.newThreadScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.newThreadScheduler).shutdown();
      }
      GenericScheduledExecutorService.INSTANCE.shutdown();
      RxRingBuffer.SPSC_POOL.shutdown();
      RxRingBuffer.SPMC_POOL.shutdown();
      return;
    }
  }
  
  static void start()
  {
    synchronized (INSTANCE)
    {
      if ((???.computationScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.computationScheduler).start();
      }
      if ((???.ioScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.ioScheduler).start();
      }
      if ((???.newThreadScheduler instanceof SchedulerLifecycle)) {
        ((SchedulerLifecycle)???.newThreadScheduler).start();
      }
      GenericScheduledExecutorService.INSTANCE.start();
      RxRingBuffer.SPSC_POOL.start();
      RxRingBuffer.SPMC_POOL.start();
      return;
    }
  }
  
  public static TestScheduler test()
  {
    return new TestScheduler();
  }
  
  public static Scheduler trampoline()
  {
    return TrampolineScheduler.instance();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\Schedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */