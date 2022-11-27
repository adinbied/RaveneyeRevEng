package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

public class URLAndHash
{
  protected byte[] sha1Hash;
  protected String url;
  
  public URLAndHash(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString != null) && (paramString.length() >= 1) && (paramString.length() < 65536))
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 20)) {
        throw new IllegalArgumentException("'sha1Hash' must have length == 20, if present");
      }
      this.url = paramString;
      this.sha1Hash = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("'url' must have length from 1 to (2^16 - 1)");
  }
  
  public static URLAndHash parse(TlsContext paramTlsContext, InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = TlsUtils.readOpaque16(paramInputStream);
    if (arrayOfByte.length >= 1)
    {
      String str = Strings.fromByteArray(arrayOfByte);
      arrayOfByte = null;
      int i = TlsUtils.readUint8(paramInputStream);
      if (i != 0)
      {
        if (i == 1) {
          paramTlsContext = TlsUtils.readFully(20, paramInputStream);
        } else {
          throw new TlsFatalAlert((short)47);
        }
      }
      else
      {
        if (TlsUtils.isTLSv12(paramTlsContext)) {
          break label73;
        }
        paramTlsContext = arrayOfByte;
      }
      return new URLAndHash(str, paramTlsContext);
      label73:
      throw new TlsFatalAlert((short)47);
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque16(Strings.toByteArray(this.url), paramOutputStream);
    if (this.sha1Hash == null)
    {
      TlsUtils.writeUint8(0, paramOutputStream);
      return;
    }
    TlsUtils.writeUint8(1, paramOutputStream);
    paramOutputStream.write(this.sha1Hash);
  }
  
  public byte[] getSHA1Hash()
  {
    return this.sha1Hash;
  }
  
  public String getURL()
  {
    return this.url;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\URLAndHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */