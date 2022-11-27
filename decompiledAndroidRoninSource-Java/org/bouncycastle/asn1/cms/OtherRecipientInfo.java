package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherRecipientInfo
  extends ASN1Object
{
  private ASN1ObjectIdentifier oriType;
  private ASN1Encodable oriValue;
  
  public OtherRecipientInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.oriType = paramASN1ObjectIdentifier;
    this.oriValue = paramASN1Encodable;
  }
  
  public OtherRecipientInfo(ASN1Sequence paramASN1Sequence)
  {
    this.oriType = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.oriValue = paramASN1Sequence.getObjectAt(1);
  }
  
  public static OtherRecipientInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherRecipientInfo)) {
      return (OtherRecipientInfo)paramObject;
    }
    if (paramObject != null) {
      return new OtherRecipientInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OtherRecipientInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1ObjectIdentifier getType()
  {
    return this.oriType;
  }
  
  public ASN1Encodable getValue()
  {
    return this.oriValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.oriType);
    localASN1EncodableVector.add(this.oriValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OtherRecipientInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */