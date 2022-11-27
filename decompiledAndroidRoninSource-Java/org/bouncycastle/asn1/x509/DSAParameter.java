package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class DSAParameter
  extends ASN1Object
{
  ASN1Integer g;
  ASN1Integer p;
  ASN1Integer q;
  
  public DSAParameter(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.p = new ASN1Integer(paramBigInteger1);
    this.q = new ASN1Integer(paramBigInteger2);
    this.g = new ASN1Integer(paramBigInteger3);
  }
  
  private DSAParameter(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      this.p = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      this.q = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      this.g = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static DSAParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof DSAParameter)) {
      return (DSAParameter)paramObject;
    }
    if (paramObject != null) {
      return new DSAParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DSAParameter getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public BigInteger getG()
  {
    return this.g.getPositiveValue();
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
    localASN1EncodableVector.add(this.p);
    localASN1EncodableVector.add(this.q);
    localASN1EncodableVector.add(this.g);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\DSAParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */