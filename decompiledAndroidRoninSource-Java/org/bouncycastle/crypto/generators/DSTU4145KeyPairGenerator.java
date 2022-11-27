package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;

public class DSTU4145KeyPairGenerator
  extends ECKeyPairGenerator
{
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    Object localObject = super.generateKeyPair();
    ECPublicKeyParameters localECPublicKeyParameters = (ECPublicKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic();
    localObject = (ECPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate();
    return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(localECPublicKeyParameters.getQ().negate(), localECPublicKeyParameters.getParameters()), (AsymmetricKeyParameter)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DSTU4145KeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */