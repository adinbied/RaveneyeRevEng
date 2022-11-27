package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue
  extends ASN1Object
{
  private ASN1ObjectIdentifier type;
  private ASN1Encodable value;
  
  public AttributeTypeAndValue(String paramString, ASN1Encodable paramASN1Encodable)
  {
    this(new ASN1ObjectIdentifier(paramString), paramASN1Encodable);
  }
  
  public AttributeTypeAndValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.type = paramASN1ObjectIdentifier;
    this.value = paramASN1Encodable;
  }
  
  private AttributeTypeAndValue(ASN1Sequence paramASN1Sequence)
  {
    this.type = ((ASN1ObjectIdentifier)paramASN1Sequence.getObjectAt(0));
    this.value = paramASN1Sequence.getObjectAt(1);
  }
  
  public static AttributeTypeAndValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof AttributeTypeAndValue)) {
      return (AttributeTypeAndValue)paramObject;
    }
    if (paramObject != null) {
      return new AttributeTypeAndValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getType()
  {
    return this.type;
  }
  
  public ASN1Encodable getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.type);
    localASN1EncodableVector.add(this.value);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\AttributeTypeAndValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */