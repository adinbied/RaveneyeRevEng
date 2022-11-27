package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;

public class DHParametersGenerator
{
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private int certainty;
  private SecureRandom random;
  private int size;
  
  public DHParameters generateParameters()
  {
    Object localObject = DHParametersHelper.generateSafePrimes(this.size, this.certainty, this.random);
    BigInteger localBigInteger = localObject[0];
    localObject = localObject[1];
    return new DHParameters(localBigInteger, DHParametersHelper.selectGenerator(localBigInteger, (BigInteger)localObject, this.random), (BigInteger)localObject, TWO, null);
  }
  
  public void init(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    this.size = paramInt1;
    this.certainty = paramInt2;
    this.random = paramSecureRandom;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DHParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */