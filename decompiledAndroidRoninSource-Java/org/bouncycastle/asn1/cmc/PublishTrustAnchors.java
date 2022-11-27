package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PublishTrustAnchors
  extends ASN1Object
{
  private final ASN1Sequence anchorHashes;
  private final AlgorithmIdentifier hashAlgorithm;
  private final ASN1Integer seqNumber;
  
  public PublishTrustAnchors(BigInteger paramBigInteger, AlgorithmIdentifier paramAlgorithmIdentifier, byte[][] paramArrayOfByte)
  {
    this.seqNumber = new ASN1Integer(paramBigInteger);
    this.hashAlgorithm = paramAlgorithmIdentifier;
    paramBigInteger = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      paramBigInteger.add(new DEROctetString(Arrays.clone(paramArrayOfByte[i])));
      i += 1;
    }
    this.anchorHashes = new DERSequence(paramBigInteger);
  }
  
  private PublishTrustAnchors(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.seqNumber = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
      this.hashAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.anchorHashes = ASN1Sequence.getInstance(paramASN1Sequence.getObjectAt(2));
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public static PublishTrustAnchors getInstance(Object paramObject)
  {
    if ((paramObject instanceof PublishTrustAnchors)) {
      return (PublishTrustAnchors)paramObject;
    }
    if (paramObject != null) {
      return new PublishTrustAnchors(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[][] getAnchorHashes()
  {
    int j = this.anchorHashes.size();
    byte[][] arrayOfByte = new byte[j][];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = Arrays.clone(ASN1OctetString.getInstance(this.anchorHashes.getObjectAt(i)).getOctets());
      i += 1;
    }
    return arrayOfByte;
  }
  
  public AlgorithmIdentifier getHashAlgorithm()
  {
    return this.hashAlgorithm;
  }
  
  public BigInteger getSeqNumber()
  {
    return this.seqNumber.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.seqNumber);
    localASN1EncodableVector.add(this.hashAlgorithm);
    localASN1EncodableVector.add(this.anchorHashes);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\PublishTrustAnchors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */