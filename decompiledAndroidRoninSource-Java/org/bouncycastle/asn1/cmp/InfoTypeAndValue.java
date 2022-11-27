package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class InfoTypeAndValue
  extends ASN1Object
{
  private ASN1ObjectIdentifier infoType;
  private ASN1Encodable infoValue;
  
  public InfoTypeAndValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.infoType = paramASN1ObjectIdentifier;
    this.infoValue = null;
  }
  
  public InfoTypeAndValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.infoType = paramASN1ObjectIdentifier;
    this.infoValue = paramASN1Encodable;
  }
  
  private InfoTypeAndValue(ASN1Sequence paramASN1Sequence)
  {
    this.infoType = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.infoValue = paramASN1Sequence.getObjectAt(1);
    }
  }
  
  public static InfoTypeAndValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof InfoTypeAndValue)) {
      return (InfoTypeAndValue)paramObject;
    }
    if (paramObject != null) {
      return new InfoTypeAndValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getInfoType()
  {
    return this.infoType;
  }
  
  public ASN1Encodable getInfoValue()
  {
    return this.infoValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.infoType);
    ASN1Encodable localASN1Encodable = this.infoValue;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\InfoTypeAndValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */