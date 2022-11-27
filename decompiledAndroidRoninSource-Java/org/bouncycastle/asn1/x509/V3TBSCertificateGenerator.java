package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class V3TBSCertificateGenerator
{
  private boolean altNamePresentAndCritical;
  Time endDate;
  Extensions extensions;
  X500Name issuer;
  private DERBitString issuerUniqueID;
  ASN1Integer serialNumber;
  AlgorithmIdentifier signature;
  Time startDate;
  X500Name subject;
  SubjectPublicKeyInfo subjectPublicKeyInfo;
  private DERBitString subjectUniqueID;
  DERTaggedObject version = new DERTaggedObject(true, 0, new ASN1Integer(2L));
  
  public TBSCertificate generateTBSCertificate()
  {
    if ((this.serialNumber != null) && (this.signature != null) && (this.issuer != null) && (this.startDate != null) && (this.endDate != null) && ((this.subject != null) || (this.altNamePresentAndCritical)) && (this.subjectPublicKeyInfo != null))
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(this.version);
      localASN1EncodableVector.add(this.serialNumber);
      localASN1EncodableVector.add(this.signature);
      localASN1EncodableVector.add(this.issuer);
      Object localObject = new ASN1EncodableVector();
      ((ASN1EncodableVector)localObject).add(this.startDate);
      ((ASN1EncodableVector)localObject).add(this.endDate);
      localASN1EncodableVector.add(new DERSequence((ASN1EncodableVector)localObject));
      localObject = this.subject;
      if (localObject == null) {
        localObject = new DERSequence();
      }
      localASN1EncodableVector.add((ASN1Encodable)localObject);
      localASN1EncodableVector.add(this.subjectPublicKeyInfo);
      localObject = this.issuerUniqueID;
      if (localObject != null) {
        localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
      }
      localObject = this.subjectUniqueID;
      if (localObject != null) {
        localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
      }
      localObject = this.extensions;
      if (localObject != null) {
        localASN1EncodableVector.add(new DERTaggedObject(true, 3, (ASN1Encodable)localObject));
      }
      return TBSCertificate.getInstance(new DERSequence(localASN1EncodableVector));
    }
    throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
  }
  
  public void setEndDate(ASN1UTCTime paramASN1UTCTime)
  {
    this.endDate = new Time(paramASN1UTCTime);
  }
  
  public void setEndDate(Time paramTime)
  {
    this.endDate = paramTime;
  }
  
  public void setExtensions(Extensions paramExtensions)
  {
    this.extensions = paramExtensions;
    if (paramExtensions != null)
    {
      paramExtensions = paramExtensions.getExtension(Extension.subjectAlternativeName);
      if ((paramExtensions != null) && (paramExtensions.isCritical())) {
        this.altNamePresentAndCritical = true;
      }
    }
  }
  
  public void setExtensions(X509Extensions paramX509Extensions)
  {
    setExtensions(Extensions.getInstance(paramX509Extensions));
  }
  
  public void setIssuer(X500Name paramX500Name)
  {
    this.issuer = paramX500Name;
  }
  
  public void setIssuer(X509Name paramX509Name)
  {
    this.issuer = X500Name.getInstance(paramX509Name);
  }
  
  public void setIssuerUniqueID(DERBitString paramDERBitString)
  {
    this.issuerUniqueID = paramDERBitString;
  }
  
  public void setSerialNumber(ASN1Integer paramASN1Integer)
  {
    this.serialNumber = paramASN1Integer;
  }
  
  public void setSignature(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.signature = paramAlgorithmIdentifier;
  }
  
  public void setStartDate(ASN1UTCTime paramASN1UTCTime)
  {
    this.startDate = new Time(paramASN1UTCTime);
  }
  
  public void setStartDate(Time paramTime)
  {
    this.startDate = paramTime;
  }
  
  public void setSubject(X500Name paramX500Name)
  {
    this.subject = paramX500Name;
  }
  
  public void setSubject(X509Name paramX509Name)
  {
    this.subject = X500Name.getInstance(paramX509Name.toASN1Primitive());
  }
  
  public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.subjectPublicKeyInfo = paramSubjectPublicKeyInfo;
  }
  
  public void setSubjectUniqueID(DERBitString paramDERBitString)
  {
    this.subjectUniqueID = paramDERBitString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\V3TBSCertificateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */