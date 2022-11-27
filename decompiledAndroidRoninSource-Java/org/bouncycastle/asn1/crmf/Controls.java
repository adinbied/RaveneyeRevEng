package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class Controls
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private Controls(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public Controls(AttributeTypeAndValue paramAttributeTypeAndValue)
  {
    this.content = new DERSequence(paramAttributeTypeAndValue);
  }
  
  public Controls(AttributeTypeAndValue[] paramArrayOfAttributeTypeAndValue)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfAttributeTypeAndValue.length)
    {
      localASN1EncodableVector.add(paramArrayOfAttributeTypeAndValue[i]);
      i += 1;
    }
    this.content = new DERSequence(localASN1EncodableVector);
  }
  
  public static Controls getInstance(Object paramObject)
  {
    if ((paramObject instanceof Controls)) {
      return (Controls)paramObject;
    }
    if (paramObject != null) {
      return new Controls(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public AttributeTypeAndValue[] toAttributeTypeAndValueArray()
  {
    int j = this.content.size();
    AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = new AttributeTypeAndValue[j];
    int i = 0;
    while (i != j)
    {
      arrayOfAttributeTypeAndValue[i] = AttributeTypeAndValue.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttributeTypeAndValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\Controls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */