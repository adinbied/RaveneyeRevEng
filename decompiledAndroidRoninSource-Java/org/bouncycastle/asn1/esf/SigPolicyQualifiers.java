package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SigPolicyQualifiers
  extends ASN1Object
{
  ASN1Sequence qualifiers;
  
  private SigPolicyQualifiers(ASN1Sequence paramASN1Sequence)
  {
    this.qualifiers = paramASN1Sequence;
  }
  
  public SigPolicyQualifiers(SigPolicyQualifierInfo[] paramArrayOfSigPolicyQualifierInfo)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfSigPolicyQualifierInfo.length)
    {
      localASN1EncodableVector.add(paramArrayOfSigPolicyQualifierInfo[i]);
      i += 1;
    }
    this.qualifiers = new DERSequence(localASN1EncodableVector);
  }
  
  public static SigPolicyQualifiers getInstance(Object paramObject)
  {
    if ((paramObject instanceof SigPolicyQualifiers)) {
      return (SigPolicyQualifiers)paramObject;
    }
    if ((paramObject instanceof ASN1Sequence)) {
      return new SigPolicyQualifiers(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public SigPolicyQualifierInfo getInfoAt(int paramInt)
  {
    return SigPolicyQualifierInfo.getInstance(this.qualifiers.getObjectAt(paramInt));
  }
  
  public int size()
  {
    return this.qualifiers.size();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.qualifiers;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SigPolicyQualifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */