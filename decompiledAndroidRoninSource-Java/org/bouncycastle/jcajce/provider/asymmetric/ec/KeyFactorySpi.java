package org.bouncycastle.jcajce.provider.asymmetric.ec;

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
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
  implements AsymmetricKeyInfoConverter
{
  String algorithm;
  ProviderConfiguration configuration;
  
  KeyFactorySpi(String paramString, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.configuration = paramProviderConfiguration;
  }
  
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof org.bouncycastle.jce.spec.ECPrivateKeySpec)) {
      return new BCECPrivateKey(this.algorithm, (org.bouncycastle.jce.spec.ECPrivateKeySpec)paramKeySpec, this.configuration);
    }
    if ((paramKeySpec instanceof java.security.spec.ECPrivateKeySpec)) {
      return new BCECPrivateKey(this.algorithm, (java.security.spec.ECPrivateKeySpec)paramKeySpec, this.configuration);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    try
    {
      if ((paramKeySpec instanceof org.bouncycastle.jce.spec.ECPublicKeySpec)) {
        return new BCECPublicKey(this.algorithm, (org.bouncycastle.jce.spec.ECPublicKeySpec)paramKeySpec, this.configuration);
      }
      if ((paramKeySpec instanceof java.security.spec.ECPublicKeySpec))
      {
        paramKeySpec = new BCECPublicKey(this.algorithm, (java.security.spec.ECPublicKeySpec)paramKeySpec, this.configuration);
        return paramKeySpec;
      }
      return super.engineGeneratePublic(paramKeySpec);
    }
    catch (Exception paramKeySpec)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid KeySpec: ");
      localStringBuilder.append(paramKeySpec.getMessage());
      throw new InvalidKeySpecException(localStringBuilder.toString(), paramKeySpec);
    }
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
    if ((paramKey instanceof ECPublicKey)) {
      return new BCECPublicKey((ECPublicKey)paramKey, this.configuration);
    }
    if ((paramKey instanceof ECPrivateKey)) {
      return new BCECPrivateKey((ECPrivateKey)paramKey, this.configuration);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
      return new BCECPrivateKey(this.algorithm, paramPrivateKeyInfo, this.configuration);
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
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
      return new BCECPublicKey(this.algorithm, paramSubjectPublicKeyInfo, this.configuration);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
  
  public static class EC
    extends KeyFactorySpi
  {
    public EC()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECDH
    extends KeyFactorySpi
  {
    public ECDH()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECDHC
    extends KeyFactorySpi
  {
    public ECDHC()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECDSA
    extends KeyFactorySpi
  {
    public ECDSA()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECGOST3410
    extends KeyFactorySpi
  {
    public ECGOST3410()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
  
  public static class ECMQV
    extends KeyFactorySpi
  {
    public ECMQV()
    {
      super(BouncyCastleProvider.CONFIGURATION);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */