package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

class DHParametersHelper
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  
  static BigInteger[] generateSafePrimes(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    BigInteger localBigInteger1;
    BigInteger localBigInteger2;
    do
    {
      localBigInteger1 = new BigInteger(paramInt1 - 1, 2, paramSecureRandom);
      localBigInteger2 = localBigInteger1.shiftLeft(1).add(ONE);
    } while ((!localBigInteger2.isProbablePrime(paramInt2)) || ((paramInt2 > 2) && (!localBigInteger1.isProbablePrime(paramInt2 - 2))) || (WNafUtil.getNafWeight(localBigInteger2) < paramInt1 >>> 2));
    return new BigInteger[] { localBigInteger2, localBigInteger1 };
  }
  
  static BigInteger selectGenerator(BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    paramBigInteger2 = paramBigInteger1.subtract(TWO);
    BigInteger localBigInteger;
    do
    {
      localBigInteger = BigIntegers.createRandomInRange(TWO, paramBigInteger2, paramSecureRandom).modPow(TWO, paramBigInteger1);
    } while (localBigInteger.equals(ONE));
    return localBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DHParametersHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */