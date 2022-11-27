package io.reactivex.internal.schedulers;

public final class ScheduledDirectPeriodicTask
  extends AbstractDirectTask
  implements Runnable
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectPeriodicTask(Runnable paramRunnable)
  {
    super(paramRunnable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledDirectPeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */