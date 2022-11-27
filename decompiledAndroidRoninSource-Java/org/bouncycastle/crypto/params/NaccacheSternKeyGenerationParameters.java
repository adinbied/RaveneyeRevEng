package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class NaccacheSternKeyGenerationParameters
  extends KeyGenerationParameters
{
  private int certainty;
  private int cntSmallPrimes;
  private boolean debug = false;
  
  public NaccacheSternKeyGenerationParameters(SecureRandom paramSecureRandom, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramSecureRandom, paramInt1, paramInt2, paramInt3, false);
  }
  
  public NaccacheSternKeyGenerationParameters(SecureRandom paramSecureRandom, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramSecureRandom, paramInt1);
    this.certainty = paramInt2;
    if (paramInt3 % 2 != 1)
    {
      if (paramInt3 >= 30)
      {
        this.cntSmallPrimes = paramInt3;
        this.debug = paramBoolean;
        return;
      }
      throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
    }
    throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
  }
  
  public int getCertainty()
  {
    return this.certainty;
  }
  
  public int getCntSmallPrimes()
  {
    return this.cntSmallPrimes;
  }
  
  public boolean isDebug()
  {
    return this.debug;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\NaccacheSternKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */