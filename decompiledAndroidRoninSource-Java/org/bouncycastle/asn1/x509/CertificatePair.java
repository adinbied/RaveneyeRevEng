package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertificatePair
  extends ASN1Object
{
  private Certificate forward;
  private Certificate reverse;
  
  private CertificatePair(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() != 1) && (paramASN1Sequence.size() != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Bad sequence size: ");
      ((StringBuilder)localObject).append(paramASN1Sequence.size());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = paramASN1Sequence.getObjects();
    while (((Enumeration)localObject).hasMoreElements())
    {
      paramASN1Sequence = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
      if (paramASN1Sequence.getTagNo() == 0)
      {
        this.forward = Certificate.getInstance(paramASN1Sequence, true);
      }
      else if (paramASN1Sequence.getTagNo() == 1)
      {
        this.reverse = Certificate.getInstance(paramASN1Sequence, true);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Bad tag number: ");
        ((StringBuilder)localObject).append(paramASN1Sequence.getTagNo());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public CertificatePair(Certificate paramCertificate1, Certificate paramCertificate2)
  {
    this.forward = paramCertificate1;
    this.reverse = paramCertificate2;
  }
  
  public static CertificatePair getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof CertificatePair)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new CertificatePair((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (CertificatePair)paramObject;
  }
  
  public Certificate getForward()
  {
    return this.forward;
  }
  
  public Certificate getReverse()
  {
    return this.reverse;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    if (this.forward != null) {
      localASN1EncodableVector.add(new DERTaggedObject(0, this.forward));
    }
    if (this.reverse != null) {
      localASN1EncodableVector.add(new DERTaggedObject(1, this.reverse));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CertificatePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */