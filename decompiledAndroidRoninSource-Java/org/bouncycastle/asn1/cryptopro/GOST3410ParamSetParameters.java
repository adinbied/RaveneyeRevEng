package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class GOST3410ParamSetParameters
  extends ASN1Object
{
  ASN1Integer a;
  int keySize;
  ASN1Integer p;
  ASN1Integer q;
  
  public GOST3410ParamSetParameters(int paramInt, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.keySize = paramInt;
    this.p = new ASN1Integer(paramBigInteger1);
    this.q = new ASN1Integer(paramBigInteger2);
    this.a = new ASN1Integer(paramBigInteger3);
  }
  
  public GOST3410ParamSetParameters(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.keySize = ((ASN1Integer)paramASN1Sequence.nextElement()).getValue().intValue();
    this.p = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.q = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.a = ((ASN1Integer)paramASN1Sequence.nextElement());
  }
  
  public static GOST3410ParamSetParameters getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof GOST3410ParamSetParameters)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new GOST3410ParamSetParameters((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid GOST3410Parameter: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (GOST3410ParamSetParameters)paramObject;
  }
  
  public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getA()
  {
    return this.a.getPositiveValue();
  }
  
  public int getKeySize()
  {
    return this.keySize;
  }
  
  public int getLKeySize()
  {
    return this.keySize;
  }
  
  public BigInteger getP()
  {
    return this.p.getPositiveValue();
  }
  
  public BigInteger getQ()
  {
    return this.q.getPositiveValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.keySize));
    localASN1EncodableVector.add(this.p);
    localASN1EncodableVector.add(this.q);
    localASN1EncodableVector.add(this.a);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cryptopro\GOST3410ParamSetParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */