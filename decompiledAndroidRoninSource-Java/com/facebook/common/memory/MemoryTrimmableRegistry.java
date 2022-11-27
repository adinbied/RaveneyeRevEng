package com.facebook.common.memory;

public abstract interface MemoryTrimmableRegistry
{
  public abstract void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
  
  public abstract void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\MemoryTrimmableRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */