package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;

public class AlgorithmParameterGeneratorSpi
  extends BaseAlgorithmParameterGeneratorSpi
{
  private int l = 0;
  protected SecureRandom random;
  protected int strength = 1024;
  
  protected AlgorithmParameters engineGenerateParameters()
  {
    Object localObject1 = new ElGamalParametersGenerator();
    Object localObject2 = this.random;
    if (localObject2 != null) {
      ((ElGamalParametersGenerator)localObject1).init(this.strength, 20, (SecureRandom)localObject2);
    } else {
      ((ElGamalParametersGenerator)localObject1).init(this.strength, 20, new SecureRandom());
    }
    localObject1 = ((ElGamalParametersGenerator)localObject1).generateParameters();
    try
    {
      localObject2 = createParametersInstance("ElGamal");
      ((AlgorithmParameters)localObject2).init(new DHParameterSpec(((ElGamalParameters)localObject1).getP(), ((ElGamalParameters)localObject1).getG(), this.l));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\AlgorithmParameterGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */