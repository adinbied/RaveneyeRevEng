package org.bouncycastle.crypto.tls;

import java.io.OutputStream;

public class TlsNullCompression
  implements TlsCompression
{
  public OutputStream compress(OutputStream paramOutputStream)
  {
    return paramOutputStream;
  }
  
  public OutputStream decompress(OutputStream paramOutputStream)
  {
    return paramOutputStream;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsNullCompression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */