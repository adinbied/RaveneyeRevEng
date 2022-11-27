package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

public class Request
  extends ASN1Object
{
  CertID reqCert;
  Extensions singleRequestExtensions;
  
  private Request(ASN1Sequence paramASN1Sequence)
  {
    this.reqCert = CertID.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2) {
      this.singleRequestExtensions = Extensions.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true);
    }
  }
  
  public Request(CertID paramCertID, Extensions paramExtensions)
  {
    this.reqCert = paramCertID;
    this.singleRequestExtensions = paramExtensions;
  }
  
  public static Request getInstance(Object paramObject)
  {
    if ((paramObject instanceof Request)) {
      return (Request)paramObject;
    }
    if (paramObject != null) {
      return new Request(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static Request getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public CertID getReqCert()
  {
    return this.reqCert;
  }
  
  public Extensions getSingleRequestExtensions()
  {
    return this.singleRequestExtensions;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.reqCert);
    Extensions localExtensions = this.singleRequestExtensions;
    if (localExtensions != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localExtensions));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */