package org.java_websocket.handshake;

import java.util.Iterator;

public abstract interface Handshakedata
{
  public abstract byte[] getContent();
  
  public abstract String getFieldValue(String paramString);
  
  public abstract boolean hasFieldValue(String paramString);
  
  public abstract Iterator<String> iterateHttpFields();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\handshake\Handshakedata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */