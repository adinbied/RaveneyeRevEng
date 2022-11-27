package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class AlgorithmParameterGeneratorSpi
  extends BaseAlgorithmParameterGeneratorSpi
{
  private int l = 0;
  protected SecureRandom random;
  protected int strength = 2048;
  
  protected AlgorithmParameters engineGenerateParameters()
  {
    Object localObject1 = new DHParametersGenerator();
    int i = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
    Object localObject2 = this.random;
    if (localObject2 != null) {
      ((DHParametersGenerator)localObject1).init(this.strength, i, (SecureRandom)localObject2);
    } else {
      ((DHParametersGenerator)localObject1).init(this.strength, i, new SecureRandom());
    }
    localObject1 = ((DHParametersGenerator)localObject1).generateParameters();
    try
    {
      localObject2 = createParametersInstance("DH");
      ((AlgorithmParameters)localObject2).init(new DHParameterSpec(((DHParameters)localObject1).getP(), ((DHParameters)localObject1).getG(), this.l));
      return (AlgorithmParameters)localObject2;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, SecureRandom paramSecureRandom)
  {
    this.strength = paramInt;
    this.random = paramSecureRandom;
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof DHGenParameterSpec))
    {
      paramAlgorithmParameterSpec = (DHGenParameterSpec)paramAlgorithmParameterSpec;
      this.strength = paramAlgorithmParameterSpec.getPrimeSize();
      this.l = paramAlgorithmParameterSpec.getExponentSize();
      this.random = paramSecureRandom;
      return;
    }
    throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\AlgorithmParameterGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */