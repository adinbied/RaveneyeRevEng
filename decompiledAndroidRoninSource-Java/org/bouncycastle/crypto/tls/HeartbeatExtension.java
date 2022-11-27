package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HeartbeatExtension
{
  protected short mode;
  
  public HeartbeatExtension(short paramShort)
  {
    if (HeartbeatMode.isValid(paramShort))
    {
      this.mode = paramShort;
      return;
    }
    throw new IllegalArgumentException("'mode' is not a valid HeartbeatMode value");
  }
  
  public static HeartbeatExtension parse(InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (HeartbeatMode.isValid(s)) {
      return new HeartbeatExtension(s);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.mode, paramOutputStream);
  }
  
  public short getMode()
  {
    return this.mode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\HeartbeatExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */