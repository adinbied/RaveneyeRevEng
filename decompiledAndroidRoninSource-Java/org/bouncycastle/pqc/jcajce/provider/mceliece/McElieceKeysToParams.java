package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;

public class McElieceKeysToParams
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof BCMcEliecePrivateKey))
    {
      paramPrivateKey = (BCMcEliecePrivateKey)paramPrivateKey;
      return new McEliecePrivateKeyParameters(paramPrivateKey.getN(), paramPrivateKey.getK(), paramPrivateKey.getField(), paramPrivateKey.getGoppaPoly(), paramPrivateKey.getP1(), paramPrivateKey.getP2(), paramPrivateKey.getSInv());
    }
    throw new InvalidKeyException("can't identify McEliece private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof BCMcEliecePublicKey)) {
      return ((BCMcEliecePublicKey)paramPublicKey).getKeyParams();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("can't identify McEliece public key: ");
    localStringBuilder.append(paramPublicKey.getClass().getName());
    throw new InvalidKeyException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceKeysToParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */