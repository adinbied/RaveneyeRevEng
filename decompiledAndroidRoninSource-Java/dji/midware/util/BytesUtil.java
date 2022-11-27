package dji.midware.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class BytesUtil
{
  private static final int[] INTERVAL = { 48, 57, 65, 90, 97, 122 };
  
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
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      Object localObject = str;
      if (str.length() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuffer.append(" ");
      localStringBuffer.append((String)localObject);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String byte2hex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str = "";
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
  
  private static byte[] fillBytes(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt -= paramArrayOfByte.length;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramInt > 0) {
      arrayOfByte = arrayComb(paramArrayOfByte, new byte[paramInt]);
    }
    return arrayOfByte;
  }
  
  public static <T extends Number> T get(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[paramInt2];
    }
    else if (paramArrayOfByte.length < paramInt1 + paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      if (paramArrayOfByte.length > paramInt1) {
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramArrayOfByte.length - paramInt1);
      }
      paramArrayOfByte = arrayOfByte;
    }
    else
    {
      paramArrayOfByte = readBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    if (paramClass == Short.class) {
      return Short.valueOf(getShort(paramArrayOfByte));
    }
    if (paramClass == Integer.class) {
      return Integer.valueOf(getInt(paramArrayOfByte));
    }
    if (paramClass == Long.class) {
      return Long.valueOf(getLong(paramArrayOfByte));
    }
    if (paramClass == Float.class) {
      return Float.valueOf(getFloat(paramArrayOfByte));
    }
    if (paramClass == Double.class) {
      return Double.valueOf(getDouble(paramArrayOfByte));
    }
    if (paramClass == BigInteger.class) {
      return Integer.valueOf(getInt(paramArrayOfByte));
    }
    if (paramClass == Byte.class) {
      return Short.valueOf(getSignedInt(paramArrayOfByte[0]));
    }
    return null;
  }
  
  public static String getBinaryStrFromByte(byte paramByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((byte)(paramByte >> 7 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 6 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 5 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 4 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 3 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 2 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 1 & 0x1));
    localStringBuilder.append((byte)(paramByte >> 0 & 0x1));
    return localStringBuilder.toString();
  }
  
  public static String getBinaryStrFromByteArr(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    String str = "";
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
  
  public static byte getByte(int paramInt)
  {
    return (byte)(paramInt & 0xFF);
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
  
  public static float getFloat(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }
  
  public static float getFloat(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4), paramInt, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
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
  
  public static short getInt(byte paramByte)
  {
    return (short)(paramByte & 0xFF);
  }
  
  public static long getLong(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8), paramInt, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static short getShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort();
  }
  
  public static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 2), paramInt, 2).order(ByteOrder.LITTLE_ENDIAN).getShort();
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
    int i = 0;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break label40;
      }
      if ((paramArrayOfByte[i] == 0) || (paramArrayOfByte[i] == -1)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = readBytes(paramArrayOfByte, 0, i);
    label40:
    return getString(arrayOfByte, "GBK");
  }
  
  public static String getString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j;
    for (;;)
    {
      j = paramInt2;
      if (i >= paramInt2) {
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
    int i = 0;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break label40;
      }
      if ((paramArrayOfByte[i] == 0) || (paramArrayOfByte[i] == -1)) {
        break;
      }
      i += 1;
    }
    byte[] arrayOfByte = readBytes(paramArrayOfByte, 0, i);
    label40:
    return getString(arrayOfByte, "UTF-8");
  }
  
  public static String getStringUTF8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j;
    for (;;)
    {
      j = paramInt2;
      if (i >= paramInt2) {
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\BytesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */