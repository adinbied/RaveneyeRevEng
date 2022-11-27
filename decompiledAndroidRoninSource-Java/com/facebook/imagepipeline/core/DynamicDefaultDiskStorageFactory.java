package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

public class DynamicDefaultDiskStorageFactory
  implements DiskStorageFactory
{
  public DiskStorage get(DiskCacheConfig paramDiskCacheConfig)
  {
    return new DynamicDefaultDiskStorage(paramDiskCacheConfig.getVersion(), paramDiskCacheConfig.getBaseDirectoryPathSupplier(), paramDiskCacheConfig.getBaseDirectoryName(), paramDiskCacheConfig.getCacheErrorLogger());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\DynamicDefaultDiskStorageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */