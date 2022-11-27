package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.util.MessageDigestUtils;

class X509SignatureUtil
{
  private static final ASN1Null derNull = DERNull.INSTANCE;
  
  private static String getDigestAlgName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = MessageDigestUtils.getDigestName(paramASN1ObjectIdentifier);
    int i = str.indexOf('-');
    if ((i > 0) && (!str.startsWith("SHA3")))
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append(str.substring(0, i));
      paramASN1ObjectIdentifier.append(str.substring(i + 1));
      return paramASN1ObjectIdentifier.toString();
    }
    return MessageDigestUtils.getDigestName(paramASN1ObjectIdentifier);
  }
  
  static String getSignatureName(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    Object localObject1 = paramAlgorithmIdentifier.getParameters();
    int i = 0;
    if ((localObject1 != null) && (!derNull.equals(localObject1)))
    {
      if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
      {
        paramAlgorithmIdentifier = RSASSAPSSparams.getInstance(localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getDigestAlgName(paramAlgorithmIdentifier.getHashAlgorithm().getAlgorithm()));
        ((StringBuilder)localObject1).append("withRSAandMGF1");
        return ((StringBuilder)localObject1).toString();
      }
      if (paramAlgorithmIdentifier.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2))
      {
        paramAlgorithmIdentifier = ASN1Sequence.getInstance(localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getDigestAlgName((ASN1ObjectIdentifier)paramAlgorithmIdentifier.getObjectAt(0)));
        ((StringBuilder)localObject1).append("withECDSA");
        return ((StringBuilder)localObject1).toString();
      }
    }
    localObject1 = Security.getProvider("BC");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Alg.Alias.Signature.");
      ((StringBuilder)localObject2).append(paramAlgorithmIdentifier.getAlgorithm().getId());
      localObject1 = ((Provider)localObject1).getProperty(((StringBuilder)localObject2).toString());
      if (localObject1 != null) {
        return (String)localObject1;
      }
    }
    localObject1 = Security.getProviders();
    while (i != localObject1.length)
    {
      localObject2 = localObject1[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.Signature.");
      localStringBuilder.append(paramAlgorithmIdentifier.getAlgorithm().getId());
      localObject2 = ((Provider)localObject2).getProperty(localStringBuilder.toString());
      if (localObject2 != null) {
        return (String)localObject2;
      }
      i += 1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\X509SignatureUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */