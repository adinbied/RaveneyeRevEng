package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECFieldElement.F2m;
import org.bouncycastle.math.ec.ECFieldElement.Fp;

public class X9FieldElement
  extends ASN1Object
{
  private static X9IntegerConverter converter = new X9IntegerConverter();
  protected ECFieldElement f;
  
  public X9FieldElement(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ASN1OctetString paramASN1OctetString)
  {
    this(new ECFieldElement.F2m(paramInt1, paramInt2, paramInt3, paramInt4, new BigInteger(1, paramASN1OctetString.getOctets())));
  }
  
  public X9FieldElement(BigInteger paramBigInteger, ASN1OctetString paramASN1OctetString)
  {
    this(new ECFieldElement.Fp(paramBigInteger, new BigInteger(1, paramASN1OctetString.getOctets())));
  }
  
  public X9FieldElement(ECFieldElement paramECFieldElement)
  {
    this.f = paramECFieldElement;
  }
  
  public ECFieldElement getValue()
  {
    return this.f;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    int i = converter.getByteLength(this.f);
    return new DEROctetString(converter.integerToBytes(this.f.toBigInteger(), i));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */