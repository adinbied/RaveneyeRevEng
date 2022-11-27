package org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V3TBSCertificateGenerator;
import org.bouncycastle.operator.ContentSigner;

public class X509v3CertificateBuilder
{
  private ExtensionsGenerator extGenerator;
  private V3TBSCertificateGenerator tbsGen;
  
  public X509v3CertificateBuilder(X500Name paramX500Name1, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, Locale paramLocale, X500Name paramX500Name2, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this(paramX500Name1, paramBigInteger, new Time(paramDate1, paramLocale), new Time(paramDate2, paramLocale), paramX500Name2, paramSubjectPublicKeyInfo);
  }
  
  public X509v3CertificateBuilder(X500Name paramX500Name1, BigInteger paramBigInteger, Date paramDate1, Date paramDate2, X500Name paramX500Name2, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this(paramX500Name1, paramBigInteger, new Time(paramDate1), new Time(paramDate2), paramX500Name2, paramSubjectPublicKeyInfo);
  }
  
  public X509v3CertificateBuilder(X500Name paramX500Name1, BigInteger paramBigInteger, Time paramTime1, Time paramTime2, X500Name paramX500Name2, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    V3TBSCertificateGenerator localV3TBSCertificateGenerator = new V3TBSCertificateGenerator();
    this.tbsGen = localV3TBSCertificateGenerator;
    localV3TBSCertificateGenerator.setSerialNumber(new ASN1Integer(paramBigInteger));
    this.tbsGen.setIssuer(paramX500Name1);
    this.tbsGen.setStartDate(paramTime1);
    this.tbsGen.setEndDate(paramTime2);
    this.tbsGen.setSubject(paramX500Name2);
    this.tbsGen.setSubjectPublicKeyInfo(paramSubjectPublicKeyInfo);
    this.extGenerator = new ExtensionsGenerator();
  }
  
  public X509v3CertificateBuilder addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws CertIOException
  {
    CertUtils.addExtension(this.extGenerator, paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
    return this;
  }
  
  public X509v3CertificateBuilder addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
    throws CertIOException
  {
    this.extGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramArrayOfByte);
    return this;
  }
  
  public X509v3CertificateBuilder addExtension(Extension paramExtension)
    throws CertIOException
  {
    this.extGenerator.addExtension(paramExtension);
    return this;
  }
  
  public X509CertificateHolder build(ContentSigner paramContentSigner)
  {
    this.tbsGen.setSignature(paramContentSigner.getAlgorithmIdentifier());
    if (!this.extGenerator.isEmpty()) {
      this.tbsGen.setExtensions(this.extGenerator.generate());
    }
    return CertUtils.generateFullCert(paramContentSigner, this.tbsGen.generateTBSCertificate());
  }
  
  public X509v3CertificateBuilder copyAndAddExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, X509CertificateHolder paramX509CertificateHolder)
  {
    paramX509CertificateHolder = paramX509CertificateHolder.toASN1Structure().getTBSCertificate().getExtensions().getExtension(paramASN1ObjectIdentifier);
    if (paramX509CertificateHolder != null)
    {
      this.extGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramX509CertificateHolder.getExtnValue().getOctets());
      return this;
    }
    paramX509CertificateHolder = new StringBuilder();
    paramX509CertificateHolder.append("extension ");
    paramX509CertificateHolder.append(paramASN1ObjectIdentifier);
    paramX509CertificateHolder.append(" not present");
    throw new NullPointerException(paramX509CertificateHolder.toString());
  }
  
  public X509v3CertificateBuilder setIssuerUniqueID(boolean[] paramArrayOfBoolean)
  {
    this.tbsGen.setIssuerUniqueID(CertUtils.booleanToBitString(paramArrayOfBoolean));
    return this;
  }
  
  public X509v3CertificateBuilder setSubjectUniqueID(boolean[] paramArrayOfBoolean)
  {
    this.tbsGen.setSubjectUniqueID(CertUtils.booleanToBitString(paramArrayOfBoolean));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\X509v3CertificateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */