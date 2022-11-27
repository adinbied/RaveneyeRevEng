package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.generators.GOST3410ParametersGenerator;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public abstract class AlgorithmParameterGeneratorSpi
  extends BaseAlgorithmParameterGeneratorSpi
{
  protected SecureRandom random;
  protected int strength = 1024;
  
  protected AlgorithmParameters engineGenerateParameters()
  {
    Object localObject1 = new GOST3410ParametersGenerator();
    Object localObject2 = this.random;
    if (localObject2 != null) {
      ((GOST3410ParametersGenerator)localObject1).init(this.strength, 2, (SecureRandom)localObject2);
    } else {
      ((GOST3410ParametersGenerator)localObject1).init(this.strength, 2, new SecureRandom());
    }
    localObject1 = ((GOST3410ParametersGenerator)localObject1).generateParameters();
    try
    {
      localObject2 = createParametersInstance("GOST3410");
      ((AlgorithmParameters)localObject2).init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(((GOST3410Parameters)localObject1).getP(), ((GOST3410Parameters)localObject1).getQ(), ((GOST3410Parameters)localObject1).getA())));
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
    throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\AlgorithmParameterGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */