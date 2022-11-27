package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public abstract class ASN1ApplicationSpecific
  extends ASN1Primitive
{
  protected final boolean isConstructed;
  protected final byte[] octets;
  protected final int tag;
  
  ASN1ApplicationSpecific(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    this.isConstructed = paramBoolean;
    this.tag = paramInt;
    this.octets = Arrays.clone(paramArrayOfByte);
  }
  
  public static ASN1ApplicationSpecific getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1ApplicationSpecific)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
          return (ASN1ApplicationSpecific)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to construct object from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ASN1ApplicationSpecific)paramObject;
  }
  
  protected static int getLengthOfHeader(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[1] & 0xFF;
    if (i == 128) {
      return 2;
    }
    if (i > 127)
    {
      i &= 0x7F;
      if (i <= 4) {
        return i + 2;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("DER length more than 4 bytes: ");
      paramArrayOfByte.append(i);
      throw new IllegalStateException(paramArrayOfByte.toString());
    }
    return 2;
  }
  
  private byte[] replaceTagNumber(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramArrayOfByte[0] & 0x1F) == 31)
    {
      i = 2;
      int j = paramArrayOfByte[1] & 0xFF;
      if ((j & 0x7F) != 0) {
        for (;;)
        {
          k = i;
          if (j < 0) {
            break;
          }
          k = i;
          if ((j & 0x80) == 0) {
            break;
          }
          j = paramArrayOfByte[i] & 0xFF;
          i += 1;
        }
      }
      throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
    }
    int k = 1;
    int i = paramArrayOfByte.length - k + 1;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, k, arrayOfByte, 1, i - 1);
    arrayOfByte[0] = ((byte)paramInt);
    return arrayOfByte;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    boolean bool1 = paramASN1Primitive instanceof ASN1ApplicationSpecific;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramASN1Primitive = (ASN1ApplicationSpecific)paramASN1Primitive;
    bool1 = bool2;
    if (this.isConstructed == paramASN1Primitive.isConstructed)
    {
      bool1 = bool2;
      if (this.tag == paramASN1Primitive.tag)
      {
        bool1 = bool2;
        if (Arrays.areEqual(this.octets, paramASN1Primitive.octets)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    int i;
    if (this.isConstructed) {
      i = 96;
    } else {
      i = 64;
    }
    paramASN1OutputStream.writeEncoded(i, this.tag, this.octets);
  }
  
  int encodedLength()
    throws IOException
  {
    return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
  }
  
  public int getApplicationTag()
  {
    return this.tag;
  }
  
  public byte[] getContents()
  {
    return Arrays.clone(this.octets);
  }
  
  public ASN1Primitive getObject()
    throws IOException
  {
    return ASN1Primitive.fromByteArray(getContents());
  }
  
  public ASN1Primitive getObject(int paramInt)
    throws IOException
  {
    if (paramInt < 31)
    {
      byte[] arrayOfByte1 = getEncoded();
      byte[] arrayOfByte2 = replaceTagNumber(paramInt, arrayOfByte1);
      if ((arrayOfByte1[0] & 0x20) != 0) {
        arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0x20));
      }
      return ASN1Primitive.fromByteArray(arrayOfByte2);
    }
    throw new IOException("unsupported tag number");
  }
  
  public int hashCode()
  {
    return this.isConstructed ^ this.tag ^ Arrays.hashCode(this.octets);
  }
  
  public boolean isConstructed()
  {
    return this.isConstructed;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1ApplicationSpecific.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */