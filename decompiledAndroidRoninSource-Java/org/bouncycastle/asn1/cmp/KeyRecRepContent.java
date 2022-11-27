package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class KeyRecRepContent
  extends ASN1Object
{
  private ASN1Sequence caCerts;
  private ASN1Sequence keyPairHist;
  private CMPCertificate newSigCert;
  private PKIStatusInfo status;
  
  private KeyRecRepContent(ASN1Sequence paramASN1Sequence)
  {
    Object localObject = paramASN1Sequence.getObjects();
    this.status = PKIStatusInfo.getInstance(((Enumeration)localObject).nextElement());
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
      int i = paramASN1Sequence.getTagNo();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            this.keyPairHist = ASN1Sequence.getInstance(paramASN1Sequence.getObject());
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag number: ");
            ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else {
          this.caCerts = ASN1Sequence.getInstance(paramASN1Sequence.getObject());
        }
      }
      else {
        this.newSigCert = CMPCertificate.getInstance(paramASN1Sequence.getObject());
      }
    }
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  public static KeyRecRepContent getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeyRecRepContent)) {
      return (KeyRecRepContent)paramObject;
    }
    if (paramObject != null) {
      return new KeyRecRepContent(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CMPCertificate[] getCaCerts()
  {
    Object localObject = this.caCerts;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CMPCertificate[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = CMPCertificate.getInstance(this.caCerts.getObjectAt(i));
      i += 1;
    }
    return (CMPCertificate[])localObject;
  }
  
  public CertifiedKeyPair[] getKeyPairHist()
  {
    Object localObject = this.keyPairHist;
    if (localObject == null) {
      return null;
    }
    int j = ((ASN1Sequence)localObject).size();
    localObject = new CertifiedKeyPair[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = CertifiedKeyPair.getInstance(this.keyPairHist.getObjectAt(i));
      i += 1;
    }
    return (CertifiedKeyPair[])localObject;
  }
  
  public CMPCertificate getNewSigCert()
  {
    return this.newSigCert;
  }
  
  public PKIStatusInfo getStatus()
  {
    return this.status;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.status);
    addOptional(localASN1EncodableVector, 0, this.newSigCert);
    addOptional(localASN1EncodableVector, 1, this.caCerts);
    addOptional(localASN1EncodableVector, 2, this.keyPairHist);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\KeyRecRepContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */