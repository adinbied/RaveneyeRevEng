package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceCCA2KeysToParams
{
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof BCMcElieceCCA2PrivateKey)) {
      return ((BCMcElieceCCA2PrivateKey)paramPrivateKey).getKeyParams();
    }
    throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof BCMcElieceCCA2PublicKey)) {
      return ((BCMcElieceCCA2PublicKey)paramPublicKey).getKeyParams();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("can't identify McElieceCCA2 public key: ");
    localStringBuilder.append(paramPublicKey.getClass().getName());
    throw new InvalidKeyException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceCCA2KeysToParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */