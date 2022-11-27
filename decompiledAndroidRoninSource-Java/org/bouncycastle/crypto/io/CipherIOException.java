package org.bouncycastle.crypto.io;

import java.io.IOException;

public class CipherIOException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  private final Throwable cause;
  
  public CipherIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\CipherIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */