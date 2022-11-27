package com.facebook.common.util;

public class ExceptionWithNoStacktrace
  extends Exception
{
  public ExceptionWithNoStacktrace(String paramString)
  {
    super(paramString);
  }
  
  public Throwable fillInStackTrace()
  {
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\commo\\util\ExceptionWithNoStacktrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */