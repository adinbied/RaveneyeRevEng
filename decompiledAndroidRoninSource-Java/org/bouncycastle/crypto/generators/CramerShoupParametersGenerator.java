package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;

public class CramerShoupParametersGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private int certainty;
  private SecureRandom random;
  private int size;
  
  public CramerShoupParameters generateParameters()
  {
    BigInteger localBigInteger1 = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
    BigInteger localBigInteger2 = ParametersHelper.selectGenerator(localBigInteger1, this.random);
    BigInteger localBigInteger3;
    do
    {
      localBigInteger3 = ParametersHelper.selectGenerator(localBigInteger1, this.random);
    } while (localBigInteger2.equals(localBigInteger3));
    return new CramerShoupParameters(localBigInteger1, localBigInteger2, localBigInteger3, new SHA256Digest());
  }
  
  public CramerShoupParameters generateParameters(DHParameters paramDHParameters)
  {
    BigInteger localBigInteger1 = paramDHParameters.getP();
    paramDHParameters = paramDHParameters.getG();
    BigInteger localBigInteger2;
    do
    {
      localBigInteger2 = ParametersHelper.selectGenerator(localBigInteger1, this.random);
    } while (paramDHParameters.equals(localBigInteger2));
    return new CramerShoupParameters(localBigInteger1, paramDHParameters, localBigInteger2, new SHA256Digest());
  }
  
  public void init(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    this.size = paramInt1;
    this.certainty = paramInt2;
    this.random = paramSecureRandom;
  }
  
  private static class ParametersHelper
  {
    private static final BigInteger TWO = BigInteger.valueOf(2L);
    
    static BigInteger[] generateSafePrimes(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
    {
      BigInteger localBigInteger1;
      BigInteger localBigInteger2;
      do
      {
        localBigInteger1 = new BigInteger(paramInt1 - 1, 2, paramSecureRandom);
        localBigInteger2 = localBigInteger1.shiftLeft(1).add(CramerShoupParametersGenerator.ONE);
      } while ((!localBigInteger2.isProbablePrime(paramInt2)) || ((paramInt2 > 2) && (!localBigInteger1.isProbablePrime(paramInt2))));
      return new BigInteger[] { localBigInteger2, localBigInteger1 };
    }
    
    static BigInteger selectGenerator(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
    {
      BigInteger localBigInteger1 = paramBigInteger.subtract(TWO);
      BigInteger localBigInteger2;
      do
      {
        localBigInteger2 = BigIntegers.createRandomInRange(TWO, localBigInteger1, paramSecureRandom).modPow(TWO, paramBigInteger);
      } while (localBigInteger2.equals(CramerShoupParametersGenerator.ONE));
      return localBigInteger2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\CramerShoupParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */