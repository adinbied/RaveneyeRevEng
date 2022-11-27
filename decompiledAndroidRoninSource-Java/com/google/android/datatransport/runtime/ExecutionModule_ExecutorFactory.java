package com.google.android.datatransport.runtime;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.Executor;

public final class ExecutionModule_ExecutorFactory
  implements Factory<Executor>
{
  private static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();
  
  public static ExecutionModule_ExecutorFactory create()
  {
    return INSTANCE;
  }
  
  public static Executor executor()
  {
    return (Executor)Preconditions.checkNotNull(ExecutionModule.executor(), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public Executor get()
  {
    return executor();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\ExecutionModule_ExecutorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */