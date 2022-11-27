package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class SigningCertificate
  extends ASN1Object
{
  ASN1Sequence certs;
  ASN1Sequence policies;
  
  private SigningCertificate(ASN1Sequence paramASN1Sequence)
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
  
  public SigningCertificate(ESSCertID paramESSCertID)
  {
    this.certs = new DERSequence(paramESSCertID);
  }
  
  public static SigningCertificate getInstance(Object paramObject)
  {
    if ((paramObject instanceof SigningCertificate)) {
      return (SigningCertificate)paramObject;
    }
    if (paramObject != null) {
      return new SigningCertificate(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ESSCertID[] getCerts()
  {
    ESSCertID[] arrayOfESSCertID = new ESSCertID[this.certs.size()];
    int i = 0;
    while (i != this.certs.size())
    {
      arrayOfESSCertID[i] = ESSCertID.getInstance(this.certs.getObjectAt(i));
      i += 1;
    }
    return arrayOfESSCertID;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ess\SigningCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */