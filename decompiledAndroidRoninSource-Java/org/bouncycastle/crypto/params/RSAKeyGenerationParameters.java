package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class RSAKeyGenerationParameters
  extends KeyGenerationParameters
{
  private int certainty;
  private BigInteger publicExponent;
  
  public RSAKeyGenerationParameters(BigInteger paramBigInteger, SecureRandom paramSecureRandom, int paramInt1, int paramInt2)
  {
    super(paramSecureRandom, paramInt1);
    if (paramInt1 >= 12)
    {
      if (paramBigInteger.testBit(0))
      {
        this.publicExponent = paramBigInteger;
        this.certainty = paramInt2;
        return;
      }
      throw new IllegalArgumentException("public exponent cannot be even");
    }
    throw new IllegalArgumentException("key strength too small");
  }
  
  public int getCertainty()
  {
    return this.certainty;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\RSAKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */