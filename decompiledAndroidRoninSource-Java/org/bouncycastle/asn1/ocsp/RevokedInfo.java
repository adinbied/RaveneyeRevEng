package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.CRLReason;

public class RevokedInfo
  extends ASN1Object
{
  private CRLReason revocationReason;
  private ASN1GeneralizedTime revocationTime;
  
  public RevokedInfo(ASN1GeneralizedTime paramASN1GeneralizedTime, CRLReason paramCRLReason)
  {
    this.revocationTime = paramASN1GeneralizedTime;
    this.revocationReason = paramCRLReason;
  }
  
  private RevokedInfo(ASN1Sequence paramASN1Sequence)
  {
    this.revocationTime = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1) {
      this.revocationReason = CRLReason.getInstance(ASN1Enumerated.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true));
    }
  }
  
  public static RevokedInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof RevokedInfo)) {
      return (RevokedInfo)paramObject;
    }
    if (paramObject != null) {
      return new RevokedInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static RevokedInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public CRLReason getRevocationReason()
  {
    return this.revocationReason;
  }
  
  public ASN1GeneralizedTime getRevocationTime()
  {
    return this.revocationTime;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.revocationTime);
    CRLReason localCRLReason = this.revocationReason;
    if (localCRLReason != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localCRLReason));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\RevokedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */