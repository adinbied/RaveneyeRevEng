package org.bouncycastle.jce.provider;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;

public class DHUtil
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof DHPrivateKey))
    {
      paramPrivateKey = (DHPrivateKey)paramPrivateKey;
      return new DHPrivateKeyParameters(paramPrivateKey.getX(), new DHParameters(paramPrivateKey.getParams().getP(), paramPrivateKey.getParams().getG(), null, paramPrivateKey.getParams().getL()));
    }
    throw new InvalidKeyException("can't identify DH private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof DHPublicKey))
    {
      paramPublicKey = (DHPublicKey)paramPublicKey;
      return new DHPublicKeyParameters(paramPublicKey.getY(), new DHParameters(paramPublicKey.getParams().getP(), paramPublicKey.getParams().getG(), null, paramPublicKey.getParams().getL()));
    }
    throw new InvalidKeyException("can't identify DH public key.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\DHUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */