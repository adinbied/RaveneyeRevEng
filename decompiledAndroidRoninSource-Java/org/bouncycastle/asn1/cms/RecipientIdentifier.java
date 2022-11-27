package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class RecipientIdentifier
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Encodable id;
  
  public RecipientIdentifier(ASN1OctetString paramASN1OctetString)
  {
    this.id = new DERTaggedObject(false, 0, paramASN1OctetString);
  }
  
  public RecipientIdentifier(ASN1Primitive paramASN1Primitive)
  {
    this.id = paramASN1Primitive;
  }
  
  public RecipientIdentifier(IssuerAndSerialNumber paramIssuerAndSerialNumber)
  {
    this.id = paramIssuerAndSerialNumber;
  }
  
  public static RecipientIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof RecipientIdentifier)))
    {
      if ((paramObject instanceof IssuerAndSerialNumber)) {
        return new RecipientIdentifier((IssuerAndSerialNumber)paramObject);
      }
      if ((paramObject instanceof ASN1OctetString)) {
        return new RecipientIdentifier((ASN1OctetString)paramObject);
      }
      if ((paramObject instanceof ASN1Primitive)) {
        return new RecipientIdentifier((ASN1Primitive)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Illegal object in RecipientIdentifier: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (RecipientIdentifier)paramObject;
  }
  
  public ASN1Encodable getId()
  {
    ASN1Encodable localASN1Encodable = this.id;
    if ((localASN1Encodable instanceof ASN1TaggedObject)) {
      return ASN1OctetString.getInstance((ASN1TaggedObject)localASN1Encodable, false);
    }
    return IssuerAndSerialNumber.getInstance(localASN1Encodable);
  }
  
  public boolean isTagged()
  {
    return this.id instanceof ASN1TaggedObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.id.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\RecipientIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */