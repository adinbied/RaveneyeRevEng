package com.xiaomi.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class be
{
  private static String a(byte paramByte)
  {
    int i;
    if (paramByte < 0) {
      i = 128;
    } else {
      i = 0;
    }
    paramByte = (paramByte & 0x7F) + i;
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramByte < 16) {
      str = "0";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(Integer.toHexString(paramByte).toLowerCase());
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuffer localStringBuffer = new StringBuffer();
      byte[] arrayOfByte = paramString.getBytes();
      int j = paramString.length();
      int i = 0;
      localMessageDigest.update(arrayOfByte, 0, j);
      paramString = localMessageDigest.digest();
      while (i < paramString.length)
      {
        localStringBuffer.append(a(paramString[i]));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    return a(paramString).subSequence(8, 24).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */