package com.dji.video.framing.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Formatter;

public class BytesUtil
{
  private static final int[] INTERVAL = { 48, 57, 65, 90, 97, 122 };
  public static byte[] getLongBuf;
  public static int getLongCurIndex = 0;
  
  public static byte[] arrayApend(byte[] paramArrayOfByte, byte paramByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    arrayOfByte[paramArrayOfByte.length] = paramByte;
    return arrayOfByte;
  }
  
  public static byte[] arrayComb(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static byte[] arrayPop(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = paramArrayOfByte.length - paramInt;
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public static byte[] arrayRemove(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length - paramInt;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static byte[] arraycopy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
    return paramArrayOfByte2;
  }
  
  public static byte[] arraycopy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt, paramArrayOfByte1.length);
    return paramArrayOfByte2;
  }
  
  public static String byte2hex(byte paramByte)
  {
    String str = Integer.toHexString(paramByte & 0xFF);
    Object localObject = str;
    if (str.length() == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  public static String byte2hex(int paramInt)
  {
    String str = Integer.toHexString(paramInt & 0xFF);
    Object localObject = str;
    if (str.length() == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  public static String byte2hex(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return str;
  }
  
  public static String byte2hex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return str;
  }
  
  public static String byte2hex(byte[] paramArrayOfByte, String paramString)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (i == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append((String)localObject1);
        str = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append((String)localObject1);
        str = ((StringBuilder)localObject2).toString();
      }
      i += 1;
    }
    return str;
  }
  
  public static String byte2hexNoSep(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append((String)localObject1);
      str = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    return str;
  }
  
  public static long calcPerByteSum(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      l += (paramArrayOfByte[i] & 0xFF);
      i += 1;
    }
    return l;
  }
  
  public static int convertFourBytesToSignedInt(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return (paramByte4 << 24) + (paramByte3 << 16) + (paramByte2 << 8) + paramByte1;
  }
  
  public static int convertTwoBytesToSignedInt(byte paramByte1, byte paramByte2)
  {
    return paramByte1 & 0xFF | paramByte2 << 8;
  }
  
  private static byte[] fillBytes(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt -= paramArrayOfByte.length;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramInt > 0) {
      arrayOfByte = arrayComb(paramArrayOfByte, new byte[paramInt]);
    }
    return arrayOfByte;
  }
  
  public static String getBinaryStrFromByte(byte paramByte)
  {
    String str = "";
    byte b = 0;
    int i = paramByte;
    paramByte = b;
    while (paramByte < 8)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i % 2);
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      i = (byte)(i >> 1);
      paramByte += 1;
    }
    return str;
  }
  
  public static String getBinaryStrFromByteArr(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(getBinaryStrFromByte(b));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static int getBitsFromByte(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt3 > 8) {
        return -1;
      }
      int i = 0;
      int j = 1;
      while (i < paramInt3)
      {
        j *= 2;
        i += 1;
      }
      return paramInt1 >> paramInt2 & j - 1;
    }
    return -1;
  }
  
  public static byte getByte(int paramInt)
  {
    return (byte)(paramInt & 0xFF);
  }
  
  public static byte getByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    paramInt2 = paramArrayOfByte.length;
    if ((paramInt2 != 0) && (paramInt1 >= 0))
    {
      if (paramInt2 <= paramInt1) {
        return 0;
      }
      return (byte)(paramArrayOfByte[paramInt1] & 0xFF);
    }
    return 0;
  }
  
  public static byte[] getBytes(char paramChar)
  {
    return new byte[] { (byte)paramChar, (byte)(paramChar >> '\b') };
  }
  
  public static byte[] getBytes(double paramDouble)
  {
    return getBytes(Double.doubleToLongBits(paramDouble));
  }
  
  public static byte[] getBytes(float paramFloat)
  {
    return getBytes(Float.floatToIntBits(paramFloat));
  }
  
  public static byte[] getBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((paramInt & 0xFF000000) >> 24) };
  }
  
  public static byte[] getBytes(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong & 0xFF), (byte)(int)(paramLong >> 8 & 0xFF), (byte)(int)(paramLong >> 16 & 0xFF), (byte)(int)(paramLong >> 24 & 0xFF), (byte)(int)(paramLong >> 32 & 0xFF), (byte)(int)(paramLong >> 40 & 0xFF), (byte)(int)(paramLong >> 48 & 0xFF), (byte)(int)(paramLong >> 56 & 0xFF) };
  }
  
  public static byte[] getBytes(String paramString)
  {
    return getBytes(paramString, "GBK");
  }
  
  private static byte[] getBytes(String paramString1, String paramString2)
  {
    return paramString1.getBytes(Charset.forName(paramString2));
  }
  
  public static byte[] getBytes(short paramShort)
  {
    return new byte[] { (byte)(paramShort & 0xFF), (byte)((paramShort & 0xFF00) >> 8) };
  }
  
  public static byte[] getBytesUTF8(String paramString)
  {
    return getBytes(paramString, "UTF-8");
  }
  
  public static double getDouble(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8)).order(ByteOrder.LITTLE_ENDIAN).getDouble();
  }
  
  public static double getDouble(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8), paramInt, 8).order(ByteOrder.LITTLE_ENDIAN).getDouble();
  }
  
  public static double getDouble(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Double.longBitsToDouble(getLong(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static float getFloat(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }
  
  public static float getFloat(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4), paramInt, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }
  
  public static float getFloat(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Float.intBitsToFloat(getInt(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int getInt(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  public static int getInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4), paramInt, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public static int getInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 0;
    if (paramArrayOfByte == null) {
      return 0;
    }
    int m = paramArrayOfByte.length;
    int i = j;
    if (m != 0)
    {
      i = j;
      if (paramInt1 >= 0)
      {
        if (m <= paramInt1) {
          return 0;
        }
        j = m - paramInt1;
        i = paramInt2;
        if (paramInt2 > j) {
          i = j;
        }
        j = i + paramInt1 - 1;
        paramInt2 = k;
        for (;;)
        {
          i = paramInt2;
          if (j < paramInt1) {
            break;
          }
          paramInt2 = paramInt2 << 8 | paramArrayOfByte[j] & 0xFF;
          j -= 1;
        }
      }
    }
    return i;
  }
  
  public static short getInt(byte paramByte)
  {
    return (short)(paramByte & 0xFF);
  }
  
  public static int getIntFromBytes(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    return (int)(getLongFromBytes(paramArrayOfByte, paramVarArgs) & 0xFFFFFFFFFFFFFFFF);
  }
  
  public static long getLong(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8), paramInt, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static long getLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if (paramArrayOfByte == null) {
      return 0L;
    }
    int i = paramArrayOfByte.length;
    long l2 = l1;
    if (i != 0)
    {
      l2 = l1;
      if (paramInt1 >= 0)
      {
        if (i <= paramInt1) {
          return 0L;
        }
        int j = i - paramInt1;
        i = paramInt2;
        if (paramInt2 > j) {
          i = j;
        }
        paramInt2 = i + paramInt1 - 1;
        for (;;)
        {
          l2 = l1;
          if (paramInt2 < paramInt1) {
            break;
          }
          l1 = l1 << 8 | paramArrayOfByte[paramInt2] & 0xFF;
          paramInt2 -= 1;
        }
      }
    }
    return l2;
  }
  
  public static long getLongFromBytes(byte... paramVarArgs)
  {
    int j = Math.min(8, paramVarArgs.length);
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l += ((paramVarArgs[i] & 0xFF) << i * 8);
      i += 1;
    }
    return l;
  }
  
  public static long getLongFromBytes(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    if (getLongBuf == null) {
      getLongBuf = new byte[8];
    }
    byte[] arrayOfByte = getLongBuf;
    int i = 0;
    Arrays.fill(arrayOfByte, (byte)0);
    getLongCurIndex = 0;
    int j = paramVarArgs.length;
    while (i < j)
    {
      int k = paramVarArgs[i];
      arrayOfByte = getLongBuf;
      int m = getLongCurIndex;
      getLongCurIndex = m + 1;
      arrayOfByte[m] = paramArrayOfByte[k];
      i += 1;
    }
    return ByteBuffer.wrap(fillBytes(getLongBuf, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static short getShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort();
  }
  
  public static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 2), paramInt, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
  }
  
  public static short getShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    short s3 = 0;
    short s1 = 0;
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = paramArrayOfByte.length;
    short s2 = s3;
    if (i != 0)
    {
      s2 = s3;
      if (paramInt1 >= 0)
      {
        if (i <= paramInt1) {
          return 0;
        }
        int j = i - paramInt1;
        i = paramInt2;
        if (paramInt2 > j) {
          i = j;
        }
        paramInt2 = i + paramInt1 - 1;
        for (;;)
        {
          s2 = s1;
          if (paramInt2 < paramInt1) {
            break;
          }
          s1 = (short)(s1 << 8 | paramArrayOfByte[paramInt2] & 0xFF);
          paramInt2 -= 1;
        }
      }
    }
    return s2;
  }
  
  public static int getSignedInt(short paramShort)
  {
    return paramShort;
  }
  
  public static short getSignedInt(byte paramByte)
  {
    return (short)paramByte;
  }
  
  public static String getString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break label47;
      }
      if ((paramArrayOfByte[i] == 0) || (paramArrayOfByte[i] == -1)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = readBytes(paramArrayOfByte, 0, i);
    label47:
    return getString(arrayOfByte, "GBK");
  }
  
  public static String getString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        j = paramInt2;
        if (i >= paramInt2) {
          break;
        }
        j = paramInt2;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[i] == 0)
        {
          j = i - paramInt1;
          break;
        }
        i += 1;
      }
      return getString(paramArrayOfByte, paramInt1, j, "GBK");
    }
    return "";
  }
  
  private static String getString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    return new String(paramArrayOfByte, paramInt1, paramInt2, Charset.forName(paramString));
  }
  
  private static String getString(byte[] paramArrayOfByte, String paramString)
  {
    return new String(paramArrayOfByte, Charset.forName(paramString));
  }
  
  public static String getStringUTF8(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break label47;
      }
      if ((paramArrayOfByte[i] == 0) || (paramArrayOfByte[i] == -1)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = readBytes(paramArrayOfByte, 0, i);
    label47:
    return getString(arrayOfByte, "UTF-8");
  }
  
  public static String getStringUTF8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        j = paramInt2;
        if (i >= paramInt2) {
          break;
        }
        j = paramInt2;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[i] == 0)
        {
          j = i - paramInt1;
          break;
        }
        i += 1;
      }
      return getString(paramArrayOfByte, paramInt1, j, "UTF-8");
    }
    return "";
  }
  
  public static String getStringUTF8Offset(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      int i = paramInt1;
      int j;
      for (;;)
      {
        j = paramInt2;
        if (i >= paramInt1 + paramInt2) {
          break;
        }
        j = paramInt2;
        if (i >= paramArrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[i] == 0)
        {
          j = i - paramInt1;
          break;
        }
        i += 1;
      }
      return new String(paramArrayOfByte, paramInt1, j, Charset.forName("UTF-8"));
    }
    return "";
  }
  
  public static long getUInt(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 4);
    return ByteBuffer.wrap(fillBytes(arrayOfByte, 8), 0, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static int getUShort(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 2);
    return ByteBuffer.wrap(fillBytes(arrayOfByte, 4), 0, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public static byte getUnsignedBytes(short paramShort)
  {
    return (byte)(paramShort & 0xFF);
  }
  
  public static byte[] getUnsignedBytes(double paramDouble)
  {
    return getUnsignedBytes(Double.doubleToLongBits(paramDouble));
  }
  
  public static byte[] getUnsignedBytes(float paramFloat)
  {
    return getUnsignedBytes(Float.floatToIntBits(paramFloat));
  }
  
  public static byte[] getUnsignedBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((paramInt & 0xFF00) >> 8) };
  }
  
  public static byte[] getUnsignedBytes(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong & 0xFF), (byte)(int)(paramLong >> 8 & 0xFF), (byte)(int)(paramLong >> 16 & 0xFF), (byte)(int)(paramLong >> 24 & 0xFF) };
  }
  
  public static long getUnsignedLong(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    if ((paramArrayOfByte != null) && (paramInt < paramArrayOfByte.length))
    {
      long l = 0L;
      int k = Math.min(paramArrayOfByte.length - paramInt, 8);
      int i = 0;
      while (i < k)
      {
        int j;
        if (paramByteOrder == ByteOrder.BIG_ENDIAN) {
          j = paramArrayOfByte[(i + paramInt)];
        } else {
          j = paramArrayOfByte[(k - i + paramInt - 1)];
        }
        j &= 0xFF;
        if ((i == 0) && (paramArrayOfByte.length - paramInt >= 8) && (j > 127)) {
          return Long.MAX_VALUE;
        }
        l = (l << 8) + j;
        i += 1;
      }
      return l;
    }
    return -1L;
  }
  
  public static long getUnsignedLong(byte[] paramArrayOfByte, ByteOrder paramByteOrder)
  {
    return getUnsignedLong(paramArrayOfByte, 0, paramByteOrder);
  }
  
  public static byte[] hex2byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.trim();
    int i = paramString.length();
    byte[] arrayOfByte;
    if (i != 0)
    {
      if (i % 2 == 1) {
        return null;
      }
      arrayOfByte = new byte[i / 2];
      i = 0;
    }
    try
    {
      while (i < paramString.length())
      {
        int k = i / 2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("0X");
        int j = i + 2;
        localStringBuilder.append(paramString.substring(i, j));
        arrayOfByte[k] = ((byte)Integer.decode(localStringBuilder.toString()).intValue());
        i = j;
      }
      return arrayOfByte;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  public static boolean isNumberOrLetter(byte paramByte)
  {
    int[] arrayOfInt = INTERVAL;
    boolean bool2 = false;
    if ((arrayOfInt[0] > paramByte) || (paramByte > arrayOfInt[1]))
    {
      arrayOfInt = INTERVAL;
      if ((arrayOfInt[2] > paramByte) || (paramByte > arrayOfInt[3]))
      {
        arrayOfInt = INTERVAL;
        bool1 = bool2;
        if (arrayOfInt[4] > paramByte) {
          return bool1;
        }
        bool1 = bool2;
        if (paramByte > arrayOfInt[5]) {
          return bool1;
        }
      }
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public static int kmp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (i != paramInt2)
    {
      j = paramInt1;
      int k = i;
      if (i >= paramArrayOfByte1.length) {
        k = 0;
      }
      for (j = paramInt1; (j > 0) && (paramArrayOfByte1[k] != paramArrayOfByte2[j]); j = paramArrayOfInt[(j - 1)]) {}
      paramInt1 = j;
      if (paramArrayOfByte1[k] == paramArrayOfByte2[j]) {
        paramInt1 = j + 1;
      }
      if (paramInt1 == paramArrayOfByte2.length)
      {
        paramInt2 = k - paramInt1 + 1;
        paramInt1 = paramInt2;
        if (paramInt2 < 0) {
          paramInt1 = paramInt2 + paramArrayOfByte1.length;
        }
        return paramInt1;
      }
      i = k + 1;
    }
    return -1;
  }
  
  public static int[] kmpNext(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length];
    int i = 0;
    arrayOfInt[0] = 0;
    int k = 1;
    while (k < paramArrayOfByte.length)
    {
      for (int j = i; (j > 0) && (paramArrayOfByte[j] != paramArrayOfByte[k]); j = arrayOfInt[(j - 1)]) {}
      i = j;
      if (paramArrayOfByte[k] == paramArrayOfByte[j]) {
        i = j + 1;
      }
      arrayOfInt[k] = i;
      k += 1;
    }
    return arrayOfInt;
  }
  
  public static byte parseBcd(int paramInt)
  {
    return (byte)(paramInt / 10 * 16 + paramInt % 10);
  }
  
  public static byte[] readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    Formatter localFormatter = new Formatter();
    try
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        localFormatter.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) });
        i += 1;
      }
      paramArrayOfByte = localFormatter.toString();
      return paramArrayOfByte;
    }
    finally
    {
      localFormatter.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\BytesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */