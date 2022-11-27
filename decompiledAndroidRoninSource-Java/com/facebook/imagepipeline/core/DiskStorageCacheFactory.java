package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.cache.disk.FileCache;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskStorageCacheFactory
  implements FileCacheFactory
{
  private DiskStorageFactory mDiskStorageFactory;
  
  public DiskStorageCacheFactory(DiskStorageFactory paramDiskStorageFactory)
  {
    this.mDiskStorageFactory = paramDiskStorageFactory;
  }
  
  public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig paramDiskCacheConfig, DiskStorage paramDiskStorage)
  {
    return buildDiskStorageCache(paramDiskCacheConfig, paramDiskStorage, Executors.newSingleThreadExecutor());
  }
  
  public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig paramDiskCacheConfig, DiskStorage paramDiskStorage, Executor paramExecutor)
  {
    DiskStorageCache.Params localParams = new DiskStorageCache.Params(paramDiskCacheConfig.getMinimumSizeLimit(), paramDiskCacheConfig.getLowDiskSpaceSizeLimit(), paramDiskCacheConfig.getDefaultSizeLimit());
    return new DiskStorageCache(paramDiskStorage, paramDiskCacheConfig.getEntryEvictionComparatorSupplier(), localParams, paramDiskCacheConfig.getCacheEventListener(), paramDiskCacheConfig.getCacheErrorLogger(), paramDiskCacheConfig.getDiskTrimmableRegistry(), paramExecutor, paramDiskCacheConfig.getIndexPopulateAtStartupEnabled());
  }
  
  public FileCache get(DiskCacheConfig paramDiskCacheConfig)
  {
    return buildDiskStorageCache(paramDiskCacheConfig, this.mDiskStorageFactory.get(paramDiskCacheConfig));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\DiskStorageCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */