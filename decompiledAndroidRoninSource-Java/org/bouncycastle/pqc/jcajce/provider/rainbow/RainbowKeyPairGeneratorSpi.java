package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.RainbowParameterSpec;

public class RainbowKeyPairGeneratorSpi
  extends KeyPairGenerator
{
  RainbowKeyPairGenerator engine = new RainbowKeyPairGenerator();
  boolean initialised = false;
  RainbowKeyGenerationParameters param;
  SecureRandom random = new SecureRandom();
  int strength = 1024;
  
  public RainbowKeyPairGeneratorSpi()
  {
    super("Rainbow");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      localObject1 = new RainbowKeyGenerationParameters(this.random, new RainbowParameters(new RainbowParameterSpec().getVi()));
      this.param = ((RainbowKeyGenerationParameters)localObject1);
      this.engine.init((KeyGenerationParameters)localObject1);
      this.initialised = true;
    }
    Object localObject2 = this.engine.generateKeyPair();
    Object localObject1 = (RainbowPublicKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPublic();
    localObject2 = (RainbowPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPrivate();
    return new KeyPair(new BCRainbowPublicKey((RainbowPublicKeyParameters)localObject1), new BCRainbowPrivateKey((RainbowPrivateKeyParameters)localObject2));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof RainbowParameterSpec))
    {
      paramAlgorithmParameterSpec = new RainbowKeyGenerationParameters(paramSecureRandom, new RainbowParameters(((RainbowParameterSpec)paramAlgorithmParameterSpec).getVi()));
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      this.initialised = true;
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\RainbowKeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */