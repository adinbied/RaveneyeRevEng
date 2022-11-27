package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PKIData
  extends ASN1Object
{
  private final TaggedContentInfo[] cmsSequence;
  private final TaggedAttribute[] controlSequence;
  private final OtherMsg[] otherMsgSequence;
  private final TaggedRequest[] reqSequence;
  
  private PKIData(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 4)
    {
      int j = 0;
      Object localObject1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(0);
      this.controlSequence = new TaggedAttribute[((ASN1Sequence)localObject1).size()];
      int i = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = this.controlSequence;
        if (i >= localObject2.length) {
          break;
        }
        localObject2[i] = TaggedAttribute.getInstance(((ASN1Sequence)localObject1).getObjectAt(i));
        i += 1;
      }
      localObject1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(1);
      this.reqSequence = new TaggedRequest[((ASN1Sequence)localObject1).size()];
      i = 0;
      for (;;)
      {
        localObject2 = this.reqSequence;
        if (i >= localObject2.length) {
          break;
        }
        localObject2[i] = TaggedRequest.getInstance(((ASN1Sequence)localObject1).getObjectAt(i));
        i += 1;
      }
      localObject1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(2);
      this.cmsSequence = new TaggedContentInfo[((ASN1Sequence)localObject1).size()];
      i = 0;
      for (;;)
      {
        localObject2 = this.cmsSequence;
        if (i >= localObject2.length) {
          break;
        }
        localObject2[i] = TaggedContentInfo.getInstance(((ASN1Sequence)localObject1).getObjectAt(i));
        i += 1;
      }
      paramASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(3);
      this.otherMsgSequence = new OtherMsg[paramASN1Sequence.size()];
      i = j;
      for (;;)
      {
        localObject1 = this.otherMsgSequence;
        if (i >= localObject1.length) {
          break;
        }
        localObject1[i] = OtherMsg.getInstance(paramASN1Sequence.getObjectAt(i));
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("Sequence not 4 elements.");
  }
  
  public PKIData(TaggedAttribute[] paramArrayOfTaggedAttribute, TaggedRequest[] paramArrayOfTaggedRequest, TaggedContentInfo[] paramArrayOfTaggedContentInfo, OtherMsg[] paramArrayOfOtherMsg)
  {
    this.controlSequence = paramArrayOfTaggedAttribute;
    this.reqSequence = paramArrayOfTaggedRequest;
    this.cmsSequence = paramArrayOfTaggedContentInfo;
    this.otherMsgSequence = paramArrayOfOtherMsg;
  }
  
  public static PKIData getInstance(Object paramObject)
  {
    if ((paramObject instanceof PKIData)) {
      return (PKIData)paramObject;
    }
    if (paramObject != null) {
      return new PKIData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public TaggedContentInfo[] getCmsSequence()
  {
    return this.cmsSequence;
  }
  
  public TaggedAttribute[] getControlSequence()
  {
    return this.controlSequence;
  }
  
  public OtherMsg[] getOtherMsgSequence()
  {
    return this.otherMsgSequence;
  }
  
  public TaggedRequest[] getReqSequence()
  {
    return this.reqSequence;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(new ASN1Encodable[] { new DERSequence(this.controlSequence), new DERSequence(this.reqSequence), new DERSequence(this.cmsSequence), new DERSequence(this.otherMsgSequence) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\PKIData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */