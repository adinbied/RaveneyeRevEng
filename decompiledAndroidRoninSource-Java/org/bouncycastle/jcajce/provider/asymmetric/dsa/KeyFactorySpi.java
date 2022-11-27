package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof DSAPrivateKeySpec)) {
      return new BCDSAPrivateKey((DSAPrivateKeySpec)paramKeySpec);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(final KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof DSAPublicKeySpec)) {
      try
      {
        paramKeySpec = new BCDSAPublicKey((DSAPublicKeySpec)paramKeySpec);
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invalid KeySpec: ");
        localStringBuilder.append(paramKeySpec.getMessage());
        throw new InvalidKeySpecException(localStringBuilder.toString())
        {
          public Throwable getCause()
          {
            return paramKeySpec;
          }
        };
      }
    }
    return super.engineGeneratePublic(paramKeySpec);
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(DSAPublicKeySpec.class)) && ((paramKey instanceof DSAPublicKey)))
    {
      paramKey = (DSAPublicKey)paramKey;
      return new DSAPublicKeySpec(paramKey.getY(), paramKey.getParams().getP(), paramKey.getParams().getQ(), paramKey.getParams().getG());
    }
    if ((paramClass.isAssignableFrom(DSAPrivateKeySpec.class)) && ((paramKey instanceof DSAPrivateKey)))
    {
      paramKey = (DSAPrivateKey)paramKey;
      return new DSAPrivateKeySpec(paramKey.getX(), paramKey.getParams().getP(), paramKey.getParams().getQ(), paramKey.getParams().getG());
    }
    return super.engineGetKeySpec(paramKey, paramClass);
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof DSAPublicKey)) {
      return new BCDSAPublicKey((DSAPublicKey)paramKey);
    }
    if ((paramKey instanceof DSAPrivateKey)) {
      return new BCDSAPrivateKey((DSAPrivateKey)paramKey);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (DSAUtil.isDsaOid(localASN1ObjectIdentifier)) {
      return new BCDSAPrivateKey(paramPrivateKeyInfo);
    }
    paramPrivateKeyInfo = new StringBuilder();
    paramPrivateKeyInfo.append("algorithm identifier ");
    paramPrivateKeyInfo.append(localASN1ObjectIdentifier);
    paramPrivateKeyInfo.append(" in key not recognised");
    throw new IOException(paramPrivateKeyInfo.toString());
  }
  
  public PublicKey generatePublic(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm();
    if (DSAUtil.isDsaOid(localASN1ObjectIdentifier)) {
      return new BCDSAPublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */