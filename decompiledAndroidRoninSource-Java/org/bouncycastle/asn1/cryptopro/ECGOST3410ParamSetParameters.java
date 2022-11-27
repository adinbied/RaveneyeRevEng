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

public class ECGOST3410ParamSetParameters
  extends ASN1Object
{
  ASN1Integer a;
  ASN1Integer b;
  ASN1Integer p;
  ASN1Integer q;
  ASN1Integer x;
  ASN1Integer y;
  
  public ECGOST3410ParamSetParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, int paramInt, BigInteger paramBigInteger5)
  {
    this.a = new ASN1Integer(paramBigInteger1);
    this.b = new ASN1Integer(paramBigInteger2);
    this.p = new ASN1Integer(paramBigInteger3);
    this.q = new ASN1Integer(paramBigInteger4);
    this.x = new ASN1Integer(paramInt);
    this.y = new ASN1Integer(paramBigInteger5);
  }
  
  public ECGOST3410ParamSetParameters(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.a = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.b = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.p = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.q = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.x = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.y = ((ASN1Integer)paramASN1Sequence.nextElement());
  }
  
  public static ECGOST3410ParamSetParameters getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ECGOST3410ParamSetParameters)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new ECGOST3410ParamSetParameters((ASN1Sequence)paramObject);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid GOST3410Parameter: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ECGOST3410ParamSetParameters)paramObject;
  }
  
  public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getA()
  {
    return this.a.getPositiveValue();
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
    localASN1EncodableVector.add(this.a);
    localASN1EncodableVector.add(this.b);
    localASN1EncodableVector.add(this.p);
    localASN1EncodableVector.add(this.q);
    localASN1EncodableVector.add(this.x);
    localASN1EncodableVector.add(this.y);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cryptopro\ECGOST3410ParamSetParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */