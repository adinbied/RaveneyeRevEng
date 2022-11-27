package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.CertificateList;

public class RevRepContentBuilder
{
  private ASN1EncodableVector crls = new ASN1EncodableVector();
  private ASN1EncodableVector revCerts = new ASN1EncodableVector();
  private ASN1EncodableVector status = new ASN1EncodableVector();
  
  public RevRepContentBuilder add(PKIStatusInfo paramPKIStatusInfo)
  {
    this.status.add(paramPKIStatusInfo);
    return this;
  }
  
  public RevRepContentBuilder add(PKIStatusInfo paramPKIStatusInfo, CertId paramCertId)
  {
    if (this.status.size() == this.revCerts.size())
    {
      this.status.add(paramPKIStatusInfo);
      this.revCerts.add(paramCertId);
      return this;
    }
    throw new IllegalStateException("status and revCerts sequence must be in common order");
  }
  
  public RevRepContentBuilder addCrl(CertificateList paramCertificateList)
  {
    this.crls.add(paramCertificateList);
    return this;
  }
  
  public RevRepContent build()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new DERSequence(this.status));
    if (this.revCerts.size() != 0) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, new DERSequence(this.revCerts)));
    }
    if (this.crls.size() != 0) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, new DERSequence(this.crls)));
    }
    return RevRepContent.getInstance(new DERSequence(localASN1EncodableVector));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\RevRepContentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */