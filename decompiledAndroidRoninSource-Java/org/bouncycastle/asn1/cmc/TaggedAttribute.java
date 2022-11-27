package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

public class TaggedAttribute
  extends ASN1Object
{
  private final ASN1ObjectIdentifier attrType;
  private final ASN1Set attrValues;
  private final BodyPartID bodyPartID;
  
  private TaggedAttribute(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.bodyPartID = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.attrType = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.attrValues = ASN1Set.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public TaggedAttribute(BodyPartID paramBodyPartID, ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Set paramASN1Set)
  {
    this.bodyPartID = paramBodyPartID;
    this.attrType = paramASN1ObjectIdentifier;
    this.attrValues = paramASN1Set;
  }
  
  public static TaggedAttribute getInstance(Object paramObject)
  {
    if ((paramObject instanceof TaggedAttribute)) {
      return (TaggedAttribute)paramObject;
    }
    if (paramObject != null) {
      return new TaggedAttribute(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getAttrType()
  {
    return this.attrType;
  }
  
  public ASN1Set getAttrValues()
  {
    return this.attrValues;
  }
  
  public BodyPartID getBodyPartID()
  {
    return this.bodyPartID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(new ASN1Encodable[] { this.bodyPartID, this.attrType, this.attrValues });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\TaggedAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */