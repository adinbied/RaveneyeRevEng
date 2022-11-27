package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PolicyInformation
  extends ASN1Object
{
  private ASN1ObjectIdentifier policyIdentifier;
  private ASN1Sequence policyQualifiers;
  
  public PolicyInformation(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.policyIdentifier = paramASN1ObjectIdentifier;
  }
  
  public PolicyInformation(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Sequence paramASN1Sequence)
  {
    this.policyIdentifier = paramASN1ObjectIdentifier;
    this.policyQualifiers = paramASN1Sequence;
  }
  
  private PolicyInformation(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.policyIdentifier = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1) {
        this.policyQualifiers = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static PolicyInformation getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof PolicyInformation))) {
      return new PolicyInformation(ASN1Sequence.getInstance(paramObject));
    }
    return (PolicyInformation)paramObject;
  }
  
  public ASN1ObjectIdentifier getPolicyIdentifier()
  {
    return this.policyIdentifier;
  }
  
  public ASN1Sequence getPolicyQualifiers()
  {
    return this.policyQualifiers;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.policyIdentifier);
    ASN1Sequence localASN1Sequence = this.policyQualifiers;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(localASN1Sequence);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("Policy information: ");
    localStringBuffer1.append(this.policyIdentifier);
    if (this.policyQualifiers != null)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      int i = 0;
      while (i < this.policyQualifiers.size())
      {
        if (localStringBuffer2.length() != 0) {
          localStringBuffer2.append(", ");
        }
        localStringBuffer2.append(PolicyQualifierInfo.getInstance(this.policyQualifiers.getObjectAt(i)));
        i += 1;
      }
      localStringBuffer1.append("[");
      localStringBuffer1.append(localStringBuffer2);
      localStringBuffer1.append("]");
    }
    return localStringBuffer1.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PolicyInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */