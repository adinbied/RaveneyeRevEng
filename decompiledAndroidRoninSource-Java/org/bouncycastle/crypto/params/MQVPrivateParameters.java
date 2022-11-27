package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;

public class MQVPrivateParameters
  implements CipherParameters
{
  private ECPrivateKeyParameters ephemeralPrivateKey;
  private ECPublicKeyParameters ephemeralPublicKey;
  private ECPrivateKeyParameters staticPrivateKey;
  
  public MQVPrivateParameters(ECPrivateKeyParameters paramECPrivateKeyParameters1, ECPrivateKeyParameters paramECPrivateKeyParameters2)
  {
    this(paramECPrivateKeyParameters1, paramECPrivateKeyParameters2, null);
  }
  
  public MQVPrivateParameters(ECPrivateKeyParameters paramECPrivateKeyParameters1, ECPrivateKeyParameters paramECPrivateKeyParameters2, ECPublicKeyParameters paramECPublicKeyParameters)
  {
    if (paramECPrivateKeyParameters1 != null)
    {
      if (paramECPrivateKeyParameters2 != null)
      {
        ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters1.getParameters();
        if (localECDomainParameters.equals(paramECPrivateKeyParameters2.getParameters()))
        {
          if (paramECPublicKeyParameters == null) {
            paramECPublicKeyParameters = new ECPublicKeyParameters(localECDomainParameters.getG().multiply(paramECPrivateKeyParameters2.getD()), localECDomainParameters);
          } else {
            if (!localECDomainParameters.equals(paramECPublicKeyParameters.getParameters())) {
              break label87;
            }
          }
          this.staticPrivateKey = paramECPrivateKeyParameters1;
          this.ephemeralPrivateKey = paramECPrivateKeyParameters2;
          this.ephemeralPublicKey = paramECPublicKeyParameters;
          return;
          label87:
          throw new IllegalArgumentException("Ephemeral public key has different domain parameters");
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
  
  public ECPublicKeyParameters getEphemeralPublicKey()
  {
    return this.ephemeralPublicKey;
  }
  
  public ECPrivateKeyParameters getStaticPrivateKey()
  {
    return this.staticPrivateKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\MQVPrivateParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */