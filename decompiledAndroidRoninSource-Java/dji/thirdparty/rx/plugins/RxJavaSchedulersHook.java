package dji.thirdparty.rx.plugins;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.functions.Action0;

public class RxJavaSchedulersHook
{
  private static final RxJavaSchedulersHook DEFAULT_INSTANCE = new RxJavaSchedulersHook();
  
  public static RxJavaSchedulersHook getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public Scheduler getComputationScheduler()
  {
    return null;
  }
  
  public Scheduler getIOScheduler()
  {
    return null;
  }
  
  public Scheduler getNewThreadScheduler()
  {
    return null;
  }
  
  public Action0 onSchedule(Action0 paramAction0)
  {
    return paramAction0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaSchedulersHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */