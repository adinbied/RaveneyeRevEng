package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;

public class TaggedContentInfo
  extends ASN1Object
{
  private final BodyPartID bodyPartID;
  private final ContentInfo contentInfo;
  
  private TaggedContentInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.bodyPartID = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.contentInfo = ContentInfo.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public TaggedContentInfo(BodyPartID paramBodyPartID, ContentInfo paramContentInfo)
  {
    this.bodyPartID = paramBodyPartID;
    this.contentInfo = paramContentInfo;
  }
  
  public static TaggedContentInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof TaggedContentInfo)) {
      return (TaggedContentInfo)paramObject;
    }
    if (paramObject != null) {
      return new TaggedContentInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TaggedContentInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BodyPartID getBodyPartID()
  {
    return this.bodyPartID;
  }
  
  public ContentInfo getContentInfo()
  {
    return this.contentInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bodyPartID);
    localASN1EncodableVector.add(this.contentInfo);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\TaggedContentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */