package com.drew.lang;

public class CompoundException
  extends Exception
{
  private static final long serialVersionUID = -9207883813472069925L;
  private final Throwable _innerException;
  
  public CompoundException(String paramString)
  {
    this(paramString, null);
  }
  
  public CompoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this._innerException = paramThrowable;
  }
  
  public CompoundException(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public Throwable getInnerException()
  {
    return this._innerException;
  }
  
  /* Error */
  public void printStackTrace()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void printStackTrace(java.io.PrintStream arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void printStackTrace(java.io.PrintWriter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\CompoundException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */