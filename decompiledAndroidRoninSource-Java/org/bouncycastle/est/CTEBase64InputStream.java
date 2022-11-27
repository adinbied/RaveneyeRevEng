package org.bouncycastle.est;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Base64;

class CTEBase64InputStream
  extends InputStream
{
  protected final byte[] data = new byte['̀'];
  protected final OutputStream dataOutputStream;
  protected boolean end;
  protected final Long max;
  protected final byte[] rawBuf = new byte['Ѐ'];
  protected long read;
  protected int rp;
  protected final InputStream src;
  protected int wp;
  
  public CTEBase64InputStream(InputStream paramInputStream, Long paramLong)
  {
    this.src = paramInputStream;
    this.dataOutputStream = new OutputStream()
    {
      public void write(int paramAnonymousInt)
        throws IOException
      {
        byte[] arrayOfByte = CTEBase64InputStream.this.data;
        CTEBase64InputStream localCTEBase64InputStream = CTEBase64InputStream.this;
        int i = localCTEBase64InputStream.wp;
        localCTEBase64InputStream.wp = (i + 1);
        arrayOfByte[i] = ((byte)paramAnonymousInt);
      }
    };
    this.max = paramLong;
  }
  
  public void close()
    throws IOException
  {
    this.src.close();
  }
  
  protected int pullFromSrc()
    throws IOException
  {
    if (this.read >= this.max.longValue()) {
      return -1;
    }
    int i = 0;
    int k;
    int j;
    do
    {
      k = this.src.read();
      if ((k < 33) && (k != 13) && (k != 10))
      {
        j = i;
        if (k >= 0)
        {
          this.read += 1L;
          j = i;
        }
      }
      else
      {
        byte[] arrayOfByte = this.rawBuf;
        if (i >= arrayOfByte.length) {
          break label212;
        }
        arrayOfByte[i] = ((byte)k);
        this.read += 1L;
        j = i + 1;
      }
      if ((k <= -1) || (j >= this.rawBuf.length) || (k == 10)) {
        break;
      }
      i = j;
    } while (this.read < this.max.longValue());
    if (j > 0) {
      try
      {
        Base64.decode(this.rawBuf, 0, j, this.dataOutputStream);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Decode Base64 Content-Transfer-Encoding: ");
        localStringBuilder.append(localException);
        throw new IOException(localStringBuilder.toString());
      }
    } else if (k == -1) {
      return -1;
    }
    return this.wp;
    label212:
    throw new IOException("Content Transfer Encoding, base64 line length > 1024");
  }
  
  public int read()
    throws IOException
  {
    if (this.rp == this.wp)
    {
      this.rp = 0;
      this.wp = 0;
      i = pullFromSrc();
      if (i == -1) {
        return i;
      }
    }
    byte[] arrayOfByte = this.data;
    int i = this.rp;
    this.rp = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\CTEBase64InputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */