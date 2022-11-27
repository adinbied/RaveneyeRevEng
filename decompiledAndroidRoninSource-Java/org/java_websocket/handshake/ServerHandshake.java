package org.java_websocket.handshake;

public abstract interface ServerHandshake
  extends Handshakedata
{
  public abstract short getHttpStatus();
  
  public abstract String getHttpStatusMessage();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\handshake\ServerHandshake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */