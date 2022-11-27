package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class SigningCertificateV2
  extends ASN1Object
{
  ASN1Sequence certs;
  ASN1Sequence policies;
  
  private SigningCertificateV2(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.certs = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() > 1) {
        this.policies = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public SigningCertificateV2(ESSCertIDv2 paramESSCertIDv2)
  {
    this.certs = new DERSequence(paramESSCertIDv2);
  }
  
  public SigningCertificateV2(ESSCertIDv2[] paramArrayOfESSCertIDv2)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfESSCertIDv2.length)
    {
      localASN1EncodableVector.add(paramArrayOfESSCertIDv2[i]);
      i += 1;
    }
    this.certs = new DERSequence(localASN1EncodableVector);
  }
  
  public SigningCertificateV2(ESSCertIDv2[] paramArrayOfESSCertIDv2, PolicyInformation[] paramArrayOfPolicyInformation)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int j = 0;
    int i = 0;
    while (i < paramArrayOfESSCertIDv2.length)
    {
      localASN1EncodableVector.add(paramArrayOfESSCertIDv2[i]);
      i += 1;
    }
    this.certs = new DERSequence(localASN1EncodableVector);
    if (paramArrayOfPolicyInformation != null)
    {
      paramArrayOfESSCertIDv2 = new ASN1EncodableVector();
      i = j;
      while (i < paramArrayOfPolicyInformation.length)
      {
        paramArrayOfESSCertIDv2.add(paramArrayOfPolicyInformation[i]);
        i += 1;
      }
      this.policies = new DERSequence(paramArrayOfESSCertIDv2);
    }
  }
  
  public static SigningCertificateV2 getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof SigningCertificateV2)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new SigningCertificateV2((ASN1Sequence)paramObject);
      }
      return null;
    }
    return (SigningCertificateV2)paramObject;
  }
  
  public ESSCertIDv2[] getCerts()
  {
    ESSCertIDv2[] arrayOfESSCertIDv2 = new ESSCertIDv2[this.certs.size()];
    int i = 0;
    while (i != this.certs.size())
    {
      arrayOfESSCertIDv2[i] = ESSCertIDv2.getInstance(this.certs.getObjectAt(i));
      i += 1;
    }
    return arrayOfESSCertIDv2;
  }
  
  public PolicyInformation[] getPolicies()
  {
    Object localObject = this.policies;
    if (localObject == null) {
      return null;
    }
    localObject = new PolicyInformation[((ASN1Sequence)localObject).size()];
    int i = 0;
    while (i != this.policies.size())
    {
      localObject[i] = PolicyInformation.getInstance(this.policies.getObjectAt(i));
      i += 1;
    }
    return (PolicyInformation[])localObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certs);
    ASN1Sequence localASN1Sequence = this.policies;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(localASN1Sequence);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\SigningCertificateV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */