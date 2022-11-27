package org.bouncycastle.jce.provider;

import org.bouncycastle.jce.exception.ExtException;

public class AnnotatedException
  extends Exception
  implements ExtException
{
  private Throwable _underlyingException;
  
  public AnnotatedException(String paramString)
  {
    this(paramString, null);
  }
  
  public AnnotatedException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._underlyingException = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this._underlyingException;
  }
  
  Throwable getUnderlyingException()
  {
    return this._underlyingException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\AnnotatedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */