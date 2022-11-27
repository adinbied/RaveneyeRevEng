package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.concurrent.BlockingQueue;

public class SocketChannelIOHelper
{
  public static boolean batch(WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws IOException
  {
    Object localObject2 = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
    boolean bool = false;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramByteChannel instanceof WrappedByteChannel))
      {
        localObject2 = (WrappedByteChannel)paramByteChannel;
        localObject1 = localObject2;
        if (!((WrappedByteChannel)localObject2).isNeedWrite()) {
          break label114;
        }
        ((WrappedByteChannel)localObject2).writeMore();
        localObject1 = localObject2;
        break label114;
      }
    }
    else {
      do
      {
        paramByteChannel.write((ByteBuffer)localObject1);
        if (((ByteBuffer)localObject1).remaining() > 0) {
          return false;
        }
        paramWebSocketImpl.outQueue.poll();
        localObject2 = (ByteBuffer)paramWebSocketImpl.outQueue.peek();
        localObject1 = localObject2;
      } while (localObject2 != null);
    }
    localObject1 = null;
    label114:
    if ((paramWebSocketImpl.outQueue.isEmpty()) && (paramWebSocketImpl.isFlushAndClose())) {
      try
      {
        paramWebSocketImpl.closeConnection();
      }
      finally {}
    }
    if ((localObject1 == null) || (!((WrappedByteChannel)paramByteChannel).isNeedWrite())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean read(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws IOException
  {
    paramByteBuffer.clear();
    int i = paramByteChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    boolean bool = false;
    if (i == -1)
    {
      paramWebSocketImpl.eot();
      return false;
    }
    if (i != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean readMore(ByteBuffer paramByteBuffer, WebSocketImpl paramWebSocketImpl, WrappedByteChannel paramWrappedByteChannel)
    throws IOException
  {
    paramByteBuffer.clear();
    int i = paramWrappedByteChannel.readMore(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == -1)
    {
      paramWebSocketImpl.eot();
      return false;
    }
    return paramWrappedByteChannel.isNeedRead();
  }
  
  public static void writeBlocking(WebSocketImpl paramWebSocketImpl, ByteChannel paramByteChannel)
    throws InterruptedException, IOException
  {
    paramWebSocketImpl = (ByteBuffer)paramWebSocketImpl.outQueue.take();
    while (paramWebSocketImpl.hasRemaining()) {
      paramByteChannel.write(paramWebSocketImpl);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\SocketChannelIOHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */