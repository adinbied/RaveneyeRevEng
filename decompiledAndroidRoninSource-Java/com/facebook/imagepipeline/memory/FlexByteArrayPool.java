package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;

public class FlexByteArrayPool
{
  final SoftRefByteArrayPool mDelegatePool;
  private final ResourceReleaser<byte[]> mResourceReleaser;
  
  public FlexByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams)
  {
    boolean bool;
    if (paramPoolParams.maxNumThreads > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.mDelegatePool = new SoftRefByteArrayPool(paramMemoryTrimmableRegistry, paramPoolParams, NoOpPoolStatsTracker.getInstance());
    this.mResourceReleaser = new ResourceReleaser()
    {
      public void release(byte[] paramAnonymousArrayOfByte)
      {
        FlexByteArrayPool.this.release(paramAnonymousArrayOfByte);
      }
    };
  }
  
  public CloseableReference<byte[]> get(int paramInt)
  {
    return CloseableReference.of(this.mDelegatePool.get(paramInt), this.mResourceReleaser);
  }
  
  public int getMinBufferSize()
  {
    return this.mDelegatePool.getMinBufferSize();
  }
  
  public Map<String, Integer> getStats()
  {
    return this.mDelegatePool.getStats();
  }
  
  public void release(byte[] paramArrayOfByte)
  {
    this.mDelegatePool.release(paramArrayOfByte);
  }
  
  static class SoftRefByteArrayPool
    extends GenericByteArrayPool
  {
    public SoftRefByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
    {
      super(paramPoolParams, paramPoolStatsTracker);
    }
    
    Bucket<byte[]> newBucket(int paramInt)
    {
      return new OOMSoftReferenceBucket(getSizeInBytes(paramInt), this.mPoolParams.maxNumThreads, 0);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\FlexByteArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */