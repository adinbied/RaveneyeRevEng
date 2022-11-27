package org.bouncycastle.cert.path;

public class CertPathValidationException
  extends Exception
{
  private final Exception cause;
  
  public CertPathValidationException(String paramString)
  {
    this(paramString, null);
  }
  
  public CertPathValidationException(String paramString, Exception paramException)
  {
    super(paramString);
    this.cause = paramException;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\path\CertPathValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */