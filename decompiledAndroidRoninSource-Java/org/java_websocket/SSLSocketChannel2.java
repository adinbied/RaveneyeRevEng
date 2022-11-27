package org.java_websocket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class SSLSocketChannel2
  implements ByteChannel, WrappedByteChannel
{
  protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
  protected SSLEngineResult engineResult;
  private SSLEngineResult.Status engineStatus = SSLEngineResult.Status.BUFFER_UNDERFLOW;
  protected ExecutorService exec;
  protected ByteBuffer inCrypt;
  protected ByteBuffer inData;
  protected ByteBuffer outCrypt;
  protected SelectionKey selectionKey;
  protected SocketChannel socketChannel;
  protected SSLEngine sslEngine;
  protected List<Future<?>> tasks;
  
  public SSLSocketChannel2(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey)
    throws IOException
  {
    if ((paramSocketChannel != null) && (paramSSLEngine != null) && (paramExecutorService != null))
    {
      this.socketChannel = paramSocketChannel;
      this.sslEngine = paramSSLEngine;
      this.exec = paramExecutorService;
      this.tasks = new ArrayList(3);
      if (paramSelectionKey != null)
      {
        paramSelectionKey.interestOps(paramSelectionKey.interestOps() | 0x4);
        this.selectionKey = paramSelectionKey;
      }
      createBuffers(paramSSLEngine.getSession());
      this.socketChannel.write(wrap(emptybuffer));
      processHandshake();
      return;
    }
    throw new IllegalArgumentException("parameter must not be null");
  }
  
  private void consumeFutureUninterruptible(Future<?> paramFuture)
  {
    int i = 0;
    try
    {
      paramFuture.get();
      if (i != 0) {
        Thread.currentThread().interrupt();
      }
      return;
    }
    catch (ExecutionException paramFuture)
    {
      for (;;)
      {
        throw new RuntimeException(paramFuture);
        i = 1;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  private boolean isHandShakeComplete()
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus = this.engineResult.getHandshakeStatus();
    return (localHandshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED) || (localHandshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
  }
  
  private void processHandshake()
    throws IOException
  {
    try
    {
      Object localObject1 = this.engineResult.getHandshakeStatus();
      Object localObject3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
      if (localObject1 == localObject3) {
        return;
      }
      if (!this.tasks.isEmpty())
      {
        localObject1 = this.tasks.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Future)((Iterator)localObject1).next();
          if (((Future)localObject3).isDone())
          {
            ((Iterator)localObject1).remove();
          }
          else
          {
            if (isBlocking()) {
              consumeFutureUninterruptible((Future)localObject3);
            }
            return;
          }
        }
      }
      if (this.engineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)
      {
        if ((!isBlocking()) || (this.engineStatus == SSLEngineResult.Status.BUFFER_UNDERFLOW))
        {
          this.inCrypt.compact();
          if (this.socketChannel.read(this.inCrypt) != -1) {
            this.inCrypt.flip();
          }
        }
        else
        {
          this.inData.compact();
          unwrap();
          if (this.engineResult.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.FINISHED) {
            break label207;
          }
          createBuffers(this.sslEngine.getSession());
          return;
        }
        throw new IOException("connection closed unexpectedly by peer");
      }
      label207:
      consumeDelegatedTasks();
      if ((this.tasks.isEmpty()) || (this.engineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP))
      {
        this.socketChannel.write(wrap(emptybuffer));
        if (this.engineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
          createBuffers(this.sslEngine.getSession());
        }
      }
      return;
    }
    finally {}
  }
  
  private int readRemaining(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    if (this.inData.hasRemaining()) {
      return transfereTo(this.inData, paramByteBuffer);
    }
    if (!this.inData.hasRemaining()) {
      this.inData.clear();
    }
    if (this.inCrypt.hasRemaining())
    {
      unwrap();
      int i = transfereTo(this.inData, paramByteBuffer);
      if (i > 0) {
        return i;
      }
    }
    return 0;
  }
  
  private int transfereTo(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    int i = paramByteBuffer1.remaining();
    int j = paramByteBuffer2.remaining();
    if (i > j)
    {
      j = Math.min(i, j);
      i = 0;
      while (i < j)
      {
        paramByteBuffer2.put(paramByteBuffer1.get());
        i += 1;
      }
      return j;
    }
    paramByteBuffer2.put(paramByteBuffer1);
    return i;
  }
  
  private ByteBuffer unwrap()
    throws SSLException
  {
    try
    {
      int i;
      do
      {
        i = this.inData.remaining();
        localObject1 = this.sslEngine.unwrap(this.inCrypt, this.inData);
        this.engineResult = ((SSLEngineResult)localObject1);
        localObject1 = ((SSLEngineResult)localObject1).getStatus();
        this.engineStatus = ((SSLEngineResult.Status)localObject1);
      } while ((localObject1 == SSLEngineResult.Status.OK) && ((i != this.inData.remaining()) || (this.engineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)));
      this.inData.flip();
      Object localObject1 = this.inData;
      return (ByteBuffer)localObject1;
    }
    finally {}
  }
  
  private ByteBuffer wrap(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    try
    {
      this.outCrypt.compact();
      this.engineResult = this.sslEngine.wrap(paramByteBuffer, this.outCrypt);
      this.outCrypt.flip();
      paramByteBuffer = this.outCrypt;
      return paramByteBuffer;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public void close()
    throws IOException
  {
    this.sslEngine.closeOutbound();
    this.sslEngine.getSession().invalidate();
    if (this.socketChannel.isOpen()) {
      this.socketChannel.write(wrap(emptybuffer));
    }
    this.socketChannel.close();
  }
  
  public SelectableChannel configureBlocking(boolean paramBoolean)
    throws IOException
  {
    return this.socketChannel.configureBlocking(paramBoolean);
  }
  
  public boolean connect(SocketAddress paramSocketAddress)
    throws IOException
  {
    return this.socketChannel.connect(paramSocketAddress);
  }
  
  protected void consumeDelegatedTasks()
  {
    for (;;)
    {
      Runnable localRunnable = this.sslEngine.getDelegatedTask();
      if (localRunnable == null) {
        break;
      }
      this.tasks.add(this.exec.submit(localRunnable));
    }
  }
  
  protected void createBuffers(SSLSession paramSSLSession)
  {
    int i = paramSSLSession.getApplicationBufferSize();
    int j = paramSSLSession.getPacketBufferSize();
    paramSSLSession = this.inData;
    if (paramSSLSession == null)
    {
      this.inData = ByteBuffer.allocate(i);
      this.outCrypt = ByteBuffer.allocate(j);
      this.inCrypt = ByteBuffer.allocate(j);
    }
    else
    {
      if (paramSSLSession.capacity() != i) {
        this.inData = ByteBuffer.allocate(i);
      }
      if (this.outCrypt.capacity() != j) {
        this.outCrypt = ByteBuffer.allocate(j);
      }
      if (this.inCrypt.capacity() != j) {
        this.inCrypt = ByteBuffer.allocate(j);
      }
    }
    this.inData.rewind();
    this.inData.flip();
    this.inCrypt.rewind();
    this.inCrypt.flip();
    this.outCrypt.rewind();
    this.outCrypt.flip();
  }
  
  public boolean finishConnect()
    throws IOException
  {
    return this.socketChannel.finishConnect();
  }
  
  public boolean isBlocking()
  {
    return this.socketChannel.isBlocking();
  }
  
  public boolean isConnected()
  {
    return this.socketChannel.isConnected();
  }
  
  public boolean isInboundDone()
  {
    return this.sslEngine.isInboundDone();
  }
  
  public boolean isNeedRead()
  {
    return (this.inData.hasRemaining()) || ((this.inCrypt.hasRemaining()) && (this.engineResult.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW));
  }
  
  public boolean isNeedWrite()
  {
    return (this.outCrypt.hasRemaining()) || (!isHandShakeComplete());
  }
  
  public boolean isOpen()
  {
    return this.socketChannel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!paramByteBuffer.hasRemaining()) {
      return 0;
    }
    if (!isHandShakeComplete())
    {
      if (isBlocking()) {
        while (!isHandShakeComplete()) {
          processHandshake();
        }
      }
      processHandshake();
      if (!isHandShakeComplete()) {
        return 0;
      }
    }
    int i = readRemaining(paramByteBuffer);
    if (i != 0) {
      return i;
    }
    this.inData.clear();
    if (!this.inCrypt.hasRemaining()) {
      this.inCrypt.clear();
    } else {
      this.inCrypt.compact();
    }
    if (((isBlocking()) && (this.inCrypt.position() == 0)) || ((this.engineStatus == SSLEngineResult.Status.BUFFER_UNDERFLOW) && (this.socketChannel.read(this.inCrypt) == -1))) {
      return -1;
    }
    this.inCrypt.flip();
    unwrap();
    i = transfereTo(this.inData, paramByteBuffer);
    if ((i == 0) && (isBlocking())) {
      return read(paramByteBuffer);
    }
    return i;
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
    throws SSLException
  {
    return readRemaining(paramByteBuffer);
  }
  
  public Socket socket()
  {
    return this.socketChannel.socket();
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!isHandShakeComplete())
    {
      processHandshake();
      return 0;
    }
    return this.socketChannel.write(wrap(paramByteBuffer));
  }
  
  public void writeMore()
    throws IOException
  {
    write(this.outCrypt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\SSLSocketChannel2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */