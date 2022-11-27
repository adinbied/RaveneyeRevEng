package org.bouncycastle.cert.ocsp;

public class OCSPException
  extends Exception
{
  private Throwable cause;
  
  public OCSPException(String paramString)
  {
    super(paramString);
  }
  
  public OCSPException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\OCSPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */