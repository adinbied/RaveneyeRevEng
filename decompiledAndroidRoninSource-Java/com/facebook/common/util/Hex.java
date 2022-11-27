package com.facebook.common.util;

public class Hex
{
  private static final byte[] DIGITS;
  private static final char[] FIRST_CHAR;
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] SECOND_CHAR;
  
  static
  {
    FIRST_CHAR = new char['Ā'];
    SECOND_CHAR = new char['Ā'];
    int k = 0;
    int j = 0;
    Object localObject;
    while (j < 256)
    {
      localObject = FIRST_CHAR;
      char[] arrayOfChar = HEX_DIGITS;
      localObject[j] = arrayOfChar[(j >> 4 & 0xF)];
      SECOND_CHAR[j] = arrayOfChar[(j & 0xF)];
      j += 1;
    }
    DIGITS = new byte[103];
    j = 0;
    while (j <= 70)
    {
      DIGITS[j] = -1;
      j += 1;
    }
    for (int i = 0;; i = (byte)(i + 1))
    {
      j = k;
      if (i >= 10) {
        break;
      }
      DIGITS[(i + 48)] = i;
    }
    while (j < 6)
    {
      localObject = DIGITS;
      i = (byte)(j + 10);
      localObject[(j + 65)] = i;
      localObject[(j + 97)] = i;
      j = (byte)(j + 1);
    }
  }
  
  public static String byte2Hex(int paramInt)
  {
    if ((paramInt <= 255) && (paramInt >= 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(FIRST_CHAR[paramInt]));
      localStringBuilder.append(String.valueOf(SECOND_CHAR[paramInt]));
      return localStringBuilder.toString();
    }
    throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
  }
  
  public static byte[] decodeHex(String paramString)
  {
    int n = paramString.length();
    if ((n & 0x1) == 0)
    {
      Object localObject = new byte[n >> 1];
      int m = 0;
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= n) {
          break;
        }
        k = j + 1;
        j = paramString.charAt(j);
        if (j > 102) {}
        int i1;
        do
        {
          do
          {
            do
            {
              k = 1;
              break;
              j = DIGITS[j];
            } while (j == -1);
            i1 = paramString.charAt(k);
          } while (i1 > 102);
          i1 = DIGITS[i1];
        } while (i1 == -1);
        localObject[i] = ((byte)(j << 4 | i1));
        i += 1;
        j = k + 1;
      }
      if (k == 0) {
        return (byte[])localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid hexadecimal digit: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("Odd number of characters.");
  }
  
  public static String encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      if ((k == 0) && (paramBoolean)) {
        break;
      }
      int m = j + 1;
      arrayOfChar[j] = FIRST_CHAR[k];
      j = m + 1;
      arrayOfChar[m] = SECOND_CHAR[k];
      i += 1;
    }
    return new String(arrayOfChar, 0, j);
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    return decodeHex(paramString.replaceAll(" ", ""));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\commo\\util\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */