package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class ElGamalKeyGenerationParameters
  extends KeyGenerationParameters
{
  private ElGamalParameters params;
  
  public ElGamalKeyGenerationParameters(SecureRandom paramSecureRandom, ElGamalParameters paramElGamalParameters)
  {
    super(paramSecureRandom, getStrength(paramElGamalParameters));
    this.params = paramElGamalParameters;
  }
  
  static int getStrength(ElGamalParameters paramElGamalParameters)
  {
    if (paramElGamalParameters.getL() != 0) {
      return paramElGamalParameters.getL();
    }
    return paramElGamalParameters.getP().bitLength();
  }
  
  public ElGamalParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ElGamalKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */