package org.java_websocket;

import java.net.InetSocketAddress;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;

public abstract class WebSocketAdapter
  implements WebSocketListener
{
  public String getFlashPolicy(WebSocket paramWebSocket)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuilder.append(paramWebSocket.getLocalSocketAddress().getPort());
    localStringBuilder.append("\" /></cross-domain-policy>\000");
    return localStringBuilder.toString();
  }
  
  public void onWebsocketHandshakeReceivedAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
    throws InvalidDataException
  {}
  
  public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket paramWebSocket, Draft paramDraft, ClientHandshake paramClientHandshake)
    throws InvalidDataException
  {
    return new HandshakeImpl1Server();
  }
  
  public void onWebsocketHandshakeSentAsClient(WebSocket paramWebSocket, ClientHandshake paramClientHandshake)
    throws InvalidDataException
  {}
  
  public void onWebsocketMessageFragment(WebSocket paramWebSocket, Framedata paramFramedata) {}
  
  public void onWebsocketPing(WebSocket paramWebSocket, Framedata paramFramedata)
  {
    paramFramedata = new FramedataImpl1(paramFramedata);
    paramFramedata.setOptcode(Framedata.Opcode.PONG);
    paramWebSocket.sendFrame(paramFramedata);
  }
  
  public void onWebsocketPong(WebSocket paramWebSocket, Framedata paramFramedata) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\WebSocketAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */