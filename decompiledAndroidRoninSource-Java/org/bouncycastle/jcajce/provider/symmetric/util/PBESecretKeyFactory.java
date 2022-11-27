package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public class PBESecretKeyFactory
  extends BaseSecretKeyFactory
  implements PBE
{
  private int digest;
  private boolean forCipher;
  private int ivSize;
  private int keySize;
  private int scheme;
  
  public PBESecretKeyFactory(String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramASN1ObjectIdentifier);
    this.forCipher = paramBoolean;
    this.scheme = paramInt1;
    this.digest = paramInt2;
    this.keySize = paramInt3;
    this.ivSize = paramInt4;
  }
  
  protected SecretKey engineGenerateSecret(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PBEKeySpec))
    {
      PBEKeySpec localPBEKeySpec = (PBEKeySpec)paramKeySpec;
      if (localPBEKeySpec.getSalt() == null) {
        return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, localPBEKeySpec, null);
      }
      if (this.forCipher) {
        paramKeySpec = PBE.Util.makePBEParameters(localPBEKeySpec, this.scheme, this.digest, this.keySize, this.ivSize);
      } else {
        paramKeySpec = PBE.Util.makePBEMacParameters(localPBEKeySpec, this.scheme, this.digest, this.keySize);
      }
      return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, localPBEKeySpec, paramKeySpec);
    }
    throw new InvalidKeySpecException("Invalid KeySpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\PBESecretKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */