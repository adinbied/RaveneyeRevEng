package org.java_websocket.drafts;

import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;

public class Draft_17
  extends Draft_10
{
  public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
    throws InvalidHandshakeException
  {
    if (readVersion(paramClientHandshake) == 13) {
      return Draft.HandshakeState.MATCHED;
    }
    return Draft.HandshakeState.NOT_MATCHED;
  }
  
  public Draft copyInstance()
  {
    return new Draft_17();
  }
  
  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    super.postProcessHandshakeRequestAsClient(paramClientHandshakeBuilder);
    paramClientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
    return paramClientHandshakeBuilder;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\drafts\Draft_17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */