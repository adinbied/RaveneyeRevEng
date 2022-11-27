package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface TlsCipher
{
  public abstract byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int getPlaintextLimit(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */