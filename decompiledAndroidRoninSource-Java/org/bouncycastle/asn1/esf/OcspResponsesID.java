package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class OcspResponsesID
  extends ASN1Object
{
  private OcspIdentifier ocspIdentifier;
  private OtherHash ocspRepHash;
  
  private OcspResponsesID(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.ocspIdentifier = OcspIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1) {
        this.ocspRepHash = OtherHash.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public OcspResponsesID(OcspIdentifier paramOcspIdentifier)
  {
    this(paramOcspIdentifier, null);
  }
  
  public OcspResponsesID(OcspIdentifier paramOcspIdentifier, OtherHash paramOtherHash)
  {
    this.ocspIdentifier = paramOcspIdentifier;
    this.ocspRepHash = paramOtherHash;
  }
  
  public static OcspResponsesID getInstance(Object paramObject)
  {
    if ((paramObject instanceof OcspResponsesID)) {
      return (OcspResponsesID)paramObject;
    }
    if (paramObject != null) {
      return new OcspResponsesID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public OcspIdentifier getOcspIdentifier()
  {
    return this.ocspIdentifier;
  }
  
  public OtherHash getOcspRepHash()
  {
    return this.ocspRepHash;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.ocspIdentifier);
    OtherHash localOtherHash = this.ocspRepHash;
    if (localOtherHash != null) {
      localASN1EncodableVector.add(localOtherHash);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OcspResponsesID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */