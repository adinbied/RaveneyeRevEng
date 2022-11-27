package com.facebook.common.statfs;

import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

public class StatFsHelper
{
  public static final long DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES = 1048576000L;
  public static final long DEFAULT_DISK_RED_LEVEL_IN_BYTES = 104857600L;
  public static final int DEFAULT_DISK_RED_LEVEL_IN_MB = 100;
  public static final long DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES = 419430400L;
  public static final int DEFAULT_DISK_YELLOW_LEVEL_IN_MB = 400;
  private static final long RESTAT_INTERVAL_MS = TimeUnit.MINUTES.toMillis(2L);
  private static StatFsHelper sStatsFsHelper;
  private final Lock lock = new ReentrantLock();
  private volatile File mExternalPath;
  @Nullable
  private volatile StatFs mExternalStatFs = null;
  private volatile boolean mInitialized = false;
  private volatile File mInternalPath;
  @Nullable
  private volatile StatFs mInternalStatFs = null;
  private long mLastRestatTime;
  
  protected static StatFs createStatFs(String paramString)
  {
    return new StatFs(paramString);
  }
  
  private void ensureInitialized()
  {
    if (!this.mInitialized)
    {
      this.lock.lock();
      try
      {
        if (!this.mInitialized)
        {
          this.mInternalPath = Environment.getDataDirectory();
          this.mExternalPath = Environment.getExternalStorageDirectory();
          updateStats();
          this.mInitialized = true;
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public static StatFsHelper getInstance()
  {
    try
    {
      if (sStatsFsHelper == null) {
        sStatsFsHelper = new StatFsHelper();
      }
      StatFsHelper localStatFsHelper = sStatsFsHelper;
      return localStatFsHelper;
    }
    finally {}
  }
  
  private void maybeUpdateStats()
  {
    if (this.lock.tryLock()) {
      try
      {
        if (SystemClock.uptimeMillis() - this.mLastRestatTime > RESTAT_INTERVAL_MS) {
          updateStats();
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  private void updateStats()
  {
    this.mInternalStatFs = updateStatsHelper(this.mInternalStatFs, this.mInternalPath);
    this.mExternalStatFs = updateStatsHelper(this.mExternalStatFs, this.mExternalPath);
    this.mLastRestatTime = SystemClock.uptimeMillis();
  }
  
  /* Error */
  @Nullable
  private StatFs updateStatsHelper(@Nullable StatFs paramStatFs, @Nullable File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +43 -> 44
    //   4: aload_2
    //   5: invokevirtual 128	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnonnull +14 -> 28
    //   17: aload_2
    //   18: invokevirtual 132	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: invokestatic 134	com/facebook/common/statfs/StatFsHelper:createStatFs	(Ljava/lang/String;)Landroid/os/StatFs;
    //   24: astore_1
    //   25: goto +11 -> 36
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual 132	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   33: invokevirtual 137	android/os/StatFs:restat	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_1
    //   39: aload_1
    //   40: invokestatic 143	com/facebook/common/internal/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   43: athrow
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: aconst_null
    //   48: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	StatFsHelper
    //   0	49	1	paramStatFs	StatFs
    //   0	49	2	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   17	25	38	finally
    //   28	36	38	finally
    //   17	25	46	java/lang/IllegalArgumentException
    //   28	36	46	java/lang/IllegalArgumentException
  }
  
  public long getAvailableStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    if (paramStorageType == StorageType.INTERNAL) {
      paramStorageType = this.mInternalStatFs;
    } else {
      paramStorageType = this.mExternalStatFs;
    }
    if (paramStorageType != null)
    {
      long l1;
      long l2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = paramStorageType.getBlockSizeLong();
        l2 = paramStorageType.getAvailableBlocksLong();
      }
      else
      {
        l1 = paramStorageType.getBlockSize();
        l2 = paramStorageType.getAvailableBlocks();
      }
      return l1 * l2;
    }
    return 0L;
  }
  
  public long getFreeStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    if (paramStorageType == StorageType.INTERNAL) {
      paramStorageType = this.mInternalStatFs;
    } else {
      paramStorageType = this.mExternalStatFs;
    }
    if (paramStorageType != null)
    {
      long l1;
      long l2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = paramStorageType.getBlockSizeLong();
        l2 = paramStorageType.getFreeBlocksLong();
      }
      else
      {
        l1 = paramStorageType.getBlockSize();
        l2 = paramStorageType.getFreeBlocks();
      }
      return l1 * l2;
    }
    return -1L;
  }
  
  public long getTotalStorageSpace(StorageType paramStorageType)
  {
    ensureInitialized();
    maybeUpdateStats();
    if (paramStorageType == StorageType.INTERNAL) {
      paramStorageType = this.mInternalStatFs;
    } else {
      paramStorageType = this.mExternalStatFs;
    }
    if (paramStorageType != null)
    {
      long l1;
      long l2;
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = paramStorageType.getBlockSizeLong();
        l2 = paramStorageType.getBlockCountLong();
      }
      else
      {
        l1 = paramStorageType.getBlockSize();
        l2 = paramStorageType.getBlockCount();
      }
      return l1 * l2;
    }
    return -1L;
  }
  
  public boolean isHighSpaceCondition()
  {
    return getAvailableStorageSpace(StorageType.INTERNAL) > 1048576000L;
  }
  
  public boolean isLowSpaceCondition()
  {
    return getAvailableStorageSpace(StorageType.INTERNAL) < 419430400L;
  }
  
  public boolean isVeryLowSpaceCondition()
  {
    return getAvailableStorageSpace(StorageType.INTERNAL) < 104857600L;
  }
  
  public void resetStats()
  {
    if (this.lock.tryLock()) {
      try
      {
        ensureInitialized();
        updateStats();
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public boolean testLowDiskSpace(StorageType paramStorageType, long paramLong)
  {
    ensureInitialized();
    long l = getAvailableStorageSpace(paramStorageType);
    boolean bool = true;
    if (l > 0L)
    {
      if (l < paramLong) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static enum StorageType
  {
    static
    {
      StorageType localStorageType = new StorageType("EXTERNAL", 1);
      EXTERNAL = localStorageType;
      $VALUES = new StorageType[] { INTERNAL, localStorageType };
    }
    
    private StorageType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\statfs\StatFsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */