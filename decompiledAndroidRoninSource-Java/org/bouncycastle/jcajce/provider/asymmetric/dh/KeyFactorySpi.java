package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof DHPrivateKeySpec)) {
      return new BCDHPrivateKey((DHPrivateKeySpec)paramKeySpec);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof DHPublicKeySpec)) {
      try
      {
        paramKeySpec = new BCDHPublicKey((DHPublicKeySpec)paramKeySpec);
        return paramKeySpec;
      }
      catch (IllegalArgumentException paramKeySpec)
      {
        throw new ExtendedInvalidKeySpecException(paramKeySpec.getMessage(), paramKeySpec);
      }
    }
    return super.engineGeneratePublic(paramKeySpec);
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(DHPrivateKeySpec.class)) && ((paramKey instanceof DHPrivateKey)))
    {
      paramKey = (DHPrivateKey)paramKey;
      return new DHPrivateKeySpec(paramKey.getX(), paramKey.getParams().getP(), paramKey.getParams().getG());
    }
    if ((paramClass.isAssignableFrom(DHPublicKeySpec.class)) && ((paramKey instanceof DHPublicKey)))
    {
      paramKey = (DHPublicKey)paramKey;
      return new DHPublicKeySpec(paramKey.getY(), paramKey.getParams().getP(), paramKey.getParams().getG());
    }
    return super.engineGetKeySpec(paramKey, paramClass);
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof DHPublicKey)) {
      return new BCDHPublicKey((DHPublicKey)paramKey);
    }
    if ((paramKey instanceof DHPrivateKey)) {
      return new BCDHPrivateKey((DHPrivateKey)paramKey);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (localASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
      return new BCDHPrivateKey(paramPrivateKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.dhpublicnumber)) {
      return new BCDHPrivateKey(paramPrivateKeyInfo);
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
    if (localASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
      return new BCDHPublicKey(paramSubjectPublicKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.dhpublicnumber)) {
      return new BCDHPublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */