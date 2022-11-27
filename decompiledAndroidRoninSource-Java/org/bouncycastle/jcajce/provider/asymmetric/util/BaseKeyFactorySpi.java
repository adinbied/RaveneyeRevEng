package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class BaseKeyFactorySpi
  extends KeyFactorySpi
  implements AsymmetricKeyInfoConverter
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec)) {
      try
      {
        paramKeySpec = generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec)paramKeySpec).getEncoded()));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("encoded key spec not recognized: ");
        localStringBuilder.append(paramKeySpec.getMessage());
        throw new InvalidKeySpecException(localStringBuilder.toString());
      }
    }
    throw new InvalidKeySpecException("key spec not recognized");
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof X509EncodedKeySpec)) {
      try
      {
        paramKeySpec = generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec)paramKeySpec).getEncoded()));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("encoded key spec not recognized: ");
        localStringBuilder.append(paramKeySpec.getMessage());
        throw new InvalidKeySpecException(localStringBuilder.toString());
      }
    }
    throw new InvalidKeySpecException("key spec not recognized");
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(PKCS8EncodedKeySpec.class)) && (paramKey.getFormat().equals("PKCS#8"))) {
      return new PKCS8EncodedKeySpec(paramKey.getEncoded());
    }
    if ((paramClass.isAssignableFrom(X509EncodedKeySpec.class)) && (paramKey.getFormat().equals("X.509"))) {
      return new X509EncodedKeySpec(paramKey.getEncoded());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not implemented yet ");
    localStringBuilder.append(paramKey);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramClass);
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\BaseKeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */