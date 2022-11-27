package com.xiaomi.push;

public class ac
{
  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4)
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      return paramArrayOfByte[3] & 0xFF | 0x0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
    }
    throw new IllegalArgumentException("the length of bytes must be 4");
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24), (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */