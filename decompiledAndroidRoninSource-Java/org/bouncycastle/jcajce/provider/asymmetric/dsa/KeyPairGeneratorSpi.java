package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Hashtable;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.DSAKeyPairGenerator;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;

public class KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  private static Object lock = new Object();
  private static Hashtable params = new Hashtable();
  DSAKeyPairGenerator engine = new DSAKeyPairGenerator();
  boolean initialised = false;
  DSAKeyGenerationParameters param;
  SecureRandom random = new SecureRandom();
  int strength = 2048;
  
  public KeyPairGeneratorSpi()
  {
    super("DSA");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      Integer localInteger = Integers.valueOf(this.strength);
      if (params.containsKey(localInteger)) {
        this.param = ((DSAKeyGenerationParameters)params.get(localInteger));
      }
      synchronized (lock)
      {
        if (params.containsKey(localInteger))
        {
          this.param = ((DSAKeyGenerationParameters)params.get(localInteger));
        }
        else
        {
          int j = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
          int i;
          if (this.strength == 1024)
          {
            localObject1 = new DSAParametersGenerator();
            if (Properties.isOverrideSet("org.bouncycastle.dsa.FIPS186-2for1024bits")) {
              i = this.strength;
            }
          }
          for (localObject3 = this.random;; localObject3 = this.random)
          {
            ((DSAParametersGenerator)localObject1).init(i, j, (SecureRandom)localObject3);
            break;
            ((DSAParametersGenerator)localObject1).init(new DSAParameterGenerationParameters(1024, 160, j, this.random));
            break;
            if (this.strength > 1024)
            {
              localObject3 = new DSAParameterGenerationParameters(this.strength, 256, j, this.random);
              localObject1 = new DSAParametersGenerator(new SHA256Digest());
              ((DSAParametersGenerator)localObject1).init((DSAParameterGenerationParameters)localObject3);
              break;
            }
            localObject1 = new DSAParametersGenerator();
            i = this.strength;
          }
          Object localObject1 = new DSAKeyGenerationParameters(this.random, ((DSAParametersGenerator)localObject1).generateParameters());
          this.param = ((DSAKeyGenerationParameters)localObject1);
          params.put(localInteger, localObject1);
        }
        this.engine.init(this.param);
        this.initialised = true;
      }
    }
    Object localObject3 = this.engine.generateKeyPair();
    DSAPublicKeyParameters localDSAPublicKeyParameters = (DSAPublicKeyParameters)((AsymmetricCipherKeyPair)localObject3).getPublic();
    localObject3 = (DSAPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject3).getPrivate();
    return new KeyPair(new BCDSAPublicKey(localDSAPublicKeyParameters), new BCDSAPrivateKey((DSAPrivateKeyParameters)localObject3));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    if ((paramInt >= 512) && (paramInt <= 4096) && ((paramInt >= 1024) || (paramInt % 64 == 0)) && ((paramInt < 1024) || (paramInt % 1024 == 0)))
    {
      this.strength = paramInt;
      this.random = paramSecureRandom;
      this.initialised = false;
      return;
    }
    throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof DSAParameterSpec))
    {
      paramAlgorithmParameterSpec = (DSAParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = new DSAKeyGenerationParameters(paramSecureRandom, new DSAParameters(paramAlgorithmParameterSpec.getP(), paramAlgorithmParameterSpec.getQ(), paramAlgorithmParameterSpec.getG()));
      this.param = paramAlgorithmParameterSpec;
      this.engine.init(paramAlgorithmParameterSpec);
      this.initialised = true;
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */