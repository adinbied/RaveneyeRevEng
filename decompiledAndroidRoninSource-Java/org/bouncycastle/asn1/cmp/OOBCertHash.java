package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OOBCertHash
  extends ASN1Object
{
  private CertId certId;
  private AlgorithmIdentifier hashAlg;
  private DERBitString hashVal;
  
  private OOBCertHash(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size() - 1;
    int i = j - 1;
    this.hashVal = DERBitString.getInstance(paramASN1Sequence.getObjectAt(j));
    while (i >= 0)
    {
      ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(i);
      if (localASN1TaggedObject.getTagNo() == 0) {
        this.hashAlg = AlgorithmIdentifier.getInstance(localASN1TaggedObject, true);
      } else {
        this.certId = CertId.getInstance(localASN1TaggedObject, true);
      }
      i -= 1;
    }
  }
  
  public OOBCertHash(AlgorithmIdentifier paramAlgorithmIdentifier, CertId paramCertId, DERBitString paramDERBitString)
  {
    this.hashAlg = paramAlgorithmIdentifier;
    this.certId = paramCertId;
    this.hashVal = paramDERBitString;
  }
  
  public OOBCertHash(AlgorithmIdentifier paramAlgorithmIdentifier, CertId paramCertId, byte[] paramArrayOfByte)
  {
    this(paramAlgorithmIdentifier, paramCertId, new DERBitString(paramArrayOfByte));
  }
  
  private void addOptional(ASN1EncodableVector paramASN1EncodableVector, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if (paramASN1Encodable != null) {
      paramASN1EncodableVector.add(new DERTaggedObject(true, paramInt, paramASN1Encodable));
    }
  }
  
  public static OOBCertHash getInstance(Object paramObject)
  {
    if ((paramObject instanceof OOBCertHash)) {
      return (OOBCertHash)paramObject;
    }
    if (paramObject != null) {
      return new OOBCertHash(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public CertId getCertId()
  {
    return this.certId;
  }
  
  public AlgorithmIdentifier getHashAlg()
  {
    return this.hashAlg;
  }
  
  public DERBitString getHashVal()
  {
    return this.hashVal;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    addOptional(localASN1EncodableVector, 0, this.hashAlg);
    addOptional(localASN1EncodableVector, 1, this.certId);
    localASN1EncodableVector.add(this.hashVal);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmp\OOBCertHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */