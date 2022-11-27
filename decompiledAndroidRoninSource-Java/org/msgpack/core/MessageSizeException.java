package org.msgpack.core;

public class MessageSizeException
  extends MessagePackException
{
  private final long size;
  
  public MessageSizeException(long paramLong)
  {
    this.size = paramLong;
  }
  
  public MessageSizeException(String paramString, long paramLong)
  {
    super(paramString);
    this.size = paramLong;
  }
  
  public long getSize()
  {
    return this.size;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageSizeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */