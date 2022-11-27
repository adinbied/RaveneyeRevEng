package org.bouncycastle.asn1;

import java.io.IOException;

public class DLBitString
  extends ASN1BitString
{
  protected DLBitString(byte paramByte, int paramInt)
  {
    this(toByteArray(paramByte), paramInt);
  }
  
  public DLBitString(int paramInt)
  {
    super(getBytes(paramInt), getPadBits(paramInt));
  }
  
  public DLBitString(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    super(paramASN1Encodable.toASN1Primitive().getEncoded("DER"), 0);
  }
  
  public DLBitString(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public DLBitString(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }
  
  static DLBitString fromOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 1)
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte.length - 1;
      byte[] arrayOfByte = new byte[j];
      if (j != 0) {
        System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, paramArrayOfByte.length - 1);
      }
      return new DLBitString(arrayOfByte, i);
    }
    throw new IllegalArgumentException("truncated BIT STRING detected");
  }
  
  public static ASN1BitString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DLBitString)))
    {
      if ((paramObject instanceof DERBitString)) {
        return (DERBitString)paramObject;
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (ASN1BitString)fromByteArray((byte[])paramObject);
          return (ASN1BitString)paramObject;
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
    return (DLBitString)paramObject;
  }
  
  public static ASN1BitString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DLBitString))) {
      return fromOctetString(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  private static byte[] toByteArray(byte paramByte)
  {
    return new byte[] { paramByte };
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    byte[] arrayOfByte1 = this.data;
    int i = arrayOfByte1.length + 1;
    byte[] arrayOfByte2 = new byte[i];
    arrayOfByte2[0] = ((byte)getPadBits());
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, i - 1);
    paramASN1OutputStream.writeEncoded(3, arrayOfByte2);
  }
  
  int encodedLength()
  {
    return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
  }
  
  boolean isConstructed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DLBitString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */