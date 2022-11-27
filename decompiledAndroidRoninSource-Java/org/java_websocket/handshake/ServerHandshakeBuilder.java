package org.java_websocket.handshake;

public abstract interface ServerHandshakeBuilder
  extends HandshakeBuilder, ServerHandshake
{
  public abstract void setHttpStatus(short paramShort);
  
  public abstract void setHttpStatusMessage(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\handshake\ServerHandshakeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */