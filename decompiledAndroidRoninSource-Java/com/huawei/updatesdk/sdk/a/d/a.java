package com.huawei.updatesdk.sdk.a.d;

public class a
{
  private static char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61 };
  
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */