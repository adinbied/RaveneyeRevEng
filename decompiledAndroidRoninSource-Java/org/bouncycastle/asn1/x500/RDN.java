package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class RDN
  extends ASN1Object
{
  private ASN1Set values;
  
  public RDN(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramASN1ObjectIdentifier);
    localASN1EncodableVector.add(paramASN1Encodable);
    this.values = new DERSet(new DERSequence(localASN1EncodableVector));
  }
  
  private RDN(ASN1Set paramASN1Set)
  {
    this.values = paramASN1Set;
  }
  
  public RDN(AttributeTypeAndValue paramAttributeTypeAndValue)
  {
    this.values = new DERSet(paramAttributeTypeAndValue);
  }
  
  public RDN(AttributeTypeAndValue[] paramArrayOfAttributeTypeAndValue)
  {
    this.values = new DERSet(paramArrayOfAttributeTypeAndValue);
  }
  
  public static RDN getInstance(Object paramObject)
  {
    if ((paramObject instanceof RDN)) {
      return (RDN)paramObject;
    }
    if (paramObject != null) {
      return new RDN(ASN1Set.getInstance(paramObject));
    }
    return null;
  }
  
  public AttributeTypeAndValue getFirst()
  {
    if (this.values.size() == 0) {
      return null;
    }
    return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
  }
  
  public AttributeTypeAndValue[] getTypesAndValues()
  {
    int j = this.values.size();
    AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = new AttributeTypeAndValue[j];
    int i = 0;
    while (i != j)
    {
      arrayOfAttributeTypeAndValue[i] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttributeTypeAndValue;
  }
  
  public boolean isMultiValued()
  {
    return this.values.size() > 1;
  }
  
  public int size()
  {
    return this.values.size();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.values;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\RDN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */