package org.bouncycastle.cert;

import java.io.IOException;

public class CertIOException
  extends IOException
{
  private Throwable cause;
  
  public CertIOException(String paramString)
  {
    super(paramString);
  }
  
  public CertIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\CertIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */