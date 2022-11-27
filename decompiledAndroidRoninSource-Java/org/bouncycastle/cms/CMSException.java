package org.bouncycastle.cms;

public class CMSException
  extends Exception
{
  Exception e;
  
  public CMSException(String paramString)
  {
    super(paramString);
  }
  
  public CMSException(String paramString, Exception paramException)
  {
    super(paramString);
    this.e = paramException;
  }
  
  public Throwable getCause()
  {
    return this.e;
  }
  
  public Exception getUnderlyingException()
  {
    return this.e;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */