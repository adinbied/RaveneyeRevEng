package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class SCVPReqRes
  extends ASN1Object
{
  private final ContentInfo request;
  private final ContentInfo response;
  
  private SCVPReqRes(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject))
    {
      this.request = ContentInfo.getInstance(ASN1TaggedObject.getInstance(paramASN1Sequence.getObjectAt(0)), true);
      paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
    }
    else
    {
      this.request = null;
      paramASN1Sequence = paramASN1Sequence.getObjectAt(0);
    }
    this.response = ContentInfo.getInstance(paramASN1Sequence);
  }
  
  public SCVPReqRes(ContentInfo paramContentInfo)
  {
    this.request = null;
    this.response = paramContentInfo;
  }
  
  public SCVPReqRes(ContentInfo paramContentInfo1, ContentInfo paramContentInfo2)
  {
    this.request = paramContentInfo1;
    this.response = paramContentInfo2;
  }
  
  public static SCVPReqRes getInstance(Object paramObject)
  {
    if ((paramObject instanceof SCVPReqRes)) {
      return (SCVPReqRes)paramObject;
    }
    if (paramObject != null) {
      return new SCVPReqRes(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ContentInfo getRequest()
  {
    return this.request;
  }
  
  public ContentInfo getResponse()
  {
    return this.response;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ContentInfo localContentInfo = this.request;
    if (localContentInfo != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, localContentInfo));
    }
    localASN1EncodableVector.add(this.response);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\SCVPReqRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */