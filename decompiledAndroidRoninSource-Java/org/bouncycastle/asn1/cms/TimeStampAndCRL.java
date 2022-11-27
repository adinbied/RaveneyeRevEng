package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.CertificateList;

public class TimeStampAndCRL
  extends ASN1Object
{
  private CertificateList crl;
  private ContentInfo timeStamp;
  
  private TimeStampAndCRL(ASN1Sequence paramASN1Sequence)
  {
    this.timeStamp = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2) {
      this.crl = CertificateList.getInstance(paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public TimeStampAndCRL(ContentInfo paramContentInfo)
  {
    this.timeStamp = paramContentInfo;
  }
  
  public static TimeStampAndCRL getInstance(Object paramObject)
  {
    if ((paramObject instanceof TimeStampAndCRL)) {
      return (TimeStampAndCRL)paramObject;
    }
    if (paramObject != null) {
      return new TimeStampAndCRL(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertificateList getCRL()
  {
    return this.crl;
  }
  
  public CertificateList getCertificateList()
  {
    return this.crl;
  }
  
  public ContentInfo getTimeStampToken()
  {
    return this.timeStamp;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.timeStamp);
    CertificateList localCertificateList = this.crl;
    if (localCertificateList != null) {
      localASN1EncodableVector.add(localCertificateList);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\TimeStampAndCRL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */