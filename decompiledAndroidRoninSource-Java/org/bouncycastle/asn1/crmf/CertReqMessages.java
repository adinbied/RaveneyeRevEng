package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class CertReqMessages
  extends ASN1Object
{
  private ASN1Sequence content;
  
  private CertReqMessages(ASN1Sequence paramASN1Sequence)
  {
    this.content = paramASN1Sequence;
  }
  
  public CertReqMessages(CertReqMsg paramCertReqMsg)
  {
    this.content = new DERSequence(paramCertReqMsg);
  }
  
  public CertReqMessages(CertReqMsg[] paramArrayOfCertReqMsg)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfCertReqMsg.length)
    {
      localASN1EncodableVector.add(paramArrayOfCertReqMsg[i]);
      i += 1;
    }
    this.content = new DERSequence(localASN1EncodableVector);
  }
  
  public static CertReqMessages getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertReqMessages)) {
      return (CertReqMessages)paramObject;
    }
    if (paramObject != null) {
      return new CertReqMessages(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.content;
  }
  
  public CertReqMsg[] toCertReqMsgArray()
  {
    int j = this.content.size();
    CertReqMsg[] arrayOfCertReqMsg = new CertReqMsg[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertReqMsg[i] = CertReqMsg.getInstance(this.content.getObjectAt(i));
      i += 1;
    }
    return arrayOfCertReqMsg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CertReqMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */