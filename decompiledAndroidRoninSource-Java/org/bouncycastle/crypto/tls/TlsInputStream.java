package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

class TlsInputStream
  extends InputStream
{
  private byte[] buf = new byte[1];
  private TlsProtocol handler = null;
  
  TlsInputStream(TlsProtocol paramTlsProtocol)
  {
    this.handler = paramTlsProtocol;
  }
  
  public int available()
    throws IOException
  {
    return this.handler.applicationDataAvailable();
  }
  
  public void close()
    throws IOException
  {
    this.handler.close();
  }
  
  public int read()
    throws IOException
  {
    if (read(this.buf) < 0) {
      return -1;
    }
    return this.buf[0] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.handler.readApplicationData(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */