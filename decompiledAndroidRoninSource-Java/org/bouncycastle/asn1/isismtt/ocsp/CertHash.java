package org.bouncycastle.asn1.isismtt.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertHash
  extends ASN1Object
{
  private byte[] certificateHash;
  private AlgorithmIdentifier hashAlgorithm;
  
  private CertHash(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.certificateHash = DEROctetString.getInstance(paramASN1Sequence.getObjectAt(1)).getOctets();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public CertHash(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.hashAlgorithm = paramAlgorithmIdentifier;
    paramAlgorithmIdentifier = new byte[paramArrayOfByte.length];
    this.certificateHash = paramAlgorithmIdentifier;
    System.arraycopy(paramArrayOfByte, 0, paramAlgorithmIdentifier, 0, paramArrayOfByte.length);
  }
  
  public static CertHash getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof CertHash)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new CertHash((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (CertHash)paramObject;
  }
  
  public byte[] getCertificateHash()
  {
    return this.certificateHash;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(new DEROctetString(this.certificateHash));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\ocsp\CertHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */