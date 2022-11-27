package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class RevDetails
  extends ASN1Object
{
  private CertTemplate certDetails;
  private Extensions crlEntryDetails;
  
  private RevDetails(ASN1Sequence paramASN1Sequence)
  {
    this.certDetails = CertTemplate.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.crlEntryDetails = Extensions.getInstance(paramASN1Sequence.getObjectAt(1));
    }
  }
  
  public RevDetails(CertTemplate paramCertTemplate)
  {
    this.certDetails = paramCertTemplate;
  }
  
  public RevDetails(CertTemplate paramCertTemplate, Extensions paramExtensions)
  {
    this.certDetails = paramCertTemplate;
    this.crlEntryDetails = paramExtensions;
  }
  
  public RevDetails(CertTemplate paramCertTemplate, X509Extensions paramX509Extensions)
  {
    this.certDetails = paramCertTemplate;
    this.crlEntryDetails = Extensions.getInstance(paramX509Extensions.toASN1Primitive());
  }
  
  public static RevDetails getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevDetails)) {
      return (RevDetails)paramObject;
    }
    if (paramObject != null) {
      return new RevDetails(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertTemplate getCertDetails()
  {
    return this.certDetails;
  }
  
  public Extensions getCrlEntryDetails()
  {
    return this.crlEntryDetails;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certDetails);
    Extensions localExtensions = this.crlEntryDetails;
    if (localExtensions != null) {
      localASN1EncodableVector.add(localExtensions);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\RevDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */