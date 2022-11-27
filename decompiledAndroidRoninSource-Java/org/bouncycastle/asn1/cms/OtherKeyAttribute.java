package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OtherKeyAttribute
  extends ASN1Object
{
  private ASN1Encodable keyAttr;
  private ASN1ObjectIdentifier keyAttrId;
  
  public OtherKeyAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.keyAttrId = paramASN1ObjectIdentifier;
    this.keyAttr = paramASN1Encodable;
  }
  
  public OtherKeyAttribute(ASN1Sequence paramASN1Sequence)
  {
    this.keyAttrId = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    this.keyAttr = paramASN1Sequence.getObjectAt(1);
  }
  
  public static OtherKeyAttribute getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherKeyAttribute)) {
      return (OtherKeyAttribute)paramObject;
    }
    if (paramObject != null) {
      return new OtherKeyAttribute(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Encodable getKeyAttr()
  {
    return this.keyAttr;
  }
  
  public ASN1ObjectIdentifier getKeyAttrId()
  {
    return this.keyAttrId;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyAttrId);
    localASN1EncodableVector.add(this.keyAttr);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OtherKeyAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */