package com.huawei.hms.c;

public final class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static char[] a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar;
    if (paramBoolean) {
      arrayOfChar = b;
    } else {
      arrayOfChar = a;
    }
    return a(paramArrayOfByte, arrayOfChar);
  }
  
  private static char[] a(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new String(a(paramArrayOfByte, paramBoolean));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */