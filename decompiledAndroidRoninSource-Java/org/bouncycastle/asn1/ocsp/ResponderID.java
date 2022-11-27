package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;

public class ResponderID
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Encodable value;
  
  public ResponderID(ASN1OctetString paramASN1OctetString)
  {
    this.value = paramASN1OctetString;
  }
  
  public ResponderID(X500Name paramX500Name)
  {
    this.value = paramX500Name;
  }
  
  public static ResponderID getInstance(Object paramObject)
  {
    if ((paramObject instanceof ResponderID)) {
      return (ResponderID)paramObject;
    }
    if ((paramObject instanceof DEROctetString)) {
      return new ResponderID((DEROctetString)paramObject);
    }
    if ((paramObject instanceof ASN1TaggedObject))
    {
      paramObject = (ASN1TaggedObject)paramObject;
      if (((ASN1TaggedObject)paramObject).getTagNo() == 1) {
        return new ResponderID(X500Name.getInstance((ASN1TaggedObject)paramObject, true));
      }
      return new ResponderID(ASN1OctetString.getInstance((ASN1TaggedObject)paramObject, true));
    }
    return new ResponderID(X500Name.getInstance(paramObject));
  }
  
  public static ResponderID getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }
  
  public byte[] getKeyHash()
  {
    ASN1Encodable localASN1Encodable = this.value;
    if ((localASN1Encodable instanceof ASN1OctetString)) {
      return ((ASN1OctetString)localASN1Encodable).getOctets();
    }
    return null;
  }
  
  public X500Name getName()
  {
    ASN1Encodable localASN1Encodable = this.value;
    if ((localASN1Encodable instanceof ASN1OctetString)) {
      return null;
    }
    return X500Name.getInstance(localASN1Encodable);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1Encodable localASN1Encodable = this.value;
    if ((localASN1Encodable instanceof ASN1OctetString)) {
      return new DERTaggedObject(true, 2, localASN1Encodable);
    }
    return new DERTaggedObject(true, 1, localASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\ResponderID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */