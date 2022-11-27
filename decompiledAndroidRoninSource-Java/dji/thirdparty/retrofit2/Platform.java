package dji.thirdparty.retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class Platform
{
  private static final Platform PLATFORM = ;
  
  private static Platform findPlatform()
  {
    try
    {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0)
      {
        localObject = new Android();
        return (Platform)localObject;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Object localObject;
      label38:
      label54:
      for (;;) {}
    }
    try
    {
      Class.forName("java.util.Optional");
      localObject = new Java8();
      return (Platform)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      break label38;
    }
    try
    {
      Class.forName("org.robovm.apple.foundation.NSObject");
      localObject = new IOS();
      return (Platform)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException3)
    {
      break label54;
    }
    return new Platform();
  }
  
  static Platform get()
  {
    return PLATFORM;
  }
  
  CallAdapter.Factory defaultCallAdapterFactory(Executor paramExecutor)
  {
    return null;
  }
  
  Executor defaultCallbackExecutor()
  {
    return null;
  }
  
  Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
    throws Throwable
  {
    throw new UnsupportedOperationException();
  }
  
  boolean isDefaultMethod(Method paramMethod)
  {
    return false;
  }
  
  static class Android
    extends Platform
  {
    CallAdapter.Factory defaultCallAdapterFactory(Executor paramExecutor)
    {
      return new ExecutorCallAdapterFactory(paramExecutor);
    }
    
    public Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }
    
    static class MainThreadExecutor
      implements Executor
    {
      private final Handler handler = new Handler(Looper.getMainLooper());
      
      public void execute(Runnable paramRunnable)
      {
        this.handler.post(paramRunnable);
      }
    }
  }
  
  static class IOS
    extends Platform
  {
    CallAdapter.Factory defaultCallAdapterFactory(Executor paramExecutor)
    {
      return new ExecutorCallAdapterFactory(paramExecutor);
    }
    
    public Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }
    
    static class MainThreadExecutor
      implements Executor
    {
      private static Method addOperation;
      private static Object queue;
      
      static
      {
        try
        {
          Class localClass = Class.forName("org.robovm.apple.foundation.NSOperationQueue");
          queue = localClass.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);
          addOperation = localClass.getDeclaredMethod("addOperation", new Class[] { Runnable.class });
          return;
        }
        catch (Exception localException)
        {
          throw new AssertionError(localException);
        }
      }
      
      /* Error */
      public void execute(Runnable arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
  
  static class Java8
    extends Platform
  {
    Object invokeDefaultMethod(Method paramMethod, Class<?> paramClass, Object paramObject, Object... paramVarArgs)
      throws Throwable
    {
      return null;
    }
    
    boolean isDefaultMethod(Method paramMethod)
    {
      return paramMethod.isDefault();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */