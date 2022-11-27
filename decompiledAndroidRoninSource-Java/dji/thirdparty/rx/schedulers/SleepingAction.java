package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.functions.Action0;

class SleepingAction
  implements Action0
{
  private final long execTime;
  private final Scheduler.Worker innerScheduler;
  private final Action0 underlying;
  
  public SleepingAction(Action0 paramAction0, Scheduler.Worker paramWorker, long paramLong)
  {
    this.underlying = paramAction0;
    this.innerScheduler = paramWorker;
    this.execTime = paramLong;
  }
  
  /* Error */
  public void call()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\SleepingAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */