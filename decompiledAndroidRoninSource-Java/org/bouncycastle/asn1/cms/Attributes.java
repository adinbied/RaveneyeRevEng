package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DLSet;

public class Attributes
  extends ASN1Object
{
  private ASN1Set attributes;
  
  public Attributes(ASN1EncodableVector paramASN1EncodableVector)
  {
    this.attributes = new DLSet(paramASN1EncodableVector);
  }
  
  private Attributes(ASN1Set paramASN1Set)
  {
    this.attributes = paramASN1Set;
  }
  
  public static Attributes getInstance(Object paramObject)
  {
    if ((paramObject instanceof Attributes)) {
      return (Attributes)paramObject;
    }
    if (paramObject != null) {
      return new Attributes(ASN1Set.getInstance(paramObject));
    }
    return null;
  }
  
  public Attribute[] getAttributes()
  {
    int j = this.attributes.size();
    Attribute[] arrayOfAttribute = new Attribute[j];
    int i = 0;
    while (i != j)
    {
      arrayOfAttribute[i] = Attribute.getInstance(this.attributes.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttribute;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.attributes;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */