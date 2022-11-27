package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class PoolConfig
{
  public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
  private final int mBitmapPoolMaxBitmapSize;
  private final int mBitmapPoolMaxPoolSize;
  private final PoolParams mBitmapPoolParams;
  private final PoolStatsTracker mBitmapPoolStatsTracker;
  private final String mBitmapPoolType;
  private final PoolParams mFlexByteArrayPoolParams;
  private final boolean mIgnoreBitmapPoolHardCap;
  private final PoolParams mMemoryChunkPoolParams;
  private final PoolStatsTracker mMemoryChunkPoolStatsTracker;
  private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  private final boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
  private final PoolParams mSmallByteArrayPoolParams;
  private final PoolStatsTracker mSmallByteArrayPoolStatsTracker;
  
  private PoolConfig(Builder paramBuilder)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("PoolConfig()");
    }
    Object localObject;
    if (paramBuilder.mBitmapPoolParams == null) {
      localObject = DefaultBitmapPoolParams.get();
    } else {
      localObject = paramBuilder.mBitmapPoolParams;
    }
    this.mBitmapPoolParams = ((PoolParams)localObject);
    if (paramBuilder.mBitmapPoolStatsTracker == null) {
      localObject = NoOpPoolStatsTracker.getInstance();
    } else {
      localObject = paramBuilder.mBitmapPoolStatsTracker;
    }
    this.mBitmapPoolStatsTracker = ((PoolStatsTracker)localObject);
    if (paramBuilder.mFlexByteArrayPoolParams == null) {
      localObject = DefaultFlexByteArrayPoolParams.get();
    } else {
      localObject = paramBuilder.mFlexByteArrayPoolParams;
    }
    this.mFlexByteArrayPoolParams = ((PoolParams)localObject);
    if (paramBuilder.mMemoryTrimmableRegistry == null) {
      localObject = NoOpMemoryTrimmableRegistry.getInstance();
    } else {
      localObject = paramBuilder.mMemoryTrimmableRegistry;
    }
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)localObject);
    if (paramBuilder.mMemoryChunkPoolParams == null) {
      localObject = DefaultNativeMemoryChunkPoolParams.get();
    } else {
      localObject = paramBuilder.mMemoryChunkPoolParams;
    }
    this.mMemoryChunkPoolParams = ((PoolParams)localObject);
    if (paramBuilder.mMemoryChunkPoolStatsTracker == null) {
      localObject = NoOpPoolStatsTracker.getInstance();
    } else {
      localObject = paramBuilder.mMemoryChunkPoolStatsTracker;
    }
    this.mMemoryChunkPoolStatsTracker = ((PoolStatsTracker)localObject);
    if (paramBuilder.mSmallByteArrayPoolParams == null) {
      localObject = DefaultByteArrayPoolParams.get();
    } else {
      localObject = paramBuilder.mSmallByteArrayPoolParams;
    }
    this.mSmallByteArrayPoolParams = ((PoolParams)localObject);
    if (paramBuilder.mSmallByteArrayPoolStatsTracker == null) {
      localObject = NoOpPoolStatsTracker.getInstance();
    } else {
      localObject = paramBuilder.mSmallByteArrayPoolStatsTracker;
    }
    this.mSmallByteArrayPoolStatsTracker = ((PoolStatsTracker)localObject);
    if (paramBuilder.mBitmapPoolType == null) {
      localObject = "legacy";
    } else {
      localObject = paramBuilder.mBitmapPoolType;
    }
    this.mBitmapPoolType = ((String)localObject);
    this.mBitmapPoolMaxPoolSize = paramBuilder.mBitmapPoolMaxPoolSize;
    int i;
    if (paramBuilder.mBitmapPoolMaxBitmapSize > 0) {
      i = paramBuilder.mBitmapPoolMaxBitmapSize;
    } else {
      i = 4194304;
    }
    this.mBitmapPoolMaxBitmapSize = i;
    this.mRegisterLruBitmapPoolAsMemoryTrimmable = paramBuilder.mRegisterLruBitmapPoolAsMemoryTrimmable;
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    this.mIgnoreBitmapPoolHardCap = paramBuilder.mIgnoreBitmapPoolHardCap;
  }
  
  public static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  public int getBitmapPoolMaxBitmapSize()
  {
    return this.mBitmapPoolMaxBitmapSize;
  }
  
  public int getBitmapPoolMaxPoolSize()
  {
    return this.mBitmapPoolMaxPoolSize;
  }
  
  public PoolParams getBitmapPoolParams()
  {
    return this.mBitmapPoolParams;
  }
  
  public PoolStatsTracker getBitmapPoolStatsTracker()
  {
    return this.mBitmapPoolStatsTracker;
  }
  
  public String getBitmapPoolType()
  {
    return this.mBitmapPoolType;
  }
  
  public PoolParams getFlexByteArrayPoolParams()
  {
    return this.mFlexByteArrayPoolParams;
  }
  
  public PoolParams getMemoryChunkPoolParams()
  {
    return this.mMemoryChunkPoolParams;
  }
  
  public PoolStatsTracker getMemoryChunkPoolStatsTracker()
  {
    return this.mMemoryChunkPoolStatsTracker;
  }
  
  public MemoryTrimmableRegistry getMemoryTrimmableRegistry()
  {
    return this.mMemoryTrimmableRegistry;
  }
  
  public PoolParams getSmallByteArrayPoolParams()
  {
    return this.mSmallByteArrayPoolParams;
  }
  
  public PoolStatsTracker getSmallByteArrayPoolStatsTracker()
  {
    return this.mSmallByteArrayPoolStatsTracker;
  }
  
  public boolean isIgnoreBitmapPoolHardCap()
  {
    return this.mIgnoreBitmapPoolHardCap;
  }
  
  public boolean isRegisterLruBitmapPoolAsMemoryTrimmable()
  {
    return this.mRegisterLruBitmapPoolAsMemoryTrimmable;
  }
  
  public static class Builder
  {
    private int mBitmapPoolMaxBitmapSize;
    private int mBitmapPoolMaxPoolSize;
    private PoolParams mBitmapPoolParams;
    private PoolStatsTracker mBitmapPoolStatsTracker;
    private String mBitmapPoolType;
    private PoolParams mFlexByteArrayPoolParams;
    public boolean mIgnoreBitmapPoolHardCap;
    private PoolParams mMemoryChunkPoolParams;
    private PoolStatsTracker mMemoryChunkPoolStatsTracker;
    private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
    private PoolParams mSmallByteArrayPoolParams;
    private PoolStatsTracker mSmallByteArrayPoolStatsTracker;
    
    public PoolConfig build()
    {
      return new PoolConfig(this, null);
    }
    
    public Builder setBitmapPoolMaxBitmapSize(int paramInt)
    {
      this.mBitmapPoolMaxBitmapSize = paramInt;
      return this;
    }
    
    public Builder setBitmapPoolMaxPoolSize(int paramInt)
    {
      this.mBitmapPoolMaxPoolSize = paramInt;
      return this;
    }
    
    public Builder setBitmapPoolParams(PoolParams paramPoolParams)
    {
      this.mBitmapPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setBitmapPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mBitmapPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
    
    public Builder setBitmapPoolType(String paramString)
    {
      this.mBitmapPoolType = paramString;
      return this;
    }
    
    public Builder setFlexByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mFlexByteArrayPoolParams = paramPoolParams;
      return this;
    }
    
    public Builder setIgnoreBitmapPoolHardCap(boolean paramBoolean)
    {
      this.mIgnoreBitmapPoolHardCap = paramBoolean;
      return this;
    }
    
    public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
    {
      this.mMemoryTrimmableRegistry = paramMemoryTrimmableRegistry;
      return this;
    }
    
    public Builder setNativeMemoryChunkPoolParams(PoolParams paramPoolParams)
    {
      this.mMemoryChunkPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mMemoryChunkPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
    
    public Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean paramBoolean)
    {
      this.mRegisterLruBitmapPoolAsMemoryTrimmable = paramBoolean;
      return this;
    }
    
    public Builder setSmallByteArrayPoolParams(PoolParams paramPoolParams)
    {
      this.mSmallByteArrayPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
      return this;
    }
    
    public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker paramPoolStatsTracker)
    {
      this.mSmallByteArrayPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\PoolConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */