package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OriginatorPublicKey
  extends ASN1Object
{
  private AlgorithmIdentifier algorithm;
  private DERBitString publicKey;
  
  public OriginatorPublicKey(ASN1Sequence paramASN1Sequence)
  {
    this.algorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    this.publicKey = ((DERBitString)paramASN1Sequence.getObjectAt(1));
  }
  
  public OriginatorPublicKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.algorithm = paramAlgorithmIdentifier;
    this.publicKey = new DERBitString(paramArrayOfByte);
  }
  
  public static OriginatorPublicKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof OriginatorPublicKey)) {
      return (OriginatorPublicKey)paramObject;
    }
    if (paramObject != null) {
      return new OriginatorPublicKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static OriginatorPublicKey getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getAlgorithm()
  {
    return this.algorithm;
  }
  
  public DERBitString getPublicKey()
  {
    return this.publicKey;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.algorithm);
    localASN1EncodableVector.add(this.publicKey);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cms\OriginatorPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */