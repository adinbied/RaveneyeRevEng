package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;

public class DiskCacheConfig
{
  private final String mBaseDirectoryName;
  private final Supplier<File> mBaseDirectoryPathSupplier;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  private final Context mContext;
  private final long mDefaultSizeLimit;
  private final DiskTrimmableRegistry mDiskTrimmableRegistry;
  private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
  private final boolean mIndexPopulateAtStartupEnabled;
  private final long mLowDiskSpaceSizeLimit;
  private final long mMinimumSizeLimit;
  private final int mVersion;
  
  protected DiskCacheConfig(Builder paramBuilder)
  {
    this.mContext = paramBuilder.mContext;
    boolean bool;
    if ((paramBuilder.mBaseDirectoryPathSupplier == null) && (this.mContext == null)) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.checkState(bool, "Either a non-null context or a base directory path or supplier must be provided.");
    if ((paramBuilder.mBaseDirectoryPathSupplier == null) && (this.mContext != null)) {
      Builder.access$102(paramBuilder, new Supplier()
      {
        public File get()
        {
          return DiskCacheConfig.this.mContext.getApplicationContext().getCacheDir();
        }
      });
    }
    this.mVersion = paramBuilder.mVersion;
    this.mBaseDirectoryName = ((String)Preconditions.checkNotNull(paramBuilder.mBaseDirectoryName));
    this.mBaseDirectoryPathSupplier = ((Supplier)Preconditions.checkNotNull(paramBuilder.mBaseDirectoryPathSupplier));
    this.mDefaultSizeLimit = paramBuilder.mMaxCacheSize;
    this.mLowDiskSpaceSizeLimit = paramBuilder.mMaxCacheSizeOnLowDiskSpace;
    this.mMinimumSizeLimit = paramBuilder.mMaxCacheSizeOnVeryLowDiskSpace;
    this.mEntryEvictionComparatorSupplier = ((EntryEvictionComparatorSupplier)Preconditions.checkNotNull(paramBuilder.mEntryEvictionComparatorSupplier));
    Object localObject;
    if (paramBuilder.mCacheErrorLogger == null) {
      localObject = NoOpCacheErrorLogger.getInstance();
    } else {
      localObject = paramBuilder.mCacheErrorLogger;
    }
    this.mCacheErrorLogger = ((CacheErrorLogger)localObject);
    if (paramBuilder.mCacheEventListener == null) {
      localObject = NoOpCacheEventListener.getInstance();
    } else {
      localObject = paramBuilder.mCacheEventListener;
    }
    this.mCacheEventListener = ((CacheEventListener)localObject);
    if (paramBuilder.mDiskTrimmableRegistry == null) {
      localObject = NoOpDiskTrimmableRegistry.getInstance();
    } else {
      localObject = paramBuilder.mDiskTrimmableRegistry;
    }
    this.mDiskTrimmableRegistry = ((DiskTrimmableRegistry)localObject);
    this.mIndexPopulateAtStartupEnabled = paramBuilder.mIndexPopulateAtStartupEnabled;
  }
  
  public static Builder newBuilder(@Nullable Context paramContext)
  {
    return new Builder(paramContext, null);
  }
  
  public String getBaseDirectoryName()
  {
    return this.mBaseDirectoryName;
  }
  
  public Supplier<File> getBaseDirectoryPathSupplier()
  {
    return this.mBaseDirectoryPathSupplier;
  }
  
  public CacheErrorLogger getCacheErrorLogger()
  {
    return this.mCacheErrorLogger;
  }
  
  public CacheEventListener getCacheEventListener()
  {
    return this.mCacheEventListener;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public long getDefaultSizeLimit()
  {
    return this.mDefaultSizeLimit;
  }
  
  public DiskTrimmableRegistry getDiskTrimmableRegistry()
  {
    return this.mDiskTrimmableRegistry;
  }
  
  public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier()
  {
    return this.mEntryEvictionComparatorSupplier;
  }
  
  public boolean getIndexPopulateAtStartupEnabled()
  {
    return this.mIndexPopulateAtStartupEnabled;
  }
  
  public long getLowDiskSpaceSizeLimit()
  {
    return this.mLowDiskSpaceSizeLimit;
  }
  
  public long getMinimumSizeLimit()
  {
    return this.mMinimumSizeLimit;
  }
  
  public int getVersion()
  {
    return this.mVersion;
  }
  
  public static class Builder
  {
    private String mBaseDirectoryName = "image_cache";
    private Supplier<File> mBaseDirectoryPathSupplier;
    private CacheErrorLogger mCacheErrorLogger;
    private CacheEventListener mCacheEventListener;
    @Nullable
    private final Context mContext;
    private DiskTrimmableRegistry mDiskTrimmableRegistry;
    private EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
    private boolean mIndexPopulateAtStartupEnabled;
    private long mMaxCacheSize = 41943040L;
    private long mMaxCacheSizeOnLowDiskSpace = 10485760L;
    private long mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
    private int mVersion = 1;
    
    private Builder(@Nullable Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public DiskCacheConfig build()
    {
      return new DiskCacheConfig(this);
    }
    
    public Builder setBaseDirectoryName(String paramString)
    {
      this.mBaseDirectoryName = paramString;
      return this;
    }
    
    public Builder setBaseDirectoryPath(File paramFile)
    {
      this.mBaseDirectoryPathSupplier = Suppliers.of(paramFile);
      return this;
    }
    
    public Builder setBaseDirectoryPathSupplier(Supplier<File> paramSupplier)
    {
      this.mBaseDirectoryPathSupplier = paramSupplier;
      return this;
    }
    
    public Builder setCacheErrorLogger(CacheErrorLogger paramCacheErrorLogger)
    {
      this.mCacheErrorLogger = paramCacheErrorLogger;
      return this;
    }
    
    public Builder setCacheEventListener(CacheEventListener paramCacheEventListener)
    {
      this.mCacheEventListener = paramCacheEventListener;
      return this;
    }
    
    public Builder setDiskTrimmableRegistry(DiskTrimmableRegistry paramDiskTrimmableRegistry)
    {
      this.mDiskTrimmableRegistry = paramDiskTrimmableRegistry;
      return this;
    }
    
    public Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier paramEntryEvictionComparatorSupplier)
    {
      this.mEntryEvictionComparatorSupplier = paramEntryEvictionComparatorSupplier;
      return this;
    }
    
    public Builder setIndexPopulateAtStartupEnabled(boolean paramBoolean)
    {
      this.mIndexPopulateAtStartupEnabled = paramBoolean;
      return this;
    }
    
    public Builder setMaxCacheSize(long paramLong)
    {
      this.mMaxCacheSize = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnLowDiskSpace(long paramLong)
    {
      this.mMaxCacheSizeOnLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setMaxCacheSizeOnVeryLowDiskSpace(long paramLong)
    {
      this.mMaxCacheSizeOnVeryLowDiskSpace = paramLong;
      return this;
    }
    
    public Builder setVersion(int paramInt)
    {
      this.mVersion = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\disk\DiskCacheConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */