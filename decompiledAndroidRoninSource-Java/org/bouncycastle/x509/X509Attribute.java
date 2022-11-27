package org.bouncycastle.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

public class X509Attribute
  extends ASN1Object
{
  Attribute attr;
  
  public X509Attribute(String paramString, ASN1Encodable paramASN1Encodable)
  {
    this.attr = new Attribute(new ASN1ObjectIdentifier(paramString), new DERSet(paramASN1Encodable));
  }
  
  public X509Attribute(String paramString, ASN1EncodableVector paramASN1EncodableVector)
  {
    this.attr = new Attribute(new ASN1ObjectIdentifier(paramString), new DERSet(paramASN1EncodableVector));
  }
  
  X509Attribute(ASN1Encodable paramASN1Encodable)
  {
    this.attr = Attribute.getInstance(paramASN1Encodable);
  }
  
  public String getOID()
  {
    return this.attr.getAttrType().getId();
  }
  
  public ASN1Encodable[] getValues()
  {
    ASN1Set localASN1Set = this.attr.getAttrValues();
    ASN1Encodable[] arrayOfASN1Encodable = new ASN1Encodable[localASN1Set.size()];
    int i = 0;
    while (i != localASN1Set.size())
    {
      arrayOfASN1Encodable[i] = localASN1Set.getObjectAt(i);
      i += 1;
    }
    return arrayOfASN1Encodable;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.attr.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */