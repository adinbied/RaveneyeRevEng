package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;

public class RainbowKeysToParams
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof BCRainbowPrivateKey))
    {
      paramPrivateKey = (BCRainbowPrivateKey)paramPrivateKey;
      return new RainbowPrivateKeyParameters(paramPrivateKey.getInvA1(), paramPrivateKey.getB1(), paramPrivateKey.getInvA2(), paramPrivateKey.getB2(), paramPrivateKey.getVi(), paramPrivateKey.getLayers());
    }
    throw new InvalidKeyException("can't identify Rainbow private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof BCRainbowPublicKey))
    {
      paramPublicKey = (BCRainbowPublicKey)paramPublicKey;
      return new RainbowPublicKeyParameters(paramPublicKey.getDocLength(), paramPublicKey.getCoeffQuadratic(), paramPublicKey.getCoeffSingular(), paramPublicKey.getCoeffScalar());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("can't identify Rainbow public key: ");
    localStringBuilder.append(paramPublicKey.getClass().getName());
    throw new InvalidKeyException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\RainbowKeysToParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */