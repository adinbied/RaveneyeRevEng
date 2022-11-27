package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class CRLNumber
  extends ASN1Object
{
  private BigInteger number;
  
  public CRLNumber(BigInteger paramBigInteger)
  {
    this.number = paramBigInteger;
  }
  
  public static CRLNumber getInstance(Object paramObject)
  {
    if ((paramObject instanceof CRLNumber)) {
      return (CRLNumber)paramObject;
    }
    if (paramObject != null) {
      return new CRLNumber(ASN1Integer.getInstance(paramObject).getValue());
    }
    return null;
  }
  
  public BigInteger getCRLNumber()
  {
    return this.number;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new ASN1Integer(this.number);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CRLNumber: ");
    localStringBuilder.append(getCRLNumber());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CRLNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */