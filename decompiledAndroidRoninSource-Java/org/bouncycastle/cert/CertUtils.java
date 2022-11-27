package org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.operator.ContentSigner;

class CertUtils
{
  private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
  private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
  
  static void addExtension(ExtensionsGenerator paramExtensionsGenerator, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws CertIOException
  {
    try
    {
      paramExtensionsGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
      return;
    }
    catch (IOException paramExtensionsGenerator)
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("cannot encode extension: ");
      paramASN1ObjectIdentifier.append(paramExtensionsGenerator.getMessage());
      throw new CertIOException(paramASN1ObjectIdentifier.toString(), paramExtensionsGenerator);
    }
  }
  
  static boolean[] bitStringToBoolean(DERBitString paramDERBitString)
  {
    if (paramDERBitString != null)
    {
      byte[] arrayOfByte = paramDERBitString.getBytes();
      int j = arrayOfByte.length * 8 - paramDERBitString.getPadBits();
      paramDERBitString = new boolean[j];
      int i = 0;
      while (i != j)
      {
        int k;
        if ((arrayOfByte[(i / 8)] & 128 >>> i % 8) != 0) {
          k = 1;
        } else {
          k = 0;
        }
        paramDERBitString[i] = k;
        i += 1;
      }
      return paramDERBitString;
    }
    return null;
  }
  
  static DERBitString booleanToBitString(boolean[] paramArrayOfBoolean)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfBoolean.length + 7) / 8];
    int i = 0;
    while (i != paramArrayOfBoolean.length)
    {
      int k = i / 8;
      int m = arrayOfByte[k];
      int j;
      if (paramArrayOfBoolean[i] != 0) {
        j = 1 << 7 - i % 8;
      } else {
        j = 0;
      }
      arrayOfByte[k] = ((byte)(m | j));
      i += 1;
    }
    i = paramArrayOfBoolean.length % 8;
    if (i == 0) {
      return new DERBitString(arrayOfByte);
    }
    return new DERBitString(arrayOfByte, 8 - i);
  }
  
  private static AttributeCertificate generateAttrStructure(AttributeCertificateInfo paramAttributeCertificateInfo, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramAttributeCertificateInfo);
    localASN1EncodableVector.add(paramAlgorithmIdentifier);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    return AttributeCertificate.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  private static CertificateList generateCRLStructure(TBSCertList paramTBSCertList, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramTBSCertList);
    localASN1EncodableVector.add(paramAlgorithmIdentifier);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    return CertificateList.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  static X509AttributeCertificateHolder generateFullAttrCert(ContentSigner paramContentSigner, AttributeCertificateInfo paramAttributeCertificateInfo)
  {
    try
    {
      paramContentSigner = new X509AttributeCertificateHolder(generateAttrStructure(paramAttributeCertificateInfo, paramContentSigner.getAlgorithmIdentifier(), generateSig(paramContentSigner, paramAttributeCertificateInfo)));
      return paramContentSigner;
    }
    catch (IOException paramContentSigner)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot produce attribute certificate signature");
  }
  
  static X509CRLHolder generateFullCRL(ContentSigner paramContentSigner, TBSCertList paramTBSCertList)
  {
    try
    {
      paramContentSigner = new X509CRLHolder(generateCRLStructure(paramTBSCertList, paramContentSigner.getAlgorithmIdentifier(), generateSig(paramContentSigner, paramTBSCertList)));
      return paramContentSigner;
    }
    catch (IOException paramContentSigner)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot produce certificate signature");
  }
  
  static X509CertificateHolder generateFullCert(ContentSigner paramContentSigner, TBSCertificate paramTBSCertificate)
  {
    try
    {
      paramContentSigner = new X509CertificateHolder(generateStructure(paramTBSCertificate, paramContentSigner.getAlgorithmIdentifier(), generateSig(paramContentSigner, paramTBSCertificate)));
      return paramContentSigner;
    }
    catch (IOException paramContentSigner)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot produce certificate signature");
  }
  
  private static byte[] generateSig(ContentSigner paramContentSigner, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    OutputStream localOutputStream = paramContentSigner.getOutputStream();
    new DEROutputStream(localOutputStream).writeObject(paramASN1Encodable);
    localOutputStream.close();
    return paramContentSigner.getSignature();
  }
  
  private static Certificate generateStructure(TBSCertificate paramTBSCertificate, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramTBSCertificate);
    localASN1EncodableVector.add(paramAlgorithmIdentifier);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    return Certificate.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  static Set getCriticalExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramExtensions.getCriticalExtensionOIDs())));
  }
  
  static List getExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_LIST;
    }
    return Collections.unmodifiableList(Arrays.asList(paramExtensions.getExtensionOIDs()));
  }
  
  static Set getNonCriticalExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramExtensions.getNonCriticalExtensionOIDs())));
  }
  
  static boolean isAlgIdEqual(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    if (!paramAlgorithmIdentifier1.getAlgorithm().equals(paramAlgorithmIdentifier2.getAlgorithm())) {
      return false;
    }
    if (paramAlgorithmIdentifier1.getParameters() == null) {
      return (paramAlgorithmIdentifier2.getParameters() == null) || (paramAlgorithmIdentifier2.getParameters().equals(DERNull.INSTANCE));
    }
    if (paramAlgorithmIdentifier2.getParameters() == null) {
      return (paramAlgorithmIdentifier1.getParameters() == null) || (paramAlgorithmIdentifier1.getParameters().equals(DERNull.INSTANCE));
    }
    return paramAlgorithmIdentifier1.getParameters().equals(paramAlgorithmIdentifier2.getParameters());
  }
  
  static ASN1Primitive parseNonEmptyASN1(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = ASN1Primitive.fromByteArray(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return paramArrayOfByte;
    }
    throw new IOException("no content found");
  }
  
  static Date recoverDate(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    try
    {
      paramASN1GeneralizedTime = paramASN1GeneralizedTime.getDate();
      return paramASN1GeneralizedTime;
    }
    catch (ParseException paramASN1GeneralizedTime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to recover date: ");
      localStringBuilder.append(paramASN1GeneralizedTime.getMessage());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\CertUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */