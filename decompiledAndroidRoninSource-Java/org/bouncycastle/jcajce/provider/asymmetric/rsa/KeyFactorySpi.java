package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec)) {
      try
      {
        PrivateKey localPrivateKey = generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec)paramKeySpec).getEncoded()));
        return localPrivateKey;
      }
      catch (Exception localException) {}
    }
    try
    {
      paramKeySpec = new BCRSAPrivateCrtKey(org.bouncycastle.asn1.pkcs.RSAPrivateKey.getInstance(((PKCS8EncodedKeySpec)paramKeySpec).getEncoded()));
      return paramKeySpec;
    }
    catch (Exception paramKeySpec)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    paramKeySpec = new StringBuilder();
    paramKeySpec.append("unable to process key spec: ");
    paramKeySpec.append(localException.toString());
    throw new ExtendedInvalidKeySpecException(paramKeySpec.toString(), localException);
    if ((paramKeySpec instanceof RSAPrivateCrtKeySpec)) {
      return new BCRSAPrivateCrtKey((RSAPrivateCrtKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof RSAPrivateKeySpec)) {
      return new BCRSAPrivateKey((RSAPrivateKeySpec)paramKeySpec);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown KeySpec type: ");
    localStringBuilder.append(paramKeySpec.getClass().getName());
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof RSAPublicKeySpec)) {
      return new BCRSAPublicKey((RSAPublicKeySpec)paramKeySpec);
    }
    return super.engineGeneratePublic(paramKeySpec);
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(RSAPublicKeySpec.class)) && ((paramKey instanceof RSAPublicKey)))
    {
      paramKey = (RSAPublicKey)paramKey;
      return new RSAPublicKeySpec(paramKey.getModulus(), paramKey.getPublicExponent());
    }
    if ((paramClass.isAssignableFrom(RSAPrivateKeySpec.class)) && ((paramKey instanceof java.security.interfaces.RSAPrivateKey)))
    {
      paramKey = (java.security.interfaces.RSAPrivateKey)paramKey;
      return new RSAPrivateKeySpec(paramKey.getModulus(), paramKey.getPrivateExponent());
    }
    if ((paramClass.isAssignableFrom(RSAPrivateCrtKeySpec.class)) && ((paramKey instanceof RSAPrivateCrtKey)))
    {
      paramKey = (RSAPrivateCrtKey)paramKey;
      return new RSAPrivateCrtKeySpec(paramKey.getModulus(), paramKey.getPublicExponent(), paramKey.getPrivateExponent(), paramKey.getPrimeP(), paramKey.getPrimeQ(), paramKey.getPrimeExponentP(), paramKey.getPrimeExponentQ(), paramKey.getCrtCoefficient());
    }
    return super.engineGetKeySpec(paramKey, paramClass);
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof RSAPublicKey)) {
      return new BCRSAPublicKey((RSAPublicKey)paramKey);
    }
    if ((paramKey instanceof RSAPrivateCrtKey)) {
      return new BCRSAPrivateCrtKey((RSAPrivateCrtKey)paramKey);
    }
    if ((paramKey instanceof java.security.interfaces.RSAPrivateKey)) {
      return new BCRSAPrivateKey((java.security.interfaces.RSAPrivateKey)paramKey);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    Object localObject = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (RSAUtil.isRsaOid((ASN1ObjectIdentifier)localObject))
    {
      localObject = org.bouncycastle.asn1.pkcs.RSAPrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey());
      if (((org.bouncycastle.asn1.pkcs.RSAPrivateKey)localObject).getCoefficient().intValue() == 0) {
        return new BCRSAPrivateKey((org.bouncycastle.asn1.pkcs.RSAPrivateKey)localObject);
      }
      return new BCRSAPrivateCrtKey(paramPrivateKeyInfo);
    }
    paramPrivateKeyInfo = new StringBuilder();
    paramPrivateKeyInfo.append("algorithm identifier ");
    paramPrivateKeyInfo.append(localObject);
    paramPrivateKeyInfo.append(" in key not recognised");
    throw new IOException(paramPrivateKeyInfo.toString());
  }
  
  public PublicKey generatePublic(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm();
    if (RSAUtil.isRsaOid(localASN1ObjectIdentifier)) {
      return new BCRSAPublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */