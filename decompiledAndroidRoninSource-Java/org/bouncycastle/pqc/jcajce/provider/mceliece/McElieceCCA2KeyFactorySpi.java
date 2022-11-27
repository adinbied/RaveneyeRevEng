package org.bouncycastle.pqc.jcajce.provider.mceliece;

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
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;

public class McElieceCCA2KeyFactorySpi
  extends KeyFactorySpi
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2";
  
  protected PrivateKey engineGeneratePrivate(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    if ((paramKeySpec instanceof PKCS8EncodedKeySpec))
    {
      paramKeySpec = ((PKCS8EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramKeySpec));
      }
      catch (IOException paramKeySpec)
      {
        label104:
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to decode PKCS8EncodedKeySpec: ");
        localStringBuilder.append(paramKeySpec);
        throw new InvalidKeySpecException(localStringBuilder.toString());
      }
    }
    try
    {
      if (PQCObjectIdentifiers.mcElieceCca2.equals(paramKeySpec.getPrivateKeyAlgorithm().getAlgorithm()))
      {
        paramKeySpec = McElieceCCA2PrivateKey.getInstance(paramKeySpec.parsePrivateKey());
        return new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(paramKeySpec.getN(), paramKeySpec.getK(), paramKeySpec.getField(), paramKeySpec.getGoppaPoly(), paramKeySpec.getP(), Utils.getDigest(paramKeySpec.getDigest()).getAlgorithmName()));
      }
      throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
    }
    catch (IOException paramKeySpec)
    {
      break label104;
    }
    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  protected PublicKey engineGeneratePublic(KeySpec paramKeySpec)
    throws InvalidKeySpecException
  {
    StringBuilder localStringBuilder;
    if ((paramKeySpec instanceof X509EncodedKeySpec))
    {
      paramKeySpec = ((X509EncodedKeySpec)paramKeySpec).getEncoded();
      try
      {
        paramKeySpec = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramKeySpec));
        try
        {
          if (PQCObjectIdentifiers.mcElieceCca2.equals(paramKeySpec.getAlgorithm().getAlgorithm()))
          {
            paramKeySpec = McElieceCCA2PublicKey.getInstance(paramKeySpec.parsePublicKey());
            return new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(paramKeySpec.getN(), paramKeySpec.getT(), paramKeySpec.getG(), Utils.getDigest(paramKeySpec.getDigest()).getAlgorithmName()));
          }
          throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
        }
        catch (IOException paramKeySpec)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unable to decode X509EncodedKeySpec: ");
          localStringBuilder.append(paramKeySpec.getMessage());
          throw new InvalidKeySpecException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
      }
      catch (IOException paramKeySpec)
      {
        throw new InvalidKeySpecException(paramKeySpec.toString());
      }
    }
    localStringBuilder.append("Unsupported key specification: ");
    localStringBuilder.append(paramKeySpec.getClass());
    localStringBuilder.append(".");
    throw new InvalidKeySpecException(localStringBuilder.toString());
  }
  
  protected KeySpec engineGetKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    return null;
  }
  
  protected Key engineTranslateKey(Key paramKey)
    throws InvalidKeyException
  {
    return null;
  }
  
  public PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws InvalidKeySpecException
  {
    try
    {
      paramPrivateKeyInfo = McElieceCCA2PrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey().toASN1Primitive());
      paramPrivateKeyInfo = new BCMcElieceCCA2PrivateKey(new McElieceCCA2PrivateKeyParameters(paramPrivateKeyInfo.getN(), paramPrivateKeyInfo.getK(), paramPrivateKeyInfo.getField(), paramPrivateKeyInfo.getGoppaPoly(), paramPrivateKeyInfo.getP(), null));
      return paramPrivateKeyInfo;
    }
    catch (IOException paramPrivateKeyInfo)
    {
      for (;;) {}
    }
    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec");
  }
  
  public PublicKey generatePublic(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws InvalidKeySpecException
  {
    try
    {
      paramSubjectPublicKeyInfo = McElieceCCA2PublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
      paramSubjectPublicKeyInfo = new BCMcElieceCCA2PublicKey(new McElieceCCA2PublicKeyParameters(paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getT(), paramSubjectPublicKeyInfo.getG(), Utils.getDigest(paramSubjectPublicKeyInfo.getDigest()).getAlgorithmName()));
      return paramSubjectPublicKeyInfo;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec");
  }
  
  public KeySpec getKeySpec(Key paramKey, Class paramClass)
    throws InvalidKeySpecException
  {
    if ((paramKey instanceof BCMcElieceCCA2PrivateKey))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
    }
    else
    {
      if (!(paramKey instanceof BCMcElieceCCA2PublicKey)) {
        break label100;
      }
      if (X509EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new X509EncodedKeySpec(paramKey.getEncoded());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("Unknown key specification: ");
    paramKey.append(paramClass);
    paramKey.append(".");
    throw new InvalidKeySpecException(paramKey.toString());
    label100:
    paramClass = new StringBuilder();
    paramClass.append("Unsupported key type: ");
    paramClass.append(paramKey.getClass());
    paramClass.append(".");
    throw new InvalidKeySpecException(paramClass.toString());
  }
  
  public Key translateKey(Key paramKey)
    throws InvalidKeyException
  {
    if (!(paramKey instanceof BCMcElieceCCA2PrivateKey))
    {
      if ((paramKey instanceof BCMcElieceCCA2PublicKey)) {
        return paramKey;
      }
      throw new InvalidKeyException("Unsupported key type.");
    }
    return paramKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceCCA2KeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */