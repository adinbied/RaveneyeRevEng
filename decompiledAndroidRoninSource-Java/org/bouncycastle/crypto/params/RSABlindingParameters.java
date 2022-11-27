package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class RSABlindingParameters
  implements CipherParameters
{
  private BigInteger blindingFactor;
  private RSAKeyParameters publicKey;
  
  public RSABlindingParameters(RSAKeyParameters paramRSAKeyParameters, BigInteger paramBigInteger)
  {
    if (!(paramRSAKeyParameters instanceof RSAPrivateCrtKeyParameters))
    {
      this.publicKey = paramRSAKeyParameters;
      this.blindingFactor = paramBigInteger;
      return;
    }
    throw new IllegalArgumentException("RSA parameters should be for a public key");
  }
  
  public BigInteger getBlindingFactor()
  {
    return this.blindingFactor;
  }
  
  public RSAKeyParameters getPublicKey()
  {
    return this.publicKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\RSABlindingParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */