package org.msgpack.core.buffer;

import java.io.IOException;
import org.msgpack.core.Preconditions;

public class ArrayBufferInput
  implements MessageBufferInput
{
  private MessageBuffer buffer;
  private boolean isEmpty;
  
  public ArrayBufferInput(MessageBuffer paramMessageBuffer)
  {
    this.buffer = paramMessageBuffer;
    if (paramMessageBuffer == null)
    {
      this.isEmpty = true;
      return;
    }
    this.isEmpty = false;
  }
  
  public ArrayBufferInput(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ArrayBufferInput(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(MessageBuffer.wrap((byte[])Preconditions.checkNotNull(paramArrayOfByte, "input array is null"), paramInt1, paramInt2));
  }
  
  public void close()
    throws IOException
  {
    this.buffer = null;
    this.isEmpty = true;
  }
  
  public MessageBuffer next()
    throws IOException
  {
    if (this.isEmpty) {
      return null;
    }
    this.isEmpty = true;
    return this.buffer;
  }
  
  public MessageBuffer reset(MessageBuffer paramMessageBuffer)
  {
    MessageBuffer localMessageBuffer = this.buffer;
    this.buffer = paramMessageBuffer;
    if (paramMessageBuffer == null)
    {
      this.isEmpty = true;
      return localMessageBuffer;
    }
    this.isEmpty = false;
    return localMessageBuffer;
  }
  
  public void reset(byte[] paramArrayOfByte)
  {
    reset(MessageBuffer.wrap((byte[])Preconditions.checkNotNull(paramArrayOfByte, "input array is null")));
  }
  
  public void reset(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    reset(MessageBuffer.wrap((byte[])Preconditions.checkNotNull(paramArrayOfByte, "input array is null"), paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\ArrayBufferInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */