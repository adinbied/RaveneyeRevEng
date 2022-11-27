package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class SM2KeyExchangePublicParameters
  implements CipherParameters
{
  private ECPublicKeyParameters ephemeralPublicKey;
  private ECPublicKeyParameters staticPublicKey;
  
  public SM2KeyExchangePublicParameters(ECPublicKeyParameters paramECPublicKeyParameters1, ECPublicKeyParameters paramECPublicKeyParameters2)
  {
    if (paramECPublicKeyParameters1 != null)
    {
      if (paramECPublicKeyParameters2 != null)
      {
        if (paramECPublicKeyParameters1.getParameters().equals(paramECPublicKeyParameters2.getParameters()))
        {
          this.staticPublicKey = paramECPublicKeyParameters1;
          this.ephemeralPublicKey = paramECPublicKeyParameters2;
          return;
        }
        throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
      }
      throw new NullPointerException("ephemeralPublicKey cannot be null");
    }
    throw new NullPointerException("staticPublicKey cannot be null");
  }
  
  public ECPublicKeyParameters getEphemeralPublicKey()
  {
    return this.ephemeralPublicKey;
  }
  
  public ECPublicKeyParameters getStaticPublicKey()
  {
    return this.staticPublicKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\SM2KeyExchangePublicParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */