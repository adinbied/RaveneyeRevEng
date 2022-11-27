package io.reactivex.internal.util;

public enum ErrorMode
{
  static
  {
    BOUNDARY = new ErrorMode("BOUNDARY", 1);
    ErrorMode localErrorMode = new ErrorMode("END", 2);
    END = localErrorMode;
    $VALUES = new ErrorMode[] { IMMEDIATE, BOUNDARY, localErrorMode };
  }
  
  private ErrorMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\ErrorMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */