package org.msgpack.core.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.msgpack.core.Preconditions;

public class InputStreamBufferInput
  implements MessageBufferInput
{
  private final byte[] buffer;
  private InputStream in;
  
  public InputStreamBufferInput(InputStream paramInputStream)
  {
    this(paramInputStream, 8192);
  }
  
  public InputStreamBufferInput(InputStream paramInputStream, int paramInt)
  {
    this.in = ((InputStream)Preconditions.checkNotNull(paramInputStream, "input is null"));
    this.buffer = new byte[paramInt];
  }
  
  public static MessageBufferInput newBufferInput(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream, "InputStream is null");
    if ((paramInputStream instanceof FileInputStream))
    {
      FileChannel localFileChannel = ((FileInputStream)paramInputStream).getChannel();
      if (localFileChannel != null) {
        return new ChannelBufferInput(localFileChannel);
      }
    }
    return new InputStreamBufferInput(paramInputStream);
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public MessageBuffer next()
    throws IOException
  {
    int i = this.in.read(this.buffer);
    if (i == -1) {
      return null;
    }
    return MessageBuffer.wrap(this.buffer, 0, i);
  }
  
  public InputStream reset(InputStream paramInputStream)
    throws IOException
  {
    InputStream localInputStream = this.in;
    this.in = paramInputStream;
    return localInputStream;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\InputStreamBufferInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */