package com.xiaomi.push;

import java.util.Random;

public class gw
{
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private static final char[] jdField_a_of_type_ArrayOfChar = "&quot;".toCharArray();
  private static final char[] b = "&apos;".toCharArray();
  private static final char[] c = "&amp;".toCharArray();
  private static final char[] d = "&lt;".toCharArray();
  private static final char[] e = "&gt;".toCharArray();
  private static char[] f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  
  public static String a(int paramInt)
  {
    if (paramInt < 1) {
      return null;
    }
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfChar[i] = f[jdField_a_of_type_JavaUtilRandom.nextInt(71)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    char[] arrayOfChar = paramString.toCharArray();
    int m = arrayOfChar.length;
    StringBuilder localStringBuilder = new StringBuilder((int)(m * 1.3D));
    int j = 0;
    int i;
    for (int k = 0; j < m; k = i)
    {
      int n = arrayOfChar[j];
      if (n > 62)
      {
        i = k;
      }
      else if (n == 60)
      {
        if (j > k) {
          localStringBuilder.append(arrayOfChar, k, j - k);
        }
        i = j + 1;
        localStringBuilder.append(d);
      }
      else if (n == 62)
      {
        if (j > k) {
          localStringBuilder.append(arrayOfChar, k, j - k);
        }
        i = j + 1;
        localStringBuilder.append(e);
      }
      else if (n == 38)
      {
        if (j > k) {
          localStringBuilder.append(arrayOfChar, k, j - k);
        }
        n = j + 5;
        if ((m > n) && (arrayOfChar[(j + 1)] == '#') && (Character.isDigit(arrayOfChar[(j + 2)])) && (Character.isDigit(arrayOfChar[(j + 3)])) && (Character.isDigit(arrayOfChar[(j + 4)])))
        {
          i = k;
          if (arrayOfChar[n] == ';') {}
        }
        else
        {
          i = j + 1;
          localStringBuilder.append(c);
        }
      }
      else if (n == 34)
      {
        if (j > k) {
          localStringBuilder.append(arrayOfChar, k, j - k);
        }
        i = j + 1;
        localStringBuilder.append(jdField_a_of_type_ArrayOfChar);
      }
      else
      {
        i = k;
        if (n == 39)
        {
          if (j > k) {
            localStringBuilder.append(arrayOfChar, k, j - k);
          }
          i = j + 1;
          localStringBuilder.append(b);
        }
      }
      j += 1;
    }
    if (k == 0) {
      return paramString;
    }
    if (j > k) {
      localStringBuilder.append(arrayOfChar, k, j - k);
    }
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return null;
    }
    int i = paramString1.indexOf(paramString2, 0);
    Object localObject = paramString1;
    if (i >= 0)
    {
      localObject = paramString1.toCharArray();
      paramString3 = paramString3.toCharArray();
      int j = paramString2.length();
      StringBuilder localStringBuilder = new StringBuilder(localObject.length);
      localStringBuilder.append((char[])localObject, 0, i);
      localStringBuilder.append(paramString3);
      i += j;
      for (;;)
      {
        int k = paramString1.indexOf(paramString2, i);
        if (k <= 0) {
          break;
        }
        localStringBuilder.append((char[])localObject, i, k - i);
        localStringBuilder.append(paramString3);
        i = k + j;
      }
      localStringBuilder.append((char[])localObject, i, localObject.length - i);
      localObject = localStringBuilder.toString();
    }
    return (String)localObject;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return String.valueOf(bc.a(paramArrayOfByte));
  }
  
  public static final String b(String paramString)
  {
    return a(a(a(a(a(paramString, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */