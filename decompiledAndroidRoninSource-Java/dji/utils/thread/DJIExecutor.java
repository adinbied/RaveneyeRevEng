package dji.utils.thread;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DJIExecutor
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  private static final int KEEP_ALIVE = 1;
  private static final Object LOCK = new Object();
  private static final int MAXIMUM_POOL_SIZE = 128;
  private static final String TAG = DJIExecutor.class.getCanonicalName();
  private static volatile Executor sDefaultExecutor;
  static volatile HandlerThread sHandlerThread;
  private static volatile Executor sNetworkExecutor;
  private static volatile Executor sUrgentExecutor;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    CPU_COUNT = i;
    CORE_POOL_SIZE = i + 1;
  }
  
  private static Executor getAsyncTaskExecutor()
  {
    if (Build.VERSION.SDK_INT < 11) {
      return null;
    }
    try
    {
      Object localObject = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
      localObject = ((Field)localObject).get(null);
      if (localObject == null) {
        return null;
      }
      if (!(localObject instanceof Executor)) {
        return null;
      }
      return (Executor)localObject;
    }
    catch (NoSuchFieldException|IllegalAccessException localNoSuchFieldException) {}
    return null;
  }
  
  private static Executor getDefaultExecutor()
  {
    if (sDefaultExecutor == null) {
      synchronized (LOCK)
      {
        if (sDefaultExecutor == null)
        {
          Object localObject3 = getAsyncTaskExecutor();
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ThreadFactory()
            {
              private final AtomicInteger mCount = new AtomicInteger(1);
              
              public Thread newThread(Runnable paramAnonymousRunnable)
              {
                return null;
              }
            };
            localObject3 = new LinkedBlockingQueue(128);
            localObject1 = new ThreadPoolExecutor(CORE_POOL_SIZE, 128, 1L, TimeUnit.SECONDS, (BlockingQueue)localObject3, (ThreadFactory)localObject1);
          }
          sDefaultExecutor = (Executor)localObject1;
        }
      }
    }
    return sDefaultExecutor;
  }
  
  public static Executor getExecutor()
  {
    return getExecutorFor(Purpose.NORMAL);
  }
  
  public static Executor getExecutorFor(Purpose paramPurpose)
  {
    int i = 4.$SwitchMap$dji$utils$thread$DJIExecutor$Purpose[paramPurpose.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return getDefaultExecutor();
          }
          return getUrgentExecutor();
        }
        return getNetworkExecutor();
      }
      return getNetworkExecutor();
    }
    return getDefaultExecutor();
  }
  
  public static Looper getLooper()
  {
    if (sHandlerThread == null) {
      try
      {
        if (sHandlerThread == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("DJIExecutor:handlerThread");
          localHandlerThread.start();
          sHandlerThread = localHandlerThread;
        }
      }
      finally {}
    }
    return sHandlerThread.getLooper();
  }
  
  private static Executor getNetworkExecutor()
  {
    if (sNetworkExecutor == null) {
      synchronized (LOCK)
      {
        if (sNetworkExecutor == null) {
          sNetworkExecutor = Executors.newCachedThreadPool(new ThreadFactory()
          {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            public Thread newThread(Runnable paramAnonymousRunnable)
            {
              return null;
            }
          });
        }
      }
    }
    return sNetworkExecutor;
  }
  
  private static Executor getUrgentExecutor()
  {
    if (sUrgentExecutor == null) {
      synchronized (LOCK)
      {
        if (sUrgentExecutor == null) {
          sUrgentExecutor = Executors.newCachedThreadPool(new ThreadFactory()
          {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            public Thread newThread(Runnable paramAnonymousRunnable)
            {
              return null;
            }
          });
        }
      }
    }
    return sUrgentExecutor;
  }
  
  public static enum Purpose
  {
    static
    {
      NETWORK = new Purpose("NETWORK", 2);
      Purpose localPurpose = new Purpose("DISK_IO", 3);
      DISK_IO = localPurpose;
      $VALUES = new Purpose[] { NORMAL, URGENT, NETWORK, localPurpose };
    }
    
    private Purpose() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\thread\DJIExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */