package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class KeyFactory
  extends KeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec)) {
      try
      {
        paramKeySpec = PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec)paramKeySpec).getEncoded());
        localObject = BouncyCastleProvider.getPrivateKey(paramKeySpec);
        if (localObject != null) {
          return (PrivateKey)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("no factory found for OID: ");
        ((StringBuilder)localObject).append(paramKeySpec.getPrivateKeyAlgorithm().getAlgorithm());
        throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown KeySpec type: ");
    ((StringBuilder)localObject).append(paramKeySpec.getClass().getName());
    throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof X509EncodedKeySpec)) {
      try
      {
        paramKeySpec = SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec)paramKeySpec).getEncoded());
        localObject = BouncyCastleProvider.getPublicKey(paramKeySpec);
        if (localObject != null) {
          return (PublicKey)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("no factory found for OID: ");
        ((StringBuilder)localObject).append(paramKeySpec.getAlgorithm().getAlgorithm());
        throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown KeySpec type: ");
    ((StringBuilder)localObject).append(paramKeySpec.getClass().getName());
    throw new InvalidKeySpecException(((StringBuilder)localObject).toString());
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
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not implemented yet ");
    localStringBuilder.append(paramKey);
    throw new InvalidKeyException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\KeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */