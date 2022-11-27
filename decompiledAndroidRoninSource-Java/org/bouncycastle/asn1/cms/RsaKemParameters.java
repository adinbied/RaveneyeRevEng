package org.bouncycastle.asn1.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class RsaKemParameters
  extends ASN1Object
{
  private final AlgorithmIdentifier keyDerivationFunction;
  private final BigInteger keyLength;
  
  private RsaKemParameters(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2)
    {
      this.keyDerivationFunction = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      this.keyLength = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(1)).getValue();
      return;
    }
    throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
  }
  
  public RsaKemParameters(AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt)
  {
    this.keyDerivationFunction = paramAlgorithmIdentifier;
    this.keyLength = BigInteger.valueOf(paramInt);
  }
  
  public static RsaKemParameters getInstance(Object paramObject)
  {
    if ((paramObject instanceof RsaKemParameters)) {
      return (RsaKemParameters)paramObject;
    }
    if (paramObject != null) {
      return new RsaKemParameters(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public AlgorithmIdentifier getKeyDerivationFunction()
  {
    return this.keyDerivationFunction;
  }
  
  public BigInteger getKeyLength()
  {
    return this.keyLength;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.keyDerivationFunction);
    localASN1EncodableVector.add(new ASN1Integer(this.keyLength));
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\RsaKemParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */