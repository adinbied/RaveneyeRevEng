package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Logger;

public class AsyncExecutor
{
  private final EventBus eventBus;
  private final Constructor<?> failureEventConstructor;
  private final Object scope;
  private final Executor threadPool;
  
  private AsyncExecutor(Executor paramExecutor, EventBus paramEventBus, Class<?> paramClass, Object paramObject)
  {
    this.threadPool = paramExecutor;
    this.eventBus = paramEventBus;
    this.scope = paramObject;
    try
    {
      this.failureEventConstructor = paramClass.getConstructor(new Class[] { Throwable.class });
      return;
    }
    catch (NoSuchMethodException paramExecutor)
    {
      throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", paramExecutor);
    }
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static AsyncExecutor create()
  {
    return new Builder(null).build();
  }
  
  public void execute(final RunnableEx paramRunnableEx)
  {
    this.threadPool.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          paramRunnableEx.run();
          return;
        }
        catch (Exception localException1)
        {
          try
          {
            Object localObject = AsyncExecutor.this.failureEventConstructor.newInstance(new Object[] { localException1 });
            if ((localObject instanceof HasExecutionScope)) {
              ((HasExecutionScope)localObject).setExecutionScope(AsyncExecutor.this.scope);
            }
            AsyncExecutor.this.eventBus.post(localObject);
            return;
          }
          catch (Exception localException2)
          {
            AsyncExecutor.this.eventBus.getLogger().log(Level.SEVERE, "Original exception:", localException1);
            throw new RuntimeException("Could not create failure event", localException2);
          }
        }
      }
    });
  }
  
  public static class Builder
  {
    private EventBus eventBus;
    private Class<?> failureEventType;
    private Executor threadPool;
    
    public AsyncExecutor build()
    {
      return buildForScope(null);
    }
    
    public AsyncExecutor buildForScope(Object paramObject)
    {
      if (this.eventBus == null) {
        this.eventBus = EventBus.getDefault();
      }
      if (this.threadPool == null) {
        this.threadPool = Executors.newCachedThreadPool();
      }
      if (this.failureEventType == null) {
        this.failureEventType = ThrowableFailureEvent.class;
      }
      return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, paramObject, null);
    }
    
    public Builder eventBus(EventBus paramEventBus)
    {
      this.eventBus = paramEventBus;
      return this;
    }
    
    public Builder failureEventType(Class<?> paramClass)
    {
      this.failureEventType = paramClass;
      return this;
    }
    
    public Builder threadPool(Executor paramExecutor)
    {
      this.threadPool = paramExecutor;
      return this;
    }
  }
  
  public static abstract interface RunnableEx
  {
    public abstract void run()
      throws Exception;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\AsyncExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */