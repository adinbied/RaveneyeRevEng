package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class BodyPartList
  extends ASN1Object
{
  private final BodyPartID[] bodyPartIDs;
  
  private BodyPartList(ASN1Sequence paramASN1Sequence)
  {
    this.bodyPartIDs = Utils.toBodyPartIDArray(paramASN1Sequence);
  }
  
  public BodyPartList(BodyPartID paramBodyPartID)
  {
    this.bodyPartIDs = new BodyPartID[] { paramBodyPartID };
  }
  
  public BodyPartList(BodyPartID[] paramArrayOfBodyPartID)
  {
    this.bodyPartIDs = Utils.clone(paramArrayOfBodyPartID);
  }
  
  public static BodyPartList getInstance(Object paramObject)
  {
    if ((paramObject instanceof BodyPartList)) {
      return (BodyPartList)paramObject;
    }
    if (paramObject != null) {
      return new BodyPartList(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static BodyPartList getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BodyPartID[] getBodyPartIDs()
  {
    return Utils.clone(this.bodyPartIDs);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.bodyPartIDs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\BodyPartList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */