package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

public class ObjectDigestInfo
  extends ASN1Object
{
  public static final int otherObjectDigest = 2;
  public static final int publicKey = 0;
  public static final int publicKeyCert = 1;
  AlgorithmIdentifier digestAlgorithm;
  ASN1Enumerated digestedObjectType;
  DERBitString objectDigest;
  ASN1ObjectIdentifier otherObjectTypeID;
  
  public ObjectDigestInfo(int paramInt, ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.digestedObjectType = new ASN1Enumerated(paramInt);
    if (paramInt == 2) {
      this.otherObjectTypeID = paramASN1ObjectIdentifier;
    }
    this.digestAlgorithm = paramAlgorithmIdentifier;
    this.objectDigest = new DERBitString(paramArrayOfByte);
  }
  
  private ObjectDigestInfo(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.size() <= 4) && (paramASN1Sequence.size() >= 3))
    {
      int i = 0;
      this.digestedObjectType = ASN1Enumerated.getInstance(paramASN1Sequence.getObjectAt(0));
      if (paramASN1Sequence.size() == 4)
      {
        this.otherObjectTypeID = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
        i = 1;
      }
      this.digestAlgorithm = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(i + 1));
      this.objectDigest = DERBitString.getInstance(paramASN1Sequence.getObjectAt(i + 2));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static ObjectDigestInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof ObjectDigestInfo)) {
      return (ObjectDigestInfo)paramObject;
    }
    if (paramObject != null) {
      return new ObjectDigestInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ObjectDigestInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digestAlgorithm;
  }
  
  public ASN1Enumerated getDigestedObjectType()
  {
    return this.digestedObjectType;
  }
  
  public DERBitString getObjectDigest()
  {
    return this.objectDigest;
  }
  
  public ASN1ObjectIdentifier getOtherObjectTypeID()
  {
    return this.otherObjectTypeID;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.digestedObjectType);
    ASN1ObjectIdentifier localASN1ObjectIdentifier = this.otherObjectTypeID;
    if (localASN1ObjectIdentifier != null) {
      localASN1EncodableVector.add(localASN1ObjectIdentifier);
    }
    localASN1EncodableVector.add(this.digestAlgorithm);
    localASN1EncodableVector.add(this.objectDigest);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\ObjectDigestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */