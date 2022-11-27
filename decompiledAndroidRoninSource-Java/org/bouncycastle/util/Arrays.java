package org.bouncycastle.util;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Arrays
{
  public static byte[] append(byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null) {
      return new byte[] { paramByte };
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    arrayOfByte[i] = paramByte;
    return arrayOfByte;
  }
  
  public static int[] append(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[] { paramInt };
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 1];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    arrayOfInt[i] = paramInt;
    return arrayOfInt;
  }
  
  public static String[] append(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {
      return new String[] { paramString };
    }
    int i = paramArrayOfString.length;
    String[] arrayOfString = new String[i + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
    arrayOfString[i] = paramString;
    return arrayOfString;
  }
  
  public static short[] append(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return new short[] { paramShort };
    }
    int i = paramArrayOfShort.length;
    short[] arrayOfShort = new short[i + 1];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, i);
    arrayOfShort[i] = paramShort;
    return arrayOfShort;
  }
  
  public static boolean areEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return true;
    }
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    if (paramArrayOfChar1 == paramArrayOfChar2) {
      return true;
    }
    if (paramArrayOfChar1 != null)
    {
      if (paramArrayOfChar2 == null) {
        return false;
      }
      if (paramArrayOfChar1.length != paramArrayOfChar2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfChar1.length)
      {
        if (paramArrayOfChar1[i] != paramArrayOfChar2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == paramArrayOfInt2) {
      return true;
    }
    if (paramArrayOfInt1 != null)
    {
      if (paramArrayOfInt2 == null) {
        return false;
      }
      if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfInt1.length)
      {
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == paramArrayOfLong2) {
      return true;
    }
    if (paramArrayOfLong1 != null)
    {
      if (paramArrayOfLong2 == null) {
        return false;
      }
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfLong1.length)
      {
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramArrayOfObject1 == paramArrayOfObject2) {
      return true;
    }
    if (paramArrayOfObject1 != null)
    {
      if (paramArrayOfObject2 == null) {
        return false;
      }
      if (paramArrayOfObject1.length != paramArrayOfObject2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfObject1.length)
      {
        Object localObject1 = paramArrayOfObject1[i];
        Object localObject2 = paramArrayOfObject2[i];
        if (localObject1 == null)
        {
          if (localObject2 != null) {
            return false;
          }
        }
        else if (!localObject1.equals(localObject2)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1 == paramArrayOfShort2) {
      return true;
    }
    if (paramArrayOfShort1 != null)
    {
      if (paramArrayOfShort2 == null) {
        return false;
      }
      if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfShort1.length)
      {
        if (paramArrayOfShort1[i] != paramArrayOfShort2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean areEqual(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    if (paramArrayOfBoolean1 == paramArrayOfBoolean2) {
      return true;
    }
    if (paramArrayOfBoolean1 != null)
    {
      if (paramArrayOfBoolean2 == null) {
        return false;
      }
      if (paramArrayOfBoolean1.length != paramArrayOfBoolean2.length) {
        return false;
      }
      int i = 0;
      while (i != paramArrayOfBoolean1.length)
      {
        if (paramArrayOfBoolean1[i] != paramArrayOfBoolean2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static byte[] clone(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] clone(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return null;
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length == paramArrayOfByte1.length))
    {
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte2.length);
      return paramArrayOfByte2;
    }
    return clone(paramArrayOfByte1);
  }
  
  public static char[] clone(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
    return arrayOfChar;
  }
  
  public static int[] clone(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public static long[] clone(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    long[] arrayOfLong = new long[paramArrayOfLong.length];
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramArrayOfLong.length);
    return arrayOfLong;
  }
  
  public static long[] clone(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (paramArrayOfLong1 == null) {
      return null;
    }
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length == paramArrayOfLong1.length))
    {
      System.arraycopy(paramArrayOfLong1, 0, paramArrayOfLong2, 0, paramArrayOfLong2.length);
      return paramArrayOfLong2;
    }
    return clone(paramArrayOfLong1);
  }
  
  public static BigInteger[] clone(BigInteger[] paramArrayOfBigInteger)
  {
    if (paramArrayOfBigInteger == null) {
      return null;
    }
    BigInteger[] arrayOfBigInteger = new BigInteger[paramArrayOfBigInteger.length];
    System.arraycopy(paramArrayOfBigInteger, 0, arrayOfBigInteger, 0, paramArrayOfBigInteger.length);
    return arrayOfBigInteger;
  }
  
  public static short[] clone(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return null;
    }
    short[] arrayOfShort = new short[paramArrayOfShort.length];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 0, paramArrayOfShort.length);
    return arrayOfShort;
  }
  
  public static byte[][] clone(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return (byte[][])null;
    }
    int j = paramArrayOfByte.length;
    byte[][] arrayOfByte = new byte[j][];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = clone(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[][][] clone(byte[][][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return (byte[][][])null;
    }
    int j = paramArrayOfByte.length;
    byte[][][] arrayOfByte = new byte[j][][];
    int i = 0;
    while (i != j)
    {
      arrayOfByte[i] = clone(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int compareUnsigned(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return 0;
    }
    if (paramArrayOfByte1 == null) {
      return -1;
    }
    if (paramArrayOfByte2 == null) {
      return 1;
    }
    int j = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte1[i] & 0xFF;
      int m = paramArrayOfByte2[i] & 0xFF;
      if (k < m) {
        return -1;
      }
      if (k > m) {
        return 1;
      }
      i += 1;
    }
    if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
      return -1;
    }
    if (paramArrayOfByte1.length > paramArrayOfByte2.length) {
      return 1;
    }
    return 0;
  }
  
  public static byte[] concatenate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte2 != null) {
      return clone(paramArrayOfByte2);
    }
    return clone(paramArrayOfByte1);
  }
  
  public static byte[] concatenate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length, paramArrayOfByte3.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte1 == null) {
      return concatenate(paramArrayOfByte2, paramArrayOfByte3);
    }
    if (paramArrayOfByte2 == null) {
      return concatenate(paramArrayOfByte1, paramArrayOfByte3);
    }
    return concatenate(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] concatenate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte4 != null))
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length + paramArrayOfByte4.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length, paramArrayOfByte4.length);
      return arrayOfByte;
    }
    if (paramArrayOfByte4 == null) {
      return concatenate(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    }
    if (paramArrayOfByte3 == null) {
      return concatenate(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte4);
    }
    if (paramArrayOfByte2 == null) {
      return concatenate(paramArrayOfByte1, paramArrayOfByte3, paramArrayOfByte4);
    }
    return concatenate(paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
  }
  
  public static byte[] concatenate(byte[][] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfByte.length)
    {
      j += paramArrayOfByte[i].length;
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    i = 0;
    j = 0;
    while (i != paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte[i], 0, arrayOfByte, j, paramArrayOfByte[i].length);
      j += paramArrayOfByte[i].length;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int[] concatenate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 == null) {
      return clone(paramArrayOfInt2);
    }
    if (paramArrayOfInt2 == null) {
      return clone(paramArrayOfInt1);
    }
    int[] arrayOfInt = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
    System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 0, paramArrayOfInt1.length);
    System.arraycopy(paramArrayOfInt2, 0, arrayOfInt, paramArrayOfInt1.length, paramArrayOfInt2.length);
    return arrayOfInt;
  }
  
  public static boolean constantTimeAreEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      return true;
    }
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
        return false;
      }
      int i = 0;
      int j = 0;
      while (i != paramArrayOfByte1.length)
      {
        j |= paramArrayOfByte1[i] ^ paramArrayOfByte2[i];
        i += 1;
      }
      return j == 0;
    }
    return false;
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (paramArrayOfShort[i] == paramShort) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static byte[] copyOf(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (paramInt >= paramArrayOfByte.length) {
      paramInt = paramArrayOfByte.length;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public static char[] copyOf(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    if (paramInt >= paramArrayOfChar.length) {
      paramInt = paramArrayOfChar.length;
    }
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt);
    return arrayOfChar;
  }
  
  public static int[] copyOf(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    if (paramInt >= paramArrayOfInt.length) {
      paramInt = paramArrayOfInt.length;
    }
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
  
  public static long[] copyOf(long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    if (paramInt >= paramArrayOfLong.length) {
      paramInt = paramArrayOfLong.length;
    }
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramInt);
    return arrayOfLong;
  }
  
  public static BigInteger[] copyOf(BigInteger[] paramArrayOfBigInteger, int paramInt)
  {
    BigInteger[] arrayOfBigInteger = new BigInteger[paramInt];
    if (paramInt >= paramArrayOfBigInteger.length) {
      paramInt = paramArrayOfBigInteger.length;
    }
    System.arraycopy(paramArrayOfBigInteger, 0, arrayOfBigInteger, 0, paramInt);
    return arrayOfBigInteger;
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = getLength(paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[i];
    paramInt2 = i;
    if (paramArrayOfByte.length - paramInt1 < i) {
      paramInt2 = paramArrayOfByte.length - paramInt1;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static int[] copyOfRange(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = getLength(paramInt1, paramInt2);
    int[] arrayOfInt = new int[i];
    paramInt2 = i;
    if (paramArrayOfInt.length - paramInt1 < i) {
      paramInt2 = paramArrayOfInt.length - paramInt1;
    }
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, 0, paramInt2);
    return arrayOfInt;
  }
  
  public static long[] copyOfRange(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int i = getLength(paramInt1, paramInt2);
    long[] arrayOfLong = new long[i];
    paramInt2 = i;
    if (paramArrayOfLong.length - paramInt1 < i) {
      paramInt2 = paramArrayOfLong.length - paramInt1;
    }
    System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, 0, paramInt2);
    return arrayOfLong;
  }
  
  public static BigInteger[] copyOfRange(BigInteger[] paramArrayOfBigInteger, int paramInt1, int paramInt2)
  {
    int i = getLength(paramInt1, paramInt2);
    BigInteger[] arrayOfBigInteger = new BigInteger[i];
    paramInt2 = i;
    if (paramArrayOfBigInteger.length - paramInt1 < i) {
      paramInt2 = paramArrayOfBigInteger.length - paramInt1;
    }
    System.arraycopy(paramArrayOfBigInteger, paramInt1, arrayOfBigInteger, 0, paramInt2);
    return arrayOfBigInteger;
  }
  
  public static void fill(byte[] paramArrayOfByte, byte paramByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = paramByte;
      i += 1;
    }
  }
  
  public static void fill(char[] paramArrayOfChar, char paramChar)
  {
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = paramChar;
      i += 1;
    }
  }
  
  public static void fill(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfInt[i] = paramInt;
      i += 1;
    }
  }
  
  public static void fill(long[] paramArrayOfLong, long paramLong)
  {
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] = paramLong;
      i += 1;
    }
  }
  
  public static void fill(short[] paramArrayOfShort, short paramShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      paramArrayOfShort[i] = paramShort;
      i += 1;
    }
  }
  
  private static int getLength(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i >= 0) {
      return i;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt1);
    localStringBuffer.append(" > ");
    localStringBuffer.append(paramInt2);
    throw new IllegalArgumentException(localStringBuffer.toString());
  }
  
  public static int hashCode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int j = paramArrayOfByte.length;
    for (int i = j + 1;; i = i * 257 ^ paramArrayOfByte[j])
    {
      j -= 1;
      if (j < 0) {
        break;
      }
    }
    return i;
  }
  
  public static int hashCode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int j = paramInt2 + 1;
    int i = paramInt2;
    for (paramInt2 = j;; paramInt2 = paramInt2 * 257 ^ paramArrayOfByte[(paramInt1 + i)])
    {
      i -= 1;
      if (i < 0) {
        break;
      }
    }
    return paramInt2;
  }
  
  public static int hashCode(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return 0;
    }
    int j = paramArrayOfChar.length;
    for (int i = j + 1;; i = i * 257 ^ paramArrayOfChar[j])
    {
      j -= 1;
      if (j < 0) {
        break;
      }
    }
    return i;
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return 0;
    }
    int j = paramArrayOfInt.length;
    for (int i = j + 1;; i = i * 257 ^ paramArrayOfInt[j])
    {
      j -= 1;
      if (j < 0) {
        break;
      }
    }
    return i;
  }
  
  public static int hashCode(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      return 0;
    }
    int j = paramInt2 + 1;
    int i = paramInt2;
    for (paramInt2 = j;; paramInt2 = paramInt2 * 257 ^ paramArrayOfInt[(paramInt1 + i)])
    {
      i -= 1;
      if (i < 0) {
        break;
      }
    }
    return paramInt2;
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null) {
      return 0;
    }
    int j = paramArrayOfLong.length;
    long l;
    for (int i = j + 1;; i = (i * 257 ^ (int)l) * 257 ^ (int)(l >>> 32))
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      l = paramArrayOfLong[j];
    }
    return i;
  }
  
  public static int hashCode(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (paramArrayOfLong == null) {
      return 0;
    }
    int j = paramInt2 + 1;
    int i = paramInt2;
    long l;
    for (paramInt2 = j;; paramInt2 = (paramInt2 * 257 ^ (int)l) * 257 ^ (int)(l >>> 32))
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      l = paramArrayOfLong[(paramInt1 + i)];
    }
    return paramInt2;
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    int j = paramArrayOfObject.length;
    for (int i = j + 1;; i = i * 257 ^ paramArrayOfObject[j].hashCode())
    {
      j -= 1;
      if (j < 0) {
        break;
      }
    }
    return i;
  }
  
  public static int hashCode(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return 0;
    }
    int j = paramArrayOfShort.length;
    for (int i = j + 1;; i = i * 257 ^ paramArrayOfShort[j] & 0xFF)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
    }
    return i;
  }
  
  public static int hashCode(int[][] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfInt.length)
    {
      j = j * 257 + hashCode(paramArrayOfInt[i]);
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(short[][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + hashCode(paramArrayOfShort[i]);
      i += 1;
    }
    return j;
  }
  
  public static int hashCode(short[][][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + hashCode(paramArrayOfShort[i]);
      i += 1;
    }
    return j;
  }
  
  public static byte[] prepend(byte[] paramArrayOfByte, byte paramByte)
  {
    if (paramArrayOfByte == null) {
      return new byte[] { paramByte };
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, i);
    arrayOfByte[0] = paramByte;
    return arrayOfByte;
  }
  
  public static int[] prepend(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[] { paramInt };
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 1];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 1, i);
    arrayOfInt[0] = paramInt;
    return arrayOfInt;
  }
  
  public static short[] prepend(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return new short[] { paramShort };
    }
    int i = paramArrayOfShort.length;
    short[] arrayOfShort = new short[i + 1];
    System.arraycopy(paramArrayOfShort, 0, arrayOfShort, 1, i);
    arrayOfShort[0] = paramShort;
    return arrayOfShort;
  }
  
  public static byte[] reverse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int i = 0;
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[j];
    for (;;)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      arrayOfByte[j] = paramArrayOfByte[i];
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int[] reverse(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int i = 0;
    int j = paramArrayOfInt.length;
    int[] arrayOfInt = new int[j];
    for (;;)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      arrayOfInt[j] = paramArrayOfInt[i];
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static class Iterator<T>
    implements Iterator<T>
  {
    private final T[] dataArray;
    private int position = 0;
    
    public Iterator(T[] paramArrayOfT)
    {
      this.dataArray = paramArrayOfT;
    }
    
    public boolean hasNext()
    {
      return this.position < this.dataArray.length;
    }
    
    public T next()
    {
      int i = this.position;
      Object localObject = this.dataArray;
      if (i != localObject.length)
      {
        this.position = (i + 1);
        return localObject[i];
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Out of elements: ");
      ((StringBuilder)localObject).append(this.position);
      throw new NoSuchElementException(((StringBuilder)localObject).toString());
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Cannot remove element from an Array.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Arrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */