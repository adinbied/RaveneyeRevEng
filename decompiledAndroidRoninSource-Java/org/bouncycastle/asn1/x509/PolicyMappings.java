package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PolicyMappings
  extends ASN1Object
{
  ASN1Sequence seq = null;
  
  public PolicyMappings(Hashtable paramHashtable)
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str1 = (String)localEnumeration.nextElement();
      String str2 = (String)paramHashtable.get(str1);
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(new ASN1ObjectIdentifier(str1));
      localASN1EncodableVector2.add(new ASN1ObjectIdentifier(str2));
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    }
    this.seq = new DERSequence(localASN1EncodableVector1);
  }
  
  private PolicyMappings(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
  }
  
  public PolicyMappings(CertPolicyId paramCertPolicyId1, CertPolicyId paramCertPolicyId2)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramCertPolicyId1);
    localASN1EncodableVector.add(paramCertPolicyId2);
    this.seq = new DERSequence(new DERSequence(localASN1EncodableVector));
  }
  
  public PolicyMappings(CertPolicyId[] paramArrayOfCertPolicyId1, CertPolicyId[] paramArrayOfCertPolicyId2)
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfCertPolicyId1.length)
    {
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      localASN1EncodableVector2.add(paramArrayOfCertPolicyId1[i]);
      localASN1EncodableVector2.add(paramArrayOfCertPolicyId2[i]);
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
      i += 1;
    }
    this.seq = new DERSequence(localASN1EncodableVector1);
  }
  
  public static PolicyMappings getInstance(Object paramObject)
  {
    if ((paramObject instanceof PolicyMappings)) {
      return (PolicyMappings)paramObject;
    }
    if (paramObject != null) {
      return new PolicyMappings(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\PolicyMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */