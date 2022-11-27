package org.bouncycastle.openssl;

import java.io.IOException;

abstract interface PEMKeyPairParser
{
  public abstract PEMKeyPair parse(byte[] paramArrayOfByte)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMKeyPairParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */