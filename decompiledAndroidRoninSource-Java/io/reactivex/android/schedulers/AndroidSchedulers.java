package io.reactivex.android.schedulers;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

public final class AndroidSchedulers
{
  private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable()
  {
    public Scheduler call()
      throws Exception
    {
      return AndroidSchedulers.MainHolder.DEFAULT;
    }
  });
  
  private AndroidSchedulers()
  {
    throw new AssertionError("No instances.");
  }
  
  public static Scheduler from(Looper paramLooper)
  {
    return from(paramLooper, false);
  }
  
  public static Scheduler from(Looper paramLooper, boolean paramBoolean)
  {
    Message localMessage;
    if (paramLooper != null) {
      if (Build.VERSION.SDK_INT < 16)
      {
        bool = false;
      }
      else
      {
        bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (Build.VERSION.SDK_INT < 22) {
            localMessage = Message.obtain();
          }
        }
      }
    }
    try
    {
      localMessage.setAsynchronous(true);
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;) {}
    }
    paramBoolean = false;
    localMessage.recycle();
    boolean bool = paramBoolean;
    return new HandlerScheduler(new Handler(paramLooper), bool);
    throw new NullPointerException("looper == null");
  }
  
  public static Scheduler mainThread()
  {
    return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
  }
  
  private static final class MainHolder
  {
    static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\android\schedulers\AndroidSchedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */