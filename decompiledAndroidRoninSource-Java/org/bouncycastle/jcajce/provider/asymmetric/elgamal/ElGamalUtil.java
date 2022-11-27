package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

public class ElGamalUtil
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof ElGamalPrivateKey))
    {
      paramPrivateKey = (ElGamalPrivateKey)paramPrivateKey;
      return new ElGamalPrivateKeyParameters(paramPrivateKey.getX(), new ElGamalParameters(paramPrivateKey.getParameters().getP(), paramPrivateKey.getParameters().getG()));
    }
    if ((paramPrivateKey instanceof DHPrivateKey))
    {
      paramPrivateKey = (DHPrivateKey)paramPrivateKey;
      return new ElGamalPrivateKeyParameters(paramPrivateKey.getX(), new ElGamalParameters(paramPrivateKey.getParams().getP(), paramPrivateKey.getParams().getG()));
    }
    throw new InvalidKeyException("can't identify private key for El Gamal.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof ElGamalPublicKey))
    {
      paramPublicKey = (ElGamalPublicKey)paramPublicKey;
      return new ElGamalPublicKeyParameters(paramPublicKey.getY(), new ElGamalParameters(paramPublicKey.getParameters().getP(), paramPublicKey.getParameters().getG()));
    }
    if ((paramPublicKey instanceof DHPublicKey))
    {
      paramPublicKey = (DHPublicKey)paramPublicKey;
      return new ElGamalPublicKeyParameters(paramPublicKey.getY(), new ElGamalParameters(paramPublicKey.getParams().getP(), paramPublicKey.getParams().getG()));
    }
    throw new InvalidKeyException("can't identify public key for El Gamal.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\ElGamalUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */