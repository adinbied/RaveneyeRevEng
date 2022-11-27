package org.bouncycastle.openssl;

import java.io.IOException;

public class PEMException
  extends IOException
{
  Exception underlying;
  
  public PEMException(String paramString)
  {
    super(paramString);
  }
  
  public PEMException(String paramString, Exception paramException)
  {
    super(paramString);
    this.underlying = paramException;
  }
  
  public Throwable getCause()
  {
    return this.underlying;
  }
  
  public Exception getUnderlyingException()
  {
    return this.underlying;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */