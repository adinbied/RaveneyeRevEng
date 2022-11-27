package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

public class TimeStampReq
  extends ASN1Object
{
  ASN1Boolean certReq;
  Extensions extensions;
  MessageImprint messageImprint;
  ASN1Integer nonce;
  ASN1ObjectIdentifier tsaPolicy;
  ASN1Integer version;
  
  private TimeStampReq(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    this.messageImprint = MessageImprint.getInstance(paramASN1Sequence.getObjectAt(1));
    int i = 2;
    while (i < j)
    {
      if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1ObjectIdentifier))
      {
        this.tsaPolicy = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(i));
      }
      else if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1Integer))
      {
        this.nonce = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(i));
      }
      else if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1Boolean))
      {
        this.certReq = ASN1Boolean.getInstance(paramASN1Sequence.getObjectAt(i));
      }
      else if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject))
      {
        ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(i);
        if (localASN1TaggedObject.getTagNo() == 0) {
          this.extensions = Extensions.getInstance(localASN1TaggedObject, false);
        }
      }
      i += 1;
    }
  }
  
  public TimeStampReq(MessageImprint paramMessageImprint, ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Integer paramASN1Integer, ASN1Boolean paramASN1Boolean, Extensions paramExtensions)
  {
    this.version = new ASN1Integer(1L);
    this.messageImprint = paramMessageImprint;
    this.tsaPolicy = paramASN1ObjectIdentifier;
    this.nonce = paramASN1Integer;
    this.certReq = paramASN1Boolean;
    this.extensions = paramExtensions;
  }
  
  public static TimeStampReq getInstance(Object paramObject)
  {
    if ((paramObject instanceof TimeStampReq)) {
      return (TimeStampReq)paramObject;
    }
    if (paramObject != null) {
      return new TimeStampReq(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Boolean getCertReq()
  {
    return this.certReq;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public MessageImprint getMessageImprint()
  {
    return this.messageImprint;
  }
  
  public ASN1Integer getNonce()
  {
    return this.nonce;
  }
  
  public ASN1ObjectIdentifier getReqPolicy()
  {
    return this.tsaPolicy;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.version);
    localASN1EncodableVector.add(this.messageImprint);
    Object localObject = this.tsaPolicy;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.nonce;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.certReq;
    if ((localObject != null) && (((ASN1Boolean)localObject).isTrue())) {
      localASN1EncodableVector.add(this.certReq);
    }
    localObject = this.extensions;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\tsp\TimeStampReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */