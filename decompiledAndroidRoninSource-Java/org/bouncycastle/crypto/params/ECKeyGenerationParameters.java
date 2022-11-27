package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class ECKeyGenerationParameters
  extends KeyGenerationParameters
{
  private ECDomainParameters domainParams;
  
  public ECKeyGenerationParameters(ECDomainParameters paramECDomainParameters, SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom, paramECDomainParameters.getN().bitLength());
    this.domainParams = paramECDomainParameters;
  }
  
  public ECDomainParameters getDomainParameters()
  {
    return this.domainParams;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECKeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */