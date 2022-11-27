package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class LraPopWitness
  extends ASN1Object
{
  private final ASN1Sequence bodyIds;
  private final BodyPartID pkiDataBodyid;
  
  private LraPopWitness(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.pkiDataBodyid = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.bodyIds = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public LraPopWitness(BodyPartID paramBodyPartID, ASN1Sequence paramASN1Sequence)
  {
    this.pkiDataBodyid = paramBodyPartID;
    this.bodyIds = paramASN1Sequence;
  }
  
  public static LraPopWitness getInstance(Object paramObject)
  {
    if ((paramObject instanceof LraPopWitness)) {
      return (LraPopWitness)paramObject;
    }
    if (paramObject != null) {
      return new LraPopWitness(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BodyPartID[] getBodyIds()
  {
    BodyPartID[] arrayOfBodyPartID = new BodyPartID[this.bodyIds.size()];
    int i = 0;
    while (i != this.bodyIds.size())
    {
      arrayOfBodyPartID[i] = BodyPartID.getInstance(this.bodyIds.getObjectAt(i));
      i += 1;
    }
    return arrayOfBodyPartID;
  }
  
  public BodyPartID getPkiDataBodyid()
  {
    return this.pkiDataBodyid;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pkiDataBodyid);
    localASN1EncodableVector.add(this.bodyIds);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\LraPopWitness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */