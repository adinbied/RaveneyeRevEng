package com.huawei.hms.support.api.push.b.b;

import android.text.TextUtils;

public class c
{
  private static String a(char paramChar, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localStringBuffer.append(paramChar);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.length() < 2) {
      return paramString;
    }
    try
    {
      int i = (int)Math.ceil(paramString.length() * 25 / 100.0D);
      int j = (int)Math.ceil(paramString.length() * 50 / 100.0D);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, i));
      localStringBuilder.append(a('*', j));
      localStringBuilder.append(paramString.substring(i + j));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (IndexOutOfBoundsException paramString) {}
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */