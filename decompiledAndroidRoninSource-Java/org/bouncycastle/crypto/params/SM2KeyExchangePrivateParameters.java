package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;

public class SM2KeyExchangePrivateParameters
  implements CipherParameters
{
  private final ECPrivateKeyParameters ephemeralPrivateKey;
  private final ECPoint ephemeralPublicPoint;
  private final boolean initiator;
  private final ECPrivateKeyParameters staticPrivateKey;
  private final ECPoint staticPublicPoint;
  
  public SM2KeyExchangePrivateParameters(boolean paramBoolean, ECPrivateKeyParameters paramECPrivateKeyParameters1, ECPrivateKeyParameters paramECPrivateKeyParameters2)
  {
    if (paramECPrivateKeyParameters1 != null)
    {
      if (paramECPrivateKeyParameters2 != null)
      {
        ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters1.getParameters();
        if (localECDomainParameters.equals(paramECPrivateKeyParameters2.getParameters()))
        {
          this.initiator = paramBoolean;
          this.staticPrivateKey = paramECPrivateKeyParameters1;
          this.staticPublicPoint = localECDomainParameters.getG().multiply(paramECPrivateKeyParameters1.getD()).normalize();
          this.ephemeralPrivateKey = paramECPrivateKeyParameters2;
          this.ephemeralPublicPoint = localECDomainParameters.getG().multiply(paramECPrivateKeyParameters2.getD()).normalize();
          return;
        }
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
      }
      throw new NullPointerException("ephemeralPrivateKey cannot be null");
    }
    throw new NullPointerException("staticPrivateKey cannot be null");
  }
  
  public ECPrivateKeyParameters getEphemeralPrivateKey()
  {
    return this.ephemeralPrivateKey;
  }
  
  public ECPoint getEphemeralPublicPoint()
  {
    return this.ephemeralPublicPoint;
  }
  
  public ECPrivateKeyParameters getStaticPrivateKey()
  {
    return this.staticPrivateKey;
  }
  
  public ECPoint getStaticPublicPoint()
  {
    return this.staticPublicPoint;
  }
  
  public boolean isInitiator()
  {
    return this.initiator;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\SM2KeyExchangePrivateParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */