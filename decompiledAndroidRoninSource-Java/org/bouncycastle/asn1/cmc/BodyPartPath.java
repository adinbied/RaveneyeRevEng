package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class BodyPartPath
  extends ASN1Object
{
  private final BodyPartID[] bodyPartIDs;
  
  private BodyPartPath(ASN1Sequence paramASN1Sequence)
  {
    this.bodyPartIDs = Utils.toBodyPartIDArray(paramASN1Sequence);
  }
  
  public BodyPartPath(BodyPartID paramBodyPartID)
  {
    this.bodyPartIDs = new BodyPartID[] { paramBodyPartID };
  }
  
  public BodyPartPath(BodyPartID[] paramArrayOfBodyPartID)
  {
    this.bodyPartIDs = Utils.clone(paramArrayOfBodyPartID);
  }
  
  public static BodyPartPath getInstance(Object paramObject)
  {
    if ((paramObject instanceof BodyPartPath)) {
      return (BodyPartPath)paramObject;
    }
    if (paramObject != null) {
      return new BodyPartPath(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static BodyPartPath getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\BodyPartPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */