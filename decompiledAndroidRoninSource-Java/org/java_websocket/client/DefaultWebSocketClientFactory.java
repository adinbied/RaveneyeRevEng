package org.java_websocket.client;

import java.net.Socket;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;

public class DefaultWebSocketClientFactory
  implements WebSocketClient.WebSocketClientFactory
{
  private final WebSocketClient webSocketClient;
  
  public DefaultWebSocketClientFactory(WebSocketClient paramWebSocketClient)
  {
    this.webSocketClient = paramWebSocketClient;
  }
  
  public WebSocket createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList, Socket paramSocket)
  {
    return new WebSocketImpl(this.webSocketClient, paramList);
  }
  
  public WebSocket createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft, Socket paramSocket)
  {
    return new WebSocketImpl(this.webSocketClient, paramDraft);
  }
  
  public ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey, String paramString, int paramInt)
  {
    if (paramSelectionKey == null) {}
    return paramSocketChannel;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\client\DefaultWebSocketClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */