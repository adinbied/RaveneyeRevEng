package org.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import org.java_websocket.drafts.Draft;
import org.java_websocket.framing.Framedata;

public abstract interface WebSocket
{
  public static final int DEFAULT_PORT = 80;
  public static final int DEFAULT_WSS_PORT = 443;
  
  public abstract void close();
  
  public abstract void close(int paramInt);
  
  public abstract void close(int paramInt, String paramString);
  
  public abstract void closeConnection(int paramInt, String paramString);
  
  public abstract Draft getDraft();
  
  public abstract InetSocketAddress getLocalSocketAddress();
  
  public abstract READYSTATE getReadyState();
  
  public abstract InetSocketAddress getRemoteSocketAddress();
  
  public abstract boolean hasBufferedData();
  
  public abstract boolean isClosed();
  
  public abstract boolean isClosing();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isFlushAndClose();
  
  public abstract boolean isOpen();
  
  public abstract void send(String paramString)
    throws NotYetConnectedException;
  
  public abstract void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, NotYetConnectedException;
  
  public abstract void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, NotYetConnectedException;
  
  public abstract void sendFrame(Framedata paramFramedata);
  
  public static enum READYSTATE
  {
    static
    {
      CONNECTING = new READYSTATE("CONNECTING", 1);
      OPEN = new READYSTATE("OPEN", 2);
      CLOSING = new READYSTATE("CLOSING", 3);
      READYSTATE localREADYSTATE = new READYSTATE("CLOSED", 4);
      CLOSED = localREADYSTATE;
      $VALUES = new READYSTATE[] { NOT_YET_CONNECTED, CONNECTING, OPEN, CLOSING, localREADYSTATE };
    }
    
    private READYSTATE() {}
  }
  
  public static enum Role
  {
    static
    {
      Role localRole = new Role("SERVER", 1);
      SERVER = localRole;
      $VALUES = new Role[] { CLIENT, localRole };
    }
    
    private Role() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\WebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */