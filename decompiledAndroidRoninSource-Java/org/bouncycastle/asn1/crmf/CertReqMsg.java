package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class CertReqMsg
  extends ASN1Object
{
  private CertRequest certReq;
  private ProofOfPossession pop;
  private ASN1Sequence regInfo;
  
  private CertReqMsg(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.certReq = CertRequest.getInstance(paramASN1Sequence.nextElement());
    while (paramASN1Sequence.hasMoreElements())
    {
      Object localObject = paramASN1Sequence.nextElement();
      if ((!(localObject instanceof ASN1TaggedObject)) && (!(localObject instanceof ProofOfPossession))) {
        this.regInfo = ASN1Sequence.getInstance(localObject);
      } else {
        this.pop = ProofOfPossession.getInstance(localObject);
      }
    }
  }
  
  public CertReqMsg(CertRequest paramCertRequest, ProofOfPossession paramProofOfPossession, AttributeTypeAndValue[] paramArrayOfAttributeTypeAndValue)
  {
    if (paramCertRequest != null)
    {
      this.certReq = paramCertRequest;
      this.pop = paramProofOfPossession;
      if (paramArrayOfAttributeTypeAndValue != null) {
        this.regInfo = new DERSequence(paramArrayOfAttributeTypeAndValue);
      }
      return;
    }
    throw new IllegalArgumentException("'certReq' cannot be null");
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(paramASN1Encodable);
    }
  }
  
  public static CertReqMsg getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertReqMsg)) {
      return (CertReqMsg)paramObject;
    }
    if (paramObject != null) {
      return new CertReqMsg(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static CertReqMsg getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public CertRequest getCertReq()
  {
    return this.certReq;
  }
  
  public ProofOfPossession getPop()
  {
    return this.pop;
  }
  
  public ProofOfPossession getPopo()
  {
    return this.pop;
  }
  
  public AttributeTypeAndValue[] getRegInfo()
  {
    Object localObject = this.regInfo;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new AttributeTypeAndValue[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = AttributeTypeAndValue.getInstance(this.regInfo.getObjectAt(i));
      i += 1;
    }
    return (AttributeTypeAndValue[])localObject;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.certReq);
    addOptional(localASN1EncodableVector, this.pop);
    addOptional(localASN1EncodableVector, this.regInfo);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\CertReqMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */