package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

public class BufferingOutputStream
  extends OutputStream
{
  private final byte[] buf;
  private int bufOff;
  private final OutputStream other;
  
  public BufferingOutputStream(OutputStream paramOutputStream)
  {
    this.other = paramOutputStream;
    this.buf = new byte['က'];
  }
  
  public BufferingOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this.other = paramOutputStream;
    this.buf = new byte[paramInt];
  }
  
  public void close()
    throws IOException
  {
    flush();
    this.other.close();
  }
  
  public void flush()
    throws IOException
  {
    this.other.write(this.buf, 0, this.bufOff);
    this.bufOff = 0;
    Arrays.fill(this.buf, (byte)0);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.buf;
    int i = this.bufOff;
    int j = i + 1;
    this.bufOff = j;
    arrayOfByte[i] = ((byte)paramInt);
    if (j == arrayOfByte.length) {
      flush();
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = this.buf;
    int j = arrayOfByte.length;
    int i = this.bufOff;
    if (paramInt2 < j - i)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      this.bufOff += paramInt1;
      return;
      j = arrayOfByte.length - i;
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, j);
      this.bufOff += j;
      flush();
      i = paramInt1 + j;
      paramInt1 = paramInt2 - j;
      paramInt2 = i;
      for (;;)
      {
        arrayOfByte = this.buf;
        if (paramInt1 < arrayOfByte.length) {
          break;
        }
        this.other.write(paramArrayOfByte, paramInt2, arrayOfByte.length);
        arrayOfByte = this.buf;
        paramInt2 += arrayOfByte.length;
        paramInt1 -= arrayOfByte.length;
      }
      if (paramInt1 <= 0) {
        break;
      }
      System.arraycopy(paramArrayOfByte, paramInt2, arrayOfByte, this.bufOff, paramInt1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\BufferingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */