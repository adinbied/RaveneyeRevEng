package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AttCertValidityPeriod
  extends ASN1Object
{
  ASN1GeneralizedTime notAfterTime;
  ASN1GeneralizedTime notBeforeTime;
  
  public AttCertValidityPeriod(ASN1GeneralizedTime paramASN1GeneralizedTime1, ASN1GeneralizedTime paramASN1GeneralizedTime2)
  {
    this.notBeforeTime = paramASN1GeneralizedTime1;
    this.notAfterTime = paramASN1GeneralizedTime2;
  }
  
  private AttCertValidityPeriod(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.notBeforeTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(0));
      this.notAfterTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static AttCertValidityPeriod getInstance(Object paramObject)
  {
    if ((paramObject instanceof AttCertValidityPeriod)) {
      return (AttCertValidityPeriod)paramObject;
    }
    if (paramObject != null) {
      return new AttCertValidityPeriod(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1GeneralizedTime getNotAfterTime()
  {
    return this.notAfterTime;
  }
  
  public ASN1GeneralizedTime getNotBeforeTime()
  {
    return this.notBeforeTime;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.notBeforeTime);
    localASN1EncodableVector.add(this.notAfterTime);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AttCertValidityPeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */