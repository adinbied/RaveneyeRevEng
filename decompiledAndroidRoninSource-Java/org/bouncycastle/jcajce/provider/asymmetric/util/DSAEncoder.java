package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.IOException;
import java.math.BigInteger;

public abstract interface DSAEncoder
{
  public abstract BigInteger[] decode(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract byte[] encode(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\DSAEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */