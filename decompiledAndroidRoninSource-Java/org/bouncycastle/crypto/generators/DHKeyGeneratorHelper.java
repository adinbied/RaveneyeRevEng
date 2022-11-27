package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

class DHKeyGeneratorHelper
{
  static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  
  BigInteger calculatePrivate(DHParameters paramDHParameters, SecureRandom paramSecureRandom)
  {
    int i = paramDHParameters.getL();
    if (i != 0)
    {
      do
      {
        paramDHParameters = new BigInteger(i, paramSecureRandom).setBit(i - 1);
      } while (WNafUtil.getNafWeight(paramDHParameters) < i >>> 2);
      return paramDHParameters;
    }
    BigInteger localBigInteger1 = TWO;
    i = paramDHParameters.getM();
    if (i != 0) {
      localBigInteger1 = ONE.shiftLeft(i - 1);
    }
    BigInteger localBigInteger3 = paramDHParameters.getQ();
    BigInteger localBigInteger2 = localBigInteger3;
    if (localBigInteger3 == null) {
      localBigInteger2 = paramDHParameters.getP();
    }
    paramDHParameters = localBigInteger2.subtract(TWO);
    i = paramDHParameters.bitLength();
    do
    {
      localBigInteger2 = BigIntegers.createRandomInRange(localBigInteger1, paramDHParameters, paramSecureRandom);
    } while (WNafUtil.getNafWeight(localBigInteger2) < i >>> 2);
    return localBigInteger2;
  }
  
  BigInteger calculatePublic(DHParameters paramDHParameters, BigInteger paramBigInteger)
  {
    return paramDHParameters.getG().modPow(paramBigInteger, paramDHParameters.getP());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DHKeyGeneratorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */