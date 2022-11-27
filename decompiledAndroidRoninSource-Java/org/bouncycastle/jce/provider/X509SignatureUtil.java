package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

class X509SignatureUtil
{
  private static final ASN1Null derNull = DERNull.INSTANCE;
  
  private static String getDigestAlgName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if (PKCSObjectIdentifiers.md5.equals(paramASN1ObjectIdentifier)) {
      return "MD5";
    }
    if (OIWObjectIdentifiers.idSHA1.equals(paramASN1ObjectIdentifier)) {
      return "SHA1";
    }
    if (NISTObjectIdentifiers.id_sha224.equals(paramASN1ObjectIdentifier)) {
      return "SHA224";
    }
    if (NISTObjectIdentifiers.id_sha256.equals(paramASN1ObjectIdentifier)) {
      return "SHA256";
    }
    if (NISTObjectIdentifiers.id_sha384.equals(paramASN1ObjectIdentifier)) {
      return "SHA384";
    }
    if (NISTObjectIdentifiers.id_sha512.equals(paramASN1ObjectIdentifier)) {
      return "SHA512";
    }
    if (TeleTrusTObjectIdentifiers.ripemd128.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD128";
    }
    if (TeleTrusTObjectIdentifiers.ripemd160.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD160";
    }
    if (TeleTrusTObjectIdentifiers.ripemd256.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD256";
    }
    if (CryptoProObjectIdentifiers.gostR3411.equals(paramASN1ObjectIdentifier)) {
      return "GOST3411";
    }
    return paramASN1ObjectIdentifier.getId();
  }
  
  static String getSignatureName(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    Object localObject = paramAlgorithmIdentifier.getParameters();
    if ((localObject != null) && (!derNull.equals(localObject)))
    {
      if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
      {
        paramAlgorithmIdentifier = RSASSAPSSparams.getInstance(localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getDigestAlgName(paramAlgorithmIdentifier.getHashAlgorithm().getAlgorithm()));
        ((StringBuilder)localObject).append("withRSAandMGF1");
        return ((StringBuilder)localObject).toString();
      }
      if (paramAlgorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2))
      {
        paramAlgorithmIdentifier = ASN1Sequence.getInstance(localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getDigestAlgName(ASN1ObjectIdentifier.getInstance(paramAlgorithmIdentifier.getObjectAt(0))));
        ((StringBuilder)localObject).append("withECDSA");
        return ((StringBuilder)localObject).toString();
      }
    }
    return paramAlgorithmIdentifier.getAlgorithm().getId();
  }
  
  static void setSignatureParameters(Signature paramSignature, ASN1Encodable paramASN1Encodable)
    throws NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    if ((paramASN1Encodable != null) && (!derNull.equals(paramASN1Encodable)))
    {
      AlgorithmParameters localAlgorithmParameters = AlgorithmParameters.getInstance(paramSignature.getAlgorithm(), paramSignature.getProvider());
      try
      {
        localAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded());
        if (paramSignature.getAlgorithm().endsWith("MGF1")) {
          try
          {
            paramSignature.setParameter(localAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
            return;
          }
          catch (GeneralSecurityException paramSignature)
          {
            paramASN1Encodable = new StringBuilder();
            paramASN1Encodable.append("Exception extracting parameters: ");
            paramASN1Encodable.append(paramSignature.getMessage());
            throw new SignatureException(paramASN1Encodable.toString());
          }
        }
        return;
      }
      catch (IOException paramSignature)
      {
        paramASN1Encodable = new StringBuilder();
        paramASN1Encodable.append("IOException decoding parameters: ");
        paramASN1Encodable.append(paramSignature.getMessage());
        throw new SignatureException(paramASN1Encodable.toString());
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509SignatureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */