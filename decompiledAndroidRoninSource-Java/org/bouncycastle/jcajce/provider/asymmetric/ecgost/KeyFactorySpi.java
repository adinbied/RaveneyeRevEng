package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof org.bouncycastle.jce.spec.ECPrivateKeySpec)) {
      return new BCECGOST3410PrivateKey((org.bouncycastle.jce.spec.ECPrivateKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof java.security.spec.ECPrivateKeySpec)) {
      return new BCECGOST3410PrivateKey((java.security.spec.ECPrivateKeySpec)paramKeySpec);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof org.bouncycastle.jce.spec.ECPublicKeySpec)) {
      return new BCECGOST3410PublicKey((org.bouncycastle.jce.spec.ECPublicKeySpec)paramKeySpec, BouncyCastleProvider.CONFIGURATION);
    }
    if ((paramKeySpec instanceof java.security.spec.ECPublicKeySpec)) {
      return new BCECGOST3410PublicKey((java.security.spec.ECPublicKeySpec)paramKeySpec);
    }
    return super.engineGeneratePublic(paramKeySpec);
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(java.security.spec.ECPublicKeySpec.class)) && ((paramKey instanceof ECPublicKey)))
    {
      paramKey = (ECPublicKey)paramKey;
      if (paramKey.getParams() != null) {
        return new java.security.spec.ECPublicKeySpec(paramKey.getW(), paramKey.getParams());
      }
      paramClass = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
      return new java.security.spec.ECPublicKeySpec(paramKey.getW(), EC5Util.convertSpec(EC5Util.convertCurve(paramClass.getCurve(), paramClass.getSeed()), paramClass));
    }
    if ((paramClass.isAssignableFrom(java.security.spec.ECPrivateKeySpec.class)) && ((paramKey instanceof ECPrivateKey)))
    {
      paramKey = (ECPrivateKey)paramKey;
      if (paramKey.getParams() != null) {
        return new java.security.spec.ECPrivateKeySpec(paramKey.getS(), paramKey.getParams());
      }
      paramClass = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
      return new java.security.spec.ECPrivateKeySpec(paramKey.getS(), EC5Util.convertSpec(EC5Util.convertCurve(paramClass.getCurve(), paramClass.getSeed()), paramClass));
    }
    if ((paramClass.isAssignableFrom(org.bouncycastle.jce.spec.ECPublicKeySpec.class)) && ((paramKey instanceof ECPublicKey)))
    {
      paramKey = (ECPublicKey)paramKey;
      if (paramKey.getParams() != null) {
        return new org.bouncycastle.jce.spec.ECPublicKeySpec(EC5Util.convertPoint(paramKey.getParams(), paramKey.getW(), false), EC5Util.convertSpec(paramKey.getParams(), false));
      }
      paramClass = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
      return new org.bouncycastle.jce.spec.ECPublicKeySpec(EC5Util.convertPoint(paramKey.getParams(), paramKey.getW(), false), paramClass);
    }
    if ((paramClass.isAssignableFrom(org.bouncycastle.jce.spec.ECPrivateKeySpec.class)) && ((paramKey instanceof ECPrivateKey)))
    {
      paramKey = (ECPrivateKey)paramKey;
      if (paramKey.getParams() != null) {
        return new org.bouncycastle.jce.spec.ECPrivateKeySpec(paramKey.getS(), EC5Util.convertSpec(paramKey.getParams(), false));
      }
      paramClass = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
      return new org.bouncycastle.jce.spec.ECPrivateKeySpec(paramKey.getS(), paramClass);
    }
    return super.engineGetKeySpec(paramKey, paramClass);
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (localASN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
      return new BCECGOST3410PrivateKey(paramPrivateKeyInfo);
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
    if (localASN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
      return new BCECGOST3410PublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */