package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class RainbowKeyGenerationParameters
  extends KeyGenerationParameters
{
  private RainbowParameters params;
  
  public RainbowKeyGenerationParameters(SecureRandom paramSecureRandom, RainbowParameters paramRainbowParameters)
  {
    super(paramSecureRandom, paramRainbowParameters.getVi()[(paramRainbowParameters.getVi().length - 1)] - paramRainbowParameters.getVi()[0]);
    this.params = paramRainbowParameters;
  }
  
  public RainbowParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */