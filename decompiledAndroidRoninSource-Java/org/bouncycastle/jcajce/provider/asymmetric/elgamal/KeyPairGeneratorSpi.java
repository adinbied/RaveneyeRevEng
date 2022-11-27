package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ElGamalKeyPairGenerator;
import org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  int certainty = 20;
  ElGamalKeyPairGenerator engine = new ElGamalKeyPairGenerator();
  boolean initialised = false;
  ElGamalKeyGenerationParameters param;
  SecureRandom random = new SecureRandom();
  int strength = 1024;
  
  public KeyPairGeneratorSpi()
  {
    super("ElGamal");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      localObject1 = BouncyCastleProvider.CONFIGURATION.getDHDefaultParameters(this.strength);
      if (localObject1 != null)
      {
        localObject1 = new ElGamalKeyGenerationParameters(this.random, new ElGamalParameters(((DHParameterSpec)localObject1).getP(), ((DHParameterSpec)localObject1).getG(), ((DHParameterSpec)localObject1).getL()));
      }
      else
      {
        localObject1 = new ElGamalParametersGenerator();
        ((ElGamalParametersGenerator)localObject1).init(this.strength, this.certainty, this.random);
        localObject1 = new ElGamalKeyGenerationParameters(this.random, ((ElGamalParametersGenerator)localObject1).generateParameters());
      }
      this.param = ((ElGamalKeyGenerationParameters)localObject1);
      this.engine.init(this.param);
      this.initialised = true;
    }
    Object localObject2 = this.engine.generateKeyPair();
    Object localObject1 = (ElGamalPublicKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPublic();
    localObject2 = (ElGamalPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPrivate();
    return new KeyPair(new BCElGamalPublicKey((ElGamalPublicKeyParameters)localObject1), new BCElGamalPrivateKey((ElGamalPrivateKeyParameters)localObject2));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    boolean bool = paramAlgorithmParameterSpec instanceof ElGamalParameterSpec;
    if ((!bool) && (!(paramAlgorithmParameterSpec instanceof DHParameterSpec))) {
      throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
    }
    if (bool)
    {
      paramAlgorithmParameterSpec = (ElGamalParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new ElGamalKeyGenerationParameters(paramSecureRandom, new ElGamalParameters(paramAlgorithmParameterSpec.getP(), paramAlgorithmParameterSpec.getG()));
    }
    else
    {
      paramAlgorithmParameterSpec = (DHParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new ElGamalKeyGenerationParameters(paramSecureRandom, new ElGamalParameters(paramAlgorithmParameterSpec.getP(), paramAlgorithmParameterSpec.getG(), paramAlgorithmParameterSpec.getL()));
    }
    this.param = paramAlgorithmParameterSpec;
    this.engine.init(this.param);
    this.initialised = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */