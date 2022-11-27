package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class DERGenerator
  extends ASN1Generator
{
  private boolean _isExplicit;
  private int _tagNo;
  private boolean _tagged = false;
  
  protected DERGenerator(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public DERGenerator(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this._tagged = true;
    this._isExplicit = paramBoolean;
    this._tagNo = paramInt;
  }
  
  private void writeLength(OutputStream paramOutputStream, int paramInt)
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
      paramOutputStream.write((byte)(i | 0x80));
      i = (i - 1) * 8;
      while (i >= 0)
      {
        paramOutputStream.write((byte)(paramInt >> i));
        i -= 8;
      }
    }
    paramOutputStream.write((byte)paramInt);
  }
  
  void writeDEREncoded(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    if (this._tagged)
    {
      int i = this._tagNo;
      int j = i | 0x80;
      if (this._isExplicit)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        writeDEREncoded(localByteArrayOutputStream, paramInt, paramArrayOfByte);
        writeDEREncoded(this._out, i | 0x20 | 0x80, localByteArrayOutputStream.toByteArray());
        return;
      }
      if ((paramInt & 0x20) != 0)
      {
        writeDEREncoded(this._out, j | 0x20, paramArrayOfByte);
        return;
      }
      writeDEREncoded(this._out, j, paramArrayOfByte);
      return;
    }
    writeDEREncoded(this._out, paramInt, paramArrayOfByte);
  }
  
  void writeDEREncoded(OutputStream paramOutputStream, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    paramOutputStream.write(paramInt);
    writeLength(paramOutputStream, paramArrayOfByte.length);
    paramOutputStream.write(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */