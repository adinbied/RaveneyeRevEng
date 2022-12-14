package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMessages;
import org.bouncycastle.asn1.pkcs.CertificationRequest;

public class PKIBody
  extends ASN1Object
  implements ASN1Choice
{
  public static final int TYPE_CA_KEY_UPDATE_ANN = 15;
  public static final int TYPE_CERT_ANN = 16;
  public static final int TYPE_CERT_CONFIRM = 24;
  public static final int TYPE_CERT_REP = 3;
  public static final int TYPE_CERT_REQ = 2;
  public static final int TYPE_CONFIRM = 19;
  public static final int TYPE_CRL_ANN = 18;
  public static final int TYPE_CROSS_CERT_REP = 14;
  public static final int TYPE_CROSS_CERT_REQ = 13;
  public static final int TYPE_ERROR = 23;
  public static final int TYPE_GEN_MSG = 21;
  public static final int TYPE_GEN_REP = 22;
  public static final int TYPE_INIT_REP = 1;
  public static final int TYPE_INIT_REQ = 0;
  public static final int TYPE_KEY_RECOVERY_REP = 10;
  public static final int TYPE_KEY_RECOVERY_REQ = 9;
  public static final int TYPE_KEY_UPDATE_REP = 8;
  public static final int TYPE_KEY_UPDATE_REQ = 7;
  public static final int TYPE_NESTED = 20;
  public static final int TYPE_P10_CERT_REQ = 4;
  public static final int TYPE_POLL_REP = 26;
  public static final int TYPE_POLL_REQ = 25;
  public static final int TYPE_POPO_CHALL = 5;
  public static final int TYPE_POPO_REP = 6;
  public static final int TYPE_REVOCATION_ANN = 17;
  public static final int TYPE_REVOCATION_REP = 12;
  public static final int TYPE_REVOCATION_REQ = 11;
  private ASN1Encodable body;
  private int tagNo;
  
  public PKIBody(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    this.tagNo = paramInt;
    this.body = getBodyForType(paramInt, paramASN1Encodable);
  }
  
  private PKIBody(ASN1TaggedObject paramASN1TaggedObject)
  {
    int i = paramASN1TaggedObject.getTagNo();
    this.tagNo = i;
    this.body = getBodyForType(i, paramASN1TaggedObject.getObject());
  }
  
  private static ASN1Encodable getBodyForType(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    switch (paramInt)
    {
    default: 
      paramASN1Encodable = new StringBuilder();
      paramASN1Encodable.append("unknown tag number: ");
      paramASN1Encodable.append(paramInt);
      throw new IllegalArgumentException(paramASN1Encodable.toString());
    case 26: 
      return PollRepContent.getInstance(paramASN1Encodable);
    case 25: 
      return PollReqContent.getInstance(paramASN1Encodable);
    case 24: 
      return CertConfirmContent.getInstance(paramASN1Encodable);
    case 23: 
      return ErrorMsgContent.getInstance(paramASN1Encodable);
    case 22: 
      return GenRepContent.getInstance(paramASN1Encodable);
    case 21: 
      return GenMsgContent.getInstance(paramASN1Encodable);
    case 20: 
      return PKIMessages.getInstance(paramASN1Encodable);
    case 19: 
      return PKIConfirmContent.getInstance(paramASN1Encodable);
    case 18: 
      return CRLAnnContent.getInstance(paramASN1Encodable);
    case 17: 
      return RevAnnContent.getInstance(paramASN1Encodable);
    case 16: 
      return CMPCertificate.getInstance(paramASN1Encodable);
    case 15: 
      return CAKeyUpdAnnContent.getInstance(paramASN1Encodable);
    case 14: 
      return CertRepMessage.getInstance(paramASN1Encodable);
    case 13: 
      return CertReqMessages.getInstance(paramASN1Encodable);
    case 12: 
      return RevRepContent.getInstance(paramASN1Encodable);
    case 11: 
      return RevReqContent.getInstance(paramASN1Encodable);
    case 10: 
      return KeyRecRepContent.getInstance(paramASN1Encodable);
    case 9: 
      return CertReqMessages.getInstance(paramASN1Encodable);
    case 8: 
      return CertRepMessage.getInstance(paramASN1Encodable);
    case 7: 
      return CertReqMessages.getInstance(paramASN1Encodable);
    case 6: 
      return POPODecKeyRespContent.getInstance(paramASN1Encodable);
    case 5: 
      return POPODecKeyChallContent.getInstance(paramASN1Encodable);
    case 4: 
      return CertificationRequest.getInstance(paramASN1Encodable);
    case 3: 
      return CertRepMessage.getInstance(paramASN1Encodable);
    case 2: 
      return CertReqMessages.getInstance(paramASN1Encodable);
    case 1: 
      return CertRepMessage.getInstance(paramASN1Encodable);
    }
    return CertReqMessages.getInstance(paramASN1Encodable);
  }
  
  public static PKIBody getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof PKIBody)))
    {
      if ((paramObject instanceof ASN1TaggedObject)) {
        return new PKIBody((ASN1TaggedObject)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid object: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (PKIBody)paramObject;
  }
  
  public ASN1Encodable getContent()
  {
    return this.body;
  }
  
  public int getType()
  {
    return this.tagNo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(true, this.tagNo, this.body);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\PKIBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */