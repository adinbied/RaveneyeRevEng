package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;

public class TimeStampResp
  extends ASN1Object
{
  PKIStatusInfo pkiStatusInfo;
  ContentInfo timeStampToken;
  
  private TimeStampResp(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.pkiStatusInfo = PKIStatusInfo.getInstance(paramASN1Sequence.nextElement());
    if (paramASN1Sequence.hasMoreElements()) {
      this.timeStampToken = ContentInfo.getInstance(paramASN1Sequence.nextElement());
    }
  }
  
  public TimeStampResp(PKIStatusInfo paramPKIStatusInfo, ContentInfo paramContentInfo)
  {
    this.pkiStatusInfo = paramPKIStatusInfo;
    this.timeStampToken = paramContentInfo;
  }
  
  public static TimeStampResp getInstance(Object paramObject)
  {
    if ((paramObject instanceof TimeStampResp)) {
      return (TimeStampResp)paramObject;
    }
    if (paramObject != null) {
      return new TimeStampResp(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public PKIStatusInfo getStatus()
  {
    return this.pkiStatusInfo;
  }
  
  public ContentInfo getTimeStampToken()
  {
    return this.timeStampToken;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.pkiStatusInfo);
    ContentInfo localContentInfo = this.timeStampToken;
    if (localContentInfo != null) {
      localASN1EncodableVector.add(localContentInfo);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\tsp\TimeStampResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */