package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

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
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof ElGamalPrivateKeySpec)) {
      return new BCElGamalPrivateKey((ElGamalPrivateKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof DHPrivateKeySpec)) {
      return new BCElGamalPrivateKey((DHPrivateKeySpec)paramKeySpec);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof ElGamalPublicKeySpec)) {
      return new BCElGamalPublicKey((ElGamalPublicKeySpec)paramKeySpec);
    }
    if ((paramKeySpec instanceof DHPublicKeySpec)) {
      return new BCElGamalPublicKey((DHPublicKeySpec)paramKeySpec);
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
      return new BCElGamalPublicKey((DHPublicKey)paramKey);
    }
    if ((paramKey instanceof DHPrivateKey)) {
      return new BCElGamalPrivateKey((DHPrivateKey)paramKey);
    }
    if ((paramKey instanceof ElGamalPublicKey)) {
      return new BCElGamalPublicKey((ElGamalPublicKey)paramKey);
    }
    if ((paramKey instanceof ElGamalPrivateKey)) {
      return new BCElGamalPrivateKey((ElGamalPrivateKey)paramKey);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (localASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
      return new BCElGamalPrivateKey(paramPrivateKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.dhpublicnumber)) {
      return new BCElGamalPrivateKey(paramPrivateKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
      return new BCElGamalPrivateKey(paramPrivateKeyInfo);
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
      return new BCElGamalPublicKey(paramSubjectPublicKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.dhpublicnumber)) {
      return new BCElGamalPublicKey(paramSubjectPublicKeyInfo);
    }
    if (localASN1ObjectIdentifier.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
      return new BCElGamalPublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */