package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jcajce.util.AlgorithmParametersUtils;

class CMSUtils
{
  private static final Set ecAlgs;
  private static final Set mqvAlgs = new HashSet();
  
  static
  {
    ecAlgs = new HashSet();
    mqvAlgs.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
    mqvAlgs.add(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
    mqvAlgs.add(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
    mqvAlgs.add(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
    mqvAlgs.add(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
    ecAlgs.add(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
    ecAlgs.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
    ecAlgs.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
  }
  
  static EnvelopedDataHelper createContentHelper(String paramString)
  {
    if (paramString != null) {
      return new EnvelopedDataHelper(new NamedJcaJceExtHelper(paramString));
    }
    return new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  }
  
  static EnvelopedDataHelper createContentHelper(Provider paramProvider)
  {
    if (paramProvider != null) {
      return new EnvelopedDataHelper(new ProviderJcaJceExtHelper(paramProvider));
    }
    return new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
  }
  
  static ASN1Encodable extractParameters(AlgorithmParameters paramAlgorithmParameters)
    throws CMSException
  {
    try
    {
      paramAlgorithmParameters = AlgorithmParametersUtils.extractParameters(paramAlgorithmParameters);
      return paramAlgorithmParameters;
    }
    catch (IOException paramAlgorithmParameters)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot extract parameters: ");
      localStringBuilder.append(paramAlgorithmParameters.getMessage());
      throw new CMSException(localStringBuilder.toString(), paramAlgorithmParameters);
    }
  }
  
  static IssuerAndSerialNumber getIssuerAndSerialNumber(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    return new IssuerAndSerialNumber(Certificate.getInstance(paramX509Certificate.getEncoded()).getIssuer(), paramX509Certificate.getSerialNumber());
  }
  
  static byte[] getSubjectKeyId(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = paramX509Certificate.getExtensionValue(Extension.subjectKeyIdentifier.getId());
    if (paramX509Certificate != null) {
      return ASN1OctetString.getInstance(ASN1OctetString.getInstance(paramX509Certificate).getOctets()).getOctets();
    }
    return null;
  }
  
  static boolean isEC(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return ecAlgs.contains(paramASN1ObjectIdentifier);
  }
  
  static boolean isMQV(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return mqvAlgs.contains(paramASN1ObjectIdentifier);
  }
  
  static boolean isRFC2631(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_alg_ESDH)) || (paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.id_alg_SSDH));
  }
  
  static void loadParameters(AlgorithmParameters paramAlgorithmParameters, ASN1Encodable paramASN1Encodable)
    throws CMSException
  {
    try
    {
      AlgorithmParametersUtils.loadParameters(paramAlgorithmParameters, paramASN1Encodable);
      return;
    }
    catch (IOException paramAlgorithmParameters)
    {
      throw new CMSException("error encoding algorithm parameters.", paramAlgorithmParameters);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\CMSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */