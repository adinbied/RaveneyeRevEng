package com.facebook.imagepipeline.memory;

import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;

public class PoolFactory
{
  @Nullable
  private MemoryChunkPool mAshmemMemoryChunkPool;
  private BitmapPool mBitmapPool;
  @Nullable
  private MemoryChunkPool mBufferMemoryChunkPool;
  private final PoolConfig mConfig;
  private FlexByteArrayPool mFlexByteArrayPool;
  @Nullable
  private MemoryChunkPool mNativeMemoryChunkPool;
  private PooledByteBufferFactory mPooledByteBufferFactory;
  private PooledByteStreams mPooledByteStreams;
  private SharedByteArray mSharedByteArray;
  private ByteArrayPool mSmallByteArrayPool;
  
  public PoolFactory(PoolConfig paramPoolConfig)
  {
    this.mConfig = ((PoolConfig)Preconditions.checkNotNull(paramPoolConfig));
  }
  
  @Nullable
  private MemoryChunkPool getAshmemMemoryChunkPool()
  {
    if (this.mAshmemMemoryChunkPool == null) {}
    try
    {
      this.mAshmemMemoryChunkPool = ((MemoryChunkPool)Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(new Class[] { MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class }).newInstance(new Object[] { this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker() }));
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    this.mAshmemMemoryChunkPool = null;
    break label118;
    this.mAshmemMemoryChunkPool = null;
    break label118;
    this.mAshmemMemoryChunkPool = null;
    break label118;
    this.mAshmemMemoryChunkPool = null;
    break label118;
    this.mAshmemMemoryChunkPool = null;
    label118:
    return this.mAshmemMemoryChunkPool;
  }
  
  @Nullable
  private MemoryChunkPool getMemoryChunkPool(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return getAshmemMemoryChunkPool();
        }
        throw new IllegalArgumentException("Invalid MemoryChunkType");
      }
      return getBufferMemoryChunkPool();
    }
    return getNativeMemoryChunkPool();
  }
  
  public BitmapPool getBitmapPool()
  {
    if (this.mBitmapPool == null)
    {
      Object localObject = this.mConfig.getBitmapPoolType();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 95945896: 
        if (((String)localObject).equals("dummy")) {
          i = 0;
        }
        break;
      case -402149703: 
        if (((String)localObject).equals("dummy_with_tracking")) {
          i = 1;
        }
        break;
      case -404562712: 
        if (((String)localObject).equals("experimental")) {
          i = 2;
        }
        break;
      case -1106578487: 
        if (((String)localObject).equals("legacy")) {
          i = 4;
        }
        break;
      case -1868884870: 
        if (((String)localObject).equals("legacy_default_params")) {
          i = 3;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (Build.VERSION.SDK_INT >= 21) {
                this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
              } else {
                this.mBitmapPool = new DummyBitmapPool();
              }
            }
            else {
              this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), this.mConfig.getBitmapPoolStatsTracker(), this.mConfig.isIgnoreBitmapPoolHardCap());
            }
          }
          else
          {
            i = this.mConfig.getBitmapPoolMaxPoolSize();
            int j = this.mConfig.getBitmapPoolMaxBitmapSize();
            NoOpPoolStatsTracker localNoOpPoolStatsTracker = NoOpPoolStatsTracker.getInstance();
            if (this.mConfig.isRegisterLruBitmapPoolAsMemoryTrimmable()) {
              localObject = this.mConfig.getMemoryTrimmableRegistry();
            } else {
              localObject = null;
            }
            this.mBitmapPool = new LruBitmapPool(i, j, localNoOpPoolStatsTracker, (MemoryTrimmableRegistry)localObject);
          }
        }
        else {
          this.mBitmapPool = new DummyTrackingInUseBitmapPool();
        }
      }
      else {
        this.mBitmapPool = new DummyBitmapPool();
      }
    }
    return this.mBitmapPool;
  }
  
  @Nullable
  public MemoryChunkPool getBufferMemoryChunkPool()
  {
    if (this.mBufferMemoryChunkPool == null) {}
    try
    {
      this.mBufferMemoryChunkPool = ((MemoryChunkPool)Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(new Class[] { MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class }).newInstance(new Object[] { this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker() }));
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    this.mBufferMemoryChunkPool = null;
    break label118;
    this.mBufferMemoryChunkPool = null;
    break label118;
    this.mBufferMemoryChunkPool = null;
    break label118;
    this.mBufferMemoryChunkPool = null;
    break label118;
    this.mBufferMemoryChunkPool = null;
    label118:
    return this.mBufferMemoryChunkPool;
  }
  
  public FlexByteArrayPool getFlexByteArrayPool()
  {
    if (this.mFlexByteArrayPool == null) {
      this.mFlexByteArrayPool = new FlexByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    }
    return this.mFlexByteArrayPool;
  }
  
  public int getFlexByteArrayPoolMaxNumThreads()
  {
    return this.mConfig.getFlexByteArrayPoolParams().maxNumThreads;
  }
  
  @Nullable
  public MemoryChunkPool getNativeMemoryChunkPool()
  {
    if (this.mNativeMemoryChunkPool == null) {
      try
      {
        this.mNativeMemoryChunkPool = ((MemoryChunkPool)Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(new Class[] { MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class }).newInstance(new Object[] { this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker() }));
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        FLog.e("PoolFactory", "", localInvocationTargetException);
        this.mNativeMemoryChunkPool = null;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        FLog.e("PoolFactory", "", localNoSuchMethodException);
        this.mNativeMemoryChunkPool = null;
      }
      catch (InstantiationException localInstantiationException)
      {
        FLog.e("PoolFactory", "", localInstantiationException);
        this.mNativeMemoryChunkPool = null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        FLog.e("PoolFactory", "", localIllegalAccessException);
        this.mNativeMemoryChunkPool = null;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        FLog.e("PoolFactory", "", localClassNotFoundException);
        this.mNativeMemoryChunkPool = null;
      }
    }
    return this.mNativeMemoryChunkPool;
  }
  
  public PooledByteBufferFactory getPooledByteBufferFactory()
  {
    return getPooledByteBufferFactory(NativeCodeSetup.getUseNativeCode() ^ true);
  }
  
  public PooledByteBufferFactory getPooledByteBufferFactory(int paramInt)
  {
    if (this.mPooledByteBufferFactory == null)
    {
      MemoryChunkPool localMemoryChunkPool = getMemoryChunkPool(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to get pool for chunk type: ");
      localStringBuilder.append(paramInt);
      Preconditions.checkNotNull(localMemoryChunkPool, localStringBuilder.toString());
      this.mPooledByteBufferFactory = new MemoryPooledByteBufferFactory(getMemoryChunkPool(paramInt), getPooledByteStreams());
    }
    return this.mPooledByteBufferFactory;
  }
  
  public PooledByteStreams getPooledByteStreams()
  {
    if (this.mPooledByteStreams == null) {
      this.mPooledByteStreams = new PooledByteStreams(getSmallByteArrayPool());
    }
    return this.mPooledByteStreams;
  }
  
  public SharedByteArray getSharedByteArray()
  {
    if (this.mSharedByteArray == null) {
      this.mSharedByteArray = new SharedByteArray(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    }
    return this.mSharedByteArray;
  }
  
  public ByteArrayPool getSmallByteArrayPool()
  {
    if (this.mSmallByteArrayPool == null) {
      this.mSmallByteArrayPool = new GenericByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getSmallByteArrayPoolParams(), this.mConfig.getSmallByteArrayPoolStatsTracker());
    }
    return this.mSmallByteArrayPool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\PoolFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */