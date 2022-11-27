package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class CramerShoupKeyGenerationParameters
  extends KeyGenerationParameters
{
  private CramerShoupParameters params;
  
  public CramerShoupKeyGenerationParameters(SecureRandom paramSecureRandom, CramerShoupParameters paramCramerShoupParameters)
  {
    super(paramSecureRandom, getStrength(paramCramerShoupParameters));
    this.params = paramCramerShoupParameters;
  }
  
  static int getStrength(CramerShoupParameters paramCramerShoupParameters)
  {
    return paramCramerShoupParameters.getP().bitLength();
  }
  
  public CramerShoupParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\CramerShoupKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */