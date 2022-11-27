package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DHParameter
  extends ASN1Object
{
  ASN1Integer g;
  ASN1Integer l;
  ASN1Integer p;
  
  public DHParameter(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    this.p = new ASN1Integer(paramBigInteger1);
    this.g = new ASN1Integer(paramBigInteger2);
    if (paramInt != 0) {
      paramBigInteger1 = new ASN1Integer(paramInt);
    } else {
      paramBigInteger1 = null;
    }
    this.l = paramBigInteger1;
  }
  
  private DHParameter(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.p = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
    this.g = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
    if (paramASN1Sequence.hasMoreElements()) {
      paramASN1Sequence = (ASN1Integer)paramASN1Sequence.nextElement();
    } else {
      paramASN1Sequence = null;
    }
    this.l = paramASN1Sequence;
  }
  
  public static DHParameter getInstance(Object paramObject)
  {
    if ((paramObject instanceof DHParameter)) {
      return (DHParameter)paramObject;
    }
    if (paramObject != null) {
      return new DHParameter(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getG()
  {
    return this.g.getPositiveValue();
  }
  
  public BigInteger getL()
  {
    ASN1Integer localASN1Integer = this.l;
    if (localASN1Integer == null) {
      return null;
    }
    return localASN1Integer.getPositiveValue();
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
    if (getL() != null) {
      localASN1EncodableVector.add(this.l);
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\pkcs\DHParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */