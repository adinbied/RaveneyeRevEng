package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  static final BigInteger defaultPublicExponent = BigInteger.valueOf(65537L);
  RSAKeyPairGenerator engine;
  RSAKeyGenerationParameters param;
  
  public KeyPairGeneratorSpi()
  {
    super("RSA");
    this.engine = new RSAKeyPairGenerator();
    RSAKeyGenerationParameters localRSAKeyGenerationParameters = new RSAKeyGenerationParameters(defaultPublicExponent, new SecureRandom(), 2048, PrimeCertaintyCalculator.getDefaultCertainty(2048));
    this.param = localRSAKeyGenerationParameters;
    this.engine.init(localRSAKeyGenerationParameters);
  }
  
  public KeyPairGeneratorSpi(String paramString)
  {
    super(paramString);
  }
  
  public KeyPair generateKeyPair()
  {
    Object localObject = this.engine.generateKeyPair();
    RSAKeyParameters localRSAKeyParameters = (RSAKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic();
    localObject = (RSAPrivateCrtKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate();
    return new KeyPair(new BCRSAPublicKey(localRSAKeyParameters), new BCRSAPrivateCrtKey((RSAPrivateCrtKeyParameters)localObject));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    paramSecureRandom = new RSAKeyGenerationParameters(defaultPublicExponent, paramSecureRandom, paramInt, PrimeCertaintyCalculator.getDefaultCertainty(paramInt));
    this.param = paramSecureRandom;
    this.engine.init(paramSecureRandom);
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof RSAKeyGenParameterSpec))
    {
      paramAlgorithmParameterSpec = (RSAKeyGenParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new RSAKeyGenerationParameters(paramAlgorithmParameterSpec.getPublicExponent(), paramSecureRandom, paramAlgorithmParameterSpec.getKeysize(), PrimeCertaintyCalculator.getDefaultCertainty(2048));
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */