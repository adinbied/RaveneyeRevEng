package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CrlValidatedID
  extends ASN1Object
{
  private OtherHash crlHash;
  private CrlIdentifier crlIdentifier;
  
  private CrlValidatedID(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.crlHash = OtherHash.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1) {
        this.crlIdentifier = CrlIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public CrlValidatedID(OtherHash paramOtherHash)
  {
    this(paramOtherHash, null);
  }
  
  public CrlValidatedID(OtherHash paramOtherHash, CrlIdentifier paramCrlIdentifier)
  {
    this.crlHash = paramOtherHash;
    this.crlIdentifier = paramCrlIdentifier;
  }
  
  public static CrlValidatedID getInstance(Object paramObject)
  {
    if ((paramObject instanceof CrlValidatedID)) {
      return (CrlValidatedID)paramObject;
    }
    if (paramObject != null) {
      return new CrlValidatedID(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public OtherHash getCrlHash()
  {
    return this.crlHash;
  }
  
  public CrlIdentifier getCrlIdentifier()
  {
    return this.crlIdentifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.crlHash.toASN1Primitive());
    CrlIdentifier localCrlIdentifier = this.crlIdentifier;
    if (localCrlIdentifier != null) {
      localASN1EncodableVector.add(localCrlIdentifier.toASN1Primitive());
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\CrlValidatedID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */