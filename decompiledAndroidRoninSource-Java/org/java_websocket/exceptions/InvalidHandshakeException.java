package org.java_websocket.exceptions;

public class InvalidHandshakeException
  extends InvalidDataException
{
  private static final long serialVersionUID = -1426533877490484964L;
  
  public InvalidHandshakeException()
  {
    super(1002);
  }
  
  public InvalidHandshakeException(String paramString)
  {
    super(1002, paramString);
  }
  
  public InvalidHandshakeException(String paramString, Throwable paramThrowable)
  {
    super(1002, paramString, paramThrowable);
  }
  
  public InvalidHandshakeException(Throwable paramThrowable)
  {
    super(1002, paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\exceptions\InvalidHandshakeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */