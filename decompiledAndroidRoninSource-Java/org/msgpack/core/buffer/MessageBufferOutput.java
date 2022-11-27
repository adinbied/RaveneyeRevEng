package org.msgpack.core.buffer;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface MessageBufferOutput
  extends Closeable, Flushable
{
  public abstract void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract MessageBuffer next(int paramInt)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeBuffer(int paramInt)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\MessageBufferOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */