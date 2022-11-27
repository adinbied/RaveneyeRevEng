package org.java_websocket.handshake;

public class HandshakeImpl1Client
  extends HandshakedataImpl1
  implements ClientHandshakeBuilder
{
  private String resourcedescriptor;
  
  public String getResourceDescriptor()
  {
    return this.resourcedescriptor;
  }
  
  public void setResourceDescriptor(String paramString)
    throws IllegalArgumentException
  {
    this.resourcedescriptor = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\handshake\HandshakeImpl1Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */