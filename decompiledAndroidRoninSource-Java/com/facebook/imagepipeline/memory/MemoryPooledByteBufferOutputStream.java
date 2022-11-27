package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;

public class MemoryPooledByteBufferOutputStream
  extends PooledByteBufferOutputStream
{
  private CloseableReference<MemoryChunk> mBufRef;
  private int mCount;
  private final MemoryChunkPool mPool;
  
  public MemoryPooledByteBufferOutputStream(MemoryChunkPool paramMemoryChunkPool)
  {
    this(paramMemoryChunkPool, paramMemoryChunkPool.getMinBufferSize());
  }
  
  public MemoryPooledByteBufferOutputStream(MemoryChunkPool paramMemoryChunkPool, int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    paramMemoryChunkPool = (MemoryChunkPool)Preconditions.checkNotNull(paramMemoryChunkPool);
    this.mPool = paramMemoryChunkPool;
    this.mCount = 0;
    this.mBufRef = CloseableReference.of(paramMemoryChunkPool.get(paramInt), this.mPool);
  }
  
  private void ensureValid()
  {
    if (CloseableReference.isValid(this.mBufRef)) {
      return;
    }
    throw new InvalidStreamException();
  }
  
  public void close()
  {
    CloseableReference.closeSafely(this.mBufRef);
    this.mBufRef = null;
    this.mCount = -1;
    super.close();
  }
  
  void realloc(int paramInt)
  {
    ensureValid();
    if (paramInt <= ((MemoryChunk)this.mBufRef.get()).getSize()) {
      return;
    }
    MemoryChunk localMemoryChunk = (MemoryChunk)this.mPool.get(paramInt);
    ((MemoryChunk)this.mBufRef.get()).copy(0, localMemoryChunk, 0, this.mCount);
    this.mBufRef.close();
    this.mBufRef = CloseableReference.of(localMemoryChunk, this.mPool);
  }
  
  public int size()
  {
    return this.mCount;
  }
  
  public MemoryPooledByteBuffer toByteBuffer()
  {
    ensureValid();
    return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt });
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
    {
      ensureValid();
      realloc(this.mCount + paramInt2);
      ((MemoryChunk)this.mBufRef.get()).write(this.mCount, paramArrayOfByte, paramInt1, paramInt2);
      this.mCount += paramInt2;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length=");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append("; regionStart=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("; regionLength=");
    localStringBuilder.append(paramInt2);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public static class InvalidStreamException
    extends RuntimeException
  {
    public InvalidStreamException()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\MemoryPooledByteBufferOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */