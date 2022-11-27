package org.bouncycastle.asn1.isismtt.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

public class MonetaryLimit
  extends ASN1Object
{
  ASN1Integer amount;
  DERPrintableString currency;
  ASN1Integer exponent;
  
  public MonetaryLimit(String paramString, int paramInt1, int paramInt2)
  {
    this.currency = new DERPrintableString(paramString, true);
    this.amount = new ASN1Integer(paramInt1);
    this.exponent = new ASN1Integer(paramInt2);
  }
  
  private MonetaryLimit(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 3)
    {
      paramASN1Sequence = paramASN1Sequence.getObjects();
      this.currency = DERPrintableString.getInstance(paramASN1Sequence.nextElement());
      this.amount = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      this.exponent = ASN1Integer.getInstance(paramASN1Sequence.nextElement());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad sequence size: ");
    localStringBuilder.append(paramASN1Sequence.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static MonetaryLimit getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof MonetaryLimit)))
    {
      if ((paramObject instanceof ASN1Sequence)) {
        return new MonetaryLimit(ASN1Sequence.getInstance(paramObject));
      }
      throw new IllegalArgumentException("unknown object in getInstance");
    }
    return (MonetaryLimit)paramObject;
  }
  
  public BigInteger getAmount()
  {
    return this.amount.getValue();
  }
  
  public String getCurrency()
  {
    return this.currency.getString();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\MonetaryLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */