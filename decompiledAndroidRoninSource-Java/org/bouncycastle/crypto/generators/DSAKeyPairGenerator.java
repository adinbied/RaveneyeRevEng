package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

public class DSAKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private DSAKeyGenerationParameters param;
  
  private static BigInteger calculatePublicKey(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return paramBigInteger2.modPow(paramBigInteger3, paramBigInteger1);
  }
  
  private static BigInteger generatePrivateKey(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    int i = paramBigInteger.bitLength();
    BigInteger localBigInteger;
    do
    {
      localBigInteger = ONE;
      localBigInteger = BigIntegers.createRandomInRange(localBigInteger, paramBigInteger.subtract(localBigInteger), paramSecureRandom);
    } while (WNafUtil.getNafWeight(localBigInteger) < i >>> 2);
    return localBigInteger;
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    DSAParameters localDSAParameters = this.param.getParameters();
    BigInteger localBigInteger = generatePrivateKey(localDSAParameters.getQ(), this.param.getRandom());
    return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(calculatePublicKey(localDSAParameters.getP(), localDSAParameters.getG(), localBigInteger), localDSAParameters), new DSAPrivateKeyParameters(localBigInteger, localDSAParameters));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((DSAKeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DSAKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */