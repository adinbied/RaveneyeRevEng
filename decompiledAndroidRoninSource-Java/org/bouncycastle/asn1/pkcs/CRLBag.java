package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CRLBag
  extends ASN1Object
{
  private ASN1ObjectIdentifier crlId;
  private ASN1Encodable crlValue;
  
  public CRLBag(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.crlId = paramASN1ObjectIdentifier;
    this.crlValue = paramASN1Encodable;
  }
  
  private CRLBag(ASN1Sequence paramASN1Sequence)
  {
    this.crlId = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    this.crlValue = ((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1)).getObject();
  }
  
  public static CRLBag getInstance(Object paramObject)
  {
    if ((paramObject instanceof CRLBag)) {
      return (CRLBag)paramObject;
    }
    if (paramObject != null) {
      return new CRLBag(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getCrlId()
  {
    return this.crlId;
  }
  
  public ASN1Encodable getCrlValue()
  {
    return this.crlValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.crlId);
    localASN1EncodableVector.add(new DERTaggedObject(0, this.crlValue));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\CRLBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */