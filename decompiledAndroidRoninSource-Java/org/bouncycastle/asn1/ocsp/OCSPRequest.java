package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class OCSPRequest
  extends ASN1Object
{
  Signature optionalSignature;
  TBSRequest tbsRequest;
  
  private OCSPRequest(ASN1Sequence paramASN1Sequence)
  {
    this.tbsRequest = TBSRequest.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() == 2) {
      this.optionalSignature = Signature.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(1), true);
    }
  }
  
  public OCSPRequest(TBSRequest paramTBSRequest, Signature paramSignature)
  {
    this.tbsRequest = paramTBSRequest;
    this.optionalSignature = paramSignature;
  }
  
  public static OCSPRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof OCSPRequest)) {
      return (OCSPRequest)paramObject;
    }
    if (paramObject != null) {
      return new OCSPRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OCSPRequest getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Signature getOptionalSignature()
  {
    return this.optionalSignature;
  }
  
  public TBSRequest getTbsRequest()
  {
    return this.tbsRequest;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.tbsRequest);
    if (this.optionalSignature != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, this.optionalSignature));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\OCSPRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */