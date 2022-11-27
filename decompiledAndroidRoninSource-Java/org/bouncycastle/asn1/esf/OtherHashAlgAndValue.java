package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHashAlgAndValue
  extends ASN1Object
{
  private AlgorithmIdentifier hashAlgorithm;
  private ASN1OctetString hashValue;
  
  private OtherHashAlgAndValue(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.hashValue = ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public OtherHashAlgAndValue(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1OctetString paramASN1OctetString)
  {
    this.hashAlgorithm = paramAlgorithmIdentifier;
    this.hashValue = paramASN1OctetString;
  }
  
  public static OtherHashAlgAndValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherHashAlgAndValue)) {
      return (OtherHashAlgAndValue)paramObject;
    }
    if (paramObject != null) {
      return new OtherHashAlgAndValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public ASN1OctetString getHashValue()
  {
    return this.hashValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(this.hashValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\OtherHashAlgAndValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */