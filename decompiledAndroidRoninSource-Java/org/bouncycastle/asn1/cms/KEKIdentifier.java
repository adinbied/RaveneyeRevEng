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

public class KEKIdentifier
  extends ASN1Object
{
  private ASN1GeneralizedTime date;
  private ASN1OctetString keyIdentifier;
  private OtherKeyAttribute other;
  
  private KEKIdentifier(ASN1Sequence paramASN1Sequence)
  {
    this.keyIdentifier = ((ASN1OctetString)paramASN1Sequence.getObjectAt(0));
    int i = paramASN1Sequence.size();
    if (i != 1)
    {
      if (i != 2) {
        if (i == 3)
        {
          this.date = ((ASN1GeneralizedTime)paramASN1Sequence.getObjectAt(1));
          paramASN1Sequence = paramASN1Sequence.getObjectAt(2);
        }
      }
      boolean bool;
      ASN1Encodable localASN1Encodable;
      do
      {
        this.other = OtherKeyAttribute.getInstance(paramASN1Sequence);
        return;
        throw new IllegalArgumentException("Invalid KEKIdentifier");
        bool = paramASN1Sequence.getObjectAt(1) instanceof ASN1GeneralizedTime;
        localASN1Encodable = paramASN1Sequence.getObjectAt(1);
        paramASN1Sequence = localASN1Encodable;
      } while (!bool);
      this.date = ((ASN1GeneralizedTime)localASN1Encodable);
    }
  }
  
  public KEKIdentifier(byte[] paramArrayOfByte, ASN1GeneralizedTime paramASN1GeneralizedTime, OtherKeyAttribute paramOtherKeyAttribute)
  {
    this.keyIdentifier = new DEROctetString(paramArrayOfByte);
    this.date = paramASN1GeneralizedTime;
    this.other = paramOtherKeyAttribute;
  }
  
  public static KEKIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof KEKIdentifier)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new KEKIdentifier((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid KEKIdentifier: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (KEKIdentifier)paramObject;
  }
  
  public static KEKIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1GeneralizedTime getDate()
  {
    return this.date;
  }
  
  public ASN1OctetString getKeyIdentifier()
  {
    return this.keyIdentifier;
  }
  
  public OtherKeyAttribute getOther()
  {
    return this.other;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyIdentifier);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\KEKIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */