package org.msgpack.core;

public class ExtensionTypeHeader
{
  private final int length;
  private final byte type;
  
  public ExtensionTypeHeader(byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "length must be >= 0");
    this.type = paramByte;
    this.length = paramInt;
  }
  
  public static byte checkedCastToByte(int paramInt)
  {
    boolean bool;
    if ((-128 <= paramInt) && (paramInt <= 127)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Extension type code must be within the range of byte");
    return (byte)paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof ExtensionTypeHeader;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (ExtensionTypeHeader)paramObject;
      bool1 = bool2;
      if (this.type == ((ExtensionTypeHeader)paramObject).type)
      {
        bool1 = bool2;
        if (this.length == ((ExtensionTypeHeader)paramObject).length) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return (this.type + 31) * 31 + this.length;
  }
  
  public String toString()
  {
    return String.format("ExtensionTypeHeader(type:%d, length:%,d)", new Object[] { Byte.valueOf(this.type), Integer.valueOf(this.length) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\ExtensionTypeHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */