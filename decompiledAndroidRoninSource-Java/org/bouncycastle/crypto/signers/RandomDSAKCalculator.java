package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomDSAKCalculator
  implements DSAKCalculator
{
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private BigInteger q;
  private SecureRandom random;
  
  public void init(BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte)
  {
    throw new IllegalStateException("Operation not supported");
  }
  
  public void init(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    this.q = paramBigInteger;
    this.random = paramSecureRandom;
  }
  
  public boolean isDeterministic()
  {
    return false;
  }
  
  public BigInteger nextK()
  {
    int i = this.q.bitLength();
    BigInteger localBigInteger;
    do
    {
      localBigInteger = new BigInteger(i, this.random);
    } while ((localBigInteger.equals(ZERO)) || (localBigInteger.compareTo(this.q) >= 0));
    return localBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\RandomDSAKCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */