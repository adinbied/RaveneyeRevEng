package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class ASN1OutputStream
{
  private OutputStream os;
  
  public ASN1OutputStream(OutputStream paramOutputStream)
  {
    this.os = paramOutputStream;
  }
  
  public void close()
    throws IOException
  {
    this.os.close();
  }
  
  public void flush()
    throws IOException
  {
    this.os.flush();
  }
  
  ASN1OutputStream getDERSubStream()
  {
    return new DEROutputStream(this.os);
  }
  
  ASN1OutputStream getDLSubStream()
  {
    return new DLOutputStream(this.os);
  }
  
  void write(int paramInt)
    throws IOException
  {
    this.os.write(paramInt);
  }
  
  void write(byte[] paramArrayOfByte)
    throws IOException
  {
    this.os.write(paramArrayOfByte);
  }
  
  void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.os.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  void writeEncoded(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws IOException
  {
    writeTag(paramInt1, paramInt2);
    writeLength(paramArrayOfByte.length);
    write(paramArrayOfByte);
  }
  
  void writeEncoded(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramInt);
    writeLength(paramArrayOfByte.length);
    write(paramArrayOfByte);
  }
  
  void writeImplicitObject(ASN1Primitive paramASN1Primitive)
    throws IOException
  {
    if (paramASN1Primitive != null)
    {
      paramASN1Primitive.encode(new ImplicitOutputStream(this.os));
      return;
    }
    throw new IOException("null object detected");
  }
  
  void writeLength(int paramInt)
    throws IOException
  {
    if (paramInt > 127)
    {
      int j = paramInt;
      int i = 1;
      for (;;)
      {
        j >>>= 8;
        if (j == 0) {
          break;
        }
        i += 1;
      }
      write((byte)(i | 0x80));
      i = (i - 1) * 8;
      while (i >= 0)
      {
        write((byte)(paramInt >> i));
        i -= 8;
      }
    }
    write((byte)paramInt);
  }
  
  protected void writeNull()
    throws IOException
  {
    this.os.write(5);
    this.os.write(0);
  }
  
  public void writeObject(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null)
    {
      paramASN1Encodable.toASN1Primitive().encode(this);
      return;
    }
    throw new IOException("null object detected");
  }
  
  void writeTag(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 31)
    {
      write(paramInt1 | paramInt2);
      return;
    }
    write(paramInt1 | 0x1F);
    if (paramInt2 < 128)
    {
      write(paramInt2);
      return;
    }
    byte[] arrayOfByte = new byte[5];
    paramInt1 = 4;
    arrayOfByte[4] = ((byte)(paramInt2 & 0x7F));
    int i;
    int j;
    do
    {
      i = paramInt2 >> 7;
      j = paramInt1 - 1;
      arrayOfByte[j] = ((byte)(i & 0x7F | 0x80));
      paramInt1 = j;
      paramInt2 = i;
    } while (i > 127);
    write(arrayOfByte, j, 5 - j);
  }
  
  private class ImplicitOutputStream
    extends ASN1OutputStream
  {
    private boolean first = true;
    
    public ImplicitOutputStream(OutputStream paramOutputStream)
    {
      super();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      if (this.first)
      {
        this.first = false;
        return;
      }
      super.write(paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */