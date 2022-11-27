package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

public class RainbowKeyFactorySpi
  extends KeyFactorySpi
  implements AsymmetricKeyInfoConverter
{
  public PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof RainbowPrivateKeySpec)) {
      return new BCRainbowPrivateKey((RainbowPrivateKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramKeySpec)));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof RainbowPublicKeySpec)) {
      return new BCRainbowPublicKey((RainbowPublicKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = generatePublic(SubjectPublicKeyInfo.getInstance(paramKeySpec));
        return paramKeySpec;
      }
      catch (Exception paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown key specification: ");
    localStringBuilder.append(paramKeySpec);
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  public final KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramKey instanceof BCRainbowPrivateKey))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
      if (RainbowPrivateKeySpec.class.isAssignableFrom(paramClass))
      {
        paramKey = (BCRainbowPrivateKey)paramKey;
        return new RainbowPrivateKeySpec(paramKey.getInvA1(), paramKey.getB1(), paramKey.getInvA2(), paramKey.getB2(), paramKey.getVi(), paramKey.getLayers());
      }
    }
    else
    {
      if (!(paramKey instanceof BCRainbowPublicKey)) {
        break label184;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
      if (RainbowPublicKeySpec.class.isAssignableFrom(paramClass))
      {
        paramKey = (BCRainbowPublicKey)paramKey;
        return new RainbowPublicKeySpec(paramKey.getDocLength(), paramKey.getCoeffQuadratic(), paramKey.getCoeffSingular(), paramKey.getCoeffScalar());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("Unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label184:
    paramClass = new StringBuilder();
    paramClass.append("Unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public final Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if (!(paramKey instanceof BCRainbowPrivateKey))
    {
      if ((paramKey instanceof BCRainbowPublicKey)) {
        return paramKey;
      }
      throw new InvalidKeyException("Unsupported key type");
    }
    return paramKey;
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    paramPrivateKeyInfo = RainbowPrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey());
    return new BCRainbowPrivateKey(paramPrivateKeyInfo.getInvA1(), paramPrivateKeyInfo.getB1(), paramPrivateKeyInfo.getInvA2(), paramPrivateKeyInfo.getB2(), paramPrivateKeyInfo.getVi(), paramPrivateKeyInfo.getLayers());
  }
  
  public PublicKey generatePublic(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    paramSubjectPublicKeyInfo = RainbowPublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
    return new BCRainbowPublicKey(paramSubjectPublicKeyInfo.getDocLength(), paramSubjectPublicKeyInfo.getCoeffQuadratic(), paramSubjectPublicKeyInfo.getCoeffSingular(), paramSubjectPublicKeyInfo.getCoeffScalar());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\rainbow\RainbowKeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */