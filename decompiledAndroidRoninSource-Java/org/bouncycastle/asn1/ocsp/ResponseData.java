package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

public class ResponseData
  extends ASN1Object
{
  private static final ASN1Integer V1 = new ASN1Integer(0L);
  private ASN1GeneralizedTime producedAt;
  private ResponderID responderID;
  private Extensions responseExtensions;
  private ASN1Sequence responses;
  private ASN1Integer version;
  private boolean versionPresent;
  
  public ResponseData(ASN1Integer paramASN1Integer, ResponderID paramResponderID, ASN1GeneralizedTime paramASN1GeneralizedTime, ASN1Sequence paramASN1Sequence, Extensions paramExtensions)
  {
    this.version = paramASN1Integer;
    this.responderID = paramResponderID;
    this.producedAt = paramASN1GeneralizedTime;
    this.responses = paramASN1Sequence;
    this.responseExtensions = paramExtensions;
  }
  
  private ResponseData(ASN1Sequence paramASN1Sequence)
  {
    int i = 0;
    if (((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) && (((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0)).getTagNo() == 0))
    {
      this.versionPresent = true;
      this.version = ASN1Integer.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), true);
      i = 1;
    }
    else
    {
      this.version = V1;
    }
    int j = i + 1;
    this.responderID = ResponderID.getInstance(paramASN1Sequence.getObjectAt(i));
    i = j + 1;
    this.producedAt = ASN1GeneralizedTime.getInstance(paramASN1Sequence.getObjectAt(j));
    j = i + 1;
    this.responses = ((ASN1Sequence)paramASN1Sequence.getObjectAt(i));
    if (paramASN1Sequence.size() > j) {
      this.responseExtensions = Extensions.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(j), true);
    }
  }
  
  public ResponseData(ResponderID paramResponderID, ASN1GeneralizedTime paramASN1GeneralizedTime, ASN1Sequence paramASN1Sequence, Extensions paramExtensions)
  {
    this(V1, paramResponderID, paramASN1GeneralizedTime, paramASN1Sequence, paramExtensions);
  }
  
  public ResponseData(ResponderID paramResponderID, ASN1GeneralizedTime paramASN1GeneralizedTime, ASN1Sequence paramASN1Sequence, X509Extensions paramX509Extensions)
  {
    this(V1, paramResponderID, ASN1GeneralizedTime.getInstance(paramASN1GeneralizedTime), paramASN1Sequence, Extensions.getInstance(paramX509Extensions));
  }
  
  public static ResponseData getInstance(Object paramObject)
  {
    if ((paramObject instanceof ResponseData)) {
      return (ResponseData)paramObject;
    }
    if (paramObject != null) {
      return new ResponseData(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ResponseData getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1GeneralizedTime getProducedAt()
  {
    return this.producedAt;
  }
  
  public ResponderID getResponderID()
  {
    return this.responderID;
  }
  
  public Extensions getResponseExtensions()
  {
    return this.responseExtensions;
  }
  
  public ASN1Sequence getResponses()
  {
    return this.responses;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if ((this.versionPresent) || (!this.version.equals(V1))) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.version));
    }
    localASN1EncodableVector.add(this.responderID);
    localASN1EncodableVector.add(this.producedAt);
    localASN1EncodableVector.add(this.responses);
    Extensions localExtensions = this.responseExtensions;
    if (localExtensions != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, localExtensions));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\ResponseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */