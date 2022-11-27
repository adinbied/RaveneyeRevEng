package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class McElieceCCA2KeyGenerationParameters
  extends KeyGenerationParameters
{
  private McElieceCCA2Parameters params;
  
  public McElieceCCA2KeyGenerationParameters(SecureRandom paramSecureRandom, McElieceCCA2Parameters paramMcElieceCCA2Parameters)
  {
    super(paramSecureRandom, 128);
    this.params = paramMcElieceCCA2Parameters;
  }
  
  public McElieceCCA2Parameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2KeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */