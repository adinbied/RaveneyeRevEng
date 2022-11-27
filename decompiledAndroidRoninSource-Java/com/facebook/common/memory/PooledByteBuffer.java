package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract interface PooledByteBuffer
  extends Closeable
{
  public abstract void close();
  
  @Nullable
  public abstract ByteBuffer getByteBuffer();
  
  public abstract long getNativePtr();
  
  public abstract boolean isClosed();
  
  public abstract byte read(int paramInt);
  
  public abstract int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract int size();
  
  public static class ClosedException
    extends RuntimeException
  {
    public ClosedException()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\PooledByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */