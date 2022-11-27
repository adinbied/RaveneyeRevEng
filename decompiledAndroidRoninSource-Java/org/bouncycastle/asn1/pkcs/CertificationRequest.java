package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest
  extends ASN1Object
{
  protected CertificationRequestInfo reqInfo = null;
  protected AlgorithmIdentifier sigAlgId = null;
  protected DERBitString sigBits = null;
  
  protected CertificationRequest() {}
  
  public CertificationRequest(ASN1Sequence paramASN1Sequence)
  {
    this.reqInfo = CertificationRequestInfo.getInstance(paramASN1Sequence.getObjectAt(0));
    this.sigAlgId = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
    this.sigBits = ((DERBitString)paramASN1Sequence.getObjectAt(2));
  }
  
  public CertificationRequest(CertificationRequestInfo paramCertificationRequestInfo, AlgorithmIdentifier paramAlgorithmIdentifier, DERBitString paramDERBitString)
  {
    this.reqInfo = paramCertificationRequestInfo;
    this.sigAlgId = paramAlgorithmIdentifier;
    this.sigBits = paramDERBitString;
  }
  
  public static CertificationRequest getInstance(Object paramObject)
  {
    if ((paramObject instanceof CertificationRequest)) {
      return (CertificationRequest)paramObject;
    }
    if (paramObject != null) {
      return new CertificationRequest(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertificationRequestInfo getCertificationRequestInfo()
  {
    return this.reqInfo;
  }
  
  public DERBitString getSignature()
  {
    return this.sigBits;
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.sigAlgId;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.reqInfo);
    localASN1EncodableVector.add(this.sigAlgId);
    localASN1EncodableVector.add(this.sigBits);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */