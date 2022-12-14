package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

public class ExtCertPathValidatorException
  extends CertPathValidatorException
  implements ExtException
{
  private Throwable cause;
  
  public ExtCertPathValidatorException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public ExtCertPathValidatorException(String paramString, Throwable paramThrowable, CertPath paramCertPath, int paramInt)
  {
    super(paramString, paramThrowable, paramCertPath, paramInt);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\exception\ExtCertPathValidatorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */