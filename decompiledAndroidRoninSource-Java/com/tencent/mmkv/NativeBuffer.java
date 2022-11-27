package com.tencent.mmkv;

public final class NativeBuffer
{
  public long pointer;
  public int size;
  
  public NativeBuffer(long paramLong, int paramInt)
  {
    this.pointer = paramLong;
    this.size = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\mmkv\NativeBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */