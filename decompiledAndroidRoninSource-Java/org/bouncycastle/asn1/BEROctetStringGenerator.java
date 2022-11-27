package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROctetStringGenerator
  extends BERGenerator
{
  public BEROctetStringGenerator(OutputStream paramOutputStream)
    throws IOException
  {
    super(paramOutputStream);
    writeBERHeader(36);
  }
  
  public BEROctetStringGenerator(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    super(paramOutputStream, paramInt, paramBoolean);
    writeBERHeader(36);
  }
  
  public OutputStream getOctetOutputStream()
  {
    return getOctetOutputStream(new byte['Ϩ']);
  }
  
  public OutputStream getOctetOutputStream(byte[] paramArrayOfByte)
  {
    return new BufferedBEROctetStream(paramArrayOfByte);
  }
  
  private class BufferedBEROctetStream
    extends OutputStream
  {
    private byte[] _buf;
    private DEROutputStream _derOut;
    private int _off;
    
    BufferedBEROctetStream(byte[] paramArrayOfByte)
    {
      this._buf = paramArrayOfByte;
      this._off = 0;
      this._derOut = new DEROutputStream(BEROctetStringGenerator.this._out);
    }
    
    public void close()
      throws IOException
    {
      int i = this._off;
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(this._buf, 0, arrayOfByte, 0, i);
        DEROctetString.encode(this._derOut, arrayOfByte);
      }
      BEROctetStringGenerator.this.writeBEREnd();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      byte[] arrayOfByte = this._buf;
      int i = this._off;
      int j = i + 1;
      this._off = j;
      arrayOfByte[i] = ((byte)paramInt);
      if (j == arrayOfByte.length)
      {
        DEROctetString.encode(this._derOut, arrayOfByte);
        this._off = 0;
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      while (paramInt2 > 0)
      {
        int i = Math.min(paramInt2, this._buf.length - this._off);
        System.arraycopy(paramArrayOfByte, paramInt1, this._buf, this._off, i);
        int j = this._off + i;
        this._off = j;
        byte[] arrayOfByte = this._buf;
        if (j < arrayOfByte.length) {
          return;
        }
        DEROctetString.encode(this._derOut, arrayOfByte);
        this._off = 0;
        paramInt1 += i;
        paramInt2 -= i;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BEROctetStringGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */