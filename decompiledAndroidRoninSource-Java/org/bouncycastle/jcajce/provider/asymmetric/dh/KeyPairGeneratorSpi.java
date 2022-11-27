package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Integers;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  private static Object lock = new Object();
  private static Hashtable params = new Hashtable();
  DHBasicKeyPairGenerator engine = new DHBasicKeyPairGenerator();
  boolean initialised = false;
  DHKeyGenerationParameters param;
  SecureRandom random = new SecureRandom();
  int strength = 2048;
  
  public KeyPairGeneratorSpi()
  {
    super("DH");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      Object localObject1 = Integers.valueOf(this.strength);
      if (params.containsKey(localObject1)) {}
      for (localObject1 = (DHKeyGenerationParameters)params.get(localObject1);; localObject1 = new DHKeyGenerationParameters(this.random, new DHParameters(((DHParameterSpec)???).getP(), ((DHParameterSpec)???).getG(), null, ((DHParameterSpec)???).getL())))
      {
        this.param = ((DHKeyGenerationParameters)localObject1);
        break label188;
        ??? = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
        if (??? == null) {
          break;
        }
      }
      synchronized (lock)
      {
        if (params.containsKey(localObject1))
        {
          this.param = ((DHKeyGenerationParameters)params.get(localObject1));
        }
        else
        {
          Object localObject4 = new DHParametersGenerator();
          ((DHParametersGenerator)localObject4).init(this.strength, PrimeCertaintyCalculator.getDefaultCertainty(this.strength), this.random);
          localObject4 = new DHKeyGenerationParameters(this.random, ((DHParametersGenerator)localObject4).generateParameters());
          this.param = ((DHKeyGenerationParameters)localObject4);
          params.put(localObject1, localObject4);
        }
        label188:
        this.engine.init(this.param);
        this.initialised = true;
      }
    }
    ??? = this.engine.generateKeyPair();
    DHPublicKeyParameters localDHPublicKeyParameters = (DHPublicKeyParameters)((AsymmetricCipherKeyPair)???).getPublic();
    ??? = (DHPrivateKeyParameters)((AsymmetricCipherKeyPair)???).getPrivate();
    return new KeyPair(new BCDHPublicKey(localDHPublicKeyParameters), new BCDHPrivateKey((DHPrivateKeyParameters)???));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
    this.initialised = false;
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof DHParameterSpec))
    {
      paramAlgorithmParameterSpec = (DHParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new DHKeyGenerationParameters(paramSecureRandom, new DHParameters(paramAlgorithmParameterSpec.getP(), paramAlgorithmParameterSpec.getG(), null, paramAlgorithmParameterSpec.getL()));
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      this.initialised = true;
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */