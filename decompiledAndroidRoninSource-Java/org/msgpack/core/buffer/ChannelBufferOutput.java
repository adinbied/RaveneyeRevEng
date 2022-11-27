package org.msgpack.core.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.msgpack.core.Preconditions;

public class ChannelBufferOutput
  implements MessageBufferOutput
{
  private MessageBuffer buffer;
  private WritableByteChannel channel;
  
  public ChannelBufferOutput(WritableByteChannel paramWritableByteChannel)
  {
    this(paramWritableByteChannel, 8192);
  }
  
  public ChannelBufferOutput(WritableByteChannel paramWritableByteChannel, int paramInt)
  {
    this.channel = ((WritableByteChannel)Preconditions.checkNotNull(paramWritableByteChannel, "output channel is null"));
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
    this.channel.close();
  }
  
  public void flush()
    throws IOException
  {}
  
  public MessageBuffer next(int paramInt)
    throws IOException
  {
    if (this.buffer.size() < paramInt) {
      this.buffer = MessageBuffer.allocate(paramInt);
    }
    return this.buffer;
  }
  
  public WritableByteChannel reset(WritableByteChannel paramWritableByteChannel)
    throws IOException
  {
    WritableByteChannel localWritableByteChannel = this.channel;
    this.channel = paramWritableByteChannel;
    return localWritableByteChannel;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    while (paramArrayOfByte.hasRemaining()) {
      this.channel.write(paramArrayOfByte);
    }
  }
  
  public void writeBuffer(int paramInt)
    throws IOException
  {
    ByteBuffer localByteBuffer = this.buffer.sliceAsByteBuffer(0, paramInt);
    while (localByteBuffer.hasRemaining()) {
      this.channel.write(localByteBuffer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\ChannelBufferOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */