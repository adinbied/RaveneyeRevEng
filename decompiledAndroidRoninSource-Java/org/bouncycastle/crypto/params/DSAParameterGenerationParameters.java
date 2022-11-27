package org.bouncycastle.crypto.params;

import java.security.SecureRandom;

public class DSAParameterGenerationParameters
{
  public static final int DIGITAL_SIGNATURE_USAGE = 1;
  public static final int KEY_ESTABLISHMENT_USAGE = 2;
  private final int certainty;
  private final int l;
  private final int n;
  private final SecureRandom random;
  private final int usageIndex;
  
  public DSAParameterGenerationParameters(int paramInt1, int paramInt2, int paramInt3, SecureRandom paramSecureRandom)
  {
    this(paramInt1, paramInt2, paramInt3, paramSecureRandom, -1);
  }
  
  public DSAParameterGenerationParameters(int paramInt1, int paramInt2, int paramInt3, SecureRandom paramSecureRandom, int paramInt4)
  {
    this.l = paramInt1;
    this.n = paramInt2;
    this.certainty = paramInt3;
    this.usageIndex = paramInt4;
    this.random = paramSecureRandom;
  }
  
  public int getCertainty()
  {
    return this.certainty;
  }
  
  public int getL()
  {
    return this.l;
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public SecureRandom getRandom()
  {
    return this.random;
  }
  
  public int getUsageIndex()
  {
    return this.usageIndex;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAParameterGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */