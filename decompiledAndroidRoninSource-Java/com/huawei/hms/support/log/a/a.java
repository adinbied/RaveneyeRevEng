package com.huawei.hms.support.log.a;

public final class a
{
  private static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61 };
  private static final byte[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    char[] arrayOfChar1 = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int m = (paramArrayOfByte[j] & 0xFF) << 8;
      int k = j + 1;
      int n = 1;
      if (k < paramInt)
      {
        m |= paramArrayOfByte[k] & 0xFF;
        k = 1;
      }
      else
      {
        k = 0;
      }
      m <<= 8;
      int i1 = j + 2;
      if (i1 < paramInt) {
        m |= paramArrayOfByte[i1] & 0xFF;
      } else {
        n = 0;
      }
      char[] arrayOfChar2 = a;
      i1 = 64;
      if (n != 0) {
        n = m & 0x3F;
      } else {
        n = 64;
      }
      arrayOfChar1[(i + 3)] = arrayOfChar2[n];
      n = m >> 6;
      arrayOfChar2 = a;
      m = i1;
      if (k != 0) {
        m = n & 0x3F;
      }
      arrayOfChar1[(i + 2)] = arrayOfChar2[m];
      k = n >> 6;
      arrayOfChar2 = a;
      arrayOfChar1[(i + 1)] = arrayOfChar2[(k & 0x3F)];
      arrayOfChar1[(i + 0)] = arrayOfChar2[(k >> 6 & 0x3F)];
      j += 3;
      i += 4;
    }
    return new String(arrayOfChar1);
  }
  
  public static byte[] a(String paramString)
  {
    int i = b(paramString);
    int j = i / 4 * 3;
    int k = i % 4;
    i = j;
    if (k == 3) {
      i = j + 2;
    }
    j = i;
    if (k == 2) {
      j = i + 1;
    }
    byte[] arrayOfByte = new byte[j];
    k = 0;
    int m = 0;
    int n = 0;
    for (int i1 = 0; k < paramString.length(); i1 = i)
    {
      i = paramString.charAt(k);
      int i4;
      if (i > 255) {
        i4 = -1;
      } else {
        i4 = b[i];
      }
      int i3 = m;
      int i2 = n;
      i = i1;
      if (i4 >= 0)
      {
        i1 += 6;
        n = n << 6 | i4;
        i3 = m;
        i2 = n;
        i = i1;
        if (i1 >= 8)
        {
          i = i1 - 8;
          arrayOfByte[m] = ((byte)(0xFF & n >> i));
          i3 = m + 1;
          i2 = n;
        }
      }
      k += 1;
      m = i3;
      n = i2;
    }
    if (m != j) {
      return new byte[0];
    }
    return arrayOfByte;
  }
  
  private static int b(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < paramString.length())
    {
      int m = paramString.charAt(i);
      int k;
      if (m <= 255)
      {
        k = j;
        if (b[m] >= 0) {}
      }
      else
      {
        k = j - 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\log\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */