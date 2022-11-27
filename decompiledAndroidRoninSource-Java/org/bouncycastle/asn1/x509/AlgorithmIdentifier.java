package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class AlgorithmIdentifier
  extends ASN1Object
{
  private ASN1ObjectIdentifier algorithm;
  private ASN1Encodable parameters;
  
  public AlgorithmIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.algorithm = paramASN1ObjectIdentifier;
  }
  
  public AlgorithmIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.algorithm = paramASN1ObjectIdentifier;
    this.parameters = paramASN1Encodable;
  }
  
  private AlgorithmIdentifier(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() >= 1) && (paramASN1Sequence.size() <= 2))
    {
      this.algorithm = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() == 2) {
        paramASN1Sequence = paramASN1Sequence.getObjectAt(1);
      } else {
        paramASN1Sequence = null;
      }
      this.parameters = paramASN1Sequence;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static AlgorithmIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof AlgorithmIdentifier)) {
      return (AlgorithmIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new AlgorithmIdentifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static AlgorithmIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public ASN1ObjectIdentifier getAlgorithm()
  {
    return this.algorithm;
  }
  
  public ASN1Encodable getParameters()
  {
    return this.parameters;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algorithm);
    ASN1Encodable localASN1Encodable = this.parameters;
    if (localASN1Encodable != null) {
      localASN1EncodableVector.add(localASN1Encodable);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AlgorithmIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */