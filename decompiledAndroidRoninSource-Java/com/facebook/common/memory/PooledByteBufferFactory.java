package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PooledByteBufferFactory
{
  public abstract PooledByteBuffer newByteBuffer(int paramInt);
  
  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException;
  
  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException;
  
  public abstract PooledByteBuffer newByteBuffer(byte[] paramArrayOfByte);
  
  public abstract PooledByteBufferOutputStream newOutputStream();
  
  public abstract PooledByteBufferOutputStream newOutputStream(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\PooledByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */