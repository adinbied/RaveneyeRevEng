package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.CramerShoupKeyGenerationParameters;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class CramerShoupKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private CramerShoupKeyGenerationParameters param;
  
  private CramerShoupPublicKeyParameters calculatePublicKey(CramerShoupParameters paramCramerShoupParameters, CramerShoupPrivateKeyParameters paramCramerShoupPrivateKeyParameters)
  {
    BigInteger localBigInteger1 = paramCramerShoupParameters.getG1();
    BigInteger localBigInteger2 = paramCramerShoupParameters.getG2();
    BigInteger localBigInteger3 = paramCramerShoupParameters.getP();
    return new CramerShoupPublicKeyParameters(paramCramerShoupParameters, localBigInteger1.modPow(paramCramerShoupPrivateKeyParameters.getX1(), localBigInteger3).multiply(localBigInteger2.modPow(paramCramerShoupPrivateKeyParameters.getX2(), localBigInteger3)), localBigInteger1.modPow(paramCramerShoupPrivateKeyParameters.getY1(), localBigInteger3).multiply(localBigInteger2.modPow(paramCramerShoupPrivateKeyParameters.getY2(), localBigInteger3)), localBigInteger1.modPow(paramCramerShoupPrivateKeyParameters.getZ(), localBigInteger3));
  }
  
  private CramerShoupPrivateKeyParameters generatePrivateKey(SecureRandom paramSecureRandom, CramerShoupParameters paramCramerShoupParameters)
  {
    BigInteger localBigInteger = paramCramerShoupParameters.getP();
    return new CramerShoupPrivateKeyParameters(paramCramerShoupParameters, generateRandomElement(localBigInteger, paramSecureRandom), generateRandomElement(localBigInteger, paramSecureRandom), generateRandomElement(localBigInteger, paramSecureRandom), generateRandomElement(localBigInteger, paramSecureRandom), generateRandomElement(localBigInteger, paramSecureRandom));
  }
  
  private BigInteger generateRandomElement(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    BigInteger localBigInteger = ONE;
    return BigIntegers.createRandomInRange(localBigInteger, paramBigInteger.subtract(localBigInteger), paramSecureRandom);
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    Object localObject = this.param.getParameters();
    CramerShoupPrivateKeyParameters localCramerShoupPrivateKeyParameters = generatePrivateKey(this.param.getRandom(), (CramerShoupParameters)localObject);
    localObject = calculatePublicKey((CramerShoupParameters)localObject, localCramerShoupPrivateKeyParameters);
    localCramerShoupPrivateKeyParameters.setPk((CramerShoupPublicKeyParameters)localObject);
    return new AsymmetricCipherKeyPair((AsymmetricKeyParameter)localObject, localCramerShoupPrivateKeyParameters);
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((CramerShoupKeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\CramerShoupKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */