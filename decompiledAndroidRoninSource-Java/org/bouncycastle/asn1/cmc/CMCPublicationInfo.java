package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class CMCPublicationInfo
  extends ASN1Object
{
  private final ASN1Sequence certHashes;
  private final AlgorithmIdentifier hashAlg;
  private final PKIPublicationInfo pubInfo;
  
  private CMCPublicationInfo(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.hashAlg = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.certHashes = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(1));
      this.pubInfo = PKIPublicationInfo.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public CMCPublicationInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[][] paramArrayOfByte, PKIPublicationInfo paramPKIPublicationInfo)
  {
    this.hashAlg = paramAlgorithmIdentifier;
    paramAlgorithmIdentifier = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      paramAlgorithmIdentifier.add(new DEROctetString(Arrays.clone(paramArrayOfByte[i])));
      i += 1;
    }
    this.certHashes = new DERSequence(paramAlgorithmIdentifier);
    this.pubInfo = paramPKIPublicationInfo;
  }
  
  public static CMCPublicationInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCPublicationInfo)) {
      return (CMCPublicationInfo)paramObject;
    }
    if (paramObject != null) {
      return new CMCPublicationInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[][] getCertHashes()
  {
    int j = this.certHashes.size();
    byte[][] arrayOfByte = new byte[j][];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = Arrays.clone(ASN1OctetString.getInstance(this.certHashes.getObjectAt(i)).getOctets());
      i += 1;
    }
    return arrayOfByte;
  }
  
  public AlgorithmIdentifier getHashAlg()
  {
    return this.hashAlg;
  }
  
  public PKIPublicationInfo getPubInfo()
  {
    return this.pubInfo;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.hashAlg);
    localASN1EncodableVector.add(this.certHashes);
    localASN1EncodableVector.add(this.pubInfo);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCPublicationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */