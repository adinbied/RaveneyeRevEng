package org.bouncycastle.crypto.tls;

import java.io.IOException;

abstract interface DTLSHandshakeRetransmit
{
  public abstract void receivedHandshakeRecord(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSHandshakeRetransmit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */