package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TeeInputStream
  extends InputStream
{
  private final InputStream input;
  private final OutputStream output;
  
  public TeeInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.input = paramInputStream;
    this.output = paramOutputStream;
  }
  
  public void close()
    throws IOException
  {
    this.input.close();
    this.output.close();
  }
  
  public OutputStream getOutputStream()
  {
    return this.output;
  }
  
  public int read()
    throws IOException
  {
    int i = this.input.read();
    if (i >= 0) {
      this.output.write(i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.output.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\TeeInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */