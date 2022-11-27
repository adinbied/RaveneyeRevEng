package org.msgpack.core.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.msgpack.core.Preconditions;

public class ChannelBufferInput
  implements MessageBufferInput
{
  private final MessageBuffer buffer;
  private ReadableByteChannel channel;
  
  public ChannelBufferInput(ReadableByteChannel paramReadableByteChannel)
  {
    this(paramReadableByteChannel, 8192);
  }
  
  public ChannelBufferInput(ReadableByteChannel paramReadableByteChannel, int paramInt)
  {
    this.channel = ((ReadableByteChannel)Preconditions.checkNotNull(paramReadableByteChannel, "input channel is null"));
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramReadableByteChannel = new StringBuilder();
    paramReadableByteChannel.append("buffer size must be > 0: ");
    paramReadableByteChannel.append(paramInt);
    Preconditions.checkArgument(bool, paramReadableByteChannel.toString());
    this.buffer = MessageBuffer.allocate(paramInt);
  }
  
  public void close()
    throws IOException
  {
    this.channel.close();
  }
  
  public MessageBuffer next()
    throws IOException
  {
    ByteBuffer localByteBuffer = this.buffer.sliceAsByteBuffer();
    while ((localByteBuffer.remaining() > 0) && (this.channel.read(localByteBuffer) != -1)) {}
    localByteBuffer.flip();
    if (localByteBuffer.remaining() == 0) {
      return null;
    }
    return this.buffer.slice(0, localByteBuffer.limit());
  }
  
  public ReadableByteChannel reset(ReadableByteChannel paramReadableByteChannel)
    throws IOException
  {
    ReadableByteChannel localReadableByteChannel = this.channel;
    this.channel = paramReadableByteChannel;
    return localReadableByteChannel;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\ChannelBufferInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */