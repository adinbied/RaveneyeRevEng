package com.facebook.common.disk;

import javax.annotation.Nullable;

public class NoOpDiskTrimmableRegistry
  implements DiskTrimmableRegistry
{
  @Nullable
  private static NoOpDiskTrimmableRegistry sInstance;
  
  public static NoOpDiskTrimmableRegistry getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpDiskTrimmableRegistry();
      }
      NoOpDiskTrimmableRegistry localNoOpDiskTrimmableRegistry = sInstance;
      return localNoOpDiskTrimmableRegistry;
    }
    finally {}
  }
  
  public void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable) {}
  
  public void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\disk\NoOpDiskTrimmableRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */