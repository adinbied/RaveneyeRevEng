package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class RecipientKeyIdentifier
  extends ASN1Object
{
  private ASN1GeneralizedTime date;
  private OtherKeyAttribute other;
  private ASN1OctetString subjectKeyIdentifier;
  
  public RecipientKeyIdentifier(ASN1OctetString paramASN1OctetString, ASN1GeneralizedTime paramASN1GeneralizedTime, OtherKeyAttribute paramOtherKeyAttribute)
  {
    this.subjectKeyIdentifier = paramASN1OctetString;
    this.date = paramASN1GeneralizedTime;
    this.other = paramOtherKeyAttribute;
  }
  
  public RecipientKeyIdentifier(ASN1Sequence paramASN1Sequence)
  {
    this.subjectKeyIdentifier = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(0));
    int i = paramASN1Sequence.size();
    if (i != 1)
    {
      if (i != 2) {
        if (i == 3) {
          this.date = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(1));
        }
      }
      while (!(paramASN1Sequence.getObjectAt(1) instanceof ASN1GeneralizedTime))
      {
        this.other = OtherKeyAttribute.getInstance(paramASN1Sequence.getObjectAt(2));
        return;
        throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
      }
      this.date = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public RecipientKeyIdentifier(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, null, null);
  }
  
  public RecipientKeyIdentifier(byte[] paramArrayOfByte, ASN1GeneralizedTime paramASN1GeneralizedTime, OtherKeyAttribute paramOtherKeyAttribute)
  {
    this.subjectKeyIdentifier = new DEROctetString(paramArrayOfByte);
    this.date = paramASN1GeneralizedTime;
    this.other = paramOtherKeyAttribute;
  }
  
  public static RecipientKeyIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof RecipientKeyIdentifier)) {
      return (RecipientKeyIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new RecipientKeyIdentifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static RecipientKeyIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1GeneralizedTime getDate()
  {
    return this.date;
  }
  
  public OtherKeyAttribute getOtherKeyAttribute()
  {
    return this.other;
  }
  
  public ASN1OctetString getSubjectKeyIdentifier()
  {
    return this.subjectKeyIdentifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.subjectKeyIdentifier);
    Object localObject = this.date;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.other;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\RecipientKeyIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */