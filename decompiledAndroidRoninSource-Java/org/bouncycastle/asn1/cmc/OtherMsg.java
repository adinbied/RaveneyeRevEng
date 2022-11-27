package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class OtherMsg
  extends ASN1Object
{
  private final BodyPartID bodyPartID;
  private final ASN1ObjectIdentifier otherMsgType;
  private final ASN1Encodable otherMsgValue;
  
  private OtherMsg(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.bodyPartID = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.otherMsgType = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.otherMsgValue = paramASN1Sequence.getObjectAt(2);
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public OtherMsg(BodyPartID paramBodyPartID, ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.bodyPartID = paramBodyPartID;
    this.otherMsgType = paramASN1ObjectIdentifier;
    this.otherMsgValue = paramASN1Encodable;
  }
  
  public static OtherMsg getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherMsg)) {
      return (OtherMsg)paramObject;
    }
    if (paramObject != null) {
      return new OtherMsg(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OtherMsg getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BodyPartID getBodyPartID()
  {
    return this.bodyPartID;
  }
  
  public ASN1ObjectIdentifier getOtherMsgType()
  {
    return this.otherMsgType;
  }
  
  public ASN1Encodable getOtherMsgValue()
  {
    return this.otherMsgValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bodyPartID);
    localASN1EncodableVector.add(this.otherMsgType);
    localASN1EncodableVector.add(this.otherMsgValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\OtherMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */