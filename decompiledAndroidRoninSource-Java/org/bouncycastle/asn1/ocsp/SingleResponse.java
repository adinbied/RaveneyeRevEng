package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class SingleResponse
  extends ASN1Object
{
  private CertID certID;
  private CertStatus certStatus;
  private ASN1GeneralizedTime nextUpdate;
  private Extensions singleExtensions;
  private ASN1GeneralizedTime thisUpdate;
  
  private SingleResponse(ASN1Sequence paramASN1Sequence)
  {
    this.certID = CertID.getInstance(paramASN1Sequence.getObjectAt(0));
    this.certStatus = CertStatus.getInstance(paramASN1Sequence.getObjectAt(1));
    this.thisUpdate = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(2));
    if (paramASN1Sequence.size() > 4)
    {
      this.nextUpdate = ASN1GeneralizedTime.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(3), true);
      paramASN1Sequence = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(4);
    }
    ASN1TaggedObject localASN1TaggedObject;
    do
    {
      this.singleExtensions = Extensions.getInstance(paramASN1Sequence, true);
      return;
      if (paramASN1Sequence.size() <= 3) {
        break;
      }
      localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(3);
      paramASN1Sequence = localASN1TaggedObject;
    } while (localASN1TaggedObject.getTagNo() != 0);
    this.nextUpdate = ASN1GeneralizedTime.getInstance(localASN1TaggedObject, true);
  }
  
  public SingleResponse(CertID paramCertID, CertStatus paramCertStatus, ASN1GeneralizedTime paramASN1GeneralizedTime1, ASN1GeneralizedTime paramASN1GeneralizedTime2, Extensions paramExtensions)
  {
    this.certID = paramCertID;
    this.certStatus = paramCertStatus;
    this.thisUpdate = paramASN1GeneralizedTime1;
    this.nextUpdate = paramASN1GeneralizedTime2;
    this.singleExtensions = paramExtensions;
  }
  
  public SingleResponse(CertID paramCertID, CertStatus paramCertStatus, ASN1GeneralizedTime paramASN1GeneralizedTime1, ASN1GeneralizedTime paramASN1GeneralizedTime2, X509Extensions paramX509Extensions)
  {
    this(paramCertID, paramCertStatus, paramASN1GeneralizedTime1, paramASN1GeneralizedTime2, Extensions.getInstance(paramX509Extensions));
  }
  
  public static SingleResponse getInstance(Object paramObject)
  {
    if ((paramObject instanceof SingleResponse)) {
      return (SingleResponse)paramObject;
    }
    if (paramObject != null) {
      return new SingleResponse(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static SingleResponse getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public CertID getCertID()
  {
    return this.certID;
  }
  
  public CertStatus getCertStatus()
  {
    return this.certStatus;
  }
  
  public ASN1GeneralizedTime getNextUpdate()
  {
    return this.nextUpdate;
  }
  
  public Extensions getSingleExtensions()
  {
    return this.singleExtensions;
  }
  
  public ASN1GeneralizedTime getThisUpdate()
  {
    return this.thisUpdate;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certID);
    localASN1EncodableVector.add(this.certStatus);
    localASN1EncodableVector.add(this.thisUpdate);
    Object localObject = this.nextUpdate;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable)localObject));
    }
    localObject = this.singleExtensions;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\SingleResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */