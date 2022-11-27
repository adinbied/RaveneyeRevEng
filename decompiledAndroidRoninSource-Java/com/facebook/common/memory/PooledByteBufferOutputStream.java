package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream
  extends OutputStream
{
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
    }
  }
  
  public abstract int size();
  
  public abstract PooledByteBuffer toByteBuffer();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\PooledByteBufferOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */