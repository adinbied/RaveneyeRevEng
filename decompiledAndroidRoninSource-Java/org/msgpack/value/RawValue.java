package org.msgpack.value;

import java.nio.ByteBuffer;

public abstract interface RawValue
  extends Value
{
  public abstract byte[] asByteArray();
  
  public abstract ByteBuffer asByteBuffer();
  
  public abstract String asString();
  
  public abstract String toString();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\RawValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */