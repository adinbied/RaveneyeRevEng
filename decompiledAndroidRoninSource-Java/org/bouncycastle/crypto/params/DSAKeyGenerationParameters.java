package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class DSAKeyGenerationParameters
  extends KeyGenerationParameters
{
  private DSAParameters params;
  
  public DSAKeyGenerationParameters(SecureRandom paramSecureRandom, DSAParameters paramDSAParameters)
  {
    super(paramSecureRandom, paramDSAParameters.getP().bitLength() - 1);
    this.params = paramDSAParameters;
  }
  
  public DSAParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */