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

public class ECPrivateKeyStructure
  extends ASN1Object
{
  private ASN1Sequence seq;
  
  public ECPrivateKeyStructure(BigInteger paramBigInteger)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray(paramBigInteger);
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(1L));
    localASN1EncodableVector.add(new DEROctetString(paramBigInteger));
    this.seq = new DERSequence(localASN1EncodableVector);
  }
  
  public ECPrivateKeyStructure(BigInteger paramBigInteger, ASN1Encodable paramASN1Encodable)
  {
    this(paramBigInteger, null, paramASN1Encodable);
  }
  
  public ECPrivateKeyStructure(BigInteger paramBigInteger, DERBitString paramDERBitString, ASN1Encodable paramASN1Encodable)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray(paramBigInteger);
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
  
  public ECPrivateKeyStructure(ASN1Sequence paramASN1Sequence)
  {
    this.seq = paramASN1Sequence;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\sec\ECPrivateKeyStructure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */