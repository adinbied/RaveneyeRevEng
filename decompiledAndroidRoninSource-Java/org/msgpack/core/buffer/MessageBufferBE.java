package org.msgpack.core.buffer;

import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

public class MessageBufferBE
  extends MessageBuffer
{
  private MessageBufferBE(Object paramObject, long paramLong, int paramInt)
  {
    super(paramObject, paramLong, paramInt);
  }
  
  MessageBufferBE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public double getDouble(int paramInt)
  {
    return unsafe.getDouble(this.base, this.address + paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return unsafe.getFloat(this.base, this.address + paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return unsafe.getInt(this.base, this.address + paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return unsafe.getLong(this.base, this.address + paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return unsafe.getShort(this.base, this.address + paramInt);
  }
  
  public void putDouble(int paramInt, double paramDouble)
  {
    unsafe.putDouble(this.base, this.address + paramInt, paramDouble);
  }
  
  public void putInt(int paramInt1, int paramInt2)
  {
    unsafe.putInt(this.base, this.address + paramInt1, paramInt2);
  }
  
  public void putLong(int paramInt, long paramLong)
  {
    unsafe.putLong(this.base, this.address + paramInt, paramLong);
  }
  
  public void putShort(int paramInt, short paramShort)
  {
    unsafe.putShort(this.base, this.address + paramInt, paramShort);
  }
  
  public MessageBufferBE slice(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    boolean bool;
    if (paramInt1 + paramInt2 <= size()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new MessageBufferBE(this.base, this.address + paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\MessageBufferBE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */