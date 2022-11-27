package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;

public class OriginatorIdentifierOrKey
  extends ASN1Object
  implements ASN1Choice
{
  private ASN1Encodable id;
  
  public OriginatorIdentifierOrKey(ASN1OctetString paramASN1OctetString)
  {
    this(new SubjectKeyIdentifier(paramASN1OctetString.getOctets()));
  }
  
  public OriginatorIdentifierOrKey(ASN1Primitive paramASN1Primitive)
  {
    this.id = paramASN1Primitive;
  }
  
  public OriginatorIdentifierOrKey(IssuerAndSerialNumber paramIssuerAndSerialNumber)
  {
    this.id = paramIssuerAndSerialNumber;
  }
  
  public OriginatorIdentifierOrKey(OriginatorPublicKey paramOriginatorPublicKey)
  {
    this.id = new DERTaggedObject(false, 1, paramOriginatorPublicKey);
  }
  
  public OriginatorIdentifierOrKey(SubjectKeyIdentifier paramSubjectKeyIdentifier)
  {
    this.id = new DERTaggedObject(false, 0, paramSubjectKeyIdentifier);
  }
  
  public static OriginatorIdentifierOrKey getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof OriginatorIdentifierOrKey)))
    {
      if ((!(paramObject instanceof IssuerAndSerialNumber)) && (!(paramObject instanceof ASN1Sequence)))
      {
        if ((paramObject instanceof ASN1TaggedObject))
        {
          localObject = (ASN1TaggedObject)paramObject;
          if (((ASN1TaggedObject)localObject).getTagNo() == 0) {
            return new OriginatorIdentifierOrKey(SubjectKeyIdentifier.getInstance((ASN1TaggedObject)localObject, false));
          }
          if (((ASN1TaggedObject)localObject).getTagNo() == 1) {
            return new OriginatorIdentifierOrKey(OriginatorPublicKey.getInstance((ASN1TaggedObject)localObject, false));
          }
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid OriginatorIdentifierOrKey: ");
        ((StringBuilder)localObject).append(paramObject.getClass().getName());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      return new OriginatorIdentifierOrKey(IssuerAndSerialNumber.getInstance(paramObject));
    }
    return (OriginatorIdentifierOrKey)paramObject;
  }
  
  public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getInstance(paramASN1TaggedObject.getObject());
    }
    throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
  }
  
  public ASN1Encodable getId()
  {
    return this.id;
  }
  
  public IssuerAndSerialNumber getIssuerAndSerialNumber()
  {
    ASN1Encodable localASN1Encodable = this.id;
    if ((localASN1Encodable instanceof IssuerAndSerialNumber)) {
      return (IssuerAndSerialNumber)localASN1Encodable;
    }
    return null;
  }
  
  public OriginatorPublicKey getOriginatorKey()
  {
    ASN1Encodable localASN1Encodable = this.id;
    if (((localASN1Encodable instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)localASN1Encodable).getTagNo() == 1)) {
      return OriginatorPublicKey.getInstance((ASN1TaggedObject)this.id, false);
    }
    return null;
  }
  
  public SubjectKeyIdentifier getSubjectKeyIdentifier()
  {
    ASN1Encodable localASN1Encodable = this.id;
    if (((localASN1Encodable instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)localASN1Encodable).getTagNo() == 0)) {
      return SubjectKeyIdentifier.getInstance((ASN1TaggedObject)this.id, false);
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.id.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OriginatorIdentifierOrKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */