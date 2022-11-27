package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

public class KeyFactorySpi
  extends BaseKeyFactorySpi
{
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof GOST3410PrivateKeySpec)) {
      return new BCGOST3410PrivateKey((GOST3410PrivateKeySpec)paramKeySpec);
    }
    return super.engineGeneratePrivate(paramKeySpec);
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof GOST3410PublicKeySpec)) {
      return new BCGOST3410PublicKey((GOST3410PublicKeySpec)paramKeySpec);
    }
    return super.engineGeneratePublic(paramKeySpec);
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramClass.isAssignableFrom(GOST3410PublicKeySpec.class)) && ((paramKey instanceof GOST3410PublicKey)))
    {
      paramKey = (GOST3410PublicKey)paramKey;
      paramClass = paramKey.getParameters().getPublicKeyParameters();
      return new GOST3410PublicKeySpec(paramKey.getY(), paramClass.getP(), paramClass.getQ(), paramClass.getA());
    }
    if ((paramClass.isAssignableFrom(GOST3410PrivateKeySpec.class)) && ((paramKey instanceof GOST3410PrivateKey)))
    {
      paramKey = (GOST3410PrivateKey)paramKey;
      paramClass = paramKey.getParameters().getPublicKeyParameters();
      return new GOST3410PrivateKeySpec(paramKey.getX(), paramClass.getP(), paramClass.getQ(), paramClass.getA());
    }
    return super.engineGetKeySpec(paramKey, paramClass);
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof GOST3410PublicKey)) {
      return new BCGOST3410PublicKey((GOST3410PublicKey)paramKey);
    }
    if ((paramKey instanceof GOST3410PrivateKey)) {
      return new BCGOST3410PrivateKey((GOST3410PrivateKey)paramKey);
    }
    throw new InvalidKeyException("key type unknown");
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    if (localASN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
      return new BCGOST3410PrivateKey(paramPrivateKeyInfo);
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
    if (localASN1ObjectIdentifier.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
      return new BCGOST3410PublicKey(paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = new StringBuilder();
    paramSubjectPublicKeyInfo.append("algorithm identifier ");
    paramSubjectPublicKeyInfo.append(localASN1ObjectIdentifier);
    paramSubjectPublicKeyInfo.append(" in key not recognised");
    throw new IOException(paramSubjectPublicKeyInfo.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */