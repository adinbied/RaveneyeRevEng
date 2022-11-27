package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.Extensions;

public class RevAnnContent
  extends ASN1Object
{
  private ASN1GeneralizedTime badSinceDate;
  private CertId certId;
  private Extensions crlDetails;
  private PKIStatus status;
  private ASN1GeneralizedTime willBeRevokedAt;
  
  private RevAnnContent(ASN1Sequence paramASN1Sequence)
  {
    this.status = PKIStatus.getInstance(paramASN1Sequence.getObjectAt(0));
    this.certId = CertId.getInstance(paramASN1Sequence.getObjectAt(1));
    this.willBeRevokedAt = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(2));
    this.badSinceDate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(3));
    if (paramASN1Sequence.size() > 4) {
      this.crlDetails = Extensions.getInstance(paramASN1Sequence.getObjectAt(4));
    }
  }
  
  public static RevAnnContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevAnnContent)) {
      return (RevAnnContent)paramObject;
    }
    if (paramObject != null) {
      return new RevAnnContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1GeneralizedTime getBadSinceDate()
  {
    return this.badSinceDate;
  }
  
  public CertId getCertId()
  {
    return this.certId;
  }
  
  public Extensions getCrlDetails()
  {
    return this.crlDetails;
  }
  
  public PKIStatus getStatus()
  {
    return this.status;
  }
  
  public ASN1GeneralizedTime getWillBeRevokedAt()
  {
    return this.willBeRevokedAt;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.status);
    localASN1EncodableVector.add(this.certId);
    localASN1EncodableVector.add(this.willBeRevokedAt);
    localASN1EncodableVector.add(this.badSinceDate);
    Extensions localExtensions = this.crlDetails;
    if (localExtensions != null) {
      localASN1EncodableVector.add(localExtensions);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\RevAnnContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */