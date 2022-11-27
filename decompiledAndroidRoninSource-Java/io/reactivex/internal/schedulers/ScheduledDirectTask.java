package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask
  extends AbstractDirectTask
  implements Callable<Void>
{
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectTask(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  public Void call()
    throws Exception
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledDirectTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */