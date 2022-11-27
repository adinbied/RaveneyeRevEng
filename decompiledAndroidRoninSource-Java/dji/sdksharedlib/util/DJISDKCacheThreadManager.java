package dji.sdksharedlib.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DJISDKCacheThreadManager
{
  private static final String TAG = "DJISDKCacheThreadManager";
  private static boolean isRunInIVTs;
  private Handler backgroundHandler;
  private HandlerThread singletonBackgroundLooperThread;
  private ExecutorService threadPool = Executors.newCachedThreadPool();
  private Handler uiHandler = new Handler(Looper.getMainLooper());
  
  private DJISDKCacheThreadManager()
  {
    HandlerThread localHandlerThread = new HandlerThread("SingleBackgroundLooper");
    this.singletonBackgroundLooperThread = localHandlerThread;
    localHandlerThread.start();
    this.backgroundHandler = new Handler(this.singletonBackgroundLooperThread.getLooper());
  }
  
  private Runnable attachExecutionTime(final Runnable paramRunnable)
  {
    new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public static DJISDKCacheThreadManager getInstance()
  {
    return SingletonHolder.instance;
  }
  
  public static Looper getSingletonBackgroundLooper()
  {
    return getInstance().getBackgroundLooper();
  }
  
  public static void invoke(Runnable paramRunnable, boolean paramBoolean)
  {
    getInstance().post(paramRunnable, paramBoolean);
  }
  
  public static void invokeDelay(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    getInstance().postDelay(paramRunnable, paramLong, paramBoolean);
  }
  
  public static void invokeInSingletonThread(Runnable paramRunnable, boolean paramBoolean)
  {
    getInstance().postInSingletonThread(paramRunnable, paramBoolean);
  }
  
  /* Error */
  private void post(Runnable arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void postDelay(final Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uiHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    paramRunnable = new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
    this.uiHandler.postDelayed(paramRunnable, paramLong);
  }
  
  /* Error */
  private void postInSingletonThread(Runnable arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void setIsRunInIVTs(boolean paramBoolean)
  {
    isRunInIVTs = paramBoolean;
  }
  
  public Looper getBackgroundLooper()
  {
    return this.singletonBackgroundLooperThread.getLooper();
  }
  
  private static class SingletonHolder
  {
    private static DJISDKCacheThreadManager instance = new DJISDKCacheThreadManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedli\\util\DJISDKCacheThreadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */