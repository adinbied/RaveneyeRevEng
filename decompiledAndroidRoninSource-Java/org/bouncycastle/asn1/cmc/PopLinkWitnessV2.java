package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Arrays;

public class PopLinkWitnessV2
  extends ASN1Object
{
  private final AlgorithmIdentifier keyGenAlgorithm;
  private final AlgorithmIdentifier macAlgorithm;
  private final byte[] witness;
  
  private PopLinkWitnessV2(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      this.keyGenAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.macAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      this.witness = Arrays.clone(ASN1OctetString.getInstance(paramASN1Sequence.getObjectAt(2)).getOctets());
      return;
    }
    throw new IllegalArgumentException("incorrect sequence size");
  }
  
  public PopLinkWitnessV2(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
  {
    this.keyGenAlgorithm = paramAlgorithmIdentifier1;
    this.macAlgorithm = paramAlgorithmIdentifier2;
    this.witness = Arrays.clone(paramArrayOfByte);
  }
  
  public static PopLinkWitnessV2 getInstance(Object paramObject)
  {
    if ((paramObject instanceof PopLinkWitnessV2)) {
      return (PopLinkWitnessV2)paramObject;
    }
    if (paramObject != null) {
      return new PopLinkWitnessV2(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getKeyGenAlgorithm()
  {
    return this.keyGenAlgorithm;
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
  {
    return this.macAlgorithm;
  }
  
  public byte[] getWitness()
  {
    return Arrays.clone(this.witness);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyGenAlgorithm);
    localASN1EncodableVector.add(this.macAlgorithm);
    localASN1EncodableVector.add(new DEROctetString(getWitness()));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\PopLinkWitnessV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */