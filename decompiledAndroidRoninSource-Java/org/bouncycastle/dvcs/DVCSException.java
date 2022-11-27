package org.bouncycastle.dvcs;

public class DVCSException
  extends Exception
{
  private static final long serialVersionUID = 389345256020131488L;
  private Throwable cause;
  
  public DVCSException(String paramString)
  {
    super(paramString);
  }
  
  public DVCSException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */