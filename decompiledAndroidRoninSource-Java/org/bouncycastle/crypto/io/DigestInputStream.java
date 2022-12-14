package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Digest;

public class DigestInputStream
  extends FilterInputStream
{
  protected Digest digest;
  
  public DigestInputStream(InputStream paramInputStream, Digest paramDigest)
  {
    super(paramInputStream);
    this.digest = paramDigest;
  }
  
  public Digest getDigest()
  {
    return this.digest;
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i >= 0) {
      this.digest.update((byte)i);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\DigestInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */