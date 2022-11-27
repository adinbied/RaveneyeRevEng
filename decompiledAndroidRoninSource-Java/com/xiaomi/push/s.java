package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.Method;

public class s
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)t.a(null, "android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SystemProperties.get: ");
      localStringBuilder.append(paramString1);
      b.a(localStringBuilder.toString());
    }
    return paramString2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */