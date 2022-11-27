package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ControlsProcessed
  extends ASN1Object
{
  private final ASN1Sequence bodyPartReferences;
  
  private ControlsProcessed(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 1)
    {
      this.bodyPartReferences = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(0));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public ControlsProcessed(BodyPartReference paramBodyPartReference)
  {
    this.bodyPartReferences = new DERSequence(paramBodyPartReference);
  }
  
  public ControlsProcessed(BodyPartReference[] paramArrayOfBodyPartReference)
  {
    this.bodyPartReferences = new DERSequence(paramArrayOfBodyPartReference);
  }
  
  public static ControlsProcessed getInstance(Object paramObject)
  {
    if ((paramObject instanceof ControlsProcessed)) {
      return (ControlsProcessed)paramObject;
    }
    if (paramObject != null) {
      return new ControlsProcessed(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartReference[] getBodyList()
  {
    BodyPartReference[] arrayOfBodyPartReference = new BodyPartReference[this.bodyPartReferences.size()];
    int i = 0;
    while (i != this.bodyPartReferences.size())
    {
      arrayOfBodyPartReference[i] = BodyPartReference.getInstance(this.bodyPartReferences.getObjectAt(i));
      i += 1;
    }
    return arrayOfBodyPartReference;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.bodyPartReferences);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\ControlsProcessed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */