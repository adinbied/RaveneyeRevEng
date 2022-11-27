package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.DSAParametersGenerator;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class AlgorithmParameterGeneratorSpi
  extends BaseAlgorithmParameterGeneratorSpi
{
  protected DSAParameterGenerationParameters params;
  protected SecureRandom random;
  protected int strength = 2048;
  
  protected AlgorithmParameters engineGenerateParameters()
  {
    if (this.strength <= 1024) {
      localObject1 = new DSAParametersGenerator();
    } else {
      localObject1 = new DSAParametersGenerator(new SHA256Digest());
    }
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    int i = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
    int j = this.strength;
    Object localObject2;
    if (j == 1024)
    {
      localObject2 = new DSAParameterGenerationParameters(1024, 160, i, this.random);
      this.params = ((DSAParameterGenerationParameters)localObject2);
      ((DSAParametersGenerator)localObject1).init((DSAParameterGenerationParameters)localObject2);
    }
    else if (j > 1024)
    {
      localObject2 = new DSAParameterGenerationParameters(j, 256, i, this.random);
      this.params = ((DSAParameterGenerationParameters)localObject2);
      ((DSAParametersGenerator)localObject1).init((DSAParameterGenerationParameters)localObject2);
    }
    else
    {
      ((DSAParametersGenerator)localObject1).init(j, i, this.random);
    }
    Object localObject1 = ((DSAParametersGenerator)localObject1).generateParameters();
    try
    {
      localObject2 = createParametersInstance("DSA");
      ((AlgorithmParameters)localObject2).init(new DSAParameterSpec(((DSAParameters)localObject1).getP(), ((DSAParameters)localObject1).getQ(), ((DSAParameters)localObject1).getG()));
      return (AlgorithmParameters)localObject2;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
  {
    if ((paramInt >= 512) && (paramInt <= 3072))
    {
      if ((paramInt <= 1024) && (paramInt % 64 != 0)) {
        throw new InvalidParameterException("strength must be a multiple of 64 below 1024 bits.");
      }
      if ((paramInt > 1024) && (paramInt % 1024 != 0)) {
        throw new InvalidParameterException("strength must be a multiple of 1024 above 1024 bits.");
      }
      this.strength = paramInt;
      this.random = paramSecureRandom;
      return;
    }
    throw new InvalidParameterException("strength must be from 512 - 3072");
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\AlgorithmParameterGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */