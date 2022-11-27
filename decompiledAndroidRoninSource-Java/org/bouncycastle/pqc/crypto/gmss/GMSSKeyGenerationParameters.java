package org.bouncycastle.pqc.crypto.gmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class GMSSKeyGenerationParameters
  extends KeyGenerationParameters
{
  private GMSSParameters params;
  
  public GMSSKeyGenerationParameters(SecureRandom paramSecureRandom, GMSSParameters paramGMSSParameters)
  {
    super(paramSecureRandom, 1);
    this.params = paramGMSSParameters;
  }
  
  public GMSSParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */