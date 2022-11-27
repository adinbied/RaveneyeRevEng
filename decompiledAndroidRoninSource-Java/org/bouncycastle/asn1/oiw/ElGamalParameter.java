package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter
  extends ASN1Object
{
  ASN1Integer g;
  ASN1Integer p;
  
  public ElGamalParameter(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.p = new ASN1Integer(paramBigInteger1);
    this.g = new ASN1Integer(paramBigInteger2);
  }
  
  private ElGamalParameter(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.p = ((ASN1Integer)paramASN1Sequence.nextElement());
    this.g = ((ASN1Integer)paramASN1Sequence.nextElement());
  }
  
  public static ElGamalParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof ElGamalParameter)) {
      return (ElGamalParameter)paramObject;
    }
    if (paramObject != null) {
      return new ElGamalParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getG()
  {
    return this.g.getPositiveValue();
  }
  
  public BigInteger getP()
  {
    return this.p.getPositiveValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.p);
    localASN1EncodableVector.add(this.g);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\oiw\ElGamalParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */