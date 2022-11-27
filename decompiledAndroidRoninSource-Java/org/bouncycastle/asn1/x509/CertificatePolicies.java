package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CertificatePolicies
  extends ASN1Object
{
  private final PolicyInformation[] policyInformation;
  
  private CertificatePolicies(ASN1Sequence paramASN1Sequence)
  {
    this.policyInformation = new PolicyInformation[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      this.policyInformation[i] = PolicyInformation.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public CertificatePolicies(PolicyInformation paramPolicyInformation)
  {
    this.policyInformation = new PolicyInformation[] { paramPolicyInformation };
  }
  
  public CertificatePolicies(PolicyInformation[] paramArrayOfPolicyInformation)
  {
    this.policyInformation = paramArrayOfPolicyInformation;
  }
  
  public static CertificatePolicies fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.certificatePolicies));
  }
  
  public static CertificatePolicies getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertificatePolicies)) {
      return (CertificatePolicies)paramObject;
    }
    if (paramObject != null) {
      return new CertificatePolicies(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CertificatePolicies getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public PolicyInformation getPolicyInformation(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    int i = 0;
    for (;;)
    {
      PolicyInformation[] arrayOfPolicyInformation = this.policyInformation;
      if (i == arrayOfPolicyInformation.length) {
        break;
      }
      if (paramASN1ObjectIdentifier.equals(arrayOfPolicyInformation[i].getPolicyIdentifier())) {
        return this.policyInformation[i];
      }
      i += 1;
    }
    return null;
  }
  
  public PolicyInformation[] getPolicyInformation()
  {
    PolicyInformation[] arrayOfPolicyInformation1 = this.policyInformation;
    PolicyInformation[] arrayOfPolicyInformation2 = new PolicyInformation[arrayOfPolicyInformation1.length];
    System.arraycopy(arrayOfPolicyInformation1, 0, arrayOfPolicyInformation2, 0, arrayOfPolicyInformation1.length);
    return arrayOfPolicyInformation2;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.policyInformation);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.policyInformation.length)
    {
      if (localStringBuffer.length() != 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(this.policyInformation[i]);
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CertificatePolicies: [");
    localStringBuilder.append(localStringBuffer);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CertificatePolicies.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */