package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins
{
  private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
  private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;
  
  private RxAndroidPlugins()
  {
    throw new AssertionError("No instances.");
  }
  
  static <T, R> R apply(Function<T, R> paramFunction, T paramT)
  {
    try
    {
      paramFunction = paramFunction.apply(paramT);
      return paramFunction;
    }
    finally {}
  }
  
  static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> paramFunction, Callable<Scheduler> paramCallable)
  {
    paramFunction = (Scheduler)apply(paramFunction, paramCallable);
    if (paramFunction != null) {
      return paramFunction;
    }
    throw new NullPointerException("Scheduler Callable returned null");
  }
  
  static Scheduler callRequireNonNull(Callable<Scheduler> paramCallable)
  {
    try
    {
      paramCallable = (Scheduler)paramCallable.call();
      if (paramCallable != null) {
        return paramCallable;
      }
      throw new NullPointerException("Scheduler Callable returned null");
    }
    finally {}
  }
  
  public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler()
  {
    return onInitMainThreadHandler;
  }
  
  public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler()
  {
    return onMainThreadHandler;
  }
  
  public static Scheduler initMainThreadScheduler(Callable<Scheduler> paramCallable)
  {
    if (paramCallable != null)
    {
      Function localFunction = onInitMainThreadHandler;
      if (localFunction == null) {
        return callRequireNonNull(paramCallable);
      }
      return applyRequireNonNull(localFunction, paramCallable);
    }
    throw new NullPointerException("scheduler == null");
  }
  
  public static Scheduler onMainThreadScheduler(Scheduler paramScheduler)
  {
    if (paramScheduler != null)
    {
      Function localFunction = onMainThreadHandler;
      if (localFunction == null) {
        return paramScheduler;
      }
      return (Scheduler)apply(localFunction, paramScheduler);
    }
    throw new NullPointerException("scheduler == null");
  }
  
  public static void reset()
  {
    setInitMainThreadSchedulerHandler(null);
    setMainThreadSchedulerHandler(null);
  }
  
  public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> paramFunction)
  {
    onInitMainThreadHandler = paramFunction;
  }
  
  public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> paramFunction)
  {
    onMainThreadHandler = paramFunction;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\android\plugins\RxAndroidPlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */