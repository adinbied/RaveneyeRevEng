package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class PKIResponse
  extends ASN1Object
{
  private final ASN1Sequence cmsSequence;
  private final ASN1Sequence controlSequence;
  private final ASN1Sequence otherMsgSequence;
  
  private PKIResponse(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.controlSequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(0));
      this.cmsSequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      this.otherMsgSequence = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public static PKIResponse getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIResponse)) {
      return (PKIResponse)paramObject;
    }
    if (paramObject != null) {
      return new PKIResponse(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static PKIResponse getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Sequence getCmsSequence()
  {
    return this.cmsSequence;
  }
  
  public ASN1Sequence getControlSequence()
  {
    return this.controlSequence;
  }
  
  public ASN1Sequence getOtherMsgSequence()
  {
    return this.otherMsgSequence;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.controlSequence);
    localASN1EncodableVector.add(this.cmsSequence);
    localASN1EncodableVector.add(this.otherMsgSequence);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\PKIResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */