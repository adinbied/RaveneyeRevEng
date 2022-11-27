package dji.publics;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
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
  private static final int MAXIMUM_POOL_SIZE;
  private static final String TAG = DJIExecutor.class.getCanonicalName();
  private static final int URGENT_MAXIMUM_POOL_SIZE;
  private static volatile ExecutorService sDefaultExecutor;
  static volatile HandlerThread sHandlerThread;
  private static volatile ExecutorService sIOExecutor;
  private static volatile ExecutorService sUrgentExecutor;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    CPU_COUNT = i;
    i += 1;
    CORE_POOL_SIZE = i;
    i = Math.min(Math.max(10, i * 2), Math.max(5, CORE_POOL_SIZE));
    URGENT_MAXIMUM_POOL_SIZE = i;
    MAXIMUM_POOL_SIZE = i * 2;
  }
  
  private static ExecutorService getAsyncTaskExecutor()
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
      return (ExecutorService)localObject;
    }
    catch (NoSuchFieldException|IllegalAccessException localNoSuchFieldException) {}
    return null;
  }
  
  private static ExecutorService getDefaultExecutor()
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
            localObject1 = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, (BlockingQueue)localObject3, (ThreadFactory)localObject1);
          }
          sDefaultExecutor = (ExecutorService)localObject1;
        }
      }
    }
    return sDefaultExecutor;
  }
  
  public static ExecutorService getExecutor()
  {
    return getExecutorFor(Purpose.NORMAL);
  }
  
  public static ExecutorService getExecutorFor(Purpose paramPurpose)
  {
    int i = 4.$SwitchMap$dji$publics$DJIExecutor$Purpose[paramPurpose.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return getDefaultExecutor();
        }
        return getUrgentExecutor();
      }
      return getIOExecutor();
    }
    return getDefaultExecutor();
  }
  
  private static ExecutorService getIOExecutor()
  {
    if (sIOExecutor == null) {
      synchronized (LOCK)
      {
        if (sIOExecutor == null)
        {
          ThreadFactory local2 = new ThreadFactory()
          {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            public Thread newThread(Runnable paramAnonymousRunnable)
            {
              return null;
            }
          };
          sIOExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), local2);
        }
      }
    }
    return sIOExecutor;
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
  
  private static ExecutorService getUrgentExecutor()
  {
    if (sUrgentExecutor == null) {
      synchronized (LOCK)
      {
        if (sUrgentExecutor == null)
        {
          ThreadFactory local3 = new ThreadFactory()
          {
            private final AtomicInteger mCount = new AtomicInteger(1);
            
            public Thread newThread(Runnable paramAnonymousRunnable)
            {
              return null;
            }
          };
          sUrgentExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, URGENT_MAXIMUM_POOL_SIZE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), local3);
        }
      }
    }
    return sUrgentExecutor;
  }
  
  public static enum Purpose
  {
    static
    {
      Purpose localPurpose = new Purpose("IO", 2);
      IO = localPurpose;
      $VALUES = new Purpose[] { NORMAL, URGENT, localPurpose };
    }
    
    private Purpose() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */