package org.bouncycastle.asn1.x509.qualified;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class MonetaryValue
  extends ASN1Object
{
  private ASN1Integer amount;
  private Iso4217CurrencyCode currency;
  private ASN1Integer exponent;
  
  private MonetaryValue(ASN1Sequence paramASN1Sequence)
  {
    paramASN1Sequence = paramASN1Sequence.getObjects();
    this.currency = Iso4217CurrencyCode.getInstance(paramASN1Sequence.nextElement());
    this.amount = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
    this.exponent = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
  }
  
  public MonetaryValue(Iso4217CurrencyCode paramIso4217CurrencyCode, int paramInt1, int paramInt2)
  {
    this.currency = paramIso4217CurrencyCode;
    this.amount = new ASN1Integer(paramInt1);
    this.exponent = new ASN1Integer(paramInt2);
  }
  
  public static MonetaryValue getInstance(Object paramObject)
  {
    if ((paramObject instanceof MonetaryValue)) {
      return (MonetaryValue)paramObject;
    }
    if (paramObject != null) {
      return new MonetaryValue(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getAmount()
  {
    return this.amount.getValue();
  }
  
  public Iso4217CurrencyCode getCurrency()
  {
    return this.currency;
  }
  
  public BigInteger getExponent()
  {
    return this.exponent.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.currency);
    localASN1EncodableVector.add(this.amount);
    localASN1EncodableVector.add(this.exponent);
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\qualified\MonetaryValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */