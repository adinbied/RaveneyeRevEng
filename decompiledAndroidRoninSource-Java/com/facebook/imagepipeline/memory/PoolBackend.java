package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;

abstract interface PoolBackend<T>
{
  @Nullable
  public abstract T get(int paramInt);
  
  public abstract int getSize(T paramT);
  
  @Nullable
  public abstract T pop();
  
  public abstract void put(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\PoolBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */