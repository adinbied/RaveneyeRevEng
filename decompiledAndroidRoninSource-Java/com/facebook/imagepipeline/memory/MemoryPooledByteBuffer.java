package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBuffer.ClosedException;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class MemoryPooledByteBuffer
  implements PooledByteBuffer
{
  CloseableReference<MemoryChunk> mBufRef;
  private final int mSize;
  
  public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> paramCloseableReference, int paramInt)
  {
    Preconditions.checkNotNull(paramCloseableReference);
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= ((MemoryChunk)paramCloseableReference.get()).getSize())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.mBufRef = paramCloseableReference.clone();
    this.mSize = paramInt;
  }
  
  public void close()
  {
    try
    {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void ensureValid()
  {
    try
    {
      boolean bool = isClosed();
      if (!bool) {
        return;
      }
      throw new PooledByteBuffer.ClosedException();
    }
    finally {}
  }
  
  @Nullable
  public ByteBuffer getByteBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = ((MemoryChunk)this.mBufRef.get()).getByteBuffer();
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  CloseableReference<MemoryChunk> getCloseableReference()
  {
    return this.mBufRef;
  }
  
  public long getNativePtr()
    throws UnsupportedOperationException
  {
    try
    {
      ensureValid();
      long l = ((MemoryChunk)this.mBufRef.get()).getNativePtr();
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = CloseableReference.isValid(this.mBufRef);
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte read(int paramInt)
  {
    for (;;)
    {
      try
      {
        ensureValid();
        boolean bool2 = true;
        if (paramInt >= 0)
        {
          bool1 = true;
          Preconditions.checkArgument(bool1);
          if (paramInt >= this.mSize) {
            break label73;
          }
          bool1 = bool2;
          Preconditions.checkArgument(bool1);
          byte b = ((MemoryChunk)this.mBufRef.get()).read(paramInt);
          return b;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label73:
      bool1 = false;
    }
  }
  
  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        ensureValid();
        if (paramInt1 + paramInt3 <= this.mSize)
        {
          bool = true;
          Preconditions.checkArgument(bool);
          paramInt1 = ((MemoryChunk)this.mBufRef.get()).read(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
          return paramInt1;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public int size()
  {
    try
    {
      ensureValid();
      int i = this.mSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\MemoryPooledByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */