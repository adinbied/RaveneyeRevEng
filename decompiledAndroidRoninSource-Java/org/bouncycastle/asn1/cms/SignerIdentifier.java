package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class SignerIdentifier
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Encodable id;
  
  public SignerIdentifier(ASN1OctetString paramASN1OctetString)
  {
    this.id = new DERTaggedObject(false, 0, paramASN1OctetString);
  }
  
  public SignerIdentifier(ASN1Primitive paramASN1Primitive)
  {
    this.id = paramASN1Primitive;
  }
  
  public SignerIdentifier(IssuerAndSerialNumber paramIssuerAndSerialNumber)
  {
    this.id = paramIssuerAndSerialNumber;
  }
  
  public static SignerIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof SignerIdentifier)))
    {
      if ((paramObject instanceof IssuerAndSerialNumber)) {
        return new SignerIdentifier((IssuerAndSerialNumber)paramObject);
      }
      if ((paramObject instanceof ASN1OctetString)) {
        return new SignerIdentifier((ASN1OctetString)paramObject);
      }
      if ((paramObject instanceof ASN1Primitive)) {
        return new SignerIdentifier((ASN1Primitive)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Illegal object in SignerIdentifier: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (SignerIdentifier)paramObject;
  }
  
  public ASN1Encodable getId()
  {
    ASN1Encodable localASN1Encodable = this.id;
    Object localObject = localASN1Encodable;
    if ((localASN1Encodable instanceof ASN1TaggedObject)) {
      localObject = ASN1OctetString.getInstance((ASN1TaggedObject)localASN1Encodable, false);
    }
    return (ASN1Encodable)localObject;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\SignerIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */