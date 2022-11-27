package com.huawei.updatesdk.sdk.a.d;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class e
{
  private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if ("****".equals(paramString)) {
      return paramString;
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      a.a("StringUtils", "encode2utf8 error", paramString);
    }
    return null;
  }
  
  public static boolean d(String paramString)
  {
    return (paramString != null) && (paramString.trim().startsWith("{")) && (paramString.trim().endsWith("}"));
  }
  
  public static boolean e(String paramString)
  {
    return a.matcher(paramString).matches();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */