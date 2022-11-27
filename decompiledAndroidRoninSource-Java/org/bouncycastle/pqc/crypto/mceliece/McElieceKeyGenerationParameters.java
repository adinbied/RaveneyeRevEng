package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class McElieceKeyGenerationParameters
  extends KeyGenerationParameters
{
  private McElieceParameters params;
  
  public McElieceKeyGenerationParameters(SecureRandom paramSecureRandom, McElieceParameters paramMcElieceParameters)
  {
    super(paramSecureRandom, 256);
    this.params = paramMcElieceParameters;
  }
  
  public McElieceParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */