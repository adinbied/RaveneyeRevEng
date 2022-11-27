package org.bouncycastle.cert;

public class CertException
  extends Exception
{
  private Throwable cause;
  
  public CertException(String paramString)
  {
    super(paramString);
  }
  
  public CertException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\CertException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */