package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;

public abstract interface ExecutorSupplier
{
  public abstract Executor forBackgroundTasks();
  
  public abstract Executor forDecode();
  
  public abstract Executor forLightweightBackgroundTasks();
  
  public abstract Executor forLocalStorageRead();
  
  public abstract Executor forLocalStorageWrite();
  
  public abstract Executor forThumbnailProducer();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ExecutorSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */