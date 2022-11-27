package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertResponse
  extends ASN1Object
{
  private ASN1Integer certReqId;
  private CertifiedKeyPair certifiedKeyPair;
  private ASN1OctetString rspInfo;
  private PKIStatusInfo status;
  
  public CertResponse(ASN1Integer paramASN1Integer, PKIStatusInfo paramPKIStatusInfo)
  {
    this(paramASN1Integer, paramPKIStatusInfo, null, null);
  }
  
  public CertResponse(ASN1Integer paramASN1Integer, PKIStatusInfo paramPKIStatusInfo, CertifiedKeyPair paramCertifiedKeyPair, ASN1OctetString paramASN1OctetString)
  {
    if (paramASN1Integer != null)
    {
      if (paramPKIStatusInfo != null)
      {
        this.certReqId = paramASN1Integer;
        this.status = paramPKIStatusInfo;
        this.certifiedKeyPair = paramCertifiedKeyPair;
        this.rspInfo = paramASN1OctetString;
        return;
      }
      throw new IllegalArgumentException("'status' cannot be null");
    }
    throw new IllegalArgumentException("'certReqId' cannot be null");
  }
  
  private CertResponse(ASN1Sequence paramASN1Sequence)
  {
    this.certReqId = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.status = PKIStatusInfo.getInstance(paramASN1Sequence.getObjectAt(1));
    if (paramASN1Sequence.size() >= 3)
    {
      if (paramASN1Sequence.size() == 3)
      {
        paramASN1Sequence = paramASN1Sequence.getObjectAt(2);
        if (!(paramASN1Sequence instanceof ASN1OctetString)) {
          this.certifiedKeyPair = CertifiedKeyPair.getInstance(paramASN1Sequence);
        }
      }
      else
      {
        this.certifiedKeyPair = CertifiedKeyPair.getInstance(paramASN1Sequence.getObjectAt(2));
        paramASN1Sequence = paramASN1Sequence.getObjectAt(3);
      }
      this.rspInfo = ASN1OctetString.getInstance(paramASN1Sequence);
    }
  }
  
  public static CertResponse getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertResponse)) {
      return (CertResponse)paramObject;
    }
    if (paramObject != null) {
      return new CertResponse(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getCertReqId()
  {
    return this.certReqId;
  }
  
  public CertifiedKeyPair getCertifiedKeyPair()
  {
    return this.certifiedKeyPair;
  }
  
  public PKIStatusInfo getStatus()
  {
    return this.status;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certReqId);
    localASN1EncodableVector.add(this.status);
    Object localObject = this.certifiedKeyPair;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.rspInfo;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CertResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */