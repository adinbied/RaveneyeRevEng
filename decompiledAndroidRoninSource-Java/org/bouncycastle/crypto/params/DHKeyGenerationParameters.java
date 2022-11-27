package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class DHKeyGenerationParameters
  extends KeyGenerationParameters
{
  private DHParameters params;
  
  public DHKeyGenerationParameters(SecureRandom paramSecureRandom, DHParameters paramDHParameters)
  {
    super(paramSecureRandom, getStrength(paramDHParameters));
    this.params = paramDHParameters;
  }
  
  static int getStrength(DHParameters paramDHParameters)
  {
    if (paramDHParameters.getL() != 0) {
      return paramDHParameters.getL();
    }
    return paramDHParameters.getP().bitLength();
  }
  
  public DHParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DHKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */