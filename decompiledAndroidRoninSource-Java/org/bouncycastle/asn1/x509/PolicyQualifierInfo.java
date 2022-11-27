package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;

public class PolicyQualifierInfo
  extends ASN1Object
{
  private ASN1ObjectIdentifier policyQualifierId;
  private ASN1Encodable qualifier;
  
  public PolicyQualifierInfo(String paramString)
  {
    this.policyQualifierId = PolicyQualifierId.id_qt_cps;
    this.qualifier = new DERIA5String(paramString);
  }
  
  public PolicyQualifierInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.policyQualifierId = paramASN1ObjectIdentifier;
    this.qualifier = paramASN1Encodable;
  }
  
  public PolicyQualifierInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.policyQualifierId = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.qualifier = paramASN1Sequence.getObjectAt(1);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static PolicyQualifierInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof PolicyQualifierInfo)) {
      return (PolicyQualifierInfo)paramObject;
    }
    if (paramObject != null) {
      return new PolicyQualifierInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getPolicyQualifierId()
  {
    return this.policyQualifierId;
  }
  
  public ASN1Encodable getQualifier()
  {
    return this.qualifier;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.policyQualifierId);
    localASN1EncodableVector.add(this.qualifier);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PolicyQualifierInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */