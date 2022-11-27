package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class V1TBSCertificateGenerator
{
  Time endDate;
  X500Name issuer;
  ASN1Integer serialNumber;
  AlgorithmIdentifier signature;
  Time startDate;
  X500Name subject;
  SubjectPublicKeyInfo subjectPublicKeyInfo;
  DERTaggedObject version = new DERTaggedObject(true, 0, new ASN1Integer(0L));
  
  public TBSCertificate generateTBSCertificate()
  {
    if ((this.serialNumber != null) && (this.signature != null) && (this.issuer != null) && (this.startDate != null) && (this.endDate != null) && (this.subject != null) && (this.subjectPublicKeyInfo != null))
    {
      ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
      localASN1EncodableVector1.add(this.serialNumber);
      localASN1EncodableVector1.add(this.signature);
      localASN1EncodableVector1.add(this.issuer);
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(this.startDate);
      localASN1EncodableVector2.add(this.endDate);
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
      localASN1EncodableVector1.add(this.subject);
      localASN1EncodableVector1.add(this.subjectPublicKeyInfo);
      return TBSCertificate.getInstance(new DERSequence(localASN1EncodableVector1));
    }
    throw new IllegalStateException("not all mandatory fields set in V1 TBScertificate generator");
  }
  
  public void setEndDate(ASN1UTCTime paramASN1UTCTime)
  {
    this.endDate = new Time(paramASN1UTCTime);
  }
  
  public void setEndDate(Time paramTime)
  {
    this.endDate = paramTime;
  }
  
  public void setIssuer(X500Name paramX500Name)
  {
    this.issuer = paramX500Name;
  }
  
  public void setIssuer(X509Name paramX509Name)
  {
    this.issuer = X500Name.getInstance(paramX509Name.toASN1Primitive());
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\V1TBSCertificateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */