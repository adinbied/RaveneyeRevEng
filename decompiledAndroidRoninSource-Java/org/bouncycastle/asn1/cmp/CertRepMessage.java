package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertRepMessage
  extends ASN1Object
{
  private ASN1Sequence caPubs;
  private ASN1Sequence response;
  
  private CertRepMessage(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    int i = 1;
    if (j > 1) {
      this.caPubs = ASN1Sequence.getInstance((ASN1TaggedObject)paramASN1Sequence.getObjectAt(0), true);
    } else {
      i = 0;
    }
    this.response = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(i));
  }
  
  public CertRepMessage(CMPCertificate[] paramArrayOfCMPCertificate, CertResponse[] paramArrayOfCertResponse)
  {
    if (paramArrayOfCertResponse != null)
    {
      int j = 0;
      if (paramArrayOfCMPCertificate != null)
      {
        ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
        i = 0;
        while (i < paramArrayOfCMPCertificate.length)
        {
          localASN1EncodableVector.add(paramArrayOfCMPCertificate[i]);
          i += 1;
        }
        this.caPubs = new DERSequence(localASN1EncodableVector);
      }
      paramArrayOfCMPCertificate = new ASN1EncodableVector();
      int i = j;
      while (i < paramArrayOfCertResponse.length)
      {
        paramArrayOfCMPCertificate.add(paramArrayOfCertResponse[i]);
        i += 1;
      }
      this.response = new DERSequence(paramArrayOfCMPCertificate);
      return;
    }
    throw new IllegalArgumentException("'response' cannot be null");
  }
  
  public static CertRepMessage getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertRepMessage)) {
      return (CertRepMessage)paramObject;
    }
    if (paramObject != null) {
      return new CertRepMessage(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CMPCertificate[] getCaPubs()
  {
    Object localObject = this.caPubs;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CMPCertificate[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = CMPCertificate.getInstance(this.caPubs.getObjectAt(i));
      i += 1;
    }
    return (CMPCertificate[])localObject;
  }
  
  public CertResponse[] getResponse()
  {
    int j = this.response.size();
    CertResponse[] arrayOfCertResponse = new CertResponse[j];
    int i = 0;
    while (i != j)
    {
      arrayOfCertResponse[i] = CertResponse.getInstance(this.response.getObjectAt(i));
      i += 1;
    }
    return arrayOfCertResponse;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ASN1Sequence localASN1Sequence = this.caPubs;
    if (localASN1Sequence != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, localASN1Sequence));
    }
    localASN1EncodableVector.add(this.response);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\CertRepMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */