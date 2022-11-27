package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils
{
  private static final long DEFAULT_TERMINATION_TIMEOUT = 2L;
  
  private static final void addDelayedShutdownHook(String paramString, ExecutorService paramExecutorService)
  {
    addDelayedShutdownHook(paramString, paramExecutorService, 2L, TimeUnit.SECONDS);
  }
  
  public static final void addDelayedShutdownHook(String paramString, final ExecutorService paramExecutorService, final long paramLong, TimeUnit paramTimeUnit)
  {
    Runtime localRuntime = Runtime.getRuntime();
    paramExecutorService = new BackgroundPriorityRunnable()
    {
      public void onRun()
      {
        try
        {
          Logger localLogger = Logger.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Executing shutdown hook for ");
          localStringBuilder.append(ExecutorUtils.this);
          localLogger.d(localStringBuilder.toString());
          paramExecutorService.shutdown();
          if (paramExecutorService.awaitTermination(paramLong, this.val$timeUnit)) {
            break label147;
          }
          localLogger = Logger.getLogger();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ExecutorUtils.this);
          localStringBuilder.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
          localLogger.d(localStringBuilder.toString());
          paramExecutorService.shutdownNow();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          label147:
          for (;;) {}
        }
        Logger.getLogger().d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] { ExecutorUtils.this }));
        paramExecutorService.shutdownNow();
      }
    };
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("Crashlytics Shutdown Hook for ");
    paramTimeUnit.append(paramString);
    localRuntime.addShutdownHook(new Thread(paramExecutorService, paramTimeUnit.toString()));
  }
  
  public static ExecutorService buildSingleThreadExecutorService(String paramString)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor(getNamedThreadFactory(paramString));
    addDelayedShutdownHook(paramString, localExecutorService);
    return localExecutorService;
  }
  
  public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String paramString)
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(paramString));
    addDelayedShutdownHook(paramString, localScheduledExecutorService);
    return localScheduledExecutorService;
  }
  
  public static final ThreadFactory getNamedThreadFactory(String paramString)
  {
    new ThreadFactory()
    {
      public Thread newThread(final Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable()
        {
          public void onRun()
          {
            paramAnonymousRunnable.run();
          }
        });
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ExecutorUtils.this);
        localStringBuilder.append(this.val$count.getAndIncrement());
        paramAnonymousRunnable.setName(localStringBuilder.toString());
        return paramAnonymousRunnable;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\ExecutorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */