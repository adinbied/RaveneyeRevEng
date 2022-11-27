package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class ASN1Integer
  extends ASN1Primitive
{
  private final byte[] bytes;
  
  public ASN1Integer(long paramLong)
  {
    this.bytes = BigInteger.valueOf(paramLong).toByteArray();
  }
  
  public ASN1Integer(BigInteger paramBigInteger)
  {
    this.bytes = paramBigInteger.toByteArray();
  }
  
  public ASN1Integer(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, true);
  }
  
  ASN1Integer(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte.length > 1)
    {
      if ((paramArrayOfByte[0] == 0) && ((paramArrayOfByte[1] & 0x80) == 0)) {
        throw new IllegalArgumentException("malformed integer");
      }
      if ((paramArrayOfByte[0] == -1) && ((paramArrayOfByte[1] & 0x80) != 0)) {
        throw new IllegalArgumentException("malformed integer");
      }
    }
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramBoolean) {
      arrayOfByte = Arrays.clone(paramArrayOfByte);
    }
    this.bytes = arrayOfByte;
  }
  
  public static ASN1Integer getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1Integer)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (ASN1Integer)fromByteArray((byte[])paramObject);
          return (ASN1Integer)paramObject;
        }
        catch (Exception paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoding error in getInstance: ");
          localStringBuilder.append(((Exception)paramObject).toString());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ASN1Integer)paramObject;
  }
  
  public static ASN1Integer getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    ASN1Primitive localASN1Primitive = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(localASN1Primitive instanceof ASN1Integer))) {
      return new ASN1Integer(ASN1OctetString.getInstance(paramASN1TaggedObject.getObject()).getOctets());
    }
    return getInstance(localASN1Primitive);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1Integer)) {
      return false;
    }
    paramASN1Primitive = (ASN1Integer)paramASN1Primitive;
    return Arrays.areEqual(this.bytes, paramASN1Primitive.bytes);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(2, this.bytes);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
  }
  
  public BigInteger getPositiveValue()
  {
    return new BigInteger(1, this.bytes);
  }
  
  public BigInteger getValue()
  {
    return new BigInteger(this.bytes);
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.bytes;
      if (i == arrayOfByte.length) {
        break;
      }
      j ^= (arrayOfByte[i] & 0xFF) << i % 4;
      i += 1;
    }
    return j;
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public String toString()
  {
    return getValue().toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Integer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */