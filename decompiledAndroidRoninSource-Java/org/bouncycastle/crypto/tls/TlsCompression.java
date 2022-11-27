package org.bouncycastle.crypto.tls;

import java.io.OutputStream;

public abstract interface TlsCompression
{
  public abstract OutputStream compress(OutputStream paramOutputStream);
  
  public abstract OutputStream decompress(OutputStream paramOutputStream);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsCompression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */