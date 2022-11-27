package org.bouncycastle.crypto;

public class CryptoException
  extends Exception
{
  private Throwable cause;
  
  public CryptoException() {}
  
  public CryptoException(String paramString)
  {
    super(paramString);
  }
  
  public CryptoException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\CryptoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */