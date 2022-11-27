package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract interface MemoryChunk
{
  public abstract void close();
  
  public abstract void copy(int paramInt1, MemoryChunk paramMemoryChunk, int paramInt2, int paramInt3);
  
  @Nullable
  public abstract ByteBuffer getByteBuffer();
  
  public abstract long getNativePtr()
    throws UnsupportedOperationException;
  
  public abstract int getSize();
  
  public abstract long getUniqueId();
  
  public abstract boolean isClosed();
  
  public abstract byte read(int paramInt);
  
  public abstract int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract int write(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\MemoryChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */