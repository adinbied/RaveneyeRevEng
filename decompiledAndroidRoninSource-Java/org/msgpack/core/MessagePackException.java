package org.msgpack.core;

public class MessagePackException
  extends RuntimeException
{
  public static final IllegalStateException UNREACHABLE = new IllegalStateException("Cannot reach here");
  
  public MessagePackException() {}
  
  public MessagePackException(String paramString)
  {
    super(paramString);
  }
  
  public MessagePackException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MessagePackException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public static UnsupportedOperationException UNSUPPORTED(String paramString)
  {
    return new UnsupportedOperationException(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessagePackException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */