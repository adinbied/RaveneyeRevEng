package org.bouncycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;

public class ECPrivateKey
  extends ASN1Object
{
  private ASN1Sequence seq;
  
  public ECPrivateKey(int paramInt, BigInteger paramBigInteger)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray((paramInt + 7) / 8, paramBigInteger);
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(1L));
    localASN1EncodableVector.add(new DEROctetString(paramBigInteger));
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  public ECPrivateKey(int paramInt, BigInteger paramBigInteger, ASN1Encodable paramASN1Encodable)
  {
    this(paramInt, paramBigInteger, null, paramASN1Encodable);
  }
  
  public ECPrivateKey(int paramInt, BigInteger paramBigInteger, DERBitString paramDERBitString, ASN1Encodable paramASN1Encodable)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray((paramInt + 7) / 8, paramBigInteger);
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(1L));
    localASN1EncodableVector.add(new DEROctetString(paramBigInteger));
    if (paramASN1Encodable != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 0, paramASN1Encodable));
    }
    if (paramDERBitString != null) {
      localASN1EncodableVector.add(new DERTaggedObject(true, 1, paramDERBitString));
    }
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  public ECPrivateKey(BigInteger paramBigInteger)
  {
    this(paramBigInteger.bitLength(), paramBigInteger);
  }
  
  public ECPrivateKey(BigInteger paramBigInteger, ASN1Encodable paramASN1Encodable)
  {
    this(paramBigInteger, null, paramASN1Encodable);
  }
  
  public ECPrivateKey(BigInteger paramBigInteger, DERBitString paramDERBitString, ASN1Encodable paramASN1Encodable)
  {
    this(paramBigInteger.bitLength(), paramBigInteger, paramDERBitString, paramASN1Encodable);
  }
  
  private ECPrivateKey(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
  }
  
  public static ECPrivateKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof ECPrivateKey)) {
      return (ECPrivateKey)paramObject;
    }
    if (paramObject != null) {
      return new ECPrivateKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  private ASN1Primitive getObjectInTag(int paramInt)
  {
    Enumeration localEnumeration = this.seq.getObjects();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (ASN1Encodable)localEnumeration.nextElement();
      if ((localObject instanceof ASN1TaggedObject))
      {
        localObject = (ASN1TaggedObject)localObject;
        if (((ASN1TaggedObject)localObject).getTagNo() == paramInt) {
          return ((ASN1TaggedObject)localObject).getObject().toASN1Primitive();
        }
      }
    }
    return null;
  }
  
  public BigInteger getKey()
  {
    return new BigInteger(1, ((ASN1OctetString)this.seq.getObjectAt(1)).getOctets());
  }
  
  public ASN1Primitive getParameters()
  {
    return getObjectInTag(0);
  }
  
  public DERBitString getPublicKey()
  {
    return (DERBitString)getObjectInTag(1);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.seq;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\sec\ECPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */