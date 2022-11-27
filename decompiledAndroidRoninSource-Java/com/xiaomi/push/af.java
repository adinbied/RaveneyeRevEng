package com.xiaomi.push;

import android.content.Context;

public class af
{
  static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2 * 2);
    int i = 0;
    while (i < paramInt2)
    {
      int j = paramArrayOfByte[(paramInt1 + i)] & 0xFF;
      localStringBuilder.append(a[(j >> 4)]);
      localStringBuilder.append(a[(j & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext)
  {
    return ae.a;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */