package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificate
  extends ASN1Object
{
  AttributeCertificateInfo acinfo;
  AlgorithmIdentifier signatureAlgorithm;
  DERBitString signatureValue;
  
  public AttributeCertificate(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.acinfo = AttributeCertificateInfo.getInstance(paramASN1Sequence.getObjectAt(0));
      this.signatureAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.signatureValue = DERBitString.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public AttributeCertificate(AttributeCertificateInfo paramAttributeCertificateInfo, AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString)
  {
    this.acinfo = paramAttributeCertificateInfo;
    this.signatureAlgorithm = paramAlgorithmIdentifier;
    this.signatureValue = paramDERBitString;
  }
  
  public static AttributeCertificate getInstance(Object paramObject)
  {
    if ((paramObject instanceof AttributeCertificate)) {
      return (AttributeCertificate)paramObject;
    }
    if (paramObject != null) {
      return new AttributeCertificate(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AttributeCertificateInfo getAcinfo()
  {
    return this.acinfo;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.signatureAlgorithm;
  }
  
  public DERBitString getSignatureValue()
  {
    return this.signatureValue;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.acinfo);
    localASN1EncodableVector.add(this.signatureAlgorithm);
    localASN1EncodableVector.add(this.signatureValue);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AttributeCertificate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */