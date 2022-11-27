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
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.pqc.asn1.McEliecePrivateKey;
import org.bouncycastle.pqc.asn1.McEliecePublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

public class McElieceKeyFactorySpi
  extends KeyFactorySpi
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
  
  private static Digest getDigest(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    return new SHA256Digest();
  }
  
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
        label100:
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to decode PKCS8EncodedKeySpec: ");
        localStringBuilder.append(paramKeySpec);
        throw new InvalidKeySpecException(localStringBuilder.toString());
      }
    }
    try
    {
      if (PQCObjectIdentifiers.mcEliece.equals(paramKeySpec.getPrivateKeyAlgorithm().getAlgorithm()))
      {
        paramKeySpec = McEliecePrivateKey.getInstance(paramKeySpec.parsePrivateKey());
        return new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(paramKeySpec.getN(), paramKeySpec.getK(), paramKeySpec.getField(), paramKeySpec.getGoppaPoly(), paramKeySpec.getP1(), paramKeySpec.getP2(), paramKeySpec.getSInv()));
      }
      throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
    }
    catch (IOException paramKeySpec)
    {
      break label100;
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
          if (PQCObjectIdentifiers.mcEliece.equals(paramKeySpec.getAlgorithm().getAlgorithm()))
          {
            paramKeySpec = McEliecePublicKey.getInstance(paramKeySpec.parsePublicKey());
            return new BCMcEliecePublicKey(new McEliecePublicKeyParameters(paramKeySpec.getN(), paramKeySpec.getT(), paramKeySpec.getG()));
          }
          throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
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
      paramPrivateKeyInfo = McEliecePrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey().toASN1Primitive());
      paramPrivateKeyInfo = new BCMcEliecePrivateKey(new McEliecePrivateKeyParameters(paramPrivateKeyInfo.getN(), paramPrivateKeyInfo.getK(), paramPrivateKeyInfo.getField(), paramPrivateKeyInfo.getGoppaPoly(), paramPrivateKeyInfo.getP1(), paramPrivateKeyInfo.getP2(), paramPrivateKeyInfo.getSInv()));
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
      paramSubjectPublicKeyInfo = McEliecePublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
      paramSubjectPublicKeyInfo = new BCMcEliecePublicKey(new McEliecePublicKeyParameters(paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getT(), paramSubjectPublicKeyInfo.getG()));
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
    if ((paramKey instanceof BCMcEliecePrivateKey))
    {
      if (PKCS8EncodedKeySpec.class.isAssignableFrom(paramClass)) {
        return new PKCS8EncodedKeySpec(paramKey.getEncoded());
      }
    }
    else
    {
      if (!(paramKey instanceof BCMcEliecePublicKey)) {
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
    if (!(paramKey instanceof BCMcEliecePrivateKey))
    {
      if ((paramKey instanceof BCMcEliecePublicKey)) {
        return paramKey;
      }
      throw new InvalidKeyException("Unsupported key type.");
    }
    return paramKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceKeyFactorySpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */