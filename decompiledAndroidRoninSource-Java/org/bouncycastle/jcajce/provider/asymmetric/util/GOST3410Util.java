package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class GOST3410Util
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof GOST3410PrivateKey))
    {
      paramPrivateKey = (GOST3410PrivateKey)paramPrivateKey;
      GOST3410PublicKeyParameterSetSpec localGOST3410PublicKeyParameterSetSpec = paramPrivateKey.getParameters().getPublicKeyParameters();
      return new GOST3410PrivateKeyParameters(paramPrivateKey.getX(), new GOST3410Parameters(localGOST3410PublicKeyParameterSetSpec.getP(), localGOST3410PublicKeyParameterSetSpec.getQ(), localGOST3410PublicKeyParameterSetSpec.getA()));
    }
    throw new InvalidKeyException("can't identify GOST3410 private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof GOST3410PublicKey))
    {
      paramPublicKey = (GOST3410PublicKey)paramPublicKey;
      localObject = paramPublicKey.getParameters().getPublicKeyParameters();
      return new GOST3410PublicKeyParameters(paramPublicKey.getY(), new GOST3410Parameters(((GOST3410PublicKeyParameterSetSpec)localObject).getP(), ((GOST3410PublicKeyParameterSetSpec)localObject).getQ(), ((GOST3410PublicKeyParameterSetSpec)localObject).getA()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't identify GOST3410 public key: ");
    ((StringBuilder)localObject).append(paramPublicKey.getClass().getName());
    throw new InvalidKeyException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\GOST3410Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */