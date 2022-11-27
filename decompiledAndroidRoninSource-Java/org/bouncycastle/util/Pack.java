package org.bouncycastle.util;

public abstract class Pack
{
  public static int bigEndianToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j += 1;
    int k = paramArrayOfByte[j];
    return paramArrayOfByte[(j + 1)] & 0xFF | i << 24 | (paramInt & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static void bigEndianToInt(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      paramArrayOfInt[paramInt] = bigEndianToInt(paramArrayOfByte, i);
      i += 4;
      paramInt += 1;
    }
  }
  
  public static long bigEndianToLong(byte[] paramArrayOfByte, int paramInt)
  {
    int i = bigEndianToInt(paramArrayOfByte, paramInt);
    paramInt = bigEndianToInt(paramArrayOfByte, paramInt + 4);
    long l = i;
    return paramInt & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 32;
  }
  
  public static void bigEndianToLong(byte[] paramArrayOfByte, int paramInt, long[] paramArrayOfLong)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfLong.length)
    {
      paramArrayOfLong[paramInt] = bigEndianToLong(paramArrayOfByte, i);
      i += 8;
      paramInt += 1;
    }
  }
  
  public static short bigEndianToShort(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)(paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8);
  }
  
  public static void intToBigEndian(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 += 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 16));
    paramInt2 += 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  public static void intToBigEndian(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      intToBigEndian(paramArrayOfInt[paramInt], paramArrayOfByte, i);
      i += 4;
      paramInt += 1;
    }
  }
  
  public static byte[] intToBigEndian(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    intToBigEndian(paramInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] intToBigEndian(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 4];
    intToBigEndian(paramArrayOfInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void intToLittleEndian(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
    paramInt2 += 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramInt2 += 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 24));
  }
  
  public static void intToLittleEndian(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      intToLittleEndian(paramArrayOfInt[paramInt], paramArrayOfByte, i);
      i += 4;
      paramInt += 1;
    }
  }
  
  public static byte[] intToLittleEndian(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    intToLittleEndian(paramInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] intToLittleEndian(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 4];
    intToLittleEndian(paramArrayOfInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static int littleEndianToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j += 1;
    int k = paramArrayOfByte[j];
    return paramArrayOfByte[(j + 1)] << 24 | i & 0xFF | (paramInt & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static void littleEndianToInt(byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      paramArrayOfInt[paramInt] = littleEndianToInt(paramArrayOfByte, i);
      i += 4;
      paramInt += 1;
    }
  }
  
  public static void littleEndianToInt(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt3)
    {
      paramArrayOfInt[(paramInt2 + paramInt1)] = littleEndianToInt(paramArrayOfByte, i);
      i += 4;
      paramInt1 += 1;
    }
  }
  
  public static int[] littleEndianToInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfInt[paramInt1] = littleEndianToInt(paramArrayOfByte, i);
      i += 4;
      paramInt1 += 1;
    }
    return arrayOfInt;
  }
  
  public static long littleEndianToLong(byte[] paramArrayOfByte, int paramInt)
  {
    int i = littleEndianToInt(paramArrayOfByte, paramInt);
    return (littleEndianToInt(paramArrayOfByte, paramInt + 4) & 0xFFFFFFFF) << 32 | i & 0xFFFFFFFF;
  }
  
  public static void littleEndianToLong(byte[] paramArrayOfByte, int paramInt, long[] paramArrayOfLong)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfLong.length)
    {
      paramArrayOfLong[paramInt] = littleEndianToLong(paramArrayOfByte, i);
      i += 8;
      paramInt += 1;
    }
  }
  
  public static short littleEndianToShort(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (short)((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | i & 0xFF);
  }
  
  public static void longToBigEndian(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    intToBigEndian((int)(paramLong >>> 32), paramArrayOfByte, paramInt);
    intToBigEndian((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt + 4);
  }
  
  public static void longToBigEndian(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfLong.length)
    {
      longToBigEndian(paramArrayOfLong[paramInt], paramArrayOfByte, i);
      i += 8;
      paramInt += 1;
    }
  }
  
  public static byte[] longToBigEndian(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    longToBigEndian(paramLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] longToBigEndian(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[paramArrayOfLong.length * 8];
    longToBigEndian(paramArrayOfLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void longToLittleEndian(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    intToLittleEndian((int)(0xFFFFFFFF & paramLong), paramArrayOfByte, paramInt);
    intToLittleEndian((int)(paramLong >>> 32), paramArrayOfByte, paramInt + 4);
  }
  
  public static void longToLittleEndian(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfLong.length)
    {
      longToLittleEndian(paramArrayOfLong[paramInt], paramArrayOfByte, i);
      i += 8;
      paramInt += 1;
    }
  }
  
  public static byte[] longToLittleEndian(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    longToLittleEndian(paramLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] longToLittleEndian(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[paramArrayOfLong.length * 8];
    longToLittleEndian(paramArrayOfLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void shortToLittleEndian(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)paramShort);
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort >>> 8));
  }
  
  public static byte[] shortToLittleEndian(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    shortToLittleEndian(paramShort, arrayOfByte, 0);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Pack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */