package org.msgpack.core;

import java.io.IOException;
import java.util.List;
import org.msgpack.core.buffer.ArrayBufferOutput;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;

public class MessageBufferPacker
  extends MessagePacker
{
  protected MessageBufferPacker(MessagePack.PackerConfig paramPackerConfig)
  {
    this(new ArrayBufferOutput(), paramPackerConfig);
  }
  
  protected MessageBufferPacker(ArrayBufferOutput paramArrayBufferOutput, MessagePack.PackerConfig paramPackerConfig)
  {
    super(paramArrayBufferOutput, paramPackerConfig);
  }
  
  private ArrayBufferOutput getArrayBufferOut()
  {
    return (ArrayBufferOutput)this.out;
  }
  
  public void clear()
  {
    getArrayBufferOut().clear();
  }
  
  public MessageBufferOutput reset(MessageBufferOutput paramMessageBufferOutput)
    throws IOException
  {
    if ((paramMessageBufferOutput instanceof ArrayBufferOutput)) {
      return super.reset(paramMessageBufferOutput);
    }
    throw new IllegalArgumentException("MessageBufferPacker accepts only ArrayBufferOutput");
  }
  
  public List<MessageBuffer> toBufferList()
  {
    try
    {
      flush();
      return getArrayBufferOut().toBufferList();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public byte[] toByteArray()
  {
    try
    {
      flush();
      return getArrayBufferOut().toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
  
  public MessageBuffer toMessageBuffer()
  {
    try
    {
      flush();
      return getArrayBufferOut().toMessageBuffer();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageBufferPacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */