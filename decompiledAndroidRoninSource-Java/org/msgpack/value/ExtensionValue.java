package org.msgpack.value;

public abstract interface ExtensionValue
  extends Value
{
  public abstract byte[] getData();
  
  public abstract byte getType();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\ExtensionValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */