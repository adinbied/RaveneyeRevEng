package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class GenericHybridParameters
  extends ASN1Object
{
  private final AlgorithmIdentifier dem;
  private final AlgorithmIdentifier kem;
  
  private GenericHybridParameters(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.kem = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.dem = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
      return;
    }
    throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
  }
  
  public GenericHybridParameters(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    this.kem = paramAlgorithmIdentifier1;
    this.dem = paramAlgorithmIdentifier2;
  }
  
  public static GenericHybridParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof GenericHybridParameters)) {
      return (GenericHybridParameters)paramObject;
    }
    if (paramObject != null) {
      return new GenericHybridParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getDem()
  {
    return this.dem;
  }
  
  public AlgorithmIdentifier getKem()
  {
    return this.kem;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.kem);
    localASN1EncodableVector.add(this.dem);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\GenericHybridParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */