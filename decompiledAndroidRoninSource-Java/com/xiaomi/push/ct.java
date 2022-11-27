package com.xiaomi.push;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

class ct
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(a(paramString));
      paramString = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String a(List<NameValuePair> paramList, String paramString)
  {
    Collections.sort(paramList, new cu());
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    for (int i = 1; paramList.hasNext(); i = 0)
    {
      NameValuePair localNameValuePair = (NameValuePair)paramList.next();
      if (i == 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(localNameValuePair.getName());
      localStringBuilder.append("=");
      localStringBuilder.append(localNameValuePair.getValue());
    }
    localStringBuilder.append("&");
    localStringBuilder.append(paramString);
    return a(new String(Base64.encode(a(localStringBuilder.toString()), 2)));
  }
  
  public static void a(String paramString) {}
  
  private static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    return paramString.getBytes();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */