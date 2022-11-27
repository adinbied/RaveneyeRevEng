package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;

public final class NullPRNG
  extends SecureRandom
{
  private static final long serialVersionUID = 1L;
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = 0;
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\NullPRNG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */