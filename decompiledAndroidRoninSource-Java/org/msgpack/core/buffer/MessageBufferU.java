package org.msgpack.core.buffer;

import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;

public class MessageBufferU
  extends MessageBuffer
{
  private final ByteBuffer wrap;
  
  private MessageBufferU(Object paramObject, long paramLong, int paramInt, ByteBuffer paramByteBuffer)
  {
    super(paramObject, paramLong, paramInt);
    this.wrap = paramByteBuffer;
  }
  
  MessageBufferU(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.position(paramInt1);
    paramArrayOfByte.limit(paramInt1 + paramInt2);
    this.wrap = paramArrayOfByte.slice();
  }
  
  private void resetBufferPosition()
  {
    this.wrap.position(0);
    this.wrap.limit(this.size);
  }
  
  public void copyTo(int paramInt1, MessageBuffer paramMessageBuffer, int paramInt2, int paramInt3)
  {
    try
    {
      this.wrap.position(paramInt1);
      paramMessageBuffer.putByteBuffer(paramInt2, this.wrap, paramInt3);
      return;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.wrap.get(paramInt) != 0;
  }
  
  public byte getByte(int paramInt)
  {
    return this.wrap.get(paramInt);
  }
  
  public void getBytes(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
  {
    try
    {
      this.wrap.position(paramInt1);
      this.wrap.limit(paramInt1 + paramInt2);
      paramByteBuffer.put(this.wrap);
      return;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public void getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    try
    {
      this.wrap.position(paramInt1);
      this.wrap.get(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public double getDouble(int paramInt)
  {
    return this.wrap.getDouble(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return this.wrap.getFloat(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.wrap.getInt(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.wrap.getLong(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return this.wrap.getShort(paramInt);
  }
  
  public void putBoolean(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void putByte(int paramInt, byte paramByte)
  {
    this.wrap.put(paramInt, paramByte);
  }
  
  public void putByteBuffer(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    if (paramByteBuffer.hasArray())
    {
      putBytes(paramInt1, paramByteBuffer.array(), paramByteBuffer.position() + paramByteBuffer.arrayOffset(), paramInt2);
      paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
      return;
    }
    int i = paramByteBuffer.limit();
    try
    {
      paramByteBuffer.limit(paramByteBuffer.position() + paramInt2);
      this.wrap.position(paramInt1);
      this.wrap.put(paramByteBuffer);
      return;
    }
    finally
    {
      paramByteBuffer.limit(i);
    }
  }
  
  public void putBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    try
    {
      this.wrap.position(paramInt1);
      this.wrap.put(paramArrayOfByte, paramInt2, paramInt3);
      return;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public void putDouble(int paramInt, double paramDouble)
  {
    this.wrap.putDouble(paramInt, paramDouble);
  }
  
  public void putFloat(int paramInt, float paramFloat)
  {
    this.wrap.putFloat(paramInt, paramFloat);
  }
  
  public void putInt(int paramInt1, int paramInt2)
  {
    this.wrap.putInt(paramInt1, paramInt2);
  }
  
  public void putLong(int paramInt, long paramLong)
  {
    this.wrap.putLong(paramInt, paramLong);
  }
  
  public void putShort(int paramInt, short paramShort)
  {
    this.wrap.putShort(paramInt, paramShort);
  }
  
  public MessageBufferU slice(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    int i = paramInt1 + paramInt2;
    boolean bool;
    if (i <= size()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    try
    {
      this.wrap.position(paramInt1);
      this.wrap.limit(i);
      Object localObject1 = this.base;
      long l = this.address;
      localObject1 = new MessageBufferU(localObject1, paramInt1 + l, paramInt2, this.wrap.slice());
      return (MessageBufferU)localObject1;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public ByteBuffer sliceAsByteBuffer()
  {
    return sliceAsByteBuffer(0, this.size);
  }
  
  public ByteBuffer sliceAsByteBuffer(int paramInt1, int paramInt2)
  {
    try
    {
      this.wrap.position(paramInt1);
      this.wrap.limit(paramInt1 + paramInt2);
      ByteBuffer localByteBuffer = this.wrap.slice();
      return localByteBuffer;
    }
    finally
    {
      resetBufferPosition();
    }
  }
  
  public byte[] toByteArray()
  {
    int i = size();
    byte[] arrayOfByte = new byte[i];
    getBytes(0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\MessageBufferU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */