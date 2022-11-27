package org.bouncycastle.util;

public class StoreException
  extends RuntimeException
{
  private Throwable _e;
  
  public StoreException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._e = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this._e;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\StoreException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */