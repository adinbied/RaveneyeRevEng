package org.java_websocket.server;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;

public class DefaultSSLWebSocketServerFactory
  implements WebSocketServer.WebSocketServerFactory
{
  protected ExecutorService exec;
  protected SSLContext sslcontext;
  
  public DefaultSSLWebSocketServerFactory(SSLContext paramSSLContext)
  {
    this(paramSSLContext, Executors.newSingleThreadScheduledExecutor());
  }
  
  public DefaultSSLWebSocketServerFactory(SSLContext paramSSLContext, ExecutorService paramExecutorService)
  {
    if ((paramSSLContext != null) && (paramExecutorService != null))
    {
      this.sslcontext = paramSSLContext;
      this.exec = paramExecutorService;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList, Socket paramSocket)
  {
    return new WebSocketImpl(paramWebSocketAdapter, paramList);
  }
  
  public WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft, Socket paramSocket)
  {
    return new WebSocketImpl(paramWebSocketAdapter, paramDraft);
  }
  
  public ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
    throws IOException
  {
    SSLEngine localSSLEngine = this.sslcontext.createSSLEngine();
    localSSLEngine.setUseClientMode(false);
    return new SSLSocketChannel2(paramSocketChannel, localSSLEngine, this.exec, paramSelectionKey);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\server\DefaultSSLWebSocketServerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */