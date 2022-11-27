package dji.thirdparty.rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.android.plugins.RxAndroidPlugins;
import dji.thirdparty.rx.android.plugins.RxAndroidSchedulersHook;

public final class AndroidSchedulers
{
  private AndroidSchedulers()
  {
    throw new AssertionError("No instances");
  }
  
  public static Scheduler mainThread()
  {
    Scheduler localScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
    if (localScheduler != null) {
      return localScheduler;
    }
    return MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
  }
  
  private static class MainThreadSchedulerHolder
  {
    static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\android\schedulers\AndroidSchedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */