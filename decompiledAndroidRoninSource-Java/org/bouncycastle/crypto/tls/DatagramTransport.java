package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface DatagramTransport
{
  public abstract void close()
    throws IOException;
  
  public abstract int getReceiveLimit()
    throws IOException;
  
  public abstract int getSendLimit()
    throws IOException;
  
  public abstract int receive(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException;
  
  public abstract void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DatagramTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */