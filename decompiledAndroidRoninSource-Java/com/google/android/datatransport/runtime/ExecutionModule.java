package com.google.android.datatransport.runtime;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module
abstract class ExecutionModule
{
  @Provides
  @Singleton
  static Executor executor()
  {
    return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\ExecutionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */