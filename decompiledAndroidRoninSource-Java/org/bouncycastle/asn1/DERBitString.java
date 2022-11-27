package org.bouncycastle.asn1;

import java.io.IOException;

public class DERBitString
  extends ASN1BitString
{
  protected DERBitString(byte paramByte, int paramInt)
  {
    this(toByteArray(paramByte), paramInt);
  }
  
  public DERBitString(int paramInt)
  {
    super(getBytes(paramInt), getPadBits(paramInt));
  }
  
  public DERBitString(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    super(paramASN1Encodable.toASN1Primitive().getEncoded("DER"), 0);
  }
  
  public DERBitString(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public DERBitString(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }
  
  static DERBitString fromOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 1)
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte.length - 1;
      byte[] arrayOfByte = new byte[j];
      if (j != 0) {
        System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, paramArrayOfByte.length - 1);
      }
      return new DERBitString(arrayOfByte, i);
    }
    throw new IllegalArgumentException("truncated BIT STRING detected");
  }
  
  public static DERBitString getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof DERBitString)))
    {
      if ((paramObject instanceof DLBitString))
      {
        paramObject = (DLBitString)paramObject;
        return new DERBitString(((DLBitString)paramObject).data, ((DLBitString)paramObject).padBits);
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (DERBitString)fromByteArray((byte[])paramObject);
          return (DERBitString)paramObject;
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
    return (DERBitString)paramObject;
  }
  
  public static DERBitString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof DERBitString))) {
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
    byte[] arrayOfByte1 = derForm(this.data, this.padBits);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERBitString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */