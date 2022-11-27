package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPTransport
  implements DatagramTransport
{
  protected static final int MAX_IP_OVERHEAD = 84;
  protected static final int MIN_IP_OVERHEAD = 20;
  protected static final int UDP_OVERHEAD = 8;
  protected final int receiveLimit;
  protected final int sendLimit;
  protected final DatagramSocket socket;
  
  public UDPTransport(DatagramSocket paramDatagramSocket, int paramInt)
    throws IOException
  {
    if ((paramDatagramSocket.isBound()) && (paramDatagramSocket.isConnected()))
    {
      this.socket = paramDatagramSocket;
      this.receiveLimit = (paramInt - 20 - 8);
      this.sendLimit = (paramInt - 84 - 8);
      return;
    }
    throw new IllegalArgumentException("'socket' must be bound and connected");
  }
  
  public void close()
    throws IOException
  {
    this.socket.close();
  }
  
  public int getReceiveLimit()
  {
    return this.receiveLimit;
  }
  
  public int getSendLimit()
  {
    return this.sendLimit;
  }
  
  public int receive(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    this.socket.setSoTimeout(paramInt3);
    paramArrayOfByte = new DatagramPacket(paramArrayOfByte, paramInt1, paramInt2);
    this.socket.receive(paramArrayOfByte);
    return paramArrayOfByte.getLength();
  }
  
  public void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 <= getSendLimit())
    {
      paramArrayOfByte = new DatagramPacket(paramArrayOfByte, paramInt1, paramInt2);
      this.socket.send(paramArrayOfByte);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\UDPTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */