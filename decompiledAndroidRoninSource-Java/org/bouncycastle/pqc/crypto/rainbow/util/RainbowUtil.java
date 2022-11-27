package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class RainbowUtil
{
  public static byte[] convertArray(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      arrayOfByte[i] = ((byte)paramArrayOfShort[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static short[] convertArray(byte[] paramArrayOfByte)
  {
    short[] arrayOfShort = new short[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static byte[][] convertArray(short[][] paramArrayOfShort)
  {
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { paramArrayOfShort.length, paramArrayOfShort[0].length });
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      int j = 0;
      while (j < paramArrayOfShort[0].length)
      {
        arrayOfByte[i][j] = ((byte)paramArrayOfShort[i][j]);
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static short[][] convertArray(byte[][] paramArrayOfByte)
  {
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfByte.length, paramArrayOfByte[0].length });
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        arrayOfShort[i][j] = ((short)(paramArrayOfByte[i][j] & 0xFF));
        j += 1;
      }
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static byte[][][] convertArray(short[][][] paramArrayOfShort)
  {
    byte[][][] arrayOfByte = (byte[][][])Array.newInstance(Byte.TYPE, new int[] { paramArrayOfShort.length, paramArrayOfShort[0].length, paramArrayOfShort[0][0].length });
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      int j = 0;
      while (j < paramArrayOfShort[0].length)
      {
        int k = 0;
        while (k < paramArrayOfShort[0][0].length)
        {
          arrayOfByte[i][j][k] = ((byte)paramArrayOfShort[i][j][k]);
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static short[][][] convertArray(byte[][][] paramArrayOfByte)
  {
    short[][][] arrayOfShort = (short[][][])Array.newInstance(Short.TYPE, new int[] { paramArrayOfByte.length, paramArrayOfByte[0].length, paramArrayOfByte[0][0].length });
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      while (j < paramArrayOfByte[0].length)
      {
        int k = 0;
        while (k < paramArrayOfByte[0][0].length)
        {
          arrayOfShort[i][j][k] = ((short)(paramArrayOfByte[i][j][k] & 0xFF));
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static int[] convertArraytoInt(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static byte[] convertIntArray(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfByte[i] = ((byte)paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static boolean equals(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length - 1;
    boolean bool2 = true;
    while (i >= 0)
    {
      boolean bool1;
      if (paramArrayOfShort1[i] == paramArrayOfShort2[i]) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 &= bool1;
      i -= 1;
    }
    return bool2;
  }
  
  public static boolean equals(short[][] paramArrayOfShort1, short[][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i -= 1;
    while (i >= 0)
    {
      bool &= equals(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i -= 1;
    }
    return bool;
  }
  
  public static boolean equals(short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i -= 1;
    while (i >= 0)
    {
      bool &= equals(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i -= 1;
    }
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbo\\util\RainbowUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */