package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import javax.net.ssl.SSLException;

public class AbstractWrappedByteChannel
  implements WrappedByteChannel
{
  private final ByteChannel channel;
  
  public AbstractWrappedByteChannel(ByteChannel paramByteChannel)
  {
    this.channel = paramByteChannel;
  }
  
  public AbstractWrappedByteChannel(WrappedByteChannel paramWrappedByteChannel)
  {
    this.channel = paramWrappedByteChannel;
  }
  
  public void close()
    throws IOException
  {
    this.channel.close();
  }
  
  public boolean isBlocking()
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof SocketChannel)) {
      return ((SocketChannel)localByteChannel).isBlocking();
    }
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).isBlocking();
    }
    return false;
  }
  
  public boolean isNeedRead()
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).isNeedRead();
    }
    return false;
  }
  
  public boolean isNeedWrite()
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).isNeedWrite();
    }
    return false;
  }
  
  public boolean isOpen()
  {
    return this.channel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return this.channel.read(paramByteBuffer);
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      return ((WrappedByteChannel)localByteChannel).readMore(paramByteBuffer);
    }
    return 0;
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    return this.channel.write(paramByteBuffer);
  }
  
  public void writeMore()
    throws IOException
  {
    ByteChannel localByteChannel = this.channel;
    if ((localByteChannel instanceof WrappedByteChannel)) {
      ((WrappedByteChannel)localByteChannel).writeMore();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\AbstractWrappedByteChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */