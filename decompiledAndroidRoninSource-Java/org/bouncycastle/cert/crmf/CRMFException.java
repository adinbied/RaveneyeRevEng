package org.bouncycastle.cert.crmf;

public class CRMFException
  extends Exception
{
  private Throwable cause;
  
  public CRMFException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\CRMFException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */