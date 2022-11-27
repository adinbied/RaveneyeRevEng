package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class PrivateKeyUsagePeriod
  extends ASN1Object
{
  private ASN1GeneralizedTime _notAfter;
  private ASN1GeneralizedTime _notBefore;
  
  private PrivateKeyUsagePeriod(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.nextElement();
      if (localASN1TaggedObject.getTagNo() == 0) {
        this._notBefore = ASN1GeneralizedTime.getInstance(localASN1TaggedObject, false);
      } else if (localASN1TaggedObject.getTagNo() == 1) {
        this._notAfter = ASN1GeneralizedTime.getInstance(localASN1TaggedObject, false);
      }
    }
  }
  
  public static PrivateKeyUsagePeriod getInstance(Object paramObject)
  {
    if ((paramObject instanceof PrivateKeyUsagePeriod)) {
      return (PrivateKeyUsagePeriod)paramObject;
    }
    if (paramObject != null) {
      return new PrivateKeyUsagePeriod(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1GeneralizedTime getNotAfter()
  {
    return this._notAfter;
  }
  
  public ASN1GeneralizedTime getNotBefore()
  {
    return this._notBefore;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ASN1GeneralizedTime localASN1GeneralizedTime = this._notBefore;
    if (localASN1GeneralizedTime != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1GeneralizedTime));
    }
    localASN1GeneralizedTime = this._notAfter;
    if (localASN1GeneralizedTime != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localASN1GeneralizedTime));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PrivateKeyUsagePeriod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */