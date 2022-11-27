package org.msgpack.core;

public class MessageInsufficientBufferException
  extends MessagePackException
{
  public MessageInsufficientBufferException() {}
  
  public MessageInsufficientBufferException(String paramString)
  {
    super(paramString);
  }
  
  public MessageInsufficientBufferException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MessageInsufficientBufferException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageInsufficientBufferException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */