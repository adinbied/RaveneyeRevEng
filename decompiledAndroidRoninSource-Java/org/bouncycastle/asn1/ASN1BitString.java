package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public abstract class ASN1BitString
  extends ASN1Primitive
  implements ASN1String
{
  private static final char[] table = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  protected final byte[] data;
  protected final int padBits;
  
  public ASN1BitString(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramArrayOfByte.length == 0) && (paramInt != 0)) {
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
      }
      if ((paramInt <= 7) && (paramInt >= 0))
      {
        this.data = Arrays.clone(paramArrayOfByte);
        this.padBits = paramInt;
        return;
      }
      throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }
    throw new NullPointerException("data cannot be null");
  }
  
  protected static byte[] derForm(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = Arrays.clone(paramArrayOfByte);
    if (paramInt > 0)
    {
      int i = paramArrayOfByte.length - 1;
      arrayOfByte[i] = ((byte)(255 << paramInt & arrayOfByte[i]));
    }
    return arrayOfByte;
  }
  
  static ASN1BitString fromInputStream(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt >= 1)
    {
      int i = paramInputStream.read();
      paramInt -= 1;
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInt != 0) {
        if (Streams.readFully(paramInputStream, arrayOfByte) == paramInt)
        {
          if ((i > 0) && (i < 8))
          {
            paramInt -= 1;
            if (arrayOfByte[paramInt] != (byte)(arrayOfByte[paramInt] & 255 << i)) {
              return new DLBitString(arrayOfByte, i);
            }
          }
        }
        else {
          throw new EOFException("EOF encountered in middle of BIT STRING");
        }
      }
      return new DERBitString(arrayOfByte, i);
    }
    throw new IllegalArgumentException("truncated BIT STRING detected");
  }
  
  protected static byte[] getBytes(int paramInt)
  {
    int k = 0;
    if (paramInt == 0) {
      return new byte[0];
    }
    int i = 4;
    int j = 3;
    while ((j >= 1) && ((255 << j * 8 & paramInt) == 0))
    {
      i -= 1;
      j -= 1;
    }
    byte[] arrayOfByte = new byte[i];
    j = k;
    while (j < i)
    {
      arrayOfByte[j] = ((byte)(paramInt >> j * 8 & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  protected static int getPadBits(int paramInt)
  {
    int i = 3;
    while (i >= 0)
    {
      if (i != 0)
      {
        j = paramInt >> i * 8;
        if (j != 0)
        {
          paramInt = j & 0xFF;
          break label52;
        }
      }
      else if (paramInt != 0)
      {
        paramInt &= 0xFF;
        break label52;
      }
      i -= 1;
    }
    paramInt = 0;
    label52:
    if (paramInt == 0) {
      return 0;
    }
    int j = 1;
    i = paramInt;
    paramInt = j;
    for (;;)
    {
      i <<= 1;
      if ((i & 0xFF) == 0) {
        break;
      }
      paramInt += 1;
    }
    return 8 - paramInt;
  }
  
  protected boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    boolean bool1 = paramASN1Primitive instanceof ASN1BitString;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramASN1Primitive = (ASN1BitString)paramASN1Primitive;
    bool1 = bool2;
    if (this.padBits == paramASN1Primitive.padBits)
    {
      bool1 = bool2;
      if (Arrays.areEqual(getBytes(), paramASN1Primitive.getBytes())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public byte[] getBytes()
  {
    return derForm(this.data, this.padBits);
  }
  
  public ASN1Primitive getLoadedObject()
  {
    return toASN1Primitive();
  }
  
  public byte[] getOctets()
  {
    if (this.padBits == 0) {
      return Arrays.clone(this.data);
    }
    throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
  }
  
  public int getPadBits()
  {
    return this.padBits;
  }
  
  public String getString()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    Object localObject = new ByteArrayOutputStream();
    ASN1OutputStream localASN1OutputStream = new ASN1OutputStream((OutputStream)localObject);
    try
    {
      localASN1OutputStream.writeObject(this);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      int i = 0;
      while (i != localObject.length)
      {
        localStringBuffer.append(table[(localObject[i] >>> 4 & 0xF)]);
        localStringBuffer.append(table[(localObject[i] & 0xF)]);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (IOException localIOException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Internal error encoding BitString: ");
      ((StringBuilder)localObject).append(localIOException.getMessage());
      throw new ASN1ParsingException(((StringBuilder)localObject).toString(), localIOException);
    }
  }
  
  public int hashCode()
  {
    return this.padBits ^ Arrays.hashCode(getBytes());
  }
  
  public int intValue()
  {
    byte[] arrayOfByte2 = this.data;
    int i = this.padBits;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (i > 0)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length <= 4) {
        arrayOfByte1 = derForm(arrayOfByte2, i);
      }
    }
    i = 0;
    int j = 0;
    while ((i != arrayOfByte1.length) && (i != 4))
    {
      j |= (arrayOfByte1[i] & 0xFF) << i * 8;
      i += 1;
    }
    return j;
  }
  
  ASN1Primitive toDERObject()
  {
    return new DERBitString(this.data, this.padBits);
  }
  
  ASN1Primitive toDLObject()
  {
    return new DLBitString(this.data, this.padBits);
  }
  
  public String toString()
  {
    return getString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1BitString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */