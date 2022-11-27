package org.bouncycastle.asn1.eac;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;

public class UnsignedInteger
  extends ASN1Object
{
  private int tagNo;
  private BigInteger value;
  
  public UnsignedInteger(int paramInt, BigInteger paramBigInteger)
  {
    this.tagNo = paramInt;
    this.value = paramBigInteger;
  }
  
  private UnsignedInteger(ASN1TaggedObject paramASN1TaggedObject)
  {
    this.tagNo = paramASN1TaggedObject.getTagNo();
    this.value = new BigInteger(1, ASN1OctetString.getInstance(paramASN1TaggedObject, false).getOctets());
  }
  
  private byte[] convertValue()
  {
    byte[] arrayOfByte1 = this.value.toByteArray();
    if (arrayOfByte1[0] == 0)
    {
      int i = arrayOfByte1.length - 1;
      byte[] arrayOfByte2 = new byte[i];
      System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, i);
      return arrayOfByte2;
    }
    return arrayOfByte1;
  }
  
  public static UnsignedInteger getInstance(Object paramObject)
  {
    if ((paramObject instanceof UnsignedInteger)) {
      return (UnsignedInteger)paramObject;
    }
    if (paramObject != null) {
      return new UnsignedInteger(ASN1TaggedObject.getInstance(paramObject));
    }
    return null;
  }
  
  public int getTagNo()
  {
    return this.tagNo;
  }
  
  public BigInteger getValue()
  {
    return this.value;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERTaggedObject(false, this.tagNo, new DEROctetString(convertValue()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\UnsignedInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */