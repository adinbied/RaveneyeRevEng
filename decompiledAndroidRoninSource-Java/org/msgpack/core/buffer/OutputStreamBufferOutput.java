package org.msgpack.core.buffer;

import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.Preconditions;

public class OutputStreamBufferOutput
  implements MessageBufferOutput
{
  private MessageBuffer buffer;
  private OutputStream out;
  
  public OutputStreamBufferOutput(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  public OutputStreamBufferOutput(OutputStream paramOutputStream, int paramInt)
  {
    this.out = ((OutputStream)Preconditions.checkNotNull(paramOutputStream, "output is null"));
    this.buffer = MessageBuffer.allocate(paramInt);
  }
  
  public void add(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public MessageBuffer next(int paramInt)
    throws IOException
  {
    if (this.buffer.size() < paramInt) {
      this.buffer = MessageBuffer.allocate(paramInt);
    }
    return this.buffer;
  }
  
  public OutputStream reset(OutputStream paramOutputStream)
    throws IOException
  {
    OutputStream localOutputStream = this.out;
    this.out = paramOutputStream;
    return localOutputStream;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeBuffer(int paramInt)
    throws IOException
  {
    write(this.buffer.array(), this.buffer.arrayOffset(), paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\OutputStreamBufferOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */