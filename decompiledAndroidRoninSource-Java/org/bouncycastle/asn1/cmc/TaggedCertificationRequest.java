package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class TaggedCertificationRequest
  extends ASN1Object
{
  private final BodyPartID bodyPartID;
  private final CertificationRequest certificationRequest;
  
  private TaggedCertificationRequest(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.bodyPartID = BodyPartID.getInstance(paramASN1Sequence.getObjectAt(0));
      this.certificationRequest = CertificationRequest.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public TaggedCertificationRequest(BodyPartID paramBodyPartID, CertificationRequest paramCertificationRequest)
  {
    this.bodyPartID = paramBodyPartID;
    this.certificationRequest = paramCertificationRequest;
  }
  
  public static TaggedCertificationRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof TaggedCertificationRequest)) {
      return (TaggedCertificationRequest)paramObject;
    }
    if (paramObject != null) {
      return new TaggedCertificationRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TaggedCertificationRequest getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.bodyPartID);
    localASN1EncodableVector.add(this.certificationRequest);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\TaggedCertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */