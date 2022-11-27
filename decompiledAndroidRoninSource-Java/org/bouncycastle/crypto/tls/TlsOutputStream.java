package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

class TlsOutputStream
  extends OutputStream
{
  private byte[] buf = new byte[1];
  private TlsProtocol handler;
  
  TlsOutputStream(TlsProtocol paramTlsProtocol)
  {
    this.handler = paramTlsProtocol;
  }
  
  public void close()
    throws IOException
  {
    this.handler.close();
  }
  
  public void flush()
    throws IOException
  {
    this.handler.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.buf;
    arrayOfByte[0] = ((byte)paramInt);
    write(arrayOfByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.handler.writeData(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */