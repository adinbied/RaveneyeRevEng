package org.java_websocket.exceptions;

public class IncompleteHandshakeException
  extends RuntimeException
{
  private static final long serialVersionUID = 7906596804233893092L;
  private int newsize;
  
  public IncompleteHandshakeException()
  {
    this.newsize = 0;
  }
  
  public IncompleteHandshakeException(int paramInt)
  {
    this.newsize = paramInt;
  }
  
  public int getPreferedSize()
  {
    return this.newsize;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\exceptions\IncompleteHandshakeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */