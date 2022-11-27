package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class ASN1Enumerated
  extends ASN1Primitive
{
  private static ASN1Enumerated[] cache = new ASN1Enumerated[12];
  private final byte[] bytes;
  
  public ASN1Enumerated(int paramInt)
  {
    this.bytes = BigInteger.valueOf(paramInt).toByteArray();
  }
  
  public ASN1Enumerated(BigInteger paramBigInteger)
  {
    this.bytes = paramBigInteger.toByteArray();
  }
  
  public ASN1Enumerated(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 1)
    {
      if ((paramArrayOfByte[0] == 0) && ((paramArrayOfByte[1] & 0x80) == 0)) {
        throw new IllegalArgumentException("malformed enumerated");
      }
      if ((paramArrayOfByte[0] == -1) && ((paramArrayOfByte[1] & 0x80) != 0)) {
        throw new IllegalArgumentException("malformed enumerated");
      }
    }
    this.bytes = Arrays.clone(paramArrayOfByte);
  }
  
  static ASN1Enumerated fromOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 1) {
      return new ASN1Enumerated(paramArrayOfByte);
    }
    if (paramArrayOfByte.length != 0)
    {
      int i = paramArrayOfByte[0] & 0xFF;
      ASN1Enumerated[] arrayOfASN1Enumerated = cache;
      if (i >= arrayOfASN1Enumerated.length) {
        return new ASN1Enumerated(Arrays.clone(paramArrayOfByte));
      }
      ASN1Enumerated localASN1Enumerated2 = arrayOfASN1Enumerated[i];
      ASN1Enumerated localASN1Enumerated1 = localASN1Enumerated2;
      if (localASN1Enumerated2 == null)
      {
        localASN1Enumerated1 = new ASN1Enumerated(Arrays.clone(paramArrayOfByte));
        arrayOfASN1Enumerated[i] = localASN1Enumerated1;
      }
      return localASN1Enumerated1;
    }
    throw new IllegalArgumentException("ENUMERATED has zero length");
  }
  
  public static ASN1Enumerated getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1Enumerated)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (ASN1Enumerated)fromByteArray((byte[])paramObject);
          return (ASN1Enumerated)paramObject;
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
    return (ASN1Enumerated)paramObject;
  }
  
  public static ASN1Enumerated getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof ASN1Enumerated))) {
      return fromOctetString(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1Enumerated)) {
      return false;
    }
    paramASN1Primitive = (ASN1Enumerated)paramASN1Primitive;
    return Arrays.areEqual(this.bytes, paramASN1Primitive.bytes);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(10, this.bytes);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
  }
  
  public BigInteger getValue()
  {
    return new BigInteger(this.bytes);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.bytes);
  }
  
  boolean isConstructed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Enumerated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */