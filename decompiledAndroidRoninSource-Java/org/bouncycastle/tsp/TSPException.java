package org.bouncycastle.tsp;

public class TSPException
  extends Exception
{
  Throwable underlyingException;
  
  public TSPException(String paramString)
  {
    super(paramString);
  }
  
  public TSPException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.underlyingException = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.underlyingException;
  }
  
  public Exception getUnderlyingException()
  {
    return (Exception)this.underlyingException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TSPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */