package com.facebook.imagepipeline.instrumentation;

public final class FrescoInstrumenter
{
  private static volatile Instrumenter sInstance;
  
  public static Runnable decorateRunnable(Runnable paramRunnable, String paramString)
  {
    Instrumenter localInstrumenter = sInstance;
    Runnable localRunnable = paramRunnable;
    if (localInstrumenter != null)
    {
      localRunnable = paramRunnable;
      if (paramRunnable != null)
      {
        if (paramString == null) {
          return paramRunnable;
        }
        localRunnable = localInstrumenter.decorateRunnable(paramRunnable, paramString);
      }
    }
    return localRunnable;
  }
  
  public static boolean isTracing()
  {
    Instrumenter localInstrumenter = sInstance;
    if (localInstrumenter == null) {
      return false;
    }
    return localInstrumenter.isTracing();
  }
  
  public static void markFailure(Object paramObject, Throwable paramThrowable)
  {
    Instrumenter localInstrumenter = sInstance;
    if (localInstrumenter != null)
    {
      if (paramObject == null) {
        return;
      }
      localInstrumenter.markFailure(paramObject, paramThrowable);
    }
  }
  
  public static Object onBeforeSubmitWork(String paramString)
  {
    Instrumenter localInstrumenter = sInstance;
    if ((localInstrumenter != null) && (paramString != null)) {
      return localInstrumenter.onBeforeSubmitWork(paramString);
    }
    return null;
  }
  
  public static Object onBeginWork(Object paramObject, String paramString)
  {
    Instrumenter localInstrumenter = sInstance;
    if ((localInstrumenter != null) && (paramObject != null)) {
      return localInstrumenter.onBeginWork(paramObject, paramString);
    }
    return null;
  }
  
  public static void onEndWork(Object paramObject)
  {
    Instrumenter localInstrumenter = sInstance;
    if (localInstrumenter != null)
    {
      if (paramObject == null) {
        return;
      }
      localInstrumenter.onEndWork(paramObject);
    }
  }
  
  public static void provide(Instrumenter paramInstrumenter)
  {
    sInstance = paramInstrumenter;
  }
  
  public static abstract interface Instrumenter
  {
    public abstract Runnable decorateRunnable(Runnable paramRunnable, String paramString);
    
    public abstract boolean isTracing();
    
    public abstract void markFailure(Object paramObject, Throwable paramThrowable);
    
    public abstract Object onBeforeSubmitWork(String paramString);
    
    public abstract Object onBeginWork(Object paramObject, String paramString);
    
    public abstract void onEndWork(Object paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\instrumentation\FrescoInstrumenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */