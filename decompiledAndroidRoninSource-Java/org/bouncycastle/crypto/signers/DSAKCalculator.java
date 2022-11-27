package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public abstract interface DSAKCalculator
{
  public abstract void init(BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte);
  
  public abstract void init(BigInteger paramBigInteger, SecureRandom paramSecureRandom);
  
  public abstract boolean isDeterministic();
  
  public abstract BigInteger nextK();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\DSAKCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */