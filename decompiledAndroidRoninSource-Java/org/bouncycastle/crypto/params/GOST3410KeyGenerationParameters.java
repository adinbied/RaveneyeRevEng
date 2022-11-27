package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class GOST3410KeyGenerationParameters
  extends KeyGenerationParameters
{
  private GOST3410Parameters params;
  
  public GOST3410KeyGenerationParameters(SecureRandom paramSecureRandom, GOST3410Parameters paramGOST3410Parameters)
  {
    super(paramSecureRandom, paramGOST3410Parameters.getP().bitLength() - 1);
    this.params = paramGOST3410Parameters;
  }
  
  public GOST3410Parameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410KeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */