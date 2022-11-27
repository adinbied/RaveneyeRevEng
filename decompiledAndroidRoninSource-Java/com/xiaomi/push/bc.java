package com.xiaomi.push;

public class bc
{
  private static final String jdField_a_of_type_JavaLangString = System.getProperty("line.separator");
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static char[] jdField_a_of_type_ArrayOfChar = new char[64];
  
  static
  {
    int m = 0;
    int i = 65;
    int j = 0;
    while (i <= 90)
    {
      jdField_a_of_type_ArrayOfChar[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 97;
    while (i <= 122)
    {
      jdField_a_of_type_ArrayOfChar[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 48;
    while (i <= 57)
    {
      jdField_a_of_type_ArrayOfChar[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    Object localObject = jdField_a_of_type_ArrayOfChar;
    localObject[j] = 43;
    localObject[(j + 1)] = 47;
    jdField_a_of_type_ArrayOfByte = new byte[''];
    j = 0;
    int k;
    for (;;)
    {
      localObject = jdField_a_of_type_ArrayOfByte;
      k = m;
      if (j >= localObject.length) {
        break;
      }
      localObject[j] = -1;
      j += 1;
    }
    while (k < 64)
    {
      jdField_a_of_type_ArrayOfByte[jdField_a_of_type_ArrayOfChar[k]] = ((byte)k);
      k += 1;
    }
  }
  
  public static String a(String paramString)
  {
    return new String(a(paramString.getBytes()));
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString.toCharArray());
  }
  
  public static byte[] a(char[] paramArrayOfChar)
  {
    return a(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static byte[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 % 4 == 0)
    {
      while ((paramInt2 > 0) && (paramArrayOfChar[(paramInt1 + paramInt2 - 1)] == '=')) {
        paramInt2 -= 1;
      }
      int m = paramInt2 * 3 / 4;
      byte[] arrayOfByte1 = new byte[m];
      int n = paramInt2 + paramInt1;
      paramInt2 = 0;
      while (paramInt1 < n)
      {
        int j = paramInt1 + 1;
        int i1 = paramArrayOfChar[paramInt1];
        int i = j + 1;
        int i2 = paramArrayOfChar[j];
        if (i < n)
        {
          paramInt1 = i + 1;
          i = paramArrayOfChar[i];
        }
        else
        {
          paramInt1 = i;
          i = 65;
        }
        int k;
        if (paramInt1 < n)
        {
          j = paramInt1 + 1;
          k = paramArrayOfChar[paramInt1];
          paramInt1 = j;
          j = k;
        }
        else
        {
          j = 65;
        }
        if ((i1 <= 127) && (i2 <= 127) && (i <= 127) && (j <= 127))
        {
          byte[] arrayOfByte2 = jdField_a_of_type_ArrayOfByte;
          k = arrayOfByte2[i1];
          i1 = arrayOfByte2[i2];
          i2 = arrayOfByte2[i];
          j = arrayOfByte2[j];
          if ((k >= 0) && (i1 >= 0) && (i2 >= 0) && (j >= 0))
          {
            i = paramInt2 + 1;
            arrayOfByte1[paramInt2] = ((byte)(k << 2 | i1 >>> 4));
            paramInt2 = i;
            if (i < m)
            {
              arrayOfByte1[i] = ((byte)((i1 & 0xF) << 4 | i2 >>> 2));
              paramInt2 = i + 1;
            }
            if (paramInt2 < m)
            {
              arrayOfByte1[paramInt2] = ((byte)((i2 & 0x3) << 6 | j));
              paramInt2 += 1;
            }
          }
          else
          {
            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
          }
        }
        else
        {
          throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        }
      }
      return arrayOfByte1;
    }
    throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static char[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = (paramInt2 * 4 + 2) / 3;
    char[] arrayOfChar1 = new char[(paramInt2 + 2) / 3 * 4];
    int i1 = paramInt2 + paramInt1;
    paramInt2 = 0;
    while (paramInt1 < i1)
    {
      int k = paramInt1 + 1;
      int i2 = paramArrayOfByte[paramInt1] & 0xFF;
      if (k < i1)
      {
        paramInt1 = k + 1;
        k = paramArrayOfByte[k] & 0xFF;
      }
      else
      {
        paramInt1 = k;
        k = 0;
      }
      int m;
      if (paramInt1 < i1)
      {
        m = paramArrayOfByte[paramInt1] & 0xFF;
        paramInt1 += 1;
      }
      else
      {
        m = 0;
      }
      int i3 = paramInt2 + 1;
      char[] arrayOfChar2 = jdField_a_of_type_ArrayOfChar;
      arrayOfChar1[paramInt2] = arrayOfChar2[(i2 >>> 2)];
      paramInt2 = i3 + 1;
      arrayOfChar1[i3] = arrayOfChar2[((i2 & 0x3) << 4 | k >>> 4)];
      int j = 61;
      if (paramInt2 < n) {
        i = arrayOfChar2[((k & 0xF) << 2 | m >>> 6)];
      } else {
        i = 61;
      }
      arrayOfChar1[paramInt2] = i;
      paramInt2 += 1;
      int i = j;
      if (paramInt2 < n) {
        i = jdField_a_of_type_ArrayOfChar[(m & 0x3F)];
      }
      arrayOfChar1[paramInt2] = i;
      paramInt2 += 1;
    }
    return arrayOfChar1;
  }
  
  public static String b(String paramString)
  {
    return new String(a(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */