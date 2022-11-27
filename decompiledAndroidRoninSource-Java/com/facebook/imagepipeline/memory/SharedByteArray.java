package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;

public class SharedByteArray
  implements MemoryTrimmable
{
  final OOMSoftReference<byte[]> mByteArraySoftRef;
  final int mMaxByteArraySize;
  final int mMinByteArraySize;
  private final ResourceReleaser<byte[]> mResourceReleaser;
  final Semaphore mSemaphore;
  
  public SharedByteArray(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams)
  {
    Preconditions.checkNotNull(paramMemoryTrimmableRegistry);
    int i = paramPoolParams.minBucketSize;
    boolean bool2 = false;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    boolean bool1 = bool2;
    if (paramPoolParams.maxBucketSize >= paramPoolParams.minBucketSize) {
      bool1 = true;
    }
    Preconditions.checkArgument(bool1);
    this.mMaxByteArraySize = paramPoolParams.maxBucketSize;
    this.mMinByteArraySize = paramPoolParams.minBucketSize;
    this.mByteArraySoftRef = new OOMSoftReference();
    this.mSemaphore = new Semaphore(1);
    this.mResourceReleaser = new ResourceReleaser()
    {
      public void release(byte[] paramAnonymousArrayOfByte)
      {
        SharedByteArray.this.mSemaphore.release();
      }
    };
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(this);
  }
  
  private byte[] allocateByteArray(int paramInt)
  {
    try
    {
      this.mByteArraySoftRef.clear();
      byte[] arrayOfByte = new byte[paramInt];
      this.mByteArraySoftRef.set(arrayOfByte);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private byte[] getByteArray(int paramInt)
  {
    paramInt = getBucketedSize(paramInt);
    byte[] arrayOfByte2 = (byte[])this.mByteArraySoftRef.get();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length >= paramInt) {}
    }
    else
    {
      arrayOfByte1 = allocateByteArray(paramInt);
    }
    return arrayOfByte1;
  }
  
  public CloseableReference<byte[]> get(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "Size must be greater than zero");
    if (paramInt <= this.mMaxByteArraySize) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "Requested size is too big");
    this.mSemaphore.acquireUninterruptibly();
    try
    {
      CloseableReference localCloseableReference = CloseableReference.of(getByteArray(paramInt), this.mResourceReleaser);
      return localCloseableReference;
    }
    finally
    {
      this.mSemaphore.release();
    }
  }
  
  int getBucketedSize(int paramInt)
  {
    return Integer.highestOneBit(Math.max(paramInt, this.mMinByteArraySize) - 1) * 2;
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    if (!this.mSemaphore.tryAcquire()) {
      return;
    }
    try
    {
      this.mByteArraySoftRef.clear();
      return;
    }
    finally
    {
      this.mSemaphore.release();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\SharedByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */