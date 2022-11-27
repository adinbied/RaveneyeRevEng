package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithRandom
  implements CipherParameters
{
  private CipherParameters parameters;
  private SecureRandom random;
  
  public ParametersWithRandom(CipherParameters paramCipherParameters)
  {
    this(paramCipherParameters, new SecureRandom());
  }
  
  public ParametersWithRandom(CipherParameters paramCipherParameters, SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    this.parameters = paramCipherParameters;
  }
  
  public CipherParameters getParameters()
  {
    return this.parameters;
  }
  
  public SecureRandom getRandom()
  {
    return this.random;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ParametersWithRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */