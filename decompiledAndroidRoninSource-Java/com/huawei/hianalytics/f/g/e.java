package com.huawei.hianalytics.f.g;

import android.text.TextUtils;
import com.huawei.hianalytics.util.c;
import java.security.SecureRandom;
import java.util.Locale;

public abstract class e
{
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static String a()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return a(arrayOfByte);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return c.a(paramArrayOfByte);
  }
  
  public static byte[] a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return new byte[0];
    }
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    int j = paramString.length() / 2;
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    while (i < j)
    {
      int k = i * 2;
      int m = a(paramString[k]);
      arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String b()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[''];
    localSecureRandom.nextBytes(arrayOfByte);
    return a(arrayOfByte);
  }
  
  public static String c()
  {
    return "a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
  }
  
  public static String d()
  {
    return "49cb4254efce57d5861aedca86e5baf1205b09cd7f742b38065559f0f70676754915acca5ad6eeaa0d68dfd5143d0a50faedb6cda3b13852705c881ba5b587ecbbb4467cbed08b6754a3f424d90c66fd3b82d48bd5c132b88ff36da668f5adc286ec8317166c70110203010001";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */