package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSABlindingFactorGenerator
{
  private static BigInteger ONE = BigInteger.valueOf(1L);
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  private RSAKeyParameters key;
  private SecureRandom random;
  
  public BigInteger generateBlindingFactor()
  {
    Object localObject = this.key;
    if (localObject != null)
    {
      localObject = ((RSAKeyParameters)localObject).getModulus();
      int i = ((BigInteger)localObject).bitLength();
      BigInteger localBigInteger1;
      BigInteger localBigInteger2;
      do
      {
        localBigInteger1 = new BigInteger(i - 1, this.random);
        localBigInteger2 = localBigInteger1.gcd((BigInteger)localObject);
      } while ((localBigInteger1.equals(ZERO)) || (localBigInteger1.equals(ONE)) || (!localBigInteger2.equals(ONE)));
      return localBigInteger1;
    }
    throw new IllegalStateException("generator not initialised");
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.key = ((RSAKeyParameters)paramCipherParameters.getParameters());
      paramCipherParameters = paramCipherParameters.getRandom();
    }
    else
    {
      this.key = ((RSAKeyParameters)paramCipherParameters);
      paramCipherParameters = new SecureRandom();
    }
    this.random = paramCipherParameters;
    if (!(this.key instanceof RSAPrivateCrtKeyParameters)) {
      return;
    }
    throw new IllegalArgumentException("generator requires RSA public key");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\RSABlindingFactorGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */