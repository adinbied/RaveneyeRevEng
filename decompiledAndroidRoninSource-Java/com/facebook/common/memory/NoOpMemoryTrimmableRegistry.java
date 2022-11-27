package com.facebook.common.memory;

public class NoOpMemoryTrimmableRegistry
  implements MemoryTrimmableRegistry
{
  private static NoOpMemoryTrimmableRegistry sInstance;
  
  public static NoOpMemoryTrimmableRegistry getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpMemoryTrimmableRegistry();
      }
      NoOpMemoryTrimmableRegistry localNoOpMemoryTrimmableRegistry = sInstance;
      return localNoOpMemoryTrimmableRegistry;
    }
    finally {}
  }
  
  public void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable) {}
  
  public void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\NoOpMemoryTrimmableRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */