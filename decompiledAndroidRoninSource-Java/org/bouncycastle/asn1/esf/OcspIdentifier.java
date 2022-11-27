package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ocsp.ResponderID;

public class OcspIdentifier
  extends ASN1Object
{
  private ResponderID ocspResponderID;
  private ASN1GeneralizedTime producedAt;
  
  private OcspIdentifier(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.ocspResponderID = ResponderID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.producedAt = ((ASN1GeneralizedTime)paramASN1Sequence.getObjectAt(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public OcspIdentifier(ResponderID paramResponderID, ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    this.ocspResponderID = paramResponderID;
    this.producedAt = paramASN1GeneralizedTime;
  }
  
  public static OcspIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof OcspIdentifier)) {
      return (OcspIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new OcspIdentifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ResponderID getOcspResponderID()
  {
    return this.ocspResponderID;
  }
  
  public ASN1GeneralizedTime getProducedAt()
  {
    return this.producedAt;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.ocspResponderID);
    localASN1EncodableVector.add(this.producedAt);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OcspIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */