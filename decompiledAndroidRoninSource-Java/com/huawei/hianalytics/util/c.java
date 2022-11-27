package com.huawei.hianalytics.util;

import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;) {}
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    paramString = "getSHA256StrJava, Unsupported Encoding: UTF-8 !";
    break label45;
    paramString = "getSHA256StrJava, No Such Algorithm!";
    label45:
    b.d("HianalyticsSDK", paramString);
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        localStringBuilder.append(a[((k & 0xF0) >> 4)]);
        localStringBuilder.append(a[(k & 0xF)]);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */