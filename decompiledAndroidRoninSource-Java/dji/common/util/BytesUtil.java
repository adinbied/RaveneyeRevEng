package dji.common.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class BytesUtil
{
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
  
  public static String byte2hex(byte[] paramArrayOfByte)
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
      ((StringBuilder)localObject2).append(" ");
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
  
  public static byte[] getBytes(String paramString1, String paramString2)
  {
    return paramString1.getBytes(Charset.forName(paramString2));
  }
  
  public static byte[] getBytes(short paramShort)
  {
    return new byte[] { (byte)(paramShort & 0xFF), (byte)((paramShort & 0xFF00) >> 8) };
  }
  
  public static double getDouble(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8)).order(ByteOrder.LITTLE_ENDIAN).getDouble();
  }
  
  public static float getFloat(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }
  
  public static int getInt(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
  
  public static int getInt(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
  }
  
  public static short getInt(byte paramByte)
  {
    return (short)(paramByte & 0xFF);
  }
  
  public static long getLong(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
  }
  
  public static short getShort(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(fillBytes(paramArrayOfByte, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort();
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
    byte[] arrayOfByte;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] == 0)
      {
        arrayOfByte = readBytes(paramArrayOfByte, 0, i);
        break;
      }
      i += 1;
    }
    return getString(arrayOfByte, "US-ASCII");
  }
  
  public static String getString(byte[] paramArrayOfByte, String paramString)
  {
    return new String(paramArrayOfByte, Charset.forName(paramString));
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
  
  public static byte[] readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      arrayOfByte[i] = paramArrayOfByte[(paramInt1 + i)];
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\BytesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */