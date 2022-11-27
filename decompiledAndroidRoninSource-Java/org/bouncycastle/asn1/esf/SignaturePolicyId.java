package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SignaturePolicyId
  extends ASN1Object
{
  private OtherHashAlgAndValue sigPolicyHash;
  private ASN1ObjectIdentifier sigPolicyId;
  private SigPolicyQualifiers sigPolicyQualifiers;
  
  public SignaturePolicyId(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OtherHashAlgAndValue paramOtherHashAlgAndValue)
  {
    this(paramASN1ObjectIdentifier, paramOtherHashAlgAndValue, null);
  }
  
  public SignaturePolicyId(ASN1ObjectIdentifier paramASN1ObjectIdentifier, OtherHashAlgAndValue paramOtherHashAlgAndValue, SigPolicyQualifiers paramSigPolicyQualifiers)
  {
    this.sigPolicyId = paramASN1ObjectIdentifier;
    this.sigPolicyHash = paramOtherHashAlgAndValue;
    this.sigPolicyQualifiers = paramSigPolicyQualifiers;
  }
  
  private SignaturePolicyId(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() != 2) && (paramASN1Sequence.size() != 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad sequence size: ");
      localStringBuilder.append(paramASN1Sequence.size());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.sigPolicyId = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.sigPolicyHash = OtherHashAlgAndValue.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() == 3) {
      this.sigPolicyQualifiers = SigPolicyQualifiers.getInstance(paramASN1Sequence.getObjectAt(2));
    }
  }
  
  public static SignaturePolicyId getInstance(Object paramObject)
  {
    if ((paramObject instanceof SignaturePolicyId)) {
      return (SignaturePolicyId)paramObject;
    }
    if (paramObject != null) {
      return new SignaturePolicyId(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public OtherHashAlgAndValue getSigPolicyHash()
  {
    return this.sigPolicyHash;
  }
  
  public ASN1ObjectIdentifier getSigPolicyId()
  {
    return new ASN1ObjectIdentifier(this.sigPolicyId.getId());
  }
  
  public SigPolicyQualifiers getSigPolicyQualifiers()
  {
    return this.sigPolicyQualifiers;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.sigPolicyId);
    localASN1EncodableVector.add(this.sigPolicyHash);
    SigPolicyQualifiers localSigPolicyQualifiers = this.sigPolicyQualifiers;
    if (localSigPolicyQualifiers != null) {
      localASN1EncodableVector.add(localSigPolicyQualifiers);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SignaturePolicyId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */