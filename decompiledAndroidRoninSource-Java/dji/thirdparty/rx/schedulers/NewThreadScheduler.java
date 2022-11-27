package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.internal.schedulers.NewThreadWorker;
import dji.thirdparty.rx.internal.util.RxThreadFactory;

public final class NewThreadScheduler
  extends Scheduler
{
  private static final NewThreadScheduler INSTANCE = new NewThreadScheduler();
  private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler-");
  private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler-";
  
  static NewThreadScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new NewThreadWorker(THREAD_FACTORY);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\NewThreadScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */